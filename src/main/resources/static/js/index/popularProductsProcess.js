document.addEventListener("DOMContentLoaded", function () {
    const categoryTabs = document.querySelectorAll('.mainPrdTab h5');
    const productLists = document.querySelectorAll('.mainPrdLst');

    // 탭 클릭 이벤트 설정
    categoryTabs.forEach(tab => {
        tab.addEventListener('click', function (event) {
            event.preventDefault();
            const targetId = this.querySelector('a').getAttribute('href').substring(1);

            categoryTabs.forEach(t => t.classList.remove('on'));
            productLists.forEach(list => list.style.display = 'none');

            this.classList.add('on');
            document.getElementById(targetId).style.display = 'block';
        });
    });

    // 초기 데이터 로드
    loadAllProducts();

    function loadAllProducts() {
        axios.get('/popularProducts')
            .then(response => {
                if (response.data.success) {
                    const data = response.data;
                    updateProductList('tablist_1', data.allCategoryProducts);
                    updateProductList('tablist_2', data.riceProducts);
                    updateProductList('tablist_3', data.fruitVegetableProducts);
                    updateProductList('tablist_4', data.meatProducts);
                    updateProductList('tablist_5', data.healthProducts);
                    updateProductList('tablist_6', data.processedFoodProducts);
                } else {
                    alert("DB로 부터 데이터조회에 실패하였습니다.");
                }
            })
            .catch(error => {
                alert("서버로부터 상품 데이터를 가져오는데 실패하였습니다.")
            });
    }

    function updateProductList(categoryId, products) {
        const productListElement = document.getElementById(categoryId).querySelector('.item-wrap');
        productListElement.innerHTML = ''; // 기존 아이템 삭제

        products.forEach(product => {
            const itemHtml = `
                <div class="item-list">
                    <div class="thumb">
                        <a href="/product?id=${product.id}"><img src="${product.mainImgPath}" class="MS_prod_img_m MS_prod_img_s"></a>
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