
// 체크박스 입력했을 때 모두 체크되는 로직
document.querySelector('.ALL_checked').addEventListener('change', function () {
    const isChecked = this.checked;
    document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
        checkbox.checked = isChecked;
    });
    totalPrice();
});

// 수량적는 칸에 숫자만 들어갈 수 있도록 변경
const amountInputs = document.querySelectorAll('.amount_value');
amountInputs.forEach(input => {
    input.addEventListener('input', function(e) {
        // 입력값이 숫자 이외의 다른 문자를 포함하고 있다면
        if (/[^\d]/.test(this.value)) { // this.value : 현재 이벤트가 발생한 입력 요소의 값
            // 숫자 이외의 문자를 제거합니다.
            this.value = this.value.replace(/[^\d]/g, '');
        }
    });
});

//수량변경시 총금액 변경 자바스크립트 코드
function totalPrice() {
    //모든 가격 리스트로 나누는 코드
    let priceList = [];
    let quantityList = [];
    let noSalePriceList = [];
    const cart_price = document.querySelectorAll('.cart_price');
    const amount_value = document.querySelectorAll('.amount_value');
    const tr_array = document.querySelectorAll('.tr');
    const checkbox_array = document.querySelectorAll('.checkOne');
    const all_checked = document.querySelector('.ALL_checked');
    let noSaleCartPrices = document.querySelectorAll('.noSaleCartPrice');
    let state_check = true;

    tr_array.forEach(function (input, index){
        if(checkbox_array[index].checked) {
            let price = parseInt(cart_price[index].textContent);
            let quantity = parseInt(amount_value[index].value);
            let noSalePrice = parseInt(noSaleCartPrices[index].value);
            priceList.push(price);
            quantityList.push(quantity);
            noSalePriceList.push(noSalePrice);
        } else {
            priceList.push(0);
            quantityList.push(0);
            noSalePriceList.push(0);
            all_checked.checked = false;
            state_check = false;
        }
    });

    // 가격과 수량을 곱한 후 합계를 구하는 코드 할인 적용 후 총 구매금액
    let total = 0;
    let noSaleTotal = 0;
    const product_total_price = document.querySelectorAll('.product_total_price');
    for (let i = 0; i < priceList.length; i++) {
        let productTotal = priceList[i] * quantityList[i];
        total += priceList[i] * quantityList[i];
        noSaleTotal += noSalePriceList[i] * quantityList[i];
        product_total_price[i].innerText = productTotal;
    }


    const total_amount = document.querySelectorAll('.total_amount');
    total_amount[0].innerText = total;
    const noSaleCartTotalPrice = document.querySelectorAll('.noSaleCartTotalPrice');
    noSaleCartTotalPrice[0].value = noSaleTotal;

    if (state_check) {
        all_checked.checked = true;
    }
}


