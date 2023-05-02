const form = document.querySelector('.under form');
const reservationIdInput = document.getElementById('validationServer01');
const nameInput = document.getElementById('validationServer02');
const dateInput = document.getElementById('validationServerUsername');
const timeInput = document.getElementById('validationServer03');
const confirmationInput = document.getElementById('validationServer04');
const numberOfPeopleInput = document.getElementById('validationServer05');
const restaurantIdInput = document.getElementById('validationServer02');

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const reservationId = reservationIdInput.value;
  const name = nameInput.value;
  const date = dateInput.value;
  const time = timeInput.value;
  const confirmation = confirmationInput.value;
  const numberOfPeople = numberOfPeopleInput.value;
  const restaurantId = restaurantIdInput.value;

  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8000/reservations');
  xhr.setRequestHeader('Content-Type', 'application/json');
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
  xhr.send(JSON.stringify({
    reservationId,
    name,
    date,
    time,
    confirmation,
    numberOfPeople,
    restaurantId,
  }));
});
