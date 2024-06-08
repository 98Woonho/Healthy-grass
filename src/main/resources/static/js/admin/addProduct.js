const addProductForm = document.getElementById('addProductForm');
const mainUploadBox = document.getElementById('mainUploadBox');
const subUploadBox = document.getElementById('subUploadBox');

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
                    <input hidden type="text" class="file-name" name="mainFileName" th:value="${mainImage.name}">
                    <img src="${src}" alt="">
                    <button type="button" id="deleteBtn">삭제</button>
                </li>
            `, 'text/html').querySelector('.item');
        const deleteBtn = item.querySelector('#deleteBtn');

        // 메인 이미지 프리뷰에 이미지 item 추가
        mainPreview.append(item);

        // 삭제 버튼 클릭 event
        deleteBtn.addEventListener('click', () => {
            item.remove();
        })
    }
})

addProductForm.onsubmit = (e) => {
    e.preventDefault();

    console.log(mainImage);

    const formData = new FormData(this);
    formData.append('mainImage', mainImage); // 추가를 원함
}