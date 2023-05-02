// Отримати елементи зі сторінки
const form = document.querySelector('form');
const guestIdInput = document.getElementById('validationServer01');
const tableRows = document.querySelectorAll('table tbody tr');

// Функція, яка заповнює таблицю з отриманих даних
function fillTable(reservations) {
  // Цикл по отриманих бронюваннях
  reservations.forEach((reservation, i) => {
    const tableCells = tableRows[i].querySelectorAll('td');
    // Заповнити комірки таблиці з отриманими даними
    tableCells[0].textContent = i + 1;
    tableCells[1].textContent = reservation.guest_id;
    tableCells[2].textContent = reservation.reservation_id;
    tableCells[3].textContent = reservation.reservation_name;
    tableCells[4].textContent = reservation.date;
    tableCells[5].textContent = reservation.time;
    tableCells[6].textContent = reservation.number_of_people;
    tableCells[7].textContent = reservation.confirmation;
    tableCells[8].textContent = reservation.restaurant_id;
  });
}

// Функція, яка відправляє запит на сервер та заповнює таблицю з отриманих даних
function fetchReservations(event) {
  event.preventDefault();
  const guestId = guestIdInput.value;
  const xhr = new XMLHttpRequest();
  xhr.open('GET', `http://localhost:8000/AllreservationsByGuestId/${guestId}`);
  xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onload = () => {
    if (xhr.status === 200) {
      const reservations = JSON.parse(xhr.responseText);
      fillTable(reservations);
    } else {
      console.error(xhr.statusText);
    }
  };
  xhr.onerror = () => {
    console.error('Error');
  };
  xhr.send();
}

// Додати обробник події на кнопку "Find All Reservations!"
form.addEventListener('submit', fetchReservations);
