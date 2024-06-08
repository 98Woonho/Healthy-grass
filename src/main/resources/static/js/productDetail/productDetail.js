let totalPriceText = document.getElementById('totalPrice');
const totalProductAmount = parseInt(totalPriceText.textContent);
let quantityInput = document.getElementById('quantity');

//수량이 변하면 총 상품금액이 변하는 로직
function getProductPrice() {
    axios.post('/productPrice', {'totalProductAmount' : totalProductAmount})
        .then(resp=> {
            console.log(resp.data)
            totalPriceText.textContent = resp.data * parseInt(quantityInput.value);
            console.log(totalPriceText.textContent);
        })
        .catch(err => {
            // Handle error
            console.log(err);
        })
}

// function upAmount(){
// axios.post('/upAmount', {'value' : parseInt(quantityInput.value)})
//     .then(resp=> {
//         console.log(resp.data)
//         quantityInput.value = resp.data;
//         console.log(quantityInput.value);
//     })
//     .catch(err=> {
//         // Handle error
//         console.log(err);
//     });
// }
quantityInput.addEventListener('change', function (e){
    e.preventDefault()

})

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
    console.log(quantityInput.value);

    getProductPrice();


})

amountDown.addEventListener('click', function (e){
    e.preventDefault();

    quantityInput.value = --quantityInput.value;
    if (quantityInput.value < 1){
        quantityInput.value = 1;
        alert("상품은 무조건 한개 이상 구매해야합니다.")
    }
    console.log(quantityInput.value);
    getProductPrice();
})

const productId = document.querySelector("#productId");




const cartBtn = document.querySelector('.cartBtn');
cartBtn.addEventListener("click", function (e){
    e.preventDefault();
    console.log(quantityInput.value);
    axios.post('/cart', {
        "productId" : productId.value,
        "quantity" : quantityInput.value
    })

        .then(res =>{

        })
        .catch(err=> {
            console.log(err);
        });

})