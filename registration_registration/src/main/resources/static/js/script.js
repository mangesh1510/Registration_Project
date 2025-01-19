// Get form and message container
const form = document.getElementById("registrationForm");
const messageDiv = document.getElementById("message");

// Add form submit event listener
form.addEventListener("submit", async (event) => {
    event.preventDefault(); // Prevent form from refreshing the page

    // Get form data
    const formData = {
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
    };

    try {
        // Send data to backend via POST request
        const response = await fetch("http://localhost:8080/api/registration", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formData),
        });

        // Handle response
        if (response.ok) {
            messageDiv.textContent = "Registration successful!";
            messageDiv.style.color = "green";
            form.reset(); // Clear the form
        } else {
            const error = await response.json();
            messageDiv.textContent = `Error: ${error.message || "Failed to register"}`;
            messageDiv.style.color = "red";
        }
    } catch (error) {
        console.error("Error during registration:", error);
        messageDiv.textContent = "Error: Unable to connect to the server.";
        messageDiv.style.color = "red";
    }
});
