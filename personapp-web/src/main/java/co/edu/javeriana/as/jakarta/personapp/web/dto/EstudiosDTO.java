package co.edu.javeriana.as.jakarta.personapp.web.dto;

import java.io.Serializable;
import java.util.Date;

public class EstudiosDTO implements Serializable{
    
    private Date fecha;
    private String univer;
    private ProfesionDTO profesion;

    public EstudiosDTO() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUniver() {
        return univer;
    }

    public void setUniver(String univer) {
        this.univer = univer;
    }

    public ProfesionDTO getProfesion() {
        return profesion;
    }

    public void setProfesion(ProfesionDTO profesion) {
        this.profesion = profesion;
    }
}
