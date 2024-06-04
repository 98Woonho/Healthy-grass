document.addEventListener('DOMContentLoaded', function() {
    const passwordForm = document.getElementById('password-form');
    const passwordInput = document.getElementById('password');
    const idInput = document.getElementById('id').value;

    function submitPassword(event) {
        event.preventDefault(); // Prevent default form submission

        const password = passwordInput.value;

        axios.post('/productInquiryBoard/passwordCheck', {
            id: idInput,
            password: password
        })
        .then(function (response) {
            if (response.data.success) {
                location.href = "/productInquiryBoard?id=" + idInput;
            } else {
                alert('비밀번호가 틀립니다.');
            }
        })
        .catch(function (error) {
            console.error('서버 응답 에러', error);
            alert('서버 응답 에러: ' + error.message);
        });
    }

    passwordForm.addEventListener('submit', submitPassword);
});