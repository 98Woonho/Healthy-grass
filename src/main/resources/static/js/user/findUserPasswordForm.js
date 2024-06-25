const findUserPasswordForm = document.querySelector('.findUserPassword');
const findUserPasswordBtn = document.querySelector('.findUserPasswordBtn');

const EmailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", "i");
const findByEmail = document.querySelector("#findByEmail");
const emailDiv = document.querySelector("#emailDiv");
const findIdCheckBox = document.getElementsByName("findIdCheckBox");
const idDiv = document.querySelector("#idDiv");
const passwordCheck = document.querySelector("#passwordCheck");
let phoneDiv = document.querySelector("#phoneDiv");
const ipinConfirm = document.querySelector('.ipin-confirm');
function check(element) {

    findIdCheckBox.forEach((e) => {
        e.checked = false;
    })
    element.checked = true;

    if (findByEmail.checked) {
        emailDiv.classList.remove("hidden");
        idDiv.classList.remove("hidden");
        phoneDiv.classList.add("hidden");
        findUserPasswordBtn.classList.remove("hidden");
        ipinConfirm.classList.add("hidden")
    } else {
        emailDiv.classList.add("hidden");
        idDiv.classList.add("hidden");
        phoneDiv.classList.remove("hidden");
        passwordCheck.classList.add("hidden");
        findUserPasswordBtn.classList.add("hidden");
        ipinConfirm.classList.remove("hidden")
    }
}

//이메일 인증코드 보내는 코드
findUserPasswordBtn.addEventListener('click', function (e) {
    e.preventDefault();
    if (findByEmail.checked) {
        if (findUserPasswordForm.id.value === "") {
            alert("아이디를 입력해주세요.")
        } else if (findUserPasswordForm.email.value === "") {
            alert("이메일을 입력해주세요.")
        } else if (!EmailRegex.test(findUserPasswordForm.email.value)) {
            alert("이메일 형식으로 입력해주세요")
        } else {
            const data = {
                id: findUserPasswordForm.id.value,
                email: findUserPasswordForm.email.value
            };
            axios.post("/user/findUserPasswordByEmailAsRandomValue", data, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    if (resp.data === "FAILURE_NOT_FOUND_USER_PASSWORD") {
                        alert("조회결과 유저 비밀번호를 찾을 수 없습니다.")
                    } else if (resp.data === "SUCCESS") {
                        alert("이메일에 비밀번호 인증 코드를 성공적으로 전달하였습니다. 본인 이메일을 확인해주세요.")
                        const passwordCheck = document.querySelector('#passwordCheck');
                        passwordCheck.classList.remove("hidden");
                    }
                })
                .catch(err => {
                    console.log(err);
                })
        }
    }
})

//인증코드 확인
const passwordCheckBtn = document.querySelector('.passwordCheckBtn');
const passwordCheckInput = document.querySelector('.passwordCheck');
passwordCheckBtn.addEventListener('click', function (e){
    e.preventDefault();
    if (passwordCheckInput.value === ""){
        alert("패스워드 인증코드를 입력하세요")
    } else if (passwordCheckInput.value.length !== 6){
        alert("비밀번호 인증코드는 6자리만 올수 있습니다.")
    } else {
        const data = {
            passwordCheck : passwordCheckInput.value
        }
        axios.post("/user/passwordAuthenticationCodeCheck", data, {headers: {"Content-Type": "application/json"}})
            .then(resp=>{
                if (resp.data === "FAILURE_NOT_FOUND_CODE"){
                    alert("비밀번호 코드를 전송할 수 없습니다.")
                } else if (resp.data === "FAILURE_ANOTHER_CODE"){
                    alert("랜덤 코드 6자리와 입력값이 다릅니다.")
                } else if(resp.data === "SUCCESS"){
                    alert("비밀번호 코드 인증이 성공하여 이메일에 임시 비밀번호 코드를 보냅니다. 로그인 후 비밀번호 수정 페이지에서 비밀번호를 재설정해주십시오")
                    location.href = "/myPage/user/modifyForm"
                }else {
                    alert("이메일 인증에 실패하였습니다. 관리자에게 문의하십시오.")
                    return false;
                }
            })
            .catch(err =>{
                console.log(err)
            })
    }
});

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
            axios.get("/user/AuthInfo/" + imp_uid)
                .then(response => {
                    success = resp.success;
                    if (success === true){
                        const data = {
                            name: response.data.response.name,
                            phone: response.data.response.phone
                        };
                        axios.post("/user/findUserPasswordByAuthentication", data, {headers: {"Content-Type": "application/json"}})
                            .then(resp =>{
                                if (resp.data === "SUCCESS"){
                                    alert("성공적으로 비밀번호를 변경하였습니다. 이메일로 임시 비밀번호가 발송되었습니다.")
                                    location.href = "/user/loginForm";
                                }else {
                                    alert("회원가입이 되지 않은 유저입니다. 먼저 회원가입을 진행해주세요")
                                    return false;
                                }
                            })
                            .catch(err =>{
                                console.log(err)
                            })
                    }
                    })
                .catch(err => {
                    console.log(err)
                })
    });
})










