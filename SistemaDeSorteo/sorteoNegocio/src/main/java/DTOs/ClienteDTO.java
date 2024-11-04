/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author ruben
 */
public class ClienteDTO {

    private String id;
    private String email;
    private String password;
    private String confirmPassword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    // Método para validar ID
    public boolean isValidId() {
        if (id == null || id.isEmpty()) {
            return false; // ID no debe estar vacío
        }
        try {
            int idNumber = Integer.parseInt(id);
            return idNumber > 9999 && idNumber < 100000; // Asegurarse que es positivo y tiene 5 dígitos
        } catch (NumberFormatException e) {
            return false; // No es un número válido
        }
    }

    // Método para validar formato de email
    public boolean isValidEmail() {
        if (email == null || email.isEmpty()) {
            return false; // Email no debe estar vacío
        }
        return email.contains("@") && email.contains("."); // Validación básica de email
    }

    // Método para verificar que las contraseñas coincidan
    public boolean isPasswordMatching() {
        return password != null && password.equals(confirmPassword);
    }

    // Método para verificar que todos los campos requeridos están llenos
    public boolean areRequiredFieldsFilled() {
        return id != null && !id.isEmpty() &&
               email != null && !email.isEmpty() &&
               password != null && !password.isEmpty() &&
               confirmPassword != null && !confirmPassword.isEmpty();
    }
}

