package co.edu.javeriana.as.jakarta.personapp.web.dto;

import java.io.Serializable;

public class ProfesionDTO implements Serializable{
    private Integer id;
    private String nom;
    private String des;

    public ProfesionDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
