fetch('data.json')
  .then(response => response.json())
  .then(data => {
    const tableRows = document.querySelectorAll('tbody tr');
    for (let i = 0; i < data.length; i++) {
      const row = tableRows[i];
      const reservation = data[i];
      row.querySelector(`#name${i + 1}`).textContent = reservation.name;
      row.querySelector(`#datetime${i + 1}`).textContent = reservation.datetime;
      row.querySelector(`#restaurant${i + 1}`).textContent = reservation.restaurant;
      row.querySelector(`#confirmed${i + 1}`).textContent = reservation.confirmed;
      row.querySelector(`#table${i + 1}`).textContent = reservation.table;
      row.querySelector(`#id${i + 1}`).textContent = reservation.id;
    }
  })
  .catch(error => console.error(error));
