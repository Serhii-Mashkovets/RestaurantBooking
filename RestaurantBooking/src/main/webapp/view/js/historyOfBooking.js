// Отримуємо таблицю
const table = document.querySelector('table tbody');

// Запит на сервер за даними
fetch('http://localhost:8000/reservations')
  .then(response => response.json())
  .then(data => {
    // Заповнюємо таблицю з отриманими даними
    data.forEach((row, index) => {
      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${index + 1}</td>
        <td><input type="email" name="email" value="${row.email}" required></td>
        <td><input type="datetime-local" name="date" value="${row.date}" required></td>
        <td><input type="text" name="restaurant" value="${row.restaurant}" required></td>
        <td><input type="number" name="table" value="${row.table}" min="1" max="20" required></td>
      `;
      table.appendChild(tr);
    });
  })
  .catch(error => console.error(error));

// Обробник події submit форми
const form = document.querySelector('.form');
form.addEventListener('submit', (event) => {
  event.preventDefault(); // перешкоджає стандартній поведінці кнопки "submit"
  
  const emailInputs = document.querySelectorAll('tbody input[type="email"]');
  const dateInputs = document.querySelectorAll('tbody input[type="datetime-local"]');
  const restaurantInputs = document.querySelectorAll('tbody input[type="text"]');
  const tableInputs = document.querySelectorAll('tbody input[type="number"]');
  
  const data = [];
  for (let i = 0; i < emailInputs.length; i++) {
    const email = emailInputs[i].value;
    const date = dateInputs[i].value;
    const restaurant = restaurantInputs[i].value;
    const table = tableInputs[i].value;
    if (email && date && restaurant && table) { // перевірка на заповненість полів
      data.push({email, date, restaurant, table});
    }
  }
  
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
  xhr.send(JSON.stringify(data));
});
