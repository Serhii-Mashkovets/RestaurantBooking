const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const emailInput = document.getElementById('exampleInputEmail1');
    const email = emailInput.value;
    const passwordInput = document.getElementById('exampleInputPassword1');
    const password = passwordInput.value;
    const rememberMeInput = document.getElementById('exampleCheck1');
    const rememberMe = rememberMeInput.checked;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8000/users');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = () => {
        if (xhr.status === 200) {
            window.location.href = 'successRegistration.html';
        } else {
            console.error(xhr.statusText);
        }
    };
    xhr.onerror = () => {
        console.error('Error');
    };
    xhr.send(`email=${email}&password=${password}&rememberMe=${rememberMe}`);
});
