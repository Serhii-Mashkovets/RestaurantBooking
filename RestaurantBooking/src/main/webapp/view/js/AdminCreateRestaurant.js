const form = document.querySelector('form');
form.addEventListener('submit', (event) => {
  event.preventDefault();

  const restaurantIdInput = document.getElementById('validationServer01');
  const restaurantId = restaurantIdInput.value;

  const nameInput = document.getElementById('validationServer02');
  const name = nameInput.value;

  const cuisineTypeInput = document.getElementById('validationServer04');
  const cuisineType = cuisineTypeInput.value;

  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8000/create_restaurant');
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
  xhr.send(`restaurantId=${restaurantId}&name=${name}&cuisineType=${cuisineType}`);
});
