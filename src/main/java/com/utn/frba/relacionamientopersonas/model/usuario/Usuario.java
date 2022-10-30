package com.utn.frba.relacionamientopersonas.model.usuario;

import com.utn.frba.relacionamientopersonas.model.persona.Persona;
import com.utn.frba.relacionamientopersonas.model.rol.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String password;

    private Boolean enable;

    @OneToOne
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuarios", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles;

    public Usuario(String nombre, String password, List<Rol> roles) {
        this.nombre=nombre;
        this.password=password;
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario() {

    }

    public String getNombre(){
        return this.nombre;
    }

}
