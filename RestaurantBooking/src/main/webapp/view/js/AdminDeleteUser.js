const form = document.querySelector('.row.g-3');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    
    const userIdInput = document.getElementById('validationServer01');
    const userId = userIdInput.value;

    
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8000/delete_user');
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

 
    xhr.send(`userId=${userId}`);
});
