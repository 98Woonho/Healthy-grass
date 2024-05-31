const pay_btn = document.querySelector('.pay_btn');

pay_btn.addEventListener('click', function (e){
    e.preventDefault();

    IMP.init("imp40654467"); // IMPort 고객사 식별코드

    IMP.request_pay({
        pg: "danal",
        pay_method: "phone",
        merchant_uid: "test_lwk2kw03",
        name: "갤럭시23 ULTRA_2",
        amount: 100,
        buyer_tel: "010-0000-0000",
    },function(resp){
        if (resp.success === true){
            const data = {
                name: resp.name, // 상품명
                amount: resp.paid_amount, //결제 금액
                pay_method: resp.pay_method, //결제 수단
                pg_type: resp.pg_type, // 거래 유형
                status: resp.status, //결재 상태
                paid_At : new Date(resp.paid_at * 1000) //결재 시간
            };
            document.querySelector(".name").value = data.name;
            document.querySelector(".amount").value = data.amount;
            document.querySelector(".pay_method").value = data.pay_method;
            document.querySelector(".pg_type").value = data.pg_type;
            document.querySelector(".status").value = data.status;
            document.querySelector(".paid_At").value = data.paid_At;

            const form = document.querySelector("#form");

            form.submit();

        }
    });

})

