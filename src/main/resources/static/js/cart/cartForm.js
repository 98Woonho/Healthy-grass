// 체크박스 입력했을 때 모두 체크되는 로직
document.querySelector('.ALL_checked').addEventListener('change', function () {
    const isChecked = this.checked;
    document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
        checkbox.checked = isChecked;
    });
});



//수량변경시 총금액 변경 자바스크립트 코드
function totalPrice() {
    //모든 가격 리스트로 나누는 코드
    let priceList = [];
    const cart_price = document.querySelectorAll('.cart_price');
    cart_price.forEach(function (input){
        let price = parseInt(input.textContent);
        priceList.push(price);
    })
    console.log("priceList" + priceList);
    // 모든 수량 리스트로 나누는 코드
    let quantityList = [];
    const amount_value = document.querySelectorAll('.amount_value');
    amount_value.forEach(function (input) {
        let quantity = parseInt(input.value);
        quantityList.push(quantity);
    })
    // 가격과 수량을 곱한 후 합계를 구하는 코드
    let total = 0;
    for (let i = 0; i < priceList.length; i++) {
        total += priceList[i] * quantityList[i];
    }
    console.log(total);
    const total_amount = document.querySelectorAll('.total_amount');
    total_amount[0].innerText = total;
}


//장바구니 수량 변경시 db에 수량 변경내용 저장
document.addEventListener('DOMContentLoaded', function () {
    const BtnUp = document.querySelectorAll(".up");
    const BtnDown = document.querySelectorAll(".down");
    const amountValue = document.querySelectorAll(".amount_value");
    const cartId = document.querySelector('.cartId');

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
            e.preventDefault();
            const stock = parseInt(this.closest('tr').querySelector('.product_amount').textContent);
            const input = this.closest('tr').querySelector('.amount_value');
            let currentValue = parseInt(input.value);
            const productId = e.target.getAttribute('data-product-id');
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
            if (currentValue > stock) {
                alert('재고보다 상품을 많이 담을수 없습니다.');
                input.value = stock;
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
            } else if (currentValue < 1) {
                alert('상품은 0개 이하로 담을수 없습니다.')
                input.value = 1;
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
            }
        });
    });
});





