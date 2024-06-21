document.addEventListener('DOMContentLoaded', function() {
    const reviewButtons = document.querySelectorAll('.review-btn');

    reviewButtons.forEach(button => {
        button.addEventListener('click', function() {
            const orderId = this.getAttribute('data-oid');
            const productId = this.getAttribute('data-pid');

            // Create a form
            const form = document.createElement('form');
            form.method = 'GET';
            form.action = '/productReview/new';

            // Add Oid as hidden input
            const oidInput = document.createElement('input');
            oidInput.type = 'hidden';
            oidInput.name = 'oId';
            oidInput.value = orderId;
            form.appendChild(oidInput);

            // Add Pid as hidden input
            const pidInput = document.createElement('input');
            pidInput.type = 'hidden';
            pidInput.name = 'pId';
            pidInput.value = productId;
            form.appendChild(pidInput);

            // Append the form to the body and submit it
            document.body.appendChild(form);
            form.submit();
        });
    });
});
