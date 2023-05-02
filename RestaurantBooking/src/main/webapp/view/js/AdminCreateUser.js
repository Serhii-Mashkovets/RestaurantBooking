const form = document.querySelector('.row');

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const userIdInput = document.getElementById('validationServer01');
  const userId = userIdInput.value;

  const nameInput = document.getElementById('validationServer02');
  const name = nameInput.value;

  const emailInput = document.querySelectorAll('.form-control')[2];
  const email = emailInput.value;

  const passwordInput = document.querySelectorAll('.form-control')[3];
  const password = passwordInput.value;

  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'http://localhost:8000/create_user');
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
  xhr.send(`userId=${userId}&name=${name}&email=${email}&password=${password}`);
});
