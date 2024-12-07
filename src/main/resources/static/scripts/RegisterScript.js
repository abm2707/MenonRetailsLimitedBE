// Wait until the DOM is fully loaded
document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("registerForm");
    const passwordInput = document.getElementById("password");
    const confirmPasswordInput = document.getElementById("confirmPassword");

    // Create a div for displaying error messages
    const errorDiv = document.createElement("div");
    errorDiv.classList.add("error-message");
    form.appendChild(errorDiv);

    form.addEventListener("submit", function(event) {
        errorDiv.innerText = ""; // Clear any previous error messages

        // Check if passwords match
        if (passwordInput.value !== confirmPasswordInput.value) {
            event.preventDefault(); // Prevent form submission
            errorDiv.innerText = "Passwords do not match!"; // Show error message
            errorDiv.style.color = "red"; // Set the error text color to red
        }
    });
});
