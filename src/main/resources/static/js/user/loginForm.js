const InputId = document.getElementById("id");
const checkedId = document.getElementById("checkedId");
window.onload = function() { // 브라우저가 실행되면 시작함.

    // 저장된 쿠키값을 가져와서 id 칸에 넣어준다. 쿠키값 없으면 공백.
    InputId.value = getCookie("userLoginId");

    // id가 있는경우 아이디 저장 체크박스 체크
    if(InputId.value !== ""){
        checkedId.checked = true;
    }

    // 아이디 저장하기 체크박스 onchange
    checkedId.onchange = function (event) {
        if(checkedId.checked){ //checked true
            setCookie("userLoginId", InputId.value, 30); // 30일 동안 쿠키 보관
        }else{ //checked false
            deleteCookie("userLoginId");
        }
    };

    // 아이디 저장하기가  눌린상태에서, id를 입력한 경우


    InputId.addEventListener("keyup", function(e) {
        if(checkedId.checked){ //checked true
            setCookie("userLoginId", InputId.value, 30); // 30일 동안 쿠키 보관
        }
    })
}

// 쿠키 설정 함수
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}

//쿠키 삭제 함수
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}

// 쿠키 가져오기 함수
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start !== -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end === -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}