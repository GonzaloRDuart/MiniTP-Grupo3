package com.utn.frba.relacionamientopersonas.model.persona;

import com.utn.frba.relacionamientopersonas.model.delegacion.Delegacion;
import com.utn.frba.relacionamientopersonas.model.delegacion.Estado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String dni;

    private String nombre;

    private String apellido;

    private LocalDate fechaNacimiento;

    private String ciudad;

    private String localidad;

    private String foto;

    public Persona(){}


    public Persona(String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String ciudad, String localidad, String foto){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.localidad = localidad;
        this.foto = foto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String toString() {
        return "Persona{" +
                "id" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", localidad='" + localidad + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
