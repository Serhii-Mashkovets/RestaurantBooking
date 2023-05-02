const form = document.querySelector('.form');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const cardNumberInput = document.getElementById('inputPassword5');
    const cardNumber = cardNumberInput.value;
    const cardExpireInput = document.querySelectorAll('#inputPassword5')[1];
    const cardExpire = cardExpireInput.value;
    const cardCvvInput = document.querySelectorAll('#inputPassword5')[2];
    const cardCvv = cardCvvInput.value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8000/send_card_info');
    //цей клас і контроллер можна додати опціонально в майбутньому
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = () => {
        if (xhr.status === 200) {
            console.log(xhr.responseText);
        } else {
            console.error(xhr.statusText);
        }
    };
    xhr.onerror = () => {
        console.error('Error');
    };
    xhr.send(`cardNumber=${cardNumber}&cardExpire=${cardExpire}&cardCvv=${cardCvv}`);
});
