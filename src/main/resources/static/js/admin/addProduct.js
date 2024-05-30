const addProductForm = document.getElementById('addProductForm');
const uploadBoxes = document.querySelectorAll('.upload-box');

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



// 이미지 uploadBox에 drop event
uploadBoxes.forEach(uploadBox => {
    uploadBox.addEventListener('dragover', (e) => {
        e.preventDefault();
        uploadBox.style.opacity = '0.5';
    });

    uploadBox.addEventListener('drop', (e) => {
        e.preventDefault();

        const imgFiles = Array.from(e.dataTransfer.files).filter(f => f.type.startsWith('image/'));

        if (imgFiles.length === 0) {
            alert("이미지 파일만 가능합니다.");
            return;
        }
    })
})

addProductForm.onsubmit = (e) => {
    e.preventDefault();
}