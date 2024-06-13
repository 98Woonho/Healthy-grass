document.getElementById('isLocked').addEventListener('change', function() {
    var passwordField = document.getElementById('password');
    if (this.checked) {
        passwordField.disabled = false;
        passwordField.value = '';
    } else {
        passwordField.disabled = true;
        passwordField.value = '';
    }
});