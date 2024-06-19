document.getElementById('editBtn').addEventListener('click', function() {
    const boardId = document.getElementById('boardId').innerText;
    window.location.href = `/customerInquiry/edit?id=${boardId}`;
});

document.getElementById('deleteBtn').addEventListener('click', function() {
    const boardId = document.getElementById('boardId').innerText;
    if (confirm('정말로 이 게시글을 삭제하시겠습니까?')) {
        axios.delete(`/customerInquiry?id=${boardId}`)
            .then(function (response) {
                if (response.data.success) {
                    alert(response.data.msg);
                    window.location.href = '/customerInquiryBoardList'; // 삭제 후 목록 페이지로 이동
                } else {
                    alert(response.data.msg);
                }
            })
            .catch(function (error) {
                console.error('There was an error!', error);
                alert('게시글 삭제에 실패했습니다. 다시 시도해 주세요.');
            });
    }
});
