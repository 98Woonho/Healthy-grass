document.getElementById('commentForm').addEventListener('submit', function(event) {
    event.preventDefault(); // 기본 폼 제출 방지

    const title = document.getElementById('commentTitle').value;
    const content = document.getElementById('commentContent').value;
    const boardId = document.getElementById('boardId').textContent.trim();

    axios.post('/productInquiryBoardComment', {
        title: title,
        content: content,
        P_Board_Id: boardId
    })
    .then(function (response) {
        if (response.data.success) {
            alert(response.data.msg || '댓글이 성공적으로 등록되었습니다.');
            window.location.reload();
        } else {
            alert(response.data.msg || '댓글 등록에 실패했습니다.');
        }
    })
    .catch(function (error) {
        alert('댓글 등록에 실패했습니다. 다시 시도해 주세요.');
    });
});