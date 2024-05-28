const joinForm = document.joinForm;
const authBtn = document.querySelector('.auth_btn');

IMP.init("imp40654467"); // IMPort 고객사 식별코드

let success = false;

authBtn.addEventListener('click', function (e){
    e.preventDefault();

    IMP.certification({ //본인인증이 완료되면 resp에 success를 담아준다.
        pg: "inicis_unified",
        merchant_uid: "test_lwk1pvez",
    }, function (resp){
        const imp_uid = resp.imp_uid;
        success = resp.success;

        axios.get("/user/getAuthInfo/"+imp_uid)
            .then(response =>{
                const nameInput = joinForm.name;
                const phoneInput = joinForm.phone;

                nameInput.value = response.data.response.name;
                phoneInput.value = response.data.response.phone;
            })
            .catch(error =>{console.log(error)})
    });
})

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
const EmailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", "i");
const PhoneRegex = (target) => {
    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}

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
    const nameInput = joinForm.name.value.trim();
    const passwordInput = joinForm.password.value.trim();
    const rePasswordInput = joinForm.rePassword.value.trim();
    const zipcodeInput = joinForm.zipcode.value.trim();
    const streetAdrInput = joinForm.streetAdr.value.trim();
    const phoneInput = joinForm.phone.value.trim();
    const emailInput = joinForm.email.value.trim();


    const idErrorMessage = document.querySelector('.idError');
    const passwordErrorMessage = document.querySelector('.passwordError');
    const rePasswordErrorMessage = document.querySelector('.rePasswordError');
    const zipcodeErrorMessage = document.querySelector('.zipcodeError');
    const streetAdrErrorMessage = document.querySelector('.streetAdrError');
    const phoneErrorMessage = document.querySelector('.phoneError');
    const emailErrorMessage = document.querySelector('.emailError');
    const nameErrorMessage = document.querySelector('.nameError');

    // 아이디 유효성 검사

    if (idInput === "") {
        idErrorMessage.innerText = "아이디를 입력해주세요";
        idErrorMessage.style.color = "red";
    } else if (!UserIdRegex.test(idInput)) {
        idErrorMessage.innerText = "아이디는 소문자와 숫자로만 이루어진 6~16자여야 합니다.";
        idErrorMessage.style.color = "red";
    } else {
        idErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }
// 이름 유효성 검사
    if (nameInput === "") {
        nameErrorMessage.innerText = "이름을 입력하세요";
        nameErrorMessage.style.color = "red";
    } else {
        nameErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }


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
        passwordErrorMessage.innerText = "";
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

// 전화번호 유효성 검사
    if (phoneInput === "") {
        phoneErrorMessage.innerText = "전화번호를 입력하세요";
        phoneErrorMessage.style.color = "red";
    } else {
        phoneErrorMessage.innerText = ""; // 오류 메시지를 지워줌
    }

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
    if (idErrorMessage.innerText === "" &&
        passwordErrorMessage.innerText === "" &&
        zipcodeErrorMessage.innerText === "" &&
        streetAdrErrorMessage.innerText === "" &&
        phoneErrorMessage.innerText === "" &&
        emailErrorMessage.innerText === ""
        && rePasswordErrorMessage.innerText === ""){
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
        if (validateForm() === false && joinForm.id.classList.contains("confirmed")) {
            alert('유효성 체크를 진행하세요')
            return;
        } else if(!joinForm.id.classList.contains("confirmed")) {
            alert("유저 중복 확인을 진행해주세요.");
            return;
        } {
            const data = {
                id: joinForm.id.value,
                name: joinForm.name.value,
                password: joinForm.password.value,
                rePassword : joinForm.rePassword.value,
                zipcode: joinForm.zipcode.value,
                streetAdr: joinForm.streetAdr.value,
                detailAdr: joinForm.detailAdr.value,
                phone: joinForm.phone.value,
                email: joinForm.email.value
            };

            axios.post("/user", data, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    if (resp.data === "SUCCESS") {
                        alert("성공적으로 회원가입이 완료되었습니다.")
                        location.href = "/user/loginForm";
                    } else alert("알수없는 이유로 회원가입에 실패하였습니다.")
                })
                .catch(err => {
                    console.log();
                })
        }
    }
)