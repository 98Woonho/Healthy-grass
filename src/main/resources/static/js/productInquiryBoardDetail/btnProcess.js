document.addEventListener('DOMContentLoaded', function() {
    var boardId = document.getElementById('boardId').textContent;

    /* 수정 버튼 로직 -> 수정 페이지로 이동합니다. */
    document.getElementById('editBtn').addEventListener('click', function() {
        console.log("수정 버튼 클릭됨");
        document.getElementById('editForm').submit();
    });

    /* 삭제버튼 로직 */
    document.getElementById('deleteBtn').addEventListener('click', function() {

        if (confirm('정말로 이 게시글을 삭제하시겠습니까?')) {
            axios.delete('/productInquiry?boardId=' + boardId)
            .then(function(response) {
                if (response.data.success) {
                    alert('게시글이 성공적으로 삭제되었습니다.');
                    window.location.href = '/productInquiryBoardList'; // 목록 페이지로 리다이렉션
                } else {
                    alert('게시글 삭제에 실패하였습니다: ' + response.data.msg);
                }
            })
            .catch(function(error) {
                console.error('Error:', error);
                alert('게시글 삭제 중 오류가 발생하였습니다.');
            });
        }
    });
});