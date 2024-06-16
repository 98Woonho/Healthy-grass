
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
isSameOrderInformationChecked.addEventListener('change', function (e){
    e.preventDefault()
    const receiver = document.querySelector('.receiver');
    const zipcode = document.querySelector('.zipcode');
    const streetAdr = document.querySelector('.streetAdr');
    const detailAdr = document.querySelector('.detailAdr');
    const phone = document.querySelector('.phone');
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



