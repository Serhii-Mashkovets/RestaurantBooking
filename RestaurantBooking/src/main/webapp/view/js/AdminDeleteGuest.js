const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const guestIDInput = document.getElementById('validationServer01');
    const guestID = guestIDInput.value;
    const xhr = new XMLHttpRequest();
    xhr.open('DELETE', `http://localhost:8000/delete_guest/${guestID}`);
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
    xhr.send();
});