//장바구니 수량 변경시 db에 수량 변경내용 저장
document.addEventListener('DOMContentLoaded', function () {
    const BtnUp = document.querySelectorAll(".up");
    const BtnDown = document.querySelectorAll(".down");
    const amountValue = document.querySelectorAll(".amount_value");
    const cartId = document.querySelector('.cartId');

    // 초기셋팅
    const all_checked = document.querySelector('.ALL_checked');
    all_checked.checked = true;
    all_checked.dispatchEvent(new Event('change'));

    BtnUp.forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const input = this.closest('tr').querySelector('.amount_value');
            const stock = parseInt(this.closest('tr').querySelector('.product_amount').textContent); //현재 남은 재고
            const productId = e.target.getAttribute('data-product-id');
            let currentValue = parseInt(input.value); //input에 있는 값
            if (currentValue < stock) {
                input.value = currentValue + 1;
                totalPrice();
                axios.post('/cart/AddAmount', {
                    "amountValue": input.value,
                    "cartId": cartId.value,
                    "productId": productId
                })
                    .then(res => {
                        console.log(res.data);
                    })
                    .catch(err => {
                        console.log(err);
                    });
            } else {
                currentValue = stock;
                alert('재고보다 상품을 많이 담을수 없습니다.');
            }
        });
    });
    BtnDown.forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const input = this.closest('tr').querySelector('.amount_value');
            let currentValue = parseInt(input.value);
            const productId = e.target.getAttribute('data-product-id');
            if (currentValue > 1) {
                input.value = currentValue - 1;
                totalPrice();
                axios.post('/cart/AddAmount', {
                    "amountValue": input.value,
                    "cartId": cartId.value,
                    "productId": productId
                })
                    .then(res => {
                        console.log(res.data);
                    })
                    .catch(err => {
                        console.log(err);
                    });
            } else {
                currentValue = 1;
                alert("물건 수량은 1개 이하로 담을 수 없습니다.")
            }
        });
    });

    amountValue.forEach(input => {
        input.addEventListener('input', function (e) {
            //stock = 남은 재고
            const stock = parseInt(this.closest('tr').querySelector('.product_amount').textContent);
            //input = 수량작성 input
            const amount_value = this.closest('tr').querySelector('.amount_value');
            let currentValue = parseInt(amount_value.value);
            const productId = e.target.getAttribute('data-product-id');
            e.preventDefault();
            totalPrice();
            axios.post('/cart/AddAmount', {
                "amountValue": amount_value.value,
                "cartId": cartId.value,
                "productId": productId
            })
                .then(res => {
                    console.log(res.data);
                })
                .catch(err => {
                    console.log(err);
                });
            if (currentValue > stock) {
                alert('재고보다 상품을 많이 담을수 없습니다.');
                amount_value.value = stock;
                totalPrice();
                axios.post('/cart/AddAmount', {
                    "amountValue": amount_value.value,
                    "cartId": cartId.value,
                    "productId": productId
                })
                    .then(res => {

                        console.log(res.data);
                    })
                    .catch(err => {
                        console.log(err);
                    });
            } else if (currentValue < 1) {
                alert('상품은 0개 이하로 담을수 없습니다.')
                amount_value.value = 1;
                totalPrice();
                axios.post('/cart/AddAmount', {
                    "amountValue": amount_value.value,
                    "cartId": cartId.value,
                    "productId": productId
                })
                    .then(res => {
                        console.log(res.data);
                    })
                    .catch(err => {
                        console.log(err);
                    });
            }
        });
    });
});
//장바구니에 담긴 아이템 삭제
const deleteCartBtn = document.querySelectorAll('.delete_cart_btn');

deleteCartBtn.forEach(deleteBtn => {
    deleteBtn.addEventListener('click', function (e){
        e.preventDefault();
        if (confirm("삭제하겠습니까?")){
            const cartId = document.querySelector('.cartId').value;
            const productId = e.target.getAttribute('data-product-id');

            axios.delete('/cart/delete', {
                data: {
                    cartId: cartId,
                    productId: productId
                }
            })
                .then(res => {
                    console.log(res.data);
                    if (res.data === "SUCCESS"){
                        alert("성공적으로 삭제가 되었습니다.")
                        location.href = "/cart";
                    }else {
                        alert("알수없는 이유로 삭제가 되지 않았습니다. 다시한번 시도해주세요")
                    }
                })
                .catch(err => {
                    console.log(err);
                });
        }
    });
})


const orderSelectProduct = document.querySelector('.order_select_product');

//장바구니에 체크된 상품만 구매하는 로직
function getCheckedValues() {
    const checkboxArray = document.querySelectorAll('.checkOne');
    const checkedValues = [];

    checkboxArray.forEach(checkbox => {
        if (checkbox.checked) {
            const row = checkbox.closest('tr');
            const cartPrice = row.querySelector('.cart_price').textContent;
            const amountValue = row.querySelector('.amount_value').value; // 상품 수량
            const productId = row.querySelector('.amount_value').getAttribute("data-product-id");
            const totalAmount = document.querySelector('.total_amount').textContent;
            const noSaleTotalPrice = document.querySelector('.noSaleCartTotalPrice').value;
            checkedValues.push({
                price: cartPrice,
                quantity: amountValue,
                total_amount : totalAmount,
                noSaleTotalPrice : noSaleTotalPrice,
                Pid : productId
            });
        }
    });

    return checkedValues;
}

orderSelectProduct.addEventListener('click', function (e){
    e.preventDefault();
    // console.log(getCheckedValues());
    const data = getCheckedValues()

    axios.post('/order', data)
        .then(res => {
            if (res.data === "SUCCESS"){
                location.href = "/order";
            }
        })
        .catch(err => {
            console.log(err);
        });

})



