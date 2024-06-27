document.addEventListener("DOMContentLoaded", function () {
    // 초기 데이터 로드
    loadHighDiscountProducts();

    function loadHighDiscountProducts() {
        axios.get('/recentProducts')
            .then(response => {
                if (response.data.success) {
                    const data = response.data;
                    updateProductList('recent-product-list', data.products);
                } else {
                    alert("DB로부터 데이터 조회에 실패하였습니다.");
                }
            })
            .catch(error => {
                alert("서버로부터 상품 데이터를 가져오는데 실패하였습니다.");
            });
    }

    function updateProductList(categoryId, products) {
        const productListElement = document.getElementById(categoryId).querySelector('.item-wrap');
        productListElement.innerHTML = ''; // 기존 아이템 삭제

        products.forEach(product => {
            const itemHtml = `
                <div class="item-list">
                    <div class="thumb">
                        <a href="/product?id=${product.id}"><img src="${product.mainImgPath + product.mainImgName}" class="MS_prod_img_m MS_prod_img_s"></a>
                    </div>
                    <div class="prd-info">
                        <ul>
                            <li class="prd-brand"><a href="/product?id=${product.id}">${product.name}</a></li>
                            <li class="prd-price"><b>${product.price}원</b></li>
                            <li class="prd-discount"><b>${product.discountedPrice}원</b> (${product.discount}% 할인)</li>
                            <li class="prd-category">카테고리: ${product.middleCategory}</li>
                            <li class="prd-review">리뷰 수: ${product.reviewCount}</li>
                            <li class="prd-rating">평점: ${product.averageRating}</li>
                        </ul>
                    </div>
                </div>
            `;
            productListElement.insertAdjacentHTML('beforeend', itemHtml);
        });
    }
});