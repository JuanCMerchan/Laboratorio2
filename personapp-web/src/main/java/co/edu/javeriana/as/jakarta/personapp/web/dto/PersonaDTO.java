package co.edu.javeriana.as.jakarta.personapp.web.dto;

import java.io.Serializable;
import java.util.List;

public class PersonaDTO implements Serializable{

    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;
    private List<TelefonoDTO> telefonoList;
    private List<EstudiosDTO> estudiosList;

    public PersonaDTO() {
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<TelefonoDTO> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<TelefonoDTO> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public List<EstudiosDTO> getEstudiosList() {
        return estudiosList;
    }

    public void setEstudiosList(List<EstudiosDTO> estudiosList) {
        this.estudiosList = estudiosList;
    }
}
