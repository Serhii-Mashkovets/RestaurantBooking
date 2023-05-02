const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    const restaurantId = document.getElementById('validationServer01').value;
    const xhr = new XMLHttpRequest();
    xhr.open('GET', `http://localhost:8000/find_restaurant?id=${restaurantId}`);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = () => {
        if (xhr.status === 200) {
            console.log(xhr.responseText);
            const restaurantData = JSON.parse(xhr.responseText);
            
        } else {
            console.error(xhr.statusText);
        }
    };
    xhr.onerror = () => {
        console.error('Error');
    };
    xhr.send();
});
