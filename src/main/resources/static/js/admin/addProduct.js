const addProductForm = document.getElementById('addProductForm');
const mainUploadBox = document.getElementById('mainUploadBox');
const subUploadBox = document.getElementById('subUploadBox');
const majorCategorySelect = document.getElementById('majorCategorySelect');
const middleCategorySelect = document.getElementById('middleCategorySelect');
const majorCategory = document.getElementById('majorCategory');
const middleCategory = document.getElementById('middleCategory');
const middleCategoryOptions = middleCategorySelect.querySelectorAll('option');

majorCategory.value = majorCategorySelect.value;
middleCategory.value = middleCategorySelect.value;

// 서브 카테고리 필터 함수
function filterMiddleCategory() {
    middleCategoryOptions.forEach(middleCategoryOption => {
        if (majorCategorySelect.value !== middleCategoryOption.getAttribute('data-major-category-name')) {
            middleCategoryOption.disabled = true;
            middleCategoryOption.style.display = 'none';
        } else {
            middleCategoryOption.disabled = false;
            middleCategoryOption.style.display = 'block';
        }
    })
}

filterMiddleCategory();


// 메인 카테고리 선택 시 이벤트
majorCategorySelect.addEventListener('change', function () {
    filterMiddleCategory();
    majorCategory.value = majorCategorySelect.value;
})

// 서브 카테고리 선택 시 이벤트
middleCategorySelect.addEventListener('change', function () {
    middleCategory.value = middleCategorySelect.value;
})

let mainImage;

// 메인 이미지 등록 dragover event
mainUploadBox.addEventListener('dragover', (e) => {
    e.preventDefault();
    mainUploadBox.style.opacity = '0.5';
});

// 메인 이미지 등록 drop event
mainUploadBox.addEventListener('drop', (e) => {
    e.preventDefault();

    // 이미지가 등록되어있는 상황에서 더 등록할 시, 경고문 출력
    if (mainPreview.querySelectorAll('.item').length === 1) {
        alert('대표 이미지는 한 개만 등록 가능합니다.');
        return;
    }

    const mainImages = e.dataTransfer.files;
    mainImage = e.dataTransfer.files[0];

    // 여러 개 drop 시 경고문 출력
    if (mainImages.length > 1) {
        alert('메인 이미지는 한 개만 등록 가능합니다.');
        return;
    }

    // 이미지가 아닌 파일 drop 시 경고문 출력
    if (!mainImages[0].type.startsWith('image/')) {
        alert('이미지 파일만 가능합니다.');
        return;
    }

    // 이미지 파일 용량 제한
    if (mainImage.size > (1024 * 1024 * 5)) {
        alert('파일 하나당 최대 사이즈는 5MB이하여야 합니다.');
        return;
    }

    const reader = new FileReader(); // FileReader
    reader.readAsDataURL(mainImage); // reader에 image 정보 넣기.
    reader.onload = function (e) {
        const src = e.target.result;

        const item = new DOMParser().parseFromString(`
                <li class="item">
                    <img src="${src}" alt="">
                    <button type="button" class="delete-btn">삭제</button>
                </li>
            `, 'text/html').querySelector('.item');
        const deleteBtn = item.querySelector('.delete-btn');

        // 메인 이미지 프리뷰에 이미지 item 추가
        mainPreview.append(item);

        // 삭제 버튼 클릭 event
        deleteBtn.addEventListener('click', () => {
            item.remove();
            mainImage = undefined;
        })
    }
})


let subImage;

// 서브 이미지 등록 dragover event
subUploadBox.addEventListener('dragover', (e) => {
    e.preventDefault();
    subUploadBox.style.opacity = '0.5';
});

// 서브 이미지 등록 drop event
subUploadBox.addEventListener('drop', (e) => {
    e.preventDefault();

    // 이미지가 등록되어있는 상황에서 더 등록할 시, 경고문 출력
    if (subPreview.querySelectorAll('.item').length === 1) {
        alert('서브 이미지는 한 개만 등록 가능합니다.');
        return;
    }

    const subImages = e.dataTransfer.files;
    subImage = e.dataTransfer.files[0];

    // 여러 개 drop 시 경고문 출력
    if (subImages.length > 1) {
        alert('서브 이미지는 한 개만 등록 가능합니다.');
        return;
    }

    // 이미지가 아닌 파일 drop 시 경고문 출력
    if (!subImages[0].type.startsWith('image/')) {
        alert('이미지 파일만 가능합니다.');
        return;
    }

    // 이미지 파일 용량 제한
    if (subImage.size > (1024 * 1024 * 5)) {
        alert('파일 하나당 최대 사이즈는 5MB이하여야 합니다.');
    }

    const reader = new FileReader(); // FileReader
    reader.readAsDataURL(subImage); // reader에 image 정보 넣기.
    reader.onload = function (e) {
        const src = e.target.result;

        const item = new DOMParser().parseFromString(`
                <li class="item">
                    <img src="${src}" alt="">
                    <button type="button" class="delete-btn">삭제</button>
                </li>
            `, 'text/html').querySelector('.item');
        const deleteBtn = item.querySelector('.delete-btn');

        // 서브 이미지 프리뷰에 이미지 item 추가
        subPreview.append(item);

        // 삭제 버튼 클릭 event
        deleteBtn.addEventListener('click', () => {
            item.remove();
            subImage = undefined;
        })
    }
})


// 제품 등록 submit
addProductForm.onsubmit = function(e) {
    e.preventDefault();

    const priceRegex = new RegExp("^\\d+$");
    const disCountRegex = new RegExp("^\\d+$");
    const amountRegex = new RegExp("^\\d+$");

    if (addProductForm['name'].value === '') {
        alert('제품명을 입력해 주세요.');
        return;
    }

    if (addProductForm['price'].value === '') {
        alert('가격을 입력해 주세요.');
        return;
    }

    if (!priceRegex.test(addProductForm['price'].value)) {
        alert('올바른 가격을 입력해 주세요.');
        return;
    }

    if (addProductForm['amount'].value === '') {
        alert('수량을 입력해 주세요.');
        return;
    }

    if (!amountRegex.test(addProductForm['amount'].value)) {
        alert('올바른 수량을 입력해 주세요.');
        return;
    }

    if (addProductForm['discount'].value === '') {
        alert('할인율을 입력해 주세요.');
        return;
    }

    if (!disCountRegex.test(addProductForm['discount'].value)) {
        alert('올바른 할인율을 입력해 주세요.');
        return;
    }

    if (addProductForm['majorCategory'].value === '') {
        alert('메인 카테고리를 선택 및 입력해 주세요.');
        return;
    }

    if (addProductForm['middleCategory'].value === '') {
        alert('서브 카테고리를 선택 및 입력해 주세요.');
        return;
    }

    if (addProductForm['content'].value === '') {
        alert('제품 설명을 입력해 주세요.');
        return;
    }

    if (mainPreview.querySelector('.item') === null) {
        alert('메인 이미지를 등록해 주세요.');
        return;
    }

    if (subPreview.querySelector('.item') === null) {
        alert('서브 이미지를 등록해 주세요.');
        return;
    }

    const formData = new FormData(this);
    formData.append('mainImage', mainImage);
    formData.append('subImage', subImage);

    axios.post('/admin/product', formData, { header : { 'Content-Type': 'multipart/form-data' }})
        .then(res => {
            alert(res.data);
            location.href = '/admin/productList';
        })
        .catch(err => {
            alert('알 수 없는 이유로 제품 등록에 실패 하였습니다. 잠시 후 다시 시도해 주세요.');
        })
}