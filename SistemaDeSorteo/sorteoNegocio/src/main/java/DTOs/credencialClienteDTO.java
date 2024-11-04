/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author ruben
 */
public class credencialClienteDTO {

    private String clienteId;
    private String token;

    public credencialClienteDTO(String clienteId, String token) {
        this.clienteId = clienteId;
        this.token = token;
    }

    public credencialClienteDTO(){
        
    }
    
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
