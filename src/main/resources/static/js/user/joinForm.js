const joinForm = document.joinForm;

joinForm.id.addEventListener('input', function () {
    if (joinForm.id.classList.contains("confirmed")) {
        joinForm.id.classList.remove("confirmed");
    }
})

joinForm.confirmUserIdDuplicationBtn.addEventListener('click', function () {
    if (joinForm.id.value === "") {
        return;
    }

    axios.get("/user/confirmUserId?id=" + joinForm.id.value)
        .then(res => {
            if (res.data === "FAILURE_DUPLICATED_USER_ID") {
                alert("이미 존재하는 아이디입니다. 다른 아이디를 입력해 주세요.");

            } else {
                alert("사용 가능한 아이디입니다.");
                joinForm.id.classList.add("confirmed");
            }
        })
        .catch(err => {
            console.log(err);
        })
})
const UserPasswordRegex = new RegExp("^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$");
const UserIdRegex = new RegExp("^[A-Za-z0-9]{6,16}$");

joinForm.searchAddressBtn.addEventListener('click', function () {
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
            joinForm.zipcode.value = data.zonecode;
            joinForm.streetAdr.value = addr;
            // 커서를 상세주소 필드로 이동한다.
            joinForm.detailAdr.focus();
            // joinForm['region'].value = addr.split(" ")[0];
        }
    }).open();
})

// 유효성 검사 함수
function validateForm() {
    const idInput = joinForm.id.value.trim();
    const passwordInput = joinForm.password.value.trim();
    const pwChkHintInput = joinForm.pwChkHint.value.trim();
    const pwChkAnsInput = joinForm.pwChkAns.value.trim();
    const zipcodeInput = joinForm.zipcode.value.trim();
    const streetAdrInput = joinForm.streetAdr.value.trim();
    const phoneInput = joinForm.phone.value.trim();

    const idErrorMessage = document.querySelector('.idError');
    const passwordErrorMessage = document.querySelector('.passwordError');
    const pwChkHintErrorMessage = document.querySelector('.pwChkHintError');
    const pwChkAnsErrorMessage = document.querySelector('.pwChkAnsError');
    const zipcodeErrorMessage = document.querySelector('.zipcodeError');
    const streetAdrErrorMessage = document.querySelector('.streetAdrError');
    const phoneErrorMessage = document.querySelector('.phoneError');

    // 아이디 유효성 검사
    if (!joinForm.id.classList.contains("confirmed")) {
        alert("유저 중복 확인을 진행해주세요.");
    } else if (idInput === "") {
        idErrorMessage.innerHTML = "아이디를 입력해주세요";
    } else if (!UserIdRegex.test(idInput)) {
        idErrorMessage.innerHTML = "아이디는 소문자와 숫자로만 이루어진 6~16자여야 합니다.";
    } else {
        idErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 비밀번호 유효성 검사
    if (passwordInput === "") {
        passwordErrorMessage.innerHTML = "비밀번호를 입력해주세요";
    } else if (!UserPasswordRegex.test(passwordInput)) {
        passwordErrorMessage.innerHTML = "비밀번호는 영문, 숫자, 특수문자가 1개 이상 포함된 8~15자여야 합니다.";
    } else {
        passwordErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 비밀번호 확인 질문 유효성 검사
    if (pwChkHintInput === "") {
        pwChkHintErrorMessage.innerHTML = "비밀번호 확인 질문을 입력하세요";
    } else {
        pwChkHintErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 비밀번호 확인 답변 유효성 검사
    if (pwChkAnsInput === "") {
        pwChkAnsErrorMessage.innerHTML = "비밀번호 확인 답변을 입력하세요";
    } else {
        pwChkAnsErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 우편번호 유효성 검사
    if (zipcodeInput === "") {
        zipcodeErrorMessage.innerHTML = "우편번호를 입력하세요";
    } else {
        zipcodeErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 주소 유효성 검사
    if (streetAdrInput === "") {
        streetAdrErrorMessage.innerHTML = "주소를 입력하세요";
    } else {
        streetAdrErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 전화번호 유효성 검사
    if (phoneInput === "") {
        phoneErrorMessage.innerHTML = "전화번호를 입력하세요";
    } else {
        phoneErrorMessage.innerHTML = ""; // 오류 메시지를 지워줌
    }

    // 모든 필드가 유효한 경우 수정요망!!!
    if(idErrorMessage.value === "" &&
        passwordErrorMessage.value === "" &&
        pwChkHintErrorMessage.value === "" &&
        pwChkAnsErrorMessage.value === "" &&
        zipcodeErrorMessage.value === "" &&
        streetAdrErrorMessage.value === "" &&
        phoneErrorMessage.value === ""){
        return true
    } else {
        return false
    }
}
// 이벤트 리스너 등록
const joinBtn = document.querySelector(".joinBtn");
joinBtn.addEventListener('click', function (e) {
    e.preventDefault();
    console.log(validateForm());

    if (validateForm()){
        const data = {
            id: joinForm.id.value,
            password: joinForm.password.value,
            pwChkHint: joinForm.pwChkHint.value,
            pwChkAns: joinForm.pwChkAns.value,
            zipcode: joinForm.zipcode.value,
            streetAdr: joinForm.streetAdr.value,
            detailAdr: joinForm.detailAdr.value,
            phone: joinForm.phone.value,
            email: joinForm.email.value
        };


        axios.post("/users", data, {headers: {"Content-Type": "application/json"}})
            .then(resp => {
                if (resp.data === "SUCCESS") {
                    alert("성공적으로 회원가입이 완료되었습니다.")
                    location.href = "/";
                } else alert("알수없는 이유로 회원가입에 실패하였습니다.")
            })
            .catch(err => {
                console.log();
            })
    }
    }
)