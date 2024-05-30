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