let totalPriceText = document.getElementById('totalPrice');
const totalProductAmount = parseInt(totalPriceText.textContent);
let quantityInput = document.getElementById('quantity');
let NoSalePrice = document.querySelector('#productPrice');
let totalNoSalePrice = NoSalePrice.innerText

//수량이 변하면 총 상품금액이 변하는 로직
function getProductPrice() {
    axios.post('/productPrice', {'totalProductAmount': totalProductAmount})
        .then(resp => {
            console.log(resp.data)
            totalPriceText.textContent = resp.data * parseInt(quantityInput.value);
            console.log(totalPriceText.textContent);
        })
        .catch(err => {
            // Handle error
            console.log(err);
        })
}


//로드 될때 자동 실행
document.addEventListener('DOMContentLoaded', (event) => {
    getProductPrice();
});

// quantityInput.addEventListener('change', function (e){
//
// quantityInput.addEventListener('change', function (e) {
//     e.preventDefault()
//
// })

quantityInput.addEventListener('input', function () {
    if (quantityInput.value < 1) {
        quantityInput.value = 1;
        alert("상품은 무조건 한개 이상 구매해야합니다.")
    }
    if (quantityInput.value > parseInt(productAmount.textContent)) {
        quantityInput.value = parseInt(productAmount.textContent)
        alert("재고보다 더 많은 상품을 구매할 수 없습니다.")
    }
    getProductPrice();
});

const amountUp = document.querySelector('.up');
const amountDown = document.querySelector('.down');
const productAmount = document.querySelector('.productAmount');
amountUp.addEventListener('click', function (e) {
    e.preventDefault();

    quantityInput.value = ++quantityInput.value;
    if (quantityInput.value > parseInt(productAmount.textContent)) {
        quantityInput.value = parseInt(productAmount.textContent)
        alert("재고보다 더 많은 상품을 구매할 수 없습니다.")
    }
    console.log(quantityInput.value);

    getProductPrice();
})

amountDown.addEventListener('click', function (e) {
    e.preventDefault();

    quantityInput.value = --quantityInput.value;
    if (quantityInput.value < 1) {
        quantityInput.value = 1;
        alert("상품은 무조건 한개 이상 구매해야합니다.")
    }
    console.log(quantityInput.value);
    getProductPrice();
})

const productId = document.getElementById('productId');

const wishBtn = document.querySelector('.wishBtn');
wishBtn.addEventListener('click', function (e) {
    e.preventDefault();

    axios.post('/myPage/wish', {
        Pid: productId.value
    })
    .then(res => {
        alert(res.data.msg);
    })
    .catch(err => {
        alert('로그인 시에만 사용할 수 있는 기능입니다.');
    })
})


const cartBtn = document.querySelector('.cartBtn');
cartBtn.addEventListener("click", function (e) {
    e.preventDefault();
    console.log("productAmount.innerText" + productAmount.innerText);
    console.log("quantityInput.value" + quantityInput.value);
    // productAmount.innerText == 상품 재고
    // quantityInput.value == 구매하려고 하는 수량
    if (parseInt(productAmount.innerText) === 0){
        alert('상품 재고가 없어 상품을 구매하지 못했습니다.')
        return;
    }
    console.log(quantityInput.value);
    axios.post('/cart', {
        "productId": productId.value,
        "quantity": quantityInput.value
    })
        .then(res => {
            console.log(res.data);
            if (res.data === "SUCCESS") {
                const myModal = new bootstrap.Modal(document.getElementById('exampleModal'));

                const modalQuantity = document.querySelector(".product-amount");
                modalQuantity.innerText = `${quantityInput.value} 개의 상품을 장바구니에 담았습니다.`;
                myModal.show();
            } else if (res.data === "AMOUNT_FULL") {
                alert("장바구니에 담은 상품이 상품 재고보다 많아 추가 구매한 상품은 취소되었습니다.")
                location.href = "/order";
            } else if (res.data === "FAILURE_LOGIN"){
                alert("장바구니에 상품을 담기 전에 로그인을 진행해 주세요")
                location.href = "/user/loginForm"
            }
        })
        .catch(err => {
            console.log(err);
        });

    const viewCartBtn = document.getElementById('viewCartBtn');
    viewCartBtn.addEventListener('click', function () {
        location.href = '/cart';
    });
})
//바로구매 클릭했을 때 동작하는 이벤트
const buyNowBtn = document.querySelector('.buyNowBtn');

buyNowBtn.addEventListener('click', function (e) {
    if (parseInt(productAmount.innerText) === 0){
        alert('상품 재고가 없어 상품을 구매하지 못했습니다.')
        return;
    }
    const productId = document.querySelector('.product-id').value;
    const quantity = quantityInput.value;

    axios.post('/cart', {
        productId: productId,
        quantity: quantity
    })
        .then(res => {
            handleResponse(res.data);
        })
        .catch(err => {
            console.log(err);
        });
});

function handleResponse(response) {
    if (response === "SUCCESS") {
        const checkedValues = getNowPurchase();
        console.log("checkedValues : " + JSON.stringify(checkedValues, null, 2));
        axios.post('/order', checkedValues)
            .then(res => {
                // 주문 성공 시 추가 로직 작성
                console.log(res.data);
                if (res.data === "SUCCESS"){
                    location.href = "/order";
                }
            })
            .catch(err => {
                console.log(err);
            });
    } else if (response === "AMOUNT_FULL") {
        alert("구매한 상품이 상품 재고보다 많아 추가 구매한 상품은 취소되었습니다.");
        location.href = "/order";
    } else if (response === "FAILURE_LOGIN") {
        alert("물건을 구매하기 전에 로그인을 진행해 주세요");
        location.href = "/user/loginForm";
    }
}

function getNowPurchase() {
    const cartPrice = document.querySelector('#discountedPrice').innerText;
    const productId = document.querySelector('.product-id').value;
    const totalAmount = totalPriceText.textContent;

    return [{
        price: parseInt(cartPrice),
        quantity: parseInt(quantityInput.value), // 상품 할인
        total_amount: totalAmount, // 상품 갯수
        noSaleTotalPrice: parseInt(totalNoSalePrice) * quantityInput.value, // 주문 총 금액
        Pid: productId
    }];
}



