function toggleInquiryContentProcess(contentId) {
    var contents = document.querySelectorAll('.' + contentId);
    contents.forEach(function(content) {
        if (content.style.display === "none") {
            content.style.display = ""; // 상품 문의 내용을 보여줍니다.
        } else {
            content.style.display = "none"; // 상품 문의 내용을 숨깁니다.
        }
    })
}