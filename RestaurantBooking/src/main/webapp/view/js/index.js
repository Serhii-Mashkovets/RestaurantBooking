const restaurantSelect = document.querySelector('.restaurantChoise select');
const datetimeInput = document.querySelector('.dateAndTimeChoise input');
const numberOfGuestsSelect = document.querySelector('.numberOfGastesChoise select');
const confirmButton = document.querySelector('.button-confirm button');

confirmButton.addEventListener('click', () => {
  const restaurant = restaurantSelect.value;
  const datetime = datetimeInput.value;
  const numberOfGuests = numberOfGuestsSelect.value;

  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8000/reservations');
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.onload = () => {
    if (xhr.status === 200) {
      console.log(xhr.responseText);
      window.location.href = 'payment.html';
    } else {
      console.error(xhr.statusText);
    }
  };
  xhr.onerror = () => {
    console.error('Error');
  };
  xhr.send(`restaurant=${restaurant}&datetime=${datetime}&numberOfGuests=${numberOfGuests}`);
});
