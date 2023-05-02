const form = document.querySelector('.row.g-3');
const userIdInput = form.querySelector('#validationServer01');
const submitButton = form.querySelector('button[type="submit"]');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  const userId = userIdInput.value;
  const xhr = new XMLHttpRequest();
  xhr.open('GET', `http://localhost:8000/get_user?id=${userId}`);
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
  xhr.send();
});
