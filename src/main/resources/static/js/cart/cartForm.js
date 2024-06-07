
// 체크박스 입력했을 때 모두 체크되는 로직
document.querySelector('.ALL_checked').addEventListener('change', function() {
    const isChecked = this.checked;
    document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
        checkbox.checked = isChecked;
    });
});
//증가 감소 누를 시 value값이 증가 또는 감소
const BtnUp = document.querySelector(".up");
const BtnDown = document.querySelector(".down");
const amountValue = document.querySelector(".amount_value");

BtnUp.addEventListener('click', function (e){
    e.preventDefault();
    amountValue.value = ++amountValue.value;
    // if (amountValue > )
    // 재고보다 많이 담았을 경우 amountValue 재고만큼 구매가능하게

})

BtnDown.addEventListener('click', function (e){
    e.preventDefault();
    amountValue.value = --amountValue.value;
    if (amountValue.value < 1){
        alert("물건 수량은 1개 이하로 담을 수 없습니다.")
        amountValue.value = 1;
    }
})


