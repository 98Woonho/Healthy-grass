const findUserIdForm = document.querySelector('.findUserId');
const findUserIdBtn = document.querySelector('.findUserIdBtn');
const PhoneRegexp = new RegExp("^01([016789])-?([0-9]{3,4})-?([0-9]{4})$");
const PhoneRegex = (target) => {
    const maxLength = 13;
    if (target.value.length > maxLength) {
        target.value = target.value.slice(0, maxLength);
    }

    target.value = target.value
        .replace(/[^0-9]/g, '')
        .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}
const EmailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", "i");
const findByEmail = document.querySelector("#findByEmail");
const findByPhone = document.querySelector("#findByPhone");
const phoneDiv = document.querySelector("#phoneDiv");
const emailDiv = document.querySelector("#emailDiv");
const findIdCheckBox = document.getElementsByName("findIdCheckBox");

function check(element) {

    findIdCheckBox.forEach((e) => {
        e.checked = false;
    })
    element.checked = true;

    if (findByEmail.checked) {
        emailDiv.classList.remove("hidden");
        phoneDiv.classList.add("hidden");
    } else {
        emailDiv.classList.add("hidden");
        phoneDiv.classList.remove("hidden")
    }
}


findUserIdBtn.addEventListener('click', function (e) {
    e.preventDefault();
    if (findByEmail.checked) {
        if (findUserIdForm.name.value === "") {
            alert("이름을 입력해주세요.")
        } else if (findUserIdForm.email.value === "") {
            alert("이메일을 입력해주세요.")
        } else if (!EmailRegex.test(findUserIdForm.email.value)) {
            alert("이메일 형식으로 입력해주세요")
        } else {
            const data = {
                name: findUserIdForm.name.value,
                email: findUserIdForm.email.value
            };
            axios.post("/user/findUserIdByEmail", data, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    if (resp.data === "FAILURE_NOT_FOUND_USER_ID") {
                        alert("조회결과 유저 아이디가 없습니다.")
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
    } else if (findByPhone.checked) {
        if (findUserIdForm.name.value === "") {
            alert("이름을 입력해주세요.")
        } else if (findUserIdForm.phone.value === "") {
            alert("휴대폰 번호를 입력해주세요.")
        } else if (!PhoneRegexp.test(findUserIdForm.phone.value)) {
            alert("휴대폰 번호 형식대로 입력하세요 010-0000-0000 또는 01012345678");
        } else {
            const data = {
                name: findUserIdForm.name.value,
                phone: findUserIdForm.phone.value
            };
            axios.post("/user/findUserIdByPhone", data, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    if (resp.data === "FAILURE_NOT_FOUND_USER_ID") {
                        alert("조회결과 유저 아이디가 없습니다.")
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
