const table = document.querySelector('.table tbody');

fetch('localhost:8080/AllRestaurants')
  .then(response => response.json())
  .then(data => {
    data.forEach((item, index) => {
      const row = table.insertRow(-1);
      const idCell = row.insertCell(0);
      const nameCell = row.insertCell(1);
      const typeCell = row.insertCell(2);

      idCell.textContent = index + 1;
      nameCell.textContent = item.name;
      typeCell.textContent = item.type;
    });
  })
  .catch(error => console.error(error));
