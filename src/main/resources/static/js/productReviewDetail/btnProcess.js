document.addEventListener('DOMContentLoaded', function () {
    const editButton = document.getElementById('edit-btn');
    const deleteButton = document.getElementById('delete-btn');

    editButton.addEventListener('click', function () {
        const reviewId = this.getAttribute('data-id');
        window.location.href = `/productReview/edit?boardId=${reviewId}`;
    });

    deleteButton.addEventListener('click', function () {
        const reviewId = this.getAttribute('data-id');

        if (confirm('정말로 삭제하시겠습니까?')) {
            axios.delete(`/productReview?boardId=${reviewId}`)
                .then(function (response) {
                    if (response.data.success) {
                        alert('리뷰가 성공적으로 삭제되었습니다.');
                        window.location.href = '/myProductReviewBoardList'; // 리뷰 목록 페이지로 이동
                    } else {
                        alert('리뷰 삭제에 실패했습니다: ' + response.data.msg);
                    }
                })
                .catch(function (error) {
                    console.error('There was an error!', error);
                    alert('리뷰 삭제 중 오류가 발생하였습니다.');
                });
        }
    });
});
