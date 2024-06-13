const salePrices = document.querySelectorAll('.sale_price');

let totalSalePrice = 0;

salePrices.forEach(function(sale) {
    let SalePrice = parseInt(sale.textContent);
        totalSalePrice += SalePrice;
});

const proudctSalePrices = document.querySelectorAll('.proudct_sale_price');

proudctSalePrices.forEach(proudctSalePrice =>{
    proudctSalePrice.textContent = totalSalePrice;
})
