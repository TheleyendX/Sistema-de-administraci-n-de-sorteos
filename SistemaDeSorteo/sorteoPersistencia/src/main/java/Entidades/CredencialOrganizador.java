package Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "credencial_organizador")
public class CredencialOrganizador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_organizador")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String token;

    public CredencialOrganizador() {
    }

    public CredencialOrganizador(String token) {
        this.token = token;
    }

    public CredencialOrganizador(Long id) {
        this.id = id;
    }

    public CredencialOrganizador(Long id, String token) {
        this.id = id;
        this.token = token;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.token);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CredencialOrganizador other = (CredencialOrganizador) obj;
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "CredencialOrganizador{" + "id=" + id + ", token=" + token + '}';
    }

    
    
}
