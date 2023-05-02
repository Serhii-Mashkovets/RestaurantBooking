const tbody = document.querySelector('tbody');

fetch('http://localhost:8000/All_Guests')
  .then(response => response.json())
  .then(data => {
    // очистити таблицю перед заповненням
    tbody.innerHTML = '';
    
    // заповнити таблицю з даними з JSON
    data.forEach((item, index) => {
      const row = document.createElement('tr');
      const numberCell = document.createElement('td');
      const idCell = document.createElement('td');
  
      numberCell.textContent = index + 1;
      idCell.textContent = item.id;
  
      row.appendChild(numberCell);
      row.appendChild(idCell);
  
      tbody.appendChild(row);
    });
  })
  .catch(error => {
    console.error(error);
  });
