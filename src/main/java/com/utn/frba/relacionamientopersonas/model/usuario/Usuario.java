package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.rol.Rol;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreUsuario;

    private String password;

    private Boolean enable;

    @Transient
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;

    public Usuario(String nombreUsuario, String password, List grantList) {
    }

    public Usuario() {

    }
}
