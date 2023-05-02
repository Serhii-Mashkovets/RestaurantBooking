const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const passwordInput = document.getElementById('exampleInputPassword1');
    const password = passwordInput.value;
    const rememberMeInput = document.getElementById('exampleCheck1');
    const rememberMe = rememberMeInput.checked;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8000/adminLogin');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = () => {
        if (xhr.status === 200) {
            window.location.href = 'adminSuccessRegistration.html';
        } else {
            console.error(xhr.statusText);
        }
    };
    xhr.onerror = () => {
        console.error('Error');
    };
    xhr.send(`password=${password}&remember_me=${rememberMe}`);
});
