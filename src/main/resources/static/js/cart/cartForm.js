
// 체크박스 입력했을 때 모두 체크되는 로직
document.querySelector('.ALL_checked').addEventListener('change', function() {
    const isChecked = this.checked;
    document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
        checkbox.checked = isChecked;
    });
});


//장바구니 수량 변경시 db에 수량 변경내용 저장
document.addEventListener('DOMContentLoaded', function() {
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
                axios.post('/cart/AddAmount', {
                    "amountValue" : input.value,
                    "cartId" : cartId.value,
                    "productId" : productId
                })
                    .then(res =>{
                        console.log(res.data);
                    })
                    .catch(err=> {
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
                axios.post('/cart/AddAmount', {
                    "amountValue" : input.value,
                    "cartId" : cartId.value,
                    "productId" : productId
                })
                    .then(res =>{
                        console.log(res.data);
                    })
                    .catch(err=> {
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
            console.log(input.value)
            console.log(cartId.value)
            console.log(productId)
            axios.post('/cart/AddAmount', {
                "amountValue" : input.value,
                "cartId" : cartId.value,
                "productId" : productId
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
                axios.post('/cart/AddAmount', {
                    "amountValue" : input.value,
                    "cartId" : cartId.value,
                    "productId" : productId
                })
                    .then(res => {
                        console.log(res.data);
                    })
                    .catch(err => {
                        console.log(err);
                    });
            }else if (currentValue < 1) {
                alert('상품은 0개 이하로 담을수 없습니다.')
                input.value = 1;
                axios.post('/cart/AddAmount', {
                    "amountValue" : input.value,
                    "cartId" : cartId.value,
                    "productId" : productId
                })
                    .then(res =>{
                        console.log(res.data);
                    })
                    .catch(err=> {
                        console.log(err);
                    });
            }
        });
    });
});





