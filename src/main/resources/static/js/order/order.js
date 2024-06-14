
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

const isSameOrderInformationChecked = document.querySelector('.is-same-orderInformation-chk');

if (isSameOrderInformationChecked){
    axios.get('/order/user')

}else {

}


