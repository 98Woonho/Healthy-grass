const DeleteBtn = document.querySelector('.deleteBtn');
const deleteUserInput = document.querySelector('.deleteUser');

function deleteUserCheck(){
    return deleteUserInput.value === "회원탈퇴에 동의합니다.";
}

DeleteBtn.addEventListener('click', function (e){
    e.preventDefault();
    if (deleteUserInput.value === ""){
        alert("회원탈퇴에 동의합니다.를 입력해 주세요. ")
    } else if (deleteUserCheck() === false){
        alert("잘못 입력하셨습니다. 회원탈퇴에 동의합니다.를 재대로 입력해 주세요.")
    } else {
        const id = document.querySelector('.userId');
        axios.delete("/myPage/user/delete?id="+id.value)
            .then(resp=>{
                if (resp.data === "SUCCESS"){
                    alert("성공적으로 회원삭제가 완료되었습니다.");
                    location.href = "/user/loginForm";
                } else alert("알수없는 이유로 회원삭제에 실패하였습니다.");
            })
            .catch(err =>{
                console.log(err);
            })
    }
})
