let totalPriceText = document.getElementById('totalPrice');
const totalProductAmount = parseInt(totalPriceText.textContent);
let quantityInput = document.getElementById('quantity');

//수량이 변하면 총 상품금액이 변하는 로직
function getProductPrice() {
    axios.post('/productPrice', {'totalProductAmount' : totalProductAmount})
        .then(function(resp) {
            console.log(resp.data)
            totalPriceText.textContent = resp.data * parseInt(quantityInput.value);
            console.log(totalPriceText.textContent);
        })
        .catch(function(err) {
            // Handle error
            console.log(err);
        });
}
quantityInput.addEventListener('input', function() {
    if (quantityInput.value < 1){
        quantityInput.value = 1;
        alert("상품은 무조건 한개 이상 구매해야합니다.")
    }
    if (quantityInput.value > parseInt(productAmount.textContent)){
        quantityInput.value = parseInt(productAmount.textContent)
        alert("재고보다 더 많은 상품을 구매할 수 없습니다.")
    }
    getProductPrice();
});

const amountUp = document.querySelector('.up');
const amountDown = document.querySelector('.down');
const productAmount = document.querySelector('.productAmount');
amountUp.addEventListener('click', function (e){
    e.preventDefault();

    quantityInput.value = ++quantityInput.value;
    if (quantityInput.value > parseInt(productAmount.textContent)){
        quantityInput.value = parseInt(productAmount.textContent)
        alert("재고보다 더 많은 상품을 구매할 수 없습니다.")
    }
    getProductPrice();
})

amountDown.addEventListener('click', function (e){
    e.preventDefault();

    quantityInput.value = --quantityInput.value;
    if (quantityInput.value < 1){
        quantityInput.value = 1;
        alert("상품은 무조건 한개 이상 구매해야합니다.")
    }
    getProductPrice();
})

const buyNowBtn = document.querySelector('.buyNowBtn');

buyNowBtn.addEventListener('click', function (e){
    e.preventDefault();

    const productName = document.getElementById('productName').textContent.trim();
    const productImage = document.getElementById('productImage');
    const productPrice = parseInt(document.getElementById('productPrice').textContent.trim());
    const discountedPrice = parseInt(document.getElementById('discountedPrice').textContent.trim());
    const discount = productPrice - discountedPrice;
    const amount = parseInt(document.getElementById('quantity').value);
    const totalPrice = document.getElementById('totalPrice').textContent.trim();
    const productUrl = window.location.pathname + window.location.search;

    const form = document.getElementById('productForm');

    // value 값을 설정
    form.querySelector('input[name="name"]').value = productName;
    form.querySelector('input[name="mainImgPath"]').value = productImage.getAttribute('src');
    form.querySelector('input[name="mainImgName"]').value = productImage.getAttribute('alt');
    form.querySelector('input[name="price"]').value = productPrice;
    form.querySelector('input[name="discountedPrice"]').value = discountedPrice;
    form.querySelector('input[name="discount"]').value = discount;
    form.querySelector('input[name="amount"]').value = amount;
    form.querySelector('input[name="totalPrice"]').value = totalPrice;
    form.querySelector('input[name="productUrl"]').value = productUrl;

    form.submit();
});


