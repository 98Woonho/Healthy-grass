const findUserIdForm = document.querySelector('.findUserId');
const findUserIdBtn = document.querySelector('.findUserIdBtn');
const EmailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$", "i");

function check(element) {
    const findByEmail = document.querySelector("#findByEmail");
    const findByPhone = document.querySelector("#findByPhone");
    const phoneDiv = document.querySelector("#phoneDiv");
    const emailDiv = document.querySelector("#emailDiv");
    const findId = document.getElementsByName("findId");

    findId.forEach((e) =>{
        e.checked = false;
    })
    element.checked = true;

    if (findByEmail.checked){
        emailDiv.classList.remove("hidden");
        phoneDiv.classList.add("hidden");
    } else {
        emailDiv.classList.add("hidden");
        phoneDiv.classList.remove("hidden")
    }
}




findUserIdBtn.addEventListener('click', function (e){
    e.preventDefault();
    if(findUserIdForm.name.value === ""){
        alert("이름을 입력해주세요.")
    } else if(findUserIdForm.email.value === ""){
        alert("이메일을 입력해주세요.")
    } else if(!EmailRegex.test(findUserIdForm.email.value)){
        alert("이메일 형식으로 입력해주세요")
    } else{
        const data = {
            name: findUserIdForm.name.value,
            email: findUserIdForm.email.value
        };
        axios.post("/user/findUserId", data, {headers: {"Content-Type": "application/json"}})
            .then(resp => {
                if (resp.data === "SUCCESS") {
                    alert("이메일에 성공적으로 ID를 전송했습니다 확인해주세요.")
                } else if(resp.data === "FAILURE_NOT_FOUND_USER_ID") {
                    alert("조회결과 유저 아이디가 없습니다.")
                } else {
                    alert("알수없는 이유로 이메일전송에 실패하였습니다.")
                }
            })
            .catch(err => {
                console.log();
            })
    }

})
