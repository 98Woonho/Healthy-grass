document.addEventListener("DOMContentLoaded", function() {
    const buttons = document.querySelectorAll('.refund-request-btn');

    buttons.forEach(button => {
        button.addEventListener('click', function() {
            const paymentId = this.getAttribute('data-id');
            const status = this.getAttribute('status');

            axios.put('/payment/refund', {
                id: paymentId,
                status: status
            })
            .then(response => {
                console.log(response.data);
                if (response.data.success) {
                    alert('환불 상태가 성공적으로 변경되었습니다!');
                    location.reload(); // 페이지를 새로고침하여 변경 사항 반영
                } else {
                    alert('배송 상태 업데이트에 실패하였습니다.');
                }
            })
            .catch(error => {
                console.error(error);
                alert('서버 오류가 발생하였습니다.');
            });
        });
    });
});
