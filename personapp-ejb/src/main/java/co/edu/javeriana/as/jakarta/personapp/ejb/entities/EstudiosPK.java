/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.as.jakarta.personapp.ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aasanchez
 */
@Embeddable
public class EstudiosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prof", nullable = false)
    private int idProf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cc_per", nullable = false)
    private int ccPer;

    public EstudiosPK() {
    }

    public EstudiosPK(int idProf, int ccPer) {
        this.idProf = idProf;
        this.ccPer = ccPer;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getCcPer() {
        return ccPer;
    }

    public void setCcPer(int ccPer) {
        this.ccPer = ccPer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProf;
        hash += (int) ccPer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiosPK)) {
            return false;
        }
        EstudiosPK other = (EstudiosPK) object;
        if (this.idProf != other.idProf) {
            return false;
        }
        if (this.ccPer != other.ccPer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.as.jakarta.personapp.ejb.entities.EstudiosPK[ idProf=" + idProf + ", ccPer=" + ccPer + " ]";
    }
    
}
