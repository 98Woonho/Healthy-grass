const findUserPasswordForm = document.querySelector('.findUserPassword');
const findUserPasswordBtn = document.querySelector('.findUserPasswordBtn');

const EmailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", "i");
const findByEmail = document.querySelector("#findByEmail");
const findByPhone = document.querySelector("#findByPhone");
const phoneDiv = document.querySelector("#phoneDiv");
const emailDiv = document.querySelector("#emailDiv");
const findIdCheckBox = document.getElementsByName("findIdCheckBox");
const idDiv = document.querySelector("#idDiv");

function check(element) {

    findIdCheckBox.forEach((e) => {
        e.checked = false;
    })
    element.checked = true;

    if (findByEmail.checked) {
        emailDiv.classList.remove("hidden");
        idDiv.classList.remove("hidden")
        phoneDiv.classList.add("hidden");
    } else {
        emailDiv.classList.add("hidden");
        idDiv.classList.add("hidden");
        phoneDiv.classList.remove("hidden")
    }
}

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
                    } else {
                        const formDiv = document.querySelector('.formDiv');
                        formDiv.innerHTML = ''; // 폼 내용을 모두 제거
                        formDiv.innerText = `조회된 유저 아이디 : ${resp.data}`
                    }
                })
                .catch(err => {
                    console.log();
                })
        }
    }
})




