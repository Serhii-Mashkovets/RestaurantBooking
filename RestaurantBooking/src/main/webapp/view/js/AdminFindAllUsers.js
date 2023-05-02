const tbody = document.querySelector('tbody');
fetch('http://localhost:8000/AllUsers')
  .then(response => response.json())
  .then(data => {
      data.forEach((obj, index) => {
          const tr = document.createElement('tr');
          const tdIndex = document.createElement('td');
          tdIndex.textContent = index + 1;
          const tdId = document.createElement('td');
          tdId.textContent = obj.id;
          const tdName = document.createElement('td');
          tdName.textContent = obj.name;
          const tdEmail = document.createElement('td');
          tdEmail.textContent = obj.email;
          const tdPassword = document.createElement('td');
          tdPassword.textContent = obj.password;

          tr.appendChild(tdIndex);
          tr.appendChild(tdId);
          tr.appendChild(tdName);
          tr.appendChild(tdEmail);
          tr.appendChild(tdPassword);

          tbody.appendChild(tr);
      });
  });
