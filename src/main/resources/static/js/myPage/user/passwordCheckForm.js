const id = document.querySelector('.id');
const password = document.querySelector('.password');
const tmp = document.querySelector('#tmp');
// 이벤트 리스너 등록
const passwordCheckBtn = document.querySelector(".passwordCheckBtn");
passwordCheckBtn.addEventListener('click', function (e) {
        e.preventDefault();
        if (id.value.trim() === "") {
            alert("아이디 에 빈문자열이 들어올 수 없습니다.")
            return false;
        } else if (password.value.trim() === "") {
            alert("비밀번호에 빈문자열이 들어올 수 없습니다.")
            return false;
        } else {
            const data = {
                id: id.value,
                password: password.value,
            };
            axios.post("/myPage/user/passwordCheck", data, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    if (resp.data === "SUCCESS") {
                        if (tmp.value === "delete") {
                            location.href = "/myPage/user/deleteForm";
                        } else if (tmp.value === "modify") {
                            location.href = "/myPage/user/modifyForm";
                        }
                    } else alert("비밀번호가 일치하지 않습니다.")
                    return false;
                })
                .catch(err => {
                    console.log(err);
                })
        }
    }
)