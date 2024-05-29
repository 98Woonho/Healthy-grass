const categorySelect = document.getElementById('categorySelect');
const majorCategory = document.getElementById('majorCategory');


const changeCategorySelect = () => {
    if (categorySelect.value === 'direct-input') {
        majorCategory.value = '';
        majorCategory.style.pointerEvents = 'auto'; // pointer-events: auto 로 변경
        majorCategory.focus();
    } else {
        majorCategory.style.pointerEvents = 'none'; // pointer-events: none 로 변경
        majorCategory.value = categorySelect.value;
    }
}