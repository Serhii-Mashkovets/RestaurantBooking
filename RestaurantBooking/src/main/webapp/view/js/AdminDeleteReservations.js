const form = document.querySelector('.row.g-3');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const reservationIdInput = document.getElementById('validationServer01');
    const reservationId = reservationIdInput.value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8000/reservationsDelete');
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
    xhr.send(`reservationId=${reservationId}`);
});
