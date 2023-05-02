const guestForm = document.getElementById('guest-form');
  guestForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const guestIdInput = document.getElementById('guest-id');
    const guestId = guestIdInput.value;
    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8000/AdminFindOneGuest');
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
    xhr.send(`guestId=${guestId}`);
  });