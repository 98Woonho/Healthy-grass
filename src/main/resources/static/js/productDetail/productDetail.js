let totalPriceText = document.getElementById('totalPrice');
const totalProductAmount = parseInt(totalPriceText.textContent);
let quantityInput = document.getElementById('quantity');

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

quantityInput.addEventListener('change', function (e) {
    e.preventDefault()

})

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
            alert(res.data);
        })
        .catch(err => {
            if (err.response.status === 409) {
                alert(err.response.data);
            } else {
                alert('알 수 없는 이유로 제품을 찜리스트에 등록 하지 못했습니다. 잠시 후 다시 시도해 주세요.');
            }
        })
})


const cartBtn = document.querySelector('.cartBtn');
cartBtn.addEventListener("click", function (e) {
    e.preventDefault();
    console.log(quantityInput.value);
    axios.post('/cart', {
        "productId": productId.value,
        "quantity": quantityInput.value
    })
        .then(res => {
            console.log(res.data);
            if (res.data === "SUCCESS") {
                const myModal = new bootstrap.Modal(document.getElementById('exampleModal'));
                myModal.show();
            } else if (res.data === "AMOUNT_FULL") {
                alert("장바구니에 담은 상품이 상품 재고보다 많아 추가 구매한 상품은 취소되었습니다.")
                location.href = "/order";
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