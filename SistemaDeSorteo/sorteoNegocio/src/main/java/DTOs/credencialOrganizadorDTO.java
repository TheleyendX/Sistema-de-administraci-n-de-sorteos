/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author ruben
 */
public class credencialOrganizadorDTO {

    private String organizadorId;
    private String token;

    public credencialOrganizadorDTO(String organizadorId, String token) {
        this.organizadorId = organizadorId;
        this.token = token;
    }

    public credencialOrganizadorDTO() {
    }

    public String getOrganizadorId() {
        return organizadorId;
    }

    public void setOrganizadorId(String organizadorId) {
        this.organizadorId = organizadorId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
