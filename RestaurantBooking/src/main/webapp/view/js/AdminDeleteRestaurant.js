const form = document.querySelector('form');

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const restaurantIdInput = document.querySelector('#validationServer01');
    const restaurantId = restaurantIdInput.value;
    const xhr = new XMLHttpRequest();
    xhr.open('DELETE', `http://localhost:8000/delete_restaurant/${restaurantId}`);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = () => {
        if (xhr.status === 200) {
            console.log(xhr.responseText);
            alert(`Restaurant with ID ${restaurantId} has been deleted!`);
        } else {
            console.error(xhr.statusText);
            alert('There was an error deleting the restaurant. Please try again later.');
        }
    };
    xhr.onerror = () => {
        console.error('Error');
        alert('There was an error deleting the restaurant. Please try again later.');
    };
    xhr.send();
});
