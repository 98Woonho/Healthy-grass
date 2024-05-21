const joinBtn = document.querySelector(".joinBtn");
joinBtn.addEventListener('click', function (e){
    e.preventDefault();
    const joinForm = document.joinForm;

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


    axios.post("/users", data, {headers: {"Content-Type":"application/json"}})
        .then(resp=>{
            if (resp.data === true){
                confirm("성공적으로 회원가입이 완료되었습니다.")
                location.href="/";
            }
            else confirm("이미 가입된 회원입니다. 다른 아이디를 입력하시오")
        })
        .catch(err=>{console.log();})
})