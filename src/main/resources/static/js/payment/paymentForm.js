const pay_btn = document.querySelector('.pay_btn');

pay_btn.addEventListener('click', function (e) {
    e.preventDefault();

    var IMP = window.IMP;
    IMP.init('imp40654467');// IMPort 고객사 식별코드
    IMP.request_pay({
        pg: 'html5_inicis.INIpayTest',
        pay_method: 'card', //카드결제
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '당근 10kg',
        amount: 100,
        buyer_email: 'hbsh@naver.com',
        buyer_name: '구매자 이름',
        buyer_tel: '연락처',
        buyer_addr: '주소',
        buyer_postcode: '우편번호'
    }, function (rsp) { // callback
        if (rsp.success) {
            var msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;

            console.log(rsp);

            axios.post("/payment/save", rsp, {headers: {"Content-Type": "application/json"}})
                .then(resp => {
                    console.log(resp)
                })
                .catch(err => {
                    console.log(err);
                })

        } else {
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : '

            alert(msg + rsp.error_msg);

            console.log(rsp);
        }
    })
});
const pay_cancel = document.querySelector('.pay_cancel');

pay_cancel.addEventListener('click', function (e) {
    e.preventDefault();

    const data = {
        imp_uid: 'imp_437900593100',
        merchant_uid: 'merchant_1717471901031',
    };

    axios.post("https://api.iamport.kr/payments/cancel", data, {headers: {"Content-Type": "application/json"}})
        .then(resp => {
            console.log(resp.data);
        })
        .catch(err => {
            console.log(err);
        })
})





