document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Add your login logic here
    console.log(`Logging in with Username: ${username}, Password: ${password}`);
});
