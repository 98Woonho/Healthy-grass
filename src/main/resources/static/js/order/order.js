const PhoneRegex = (target) => {
    const maxLength = 13;
    if (target.value.length > maxLength) {
        target.value = target.value.slice(0, maxLength);
    }

    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

//상품 화면에 보여주는 코드
const salePrices = document.querySelectorAll('.sale_price');

let totalSalePrice = 0;

salePrices.forEach(function (sale) {
    let SalePrice = parseInt(sale.textContent);
    totalSalePrice += SalePrice;
});

const productSalePrices = document.querySelectorAll('.product_sale_price');

productSalePrices.forEach(productSalePrice => {
    productSalePrice.textContent = totalSalePrice;
})
const receiver = document.querySelector('.receiver');
const zipcode = document.querySelector('.zipcode');
const streetAdr = document.querySelector('.streetAdr');
const detailAdr = document.querySelector('.detailAdr');
const phone = document.querySelector('.phone');
const zipcodeSearch = document.querySelector('.zipcode-search');
const isSameOrderInformationChecked = document.querySelector('.is-same-orderInformation-chk');
isSameOrderInformationChecked.addEventListener('change', function (e) {
    e.preventDefault()
    // 만약 주문자 정보가 동일함이 체크되었으면
    if (e.target.checked) {
        axios.get('/order/user')
            .then(res => {
                //user 정보를 넣어줌
                const user = res.data;
                receiver.value = user.name;
                zipcode.value = user.zipcode;
                streetAdr.value = user.streetAdr;
                detailAdr.value = user.detailAdr;
                phone.value = user.phone;
            })
            .catch(err => {
                console.log(err);
            });
        //아니면 빈 문자열 넣음
    } else {
        receiver.value = "";
        zipcode.value = "";
        streetAdr.value = "";
        detailAdr.value = "";
        phone.value = "";
    }
})
document.addEventListener('DOMContentLoaded', () => {
    const radioButtons = document.querySelectorAll('input[name="addressType"]');

    radioButtons.forEach(radio => {
        radio.addEventListener('change', (e) => {


            const selectedValue = e.target.value;
            if (selectedValue === 'N') {
                if (isSameOrderInformationChecked.checked) {
                    isSameOrderInformationChecked.checked = false;
                    receiver.value = "";
                    zipcode.value = "";
                    streetAdr.value = "";
                    detailAdr.value = "";
                    phone.value = "";
                }
                receiver.value = "";
                zipcode.value = "";
                streetAdr.value = "";
                detailAdr.value = "";
                phone.value = "";
                // 신규 배송지를 선택한 경우에 대한 처리
                new daum.Postcode({
                    oncomplete: function (data) {
                        let addr = '';
                        if (data.userSelectedType === 'R') {
                            // 도로명 주소
                            addr = data.roadAddress;
                        } else {
                            // 지번 주소
                            addr = data.jibunAddress;
                        }

                        // 우편번호와 주소 정보를 해당 필드에 넣는다.
                        zipcode.value = data.zonecode;
                        streetAdr.value = addr;
                        // 커서를 상세주소 필드로 이동한다.
                        detailAdr.focus();
                    }
                }).open();
            } else if (selectedValue === 'B') {
                if (isSameOrderInformationChecked.checked) {
                    isSameOrderInformationChecked.checked = false;
                    receiver.value = "";
                    zipcode.value = "";
                    streetAdr.value = "";
                    detailAdr.value = "";
                    phone.value = "";
                }
                axios.get("/order/shipping")
                    .then(res => {

                        const shipping = res.data;
                        if (shipping.name === undefined){
                            alert('기본 배송지로 등록한 배송지가 없습니다. 마이페이지에서 배송지 주소를 입력해주세요')
                        }else {
                        receiver.value = shipping.name;
                        zipcode.value = shipping.zipcode;
                        streetAdr.value = shipping.streetAdr;
                        detailAdr.value = shipping.detailAdr;
                        phone.value = shipping.phone;
                        }
// // 운호씨 코드
//                         receiver.value = shipping === '' ? '' : shipping.name;
//                         zipcode.value = shipping === '' ? '' : shipping.zipcode;
//                         streetAdr.value = shipping === '' ? '' : shipping.streetAdr;
//                         detailAdr.value = shipping === '' ? '' : shipping.detailAdr;
//                         phone.value = shipping === '' ? '' : shipping.phone;
                    })
                    .catch(err => {
                        console.log(err);
                    });
            } else if (selectedValue === 'R') {
                if (isSameOrderInformationChecked.checked) {
                    isSameOrderInformationChecked.checked = false;
                    receiver.value = "";
                    zipcode.value = "";
                    streetAdr.value = "";
                    detailAdr.value = "";
                    phone.value = "";
                }
            }
        });
    });
});

zipcodeSearch.addEventListener('click', function (e) {
    e.preventDefault();
    new daum.Postcode({
        oncomplete: function (data) {
            let addr = '';
            if (data.userSelectedType === 'R') {
                // 도로명 주소
                addr = data.roadAddress;
            } else {
                // 지번 주소
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            zipcode.value = data.zonecode;
            streetAdr.value = addr;
            // 커서를 상세주소 필드로 이동한다.
            detailAdr.focus();
        }
    }).open();
})

// 요소의 위치 정보를 받는 함수
function getElementOffset(element) {
    const rect = element.getBoundingClientRect();
    const scrollLeft = window.pageXOffset || document.documentElement.scrollLeft;
    const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
    return {
        top: rect.top + scrollTop,
        left: rect.left + scrollLeft
    };
}
// 배송 메세지 입력
const selectElement = document.getElementById('orderMessageSelect');
const textareaElement = document.getElementById('orderMessageTextarea');
selectElement.addEventListener('change', function (e){
    e.preventDefault();
    console.log(selectElement.value);
    if (selectElement.value !== '배송 메시지를 선택해주세요.') {
        textareaElement.disabled = true; // textarea를 비활성화
        textareaElement.value = selectElement.value; // 선택된 옵션의 값을 textarea에 설정
    } else {
        textareaElement.disabled = false; // textarea를 활성화
        textareaElement.value = ''; // 기본 값이나 선택된 값을 지움
    }
})

const productName = document.querySelector('.product-name');
const saleTotalPrice = document.querySelector('.sale-total-price');
const userEmail = document.querySelector('.user-email');
const userName = document.querySelector('.user-name');
const userPhone = document.querySelector('.user-phone');
const payBtn = document.querySelector('.pay-btn');
const radioButtons = document.querySelectorAll('input[name="radio_paymethod"]');
const paymentAgree = document.querySelector('.payment-agree');
let selectedValue;

// 결제 방식에 따른 설정 객체
const paymentMethods = {
    'B': {
        pg: 'html5_inicis.INIpayTest',
        pay_method: 'card'
    },
    'V': {
        pg: 'html5_inicis.INIpayTest',
        pay_method: 'trans'
    },
    'C': {
        pg: 'html5_inicis.INIpayTest',
        pay_method: 'vbank'
    }
};

// 각 라디오 버튼에 change 이벤트 리스너 추가
radioButtons.forEach(radio => {
    radio.addEventListener('change', (e) => {
        // 클릭된 라디오 버튼의 값 가져오기
        selectedValue = e.target.value;
        console.log(selectedValue);
    });
});

// 결제 버튼 클릭 시 처리 함수
payBtn.addEventListener('click', function (e) {
    e.preventDefault();

    if (receiver.value === "" || receiver.value === null) {
        alert('받으시는 분을 입력해주세요');
        receiver.focus();
        window.scrollTo({top: getElementOffset(receiver).top - 200})
        return;
    }
    if (zipcode.value === "" || zipcode.value === null){
        alert('배송지 우편번호를 입력해주세요');
        zipcode.focus();
        window.scrollTo({top: getElementOffset(zipcode).top - 200})
        return;
    }
    if (streetAdr.value === "" || streetAdr.value === null){
        alert('배송지 주소를 입력해주세요');
        streetAdr.focus();
        window.scrollTo({top: getElementOffset(streetAdr).top - 200})
        return;
    }
    if (phone.value === "" || phone.value === null){
        alert('휴대폰 번호를 입력해주세요');
        phone.focus();
        window.scrollTo({top: getElementOffset(phone).top - 200})
        return;
    }
    if (streetAdr.value === "" || streetAdr.value === null){
        alert('배송지 주소를 입력해주세요 입력해주세요');
        streetAdr.focus();
        window.scrollTo({top: getElementOffset(streetAdr).top - 200})
        return;
    }
    if (paymentAgree.checked === false){
        alert('결제정보 확인 / 구매진행 동의 체크를 해주세요');
        window.scrollTo({top: getElementOffset(paymentAgree).top - 200})
        return;
    }

    console.log(selectedValue);

    // 결제 처리 함수 호출
    processPayment(selectedValue);
});

// 결제 처리 함수
function processPayment(selectedValue) {
    const method = paymentMethods[selectedValue];

    if (!method) {
        alert('결제 방법을 선택해주세요');
        return;
    }

    data = {
        pg: method.pg,
        pay_method: method.pay_method,
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: productName.innerText,
        // amount: saleTotalPrice.innerText,
        amount : 100,
        buyer_email: userEmail.value,
        buyer_name: userName.value,
        buyer_tel: userPhone.value,
        buyer_addr: streetAdr.value + detailAdr.value,
        buyer_postcode: zipcode.value,
        custom_data: textareaElement.value
    }

    axios.get('/payment/imp')
        .then(response => {
            const impKey = response.data;
            IMP.init(impKey); // IMPort 고객사 식별코드
            IMP.request_pay(data, function (rsp) { // callback
                if (rsp.success) {
                    console.log(rsp);
                    alert('결제가 완료되었습니다.');
                    const productIdElements = document.querySelectorAll('.product-id');
                    const quantityElements = document.querySelectorAll('.order-quantity');
                    const priceElements = document.querySelectorAll('.price');

                    const list = []
                    productIdElements.forEach((element, index) => {
                        const id = element.value.trim();
                        const quantity = quantityElements[index].innerText.trim();
                        const price = priceElements[index].innerText.trim();
                        const data = {
                            id: id,
                            quantity: quantity,
                            price: price
                        };
                        list.push(data);

                    });

                    console.log(list);

                    rsp.productList = list;

                    axios.post("/payment/save", rsp, {headers: {"Content-Type": "application/json"}})
                        .then(resp => {
                            location.href = "/myPage/paymentList";
                        })
                        .catch(err => {
                            console.log(err);
                        });
                } else {
                    console.log(rsp);
                    alert('결제에 실패하였습니다.');
                }
            });
        })
        .catch(error => {
            console.error('There has been a problem with your axios operation:', error);
        });
}

