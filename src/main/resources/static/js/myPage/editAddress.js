const searchAddressBtn = document.getElementById('searchAddressBtn');
const editAddressForm = document.getElementById('editAddressForm');

const PhoneRegex = (target) => {
    const maxLength = 13;
    if (target.value.length > maxLength) {
        target.value = target.value.slice(0, maxLength);
    }

    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}
searchAddressBtn.addEventListener('click', function () {
    new daum.Postcode({
        oncomplete: function (data) {
            let addr = '';
            if (data.userSelectedType === 'R') {
                // 도로명 주소
                addr = data.roadAddress;
            } else {
                // 지번 주소
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            editAddressForm.zipcode.value = data.zonecode;
            editAddressForm.streetAdr.value = addr;
            // 커서를 상세주소 필드로 이동한다.
            editAddressForm.detailAdr.focus();
            // editAddressForm['region'].value = addr.split(" ")[0];
        }
    }).open();
})

editAddressForm.onsubmit = function(e) {
    e.preventDefault();

    const nameRegex = new RegExp('^[가-힣]{2,5}$');
    const phoneRegex = new RegExp('^01[0-9]-\\d{3,4}-\\d{4}$');

    if (editAddressForm.name.value === '') {
        alert('이름을 입력해 주세요.');
        return;
    }

    if (!nameRegex.test(editAddressForm.name.value)) {
        alert('올바른 이름을 입력해 주세요.');
        return;
    }

    if (editAddressForm.zipcode.value === '' || editAddressForm.streetAdr.value === '') {
        alert('우편번호 찾기를 통해 우편번호 및 주소를 입력해 주세요.');
        return;
    }

    if (editAddressForm.detailAdr.value === '') {
        alert('상세 주소를 입력해 주세요.');
        return;
    }

    if (editAddressForm.phone.value === '') {
        alert('휴대폰 번호를 입력해 주세요.');
        return;
    }

    if (!phoneRegex.test(editAddressForm.phone.value)) {
        alert('올바른 휴대폰 번호를 입력해 주세요.');
        return;
    }

    const formData = new FormData(editAddressForm);

    axios.post('/myPage/editAddress', formData)
        .then(res => {
            alert(res.data);
        })
        .catch(err => {
            alert('알 수 없는 이유로 배송지 저장에 실패 하였습니다. 잠시 후 다시 시도해 주세요.');
        })
}