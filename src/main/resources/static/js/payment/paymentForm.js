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

            pay_info(rsp);

            axios.post("")


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
        amount: 0,
        checksum: 0,
        reason: '돈이 없습니다',
        refund_holder: '황보성현',
        refund_bank: 'BK11',
        refund_account: '3510027422763'
    };

    axios.post("https://api.iamport.kr/payments/cancel", data, {headers: {"Content-Type": "application/json"}})
        .then(resp => {
            console.log(resp.data);
        })
        .catch(err => {
            console.log(err);
        })
})


function pay_info(rsp) {
    var form = document.createElement('form');
    var objs;

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_name');
    objs.setAttribute('value', rsp.buyer_name);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_phone');
    objs.setAttribute('value', rsp.buyer_tel);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'member_email');
    objs.setAttribute('value', rsp.buyer_email);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buy_addr');
    objs.setAttribute('value', rsp.buyer_addr);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buy_product_name');
    objs.setAttribute('value', rsp.name);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_buyid');
    objs.setAttribute('value', rsp.imp_uid);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_merid');
    objs.setAttribute('value', rsp.merchant_uid);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'amount');
    objs.setAttribute('value', rsp.paid_amount);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_card_num');
    objs.setAttribute('value', rsp.apply_num);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_pay_ok');
    objs.setAttribute('value', rsp.success);
    form.appendChild(objs);

    objs = document.createElement('input');
    objs.setAttribute('type', 'hidden');
    objs.setAttribute('name', 'buyer_postcode');
    objs.setAttribute('value', rsp.buyer_postcode);
    form.appendChild(objs);


    form.setAttribute('method', 'post');
    form.setAttribute('action', "paymentForm");
    document.body.appendChild(form);
    form.submit();
}


