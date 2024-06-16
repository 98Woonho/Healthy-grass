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

salePrices.forEach(function(sale) {
    let SalePrice = parseInt(sale.textContent);
        totalSalePrice += SalePrice;
});

const productSalePrices = document.querySelectorAll('.product_sale_price');

productSalePrices.forEach(productSalePrice =>{
    productSalePrice.textContent = totalSalePrice;
})
const receiver = document.querySelector('.receiver');
const zipcode = document.querySelector('.zipcode');
const streetAdr = document.querySelector('.streetAdr');
const detailAdr = document.querySelector('.detailAdr');
const phone = document.querySelector('.phone');
const zipcodeSearch = document.querySelector('.zipcode-search');
const isSameOrderInformationChecked = document.querySelector('.is-same-orderInformation-chk');
isSameOrderInformationChecked.addEventListener('change', function (e){
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
    }else {
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
                if (isSameOrderInformationChecked.checked){
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
            } else if (selectedValue === 'B'){
                if (isSameOrderInformationChecked.checked){
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
                        receiver.value = shipping.name;
                        zipcode.value = shipping.zipcode;
                        streetAdr.value = shipping.streetAdr;
                        detailAdr.value = shipping.detailAdr;
                        phone.value = shipping.phone;
                    })
                    .catch(err => {
                        console.log(err);
                    });
            } else if (selectedValue === 'R'){
                if (isSameOrderInformationChecked.checked){
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

zipcodeSearch.addEventListener('click', function (e){
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

//결제
const payBtn = document.querySelector('.pay-btn');

payBtn.addEventListener('click', function (e){
    e.preventDefault();
    //
    // 모든 라디오 버튼을 선택
    const radioButtons = document.querySelectorAll('input[name="radio_paymethod"]');

    // 각 라디오 버튼에 change 이벤트 리스너 추가
    radioButtons.forEach(radio => {
        radio.addEventListener('change', (e) => {
            // 클릭된 라디오 버튼의 값 가져오기
            const selectedValue = e.target.value;
            if (selectedValue === 'B'){
                var IMP = window.IMP;
                IMP.init('imp40654467');// IMPort 고객사 식별코드
                IMP.request_pay({
                    pg: 'html5_inicis.INIpayTest',
                    pay_method: 'card', //카드결제
                    merchant_uid: 'merchant_' + new Date().getTime(),
                    name: '당근 10kg',
                    amount: 100,
                    buyer_email: 'hbsh@naver.com',
                    buyer_name: '구매자 이름',
                    buyer_tel: '연락처',
                    buyer_addr: '주소',
                    buyer_postcode: '우편번호'
                }, function (rsp) { // callback
                    if (rsp.success) {
                        var msg = '결제가 완료되었습니다.';
                        msg += '고유ID : ' + rsp.imp_uid;
                        msg += '상점 거래ID : ' + rsp.merchant_uid;
                        msg += '결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;

                        console.log(rsp);

                        axios.post("/payment/save", rsp, {headers: {"Content-Type": "application/json"}})
                            .then(resp => {
                                console.log(resp)
                            })
                            .catch(err => {
                                console.log(err);
                            })

                    } else {
                        var msg = '결제에 실패하였습니다.';
                        alert(msg + rsp.error_msg);

                        console.log(rsp);
                    }
                })
            }

            // 필요한 추가 작업 수행
            // 예: 특정 결제 방식에 따라 다른 입력 필드를 활성화/비활성화
        });
    });
});
