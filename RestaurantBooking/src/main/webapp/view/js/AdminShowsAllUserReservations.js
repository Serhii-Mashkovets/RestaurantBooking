// Отримуємо елементи форми
const form = document.querySelector('form');
const input = document.querySelector('#validationServer01');

// Додаємо обробник події submit на форму
form.addEventListener('submit', (event) => {
  event.preventDefault(); // Зупиняємо стандартну поведінку форми

  // Отримуємо значення поля введення
  const userId = input.value;

  // Відправляємо POST-запит за допомогою fetch
  fetch('http://localhost:8000/getAllReservationsForUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ id: userId }) // Передаємо JSON-об'єкт у тілі запиту
  })
  .then(response => response.json()) // Розпаковуємо JSON-відповідь
  .then(data => {
    // Отримуємо таблицю та її тіло
    const table = document.querySelector('.table');
    const tbody = table.querySelector('tbody');

    // Очищуємо тіло таблиці
    tbody.innerHTML = '';

    // Заповнюємо таблицю даними з JSON-відповіді
    data.forEach(row => {
      const tr = document.createElement('tr');

      // Заповнюємо комірки таблиці
      const th = document.createElement('th');
      th.setAttribute('scope', 'row');
      th.innerText = row.id;
      tr.appendChild(th);

      const td1 = document.createElement('td');
      td1.innerText = row.userId;
      tr.appendChild(td1);

      const td2 = document.createElement('td');
      td2.innerText = row.userName;
      tr.appendChild(td2);

      const td3 = document.createElement('td');
      td3.innerText = row.userEmail;
      tr.appendChild(td3);

      const td4 = document.createElement('td');
      td4.innerText = row.userPassword;
      tr.appendChild(td4);

      const td5 = document.createElement('td');
      td5.innerText = row.reservationId;
      tr.appendChild(td5);

      const td6 = document.createElement('td');
      td6.innerText = row.reservationName;
      tr.appendChild(td6);

      const td7 = document.createElement('td');
      td7.innerText = row.reservationDate;
      tr.appendChild(td7);

      const td8 = document.createElement('td');
      td8.innerText = row.reservationTime;
      tr.appendChild(td8);

      const td9 = document.createElement('td');
      td9.innerText = row.numOfPeople;
      tr.appendChild(td9);

      const td10 = document.createElement('td');
      td10.innerText = row.confirmation;
      tr.appendChild(td10);

      const td11 = document.createElement('td');
      td11.innerText = row.comments;
      tr.appendChild(td11);
        // Додаємо рядок у тіло таблиці
  tbody.appendChild(tr);
});
})
.catch(error => console.log(error)); // Обробляємо помилки виконання запиту
});
