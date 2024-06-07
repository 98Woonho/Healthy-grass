function toggleInquiryContentProcess(contentId) {
    var content = document.getElementById(contentId);
    if (content.style.display === "none") {
        content.style.display = ""; // 상품 문의 내용을 보여줍니다.
    } else {
        content.style.display = "none"; // 상품 문의 내용을 숨깁니다.
    }
}