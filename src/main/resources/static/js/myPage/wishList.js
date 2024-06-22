const pageno = document.getElementById('pageno');
const allSelect = document.getElementById('allSelect');
const selects = document.querySelectorAll('.select');
const productInfos = document.querySelectorAll('.product-info');

allSelect.addEventListener('click', function () {
    selects.forEach(select => {
        select.checked = allSelect.checked;
    })
})

productInfos.forEach(productInfo => {
    const addCartBtn = productInfo.querySelector('.add-cart-btn');
    const deleteBtn = productInfo.querySelector('.delete-btn');

    // 장바구니 추가 버튼
    addCartBtn.addEventListener('click', function () {
        axios.post('/cart', {
            productId: productInfo.getAttribute('data-pid'),
            quantity: 1
        })
            .then(res => {
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

    // 찜한 상품 삭제 버튼
    deleteBtn.addEventListener('click', function () {
        const pIds = [productInfo.getAttribute('data-pId')];

        axios.delete(`/myPage/wish/${pIds}`)
            .then(res => {
                location.href = `/myPage/wishList?pageno=${pageno.value}`;
            })
            .catch(err => {
                alert('알 수 없는 이유로 삭제하지 못하였습니다. 잠시 후 다시 시도해 주세요.');
            })
    })
})

const handleSelectDelete = () => {
    let pIds = [];

    productInfos.forEach(productInfo => {
        const select = productInfo.querySelector('.select');

        if (select.checked) {
            pIds.push(productInfo.getAttribute('data-pid'));
        }
    })

    axios.delete(`/myPage/wish/${pIds}`)
        .then(res => {
            location.href = `/myPage/wishList?pageno=${pageno.value}`;
        })
        .catch(err => {
            alert('알 수 없는 이유로 삭제하지 못하였습니다. 잠시 후 다시 시도해 주세요.');
        })
}