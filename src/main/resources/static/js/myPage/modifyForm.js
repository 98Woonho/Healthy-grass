modifyForm = document.querySelector('.modifyForm');

const UserPasswordRegex = new RegExp("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$");
const EmailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", "i");
const PhoneRegex = (target) => {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

modifyForm.searchAddressBtn.addEventListener('click', function () {
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
            modifyForm.zipcode.value = data.zonecode;
            modifyForm.streetAdr.value = addr;
            // 커서를 상세주소 필드로 이동한다.
            modifyForm.detailAdr.focus();
            // modifyForm['region'].value = addr.split(" ")[0];
        }
    }).open();
})

// 유효성 검사 함수
function validateForm() {
    const passwordInput = modifyForm.password.value.trim();
    const rePasswordInput = modifyForm.rePassword.value.trim();
    const zipcodeInput = modifyForm.zipcode.value.trim();
    const streetAdrInput = modifyForm.streetAdr.value.trim();
    const emailInput = modifyForm.email.value.trim();


    const passwordErrorMessage = document.querySelector('.passwordError');
    const rePasswordErrorMessage = document.querySelector('.rePasswordError');
    const zipcodeErrorMessage = document.querySelector('.zipcodeError');
    const streetAdrErrorMessage = document.querySelector('.streetAdrError');
    const emailErrorMessage = document.querySelector('.emailError');


// 비밀번호 유효성 검사
    if (passwordInput === "") {
        passwordErrorMessage.innerText = "비밀번호를 입력해주세요";
        passwordErrorMessage.style.color = "red";
    } else if (!UserPasswordRegex.test(passwordInput)) {
        passwordErrorMessage.innerText = "비밀번호는 영문, 숫자, 특수문자가 1개 이상 포함된 8~15자여야 합니다.";
        passwordErrorMessage.style.color = "red";
    } else if (passwordInput !== rePasswordInput){
        rePasswordErrorMessage.innerText = "비밀번호가 일치하지 않습니다."
        rePasswordErrorMessage.style.color = "red";
    } else {
        rePasswordErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }

// 우편번호 유효성 검사
    if (zipcodeInput === "") {
        zipcodeErrorMessage.innerText = "우편번호를 입력하세요";
        zipcodeErrorMessage.style.color = "red";
    } else {
        zipcodeErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }

// 주소 유효성 검사
    if (streetAdrInput === "") {
        streetAdrErrorMessage.innerText = "주소를 입력하세요";
        streetAdrErrorMessage.style.color = "red";
    } else {
        streetAdrErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }

    //이메일 유효성 검사
    if (emailInput === "") {
        emailErrorMessage.innerText = "이메일을 입력하세요";
        emailErrorMessage.style.color = "red";
    } else if (!EmailRegex.test(emailInput)) {
        emailErrorMessage.innerText = "이메일 형식으로 입력해주세요 이메일형식은 email@naver.com 입니다.";
        emailErrorMessage.style.color = "red";
    } else {
        emailErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }


    // 모든 필드가 유효한 경우
    if (passwordErrorMessage.innerText === "" &&
        zipcodeErrorMessage.innerText === "" &&
        streetAdrErrorMessage.innerText === "" &&
        emailErrorMessage.innerText === "" &&
        rePasswordErrorMessage.innerText === ""){
        return true
    } else {
        return false
    }
}

// 이벤트 리스너 등록
const modifyBtn = document.querySelector(".modifyBtn");
modifyBtn.addEventListener('click', function (e) {
        e.preventDefault();
        console.log(validateForm());
        if (validateForm() === false) {
            alert('유효성 체크를 진행하세요')
        } else {
            const data = {
                id: modifyForm.id.value,
                name: modifyForm.name.value,
                password: modifyForm.password.value,
                rePassword : modifyForm.rePassword.value,
                zipcode: modifyForm.zipcode.value,
                streetAdr: modifyForm.streetAdr.value,
                detailAdr: modifyForm.detailAdr.value,
                phone: modifyForm.phone.value,
                email: modifyForm.email.value
            };

            axios.post("/myPage/user/modify", data, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    if (resp.data === "SUCCESS") {
                        alert("성공적으로 회원수정이 완료되었습니다.")
                        location.href = "/user/loginForm";
                    } else alert("알수없는 이유로 회원수정에 실패하였습니다.")
                })
                .catch(err => {
                    console.log(err);
                })
        }
    }
)