function createAndSubmitForm() {
    var form = document.createElement("form");
    form.method = "GET";
    form.action = "/customerInquiry";

    document.body.appendChild(form);

    form.submit();
}