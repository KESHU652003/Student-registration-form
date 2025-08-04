function validateForm() {
  const name = document.getElementById("name").value.trim();
  const phone = document.getElementById("phone").value.trim();
  const email = document.getElementById("email").value.trim();
  const course = document.getElementById("course").value.trim();

  const nameRegex = /^[a-zA-Z ]{3,}$/;
  const phoneRegex = /^[6-9]\d{9}$/;
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

  if (!nameRegex.test(name)) {
    alert("Please enter a valid name (at least 3 letters).");
    return false;
  }

  if (!phoneRegex.test(phone)) {
    alert("Please enter a valid 10-digit phone number starting with 6-9.");
    return false;
  }

  if (!emailRegex.test(email)) {
    alert("Please enter a valid email address.");
    return false;
  }

  if (course.length < 2) {
    alert("Please enter a valid course name.");
    return false;
  }

  return true;
}
