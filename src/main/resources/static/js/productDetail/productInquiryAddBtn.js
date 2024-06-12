function createAndSubmitForm() {
    var form = document.createElement("form");
    form.method = "GET";
    form.action = "/productInquiry";

    var input = document.createElement("input");
    input.type = "hidden";
    input.name = "productId";
    input.value = document.getElementById("productId").value;

    form.appendChild(input);

    document.body.appendChild(form);

    form.submit();
}