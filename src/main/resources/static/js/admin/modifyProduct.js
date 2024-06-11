const modifyProductForm = document.getElementById('modifyProductForm');
const mainUploadBox = document.getElementById('mainUploadBox');
const subUploadBox = document.getElementById('subUploadBox');
const majorCategory = document.getElementById('majorCategory');
const middleCategory = document.getElementById('middleCategory');
const mainPreview = document.getElementById('mainPreview');
const subPreview = document.getElementById('subPreview');
const items = document.querySelectorAll('.item');

items.forEach(item => {
    const deleteBtn = item.querySelector('.delete-btn');

    deleteBtn.addEventListener('click', () => {
        item.remove();
    })
})

// 카테고리 선택 function
const changeCategorySelect = (select) => {
    const categoryInput = select.parentElement.querySelector('input');

    // 카테고리에서 직접 입력 select 시
    if (select.value === 'direct-input') {
        categoryInput.value = '';
        categoryInput.style.pointerEvents = 'auto'; // pointer-events: auto 로 변경
        categoryInput.focus();
    } else {
        categoryInput.style.pointerEvents = 'none'; // pointer-events: none 로 변경
        categoryInput.value = select.value;
    }
}

let mainImage;

// 메인 이미지 등록 dragover event
mainUploadBox.addEventListener('dragover', (e) => {
    e.preventDefault();
    mainUploadBox.style.opacity = '0.5';
});

// 메인 이미지 등록 drop event
mainUploadBox.addEventListener('drop', (e) => {
    e.preventDefault();

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

    // 메인 이미지와 동일한 이미지는 등록 불가
    if (subImage && mainImage.name === subImage.name) {
        alert('동일한 이미지는 등록할 수 없습니다.');
        return;
    }

    const reader = new FileReader(); // FileReader
    const mainPreview = document.getElementById('mainPreview');

    // 이미지가 등록되어있는 상황에서 더 등록할 시, 경고문 출력
    if (mainPreview.querySelectorAll('.item').length === 1) {
        alert('대표 이미지는 한 개만 등록 가능합니다.');
        return;
    }

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

    // 메인 이미지와 동일한 이미지는 등록 불가
    if (mainImage && subImage.name === mainImage.name) {
        alert('동일한 이미지는 등록할 수 없습니다.');
        return;
    }

    const reader = new FileReader(); // FileReader
    const subPreview = document.getElementById('subPreview');

    // 이미지가 등록되어있는 상황에서 더 등록할 시, 경고문 출력
    if (subPreview.querySelectorAll('.item').length === 1) {
        alert('대표 이미지는 한 개만 등록 가능합니다.');
        return;
    }

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
modifyProductForm.onsubmit = function(e) {
    e.preventDefault();

    const priceRegex = new RegExp("^\\d+$");
    const disCountRegex = new RegExp("^\\d+$");
    const amountRegex = new RegExp("^\\d+$");

    if (modifyProductForm['name'].value === '') {
        alert('제품명을 입력해 주세요.');
        return;
    }

    if (modifyProductForm['price'].value === '') {
        alert('가격을 입력해 주세요.');
        return;
    }

    if (!priceRegex.test(modifyProductForm['price'].value)) {
        alert('올바른 가격을 입력해 주세요.');
        return;
    }

    if (modifyProductForm['amount'].value === '') {
        alert('수량을 입력해 주세요.');
        return;
    }

    if (!amountRegex.test(modifyProductForm['amount'].value)) {
        alert('올바른 수량을 입력해 주세요.');
        return;
    }

    if (modifyProductForm['discount'].value === '') {
        alert('할인율을 입력해 주세요.');
        return;
    }

    if (!disCountRegex.test(modifyProductForm['discount'].value)) {
        alert('올바른 할인율을 입력해 주세요.');
        return;
    }

    if (modifyProductForm['majorCategory'].value === '') {
        alert('메인 카테고리를 선택 및 입력해 주세요.');
        return;
    }

    if (modifyProductForm['middleCategory'].value === '') {
        alert('서브 카테고리를 선택 및 입력해 주세요.');
        return;
    }

    if (modifyProductForm['content'].value === '') {
        alert('제품 설명을 입력해 주세요.');
        return;
    }

    if (mainPreview.querySelector('.item') === null) {
        alert('메인 이미지를 등록해 주세요.');
        return;
    }

    if (mainPreview.querySelector('.item') === null) {
        alert('서브 이미지를 등록해 주세요.');
        return;
    }

    const formData = new FormData(this);
    formData.append('mainImage', mainImage);
    formData.append('subImage', subImage);
    formData.append('content', document.getElementById('content').value);

    axios.put('/admin/product', formData, { header : { 'Content-Type': 'multipart/form-data' }})
        .then(res => {
            console.log(res);
            alert(res.data);
        })
        .catch(err => {
            alert('알 수 없는 이유로 제품 등록에 실패 하였습니다. 잠시 후 다시 시도해 주세요.');
        })
}