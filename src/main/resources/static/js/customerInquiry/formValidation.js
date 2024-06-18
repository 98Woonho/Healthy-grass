document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault();

    var title = document.getElementById('title').value.trim();
    var content = document.getElementById('content').value.trim();

    var errorMessages = [];

    // Check title
    if (title.length === 0) {
        errorMessages.push('제목을 입력해 주세요.');
    } else if (title.length > 80) {
        errorMessages.push('제목은 80자를 초과할 수 없습니다.');
    }

    // Check content
    if (content.length === 0) {
        errorMessages.push('내용을 입력해 주세요.');
    }

    // If there are errors, show errors and stop submission
    if (errorMessages.length > 0) {
        alert(errorMessages.join('\n'));
        return;
    }

//    수정 필요
//    // Prepare data to send
//    var formData = {
//        Pid: Pid, // 수정된 부분
//        title: title,
//        password: password,
//        content: content,
//        isLocked: isLocked
//    };
//
//    // Send POST request using Axios
//    axios.post('/productInquiry', formData)
//        .then(function(response) {
//            if (response.data.success) {
//                alert('문의가 성공적으로 등록되었습니다.');
//                window.location.href = 'product?id=' + Pid; // 리다이렉션 코드
//            } else {
//                alert('문의 등록에 실패하였습니다: ' + response.data.msg);
//            }
//        })
//        .catch(function(error) {
//            console.error('Error:', error);
//            alert('문의 등록 중 오류가 발생하였습니다.');
//        });
});
