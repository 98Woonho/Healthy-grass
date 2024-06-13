document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault();

    var title = document.getElementById('title').value.trim();
    var content = document.getElementById('content').value.trim();
    var id = document.getElementById('id').value;

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

    // Prepare data to send
    var formData = {
        id: id,
        title: title,
        content: content,
    };

    // Send PUT request using Axios
    axios.put('/productInquiry', formData)
        .then(function(response) {
            if (response.data.success) {
                alert('문의가 성공적으로 수정되었습니다.');
                window.location.href = 'productInquiryBoard?id=' + id; // 리다이렉션 코드
            } else {
                alert('문의 수정에 실패하였습니다: ' + response.data.msg);
            }
        })
        .catch(function(error) {
            console.error('Error:', error);
            alert('문의 수정 중 오류가 발생하였습니다.');
        });
});

document.getElementById('cancel').addEventListener('click', function(event) {
    event.preventDefault();

    var id = document.getElementById('id').value;
    console.log("취소버튼 클릭됨")

    var form = document.createElement('form');
    form.method = 'get';
    form.action = '/productInquiryBoard';

    var hiddenField = document.createElement('input');
    hiddenField.type = 'hidden';
    hiddenField.name = 'id';
    hiddenField.value = id;

    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
});
