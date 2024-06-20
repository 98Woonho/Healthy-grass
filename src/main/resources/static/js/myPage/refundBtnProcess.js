document.addEventListener('DOMContentLoaded', function() {
    const refundButtons = document.querySelectorAll('.refund-request-btn');

    refundButtons.forEach(button => {
        button.addEventListener('click', function() {
            const paymentId = this.getAttribute('data-id');

            if (confirm('정말로 환불 요청을 하시겠습니까?')) {
                axios.put(`/myPage/payment`, { id: paymentId, status: "R" })
                    .then(function(response) {
                        if (response.data.success) {
                            alert('환불 요청이 성공적으로 처리되었습니다.');
                            location.reload(); // 페이지를 새로고침하여 상태를 업데이트합니다.
                        } else {
                            alert('환불 요청 처리에 실패하였습니다: ' + response.data.msg);
                        }
                    })
                    .catch(function(error) {
                        console.error('There was an error!', error);
                        alert('환불 요청 처리 중 오류가 발생하였습니다.');
                    });
            }
        });
    });
});
