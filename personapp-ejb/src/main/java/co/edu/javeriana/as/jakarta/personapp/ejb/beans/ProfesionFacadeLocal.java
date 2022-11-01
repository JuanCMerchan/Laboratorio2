/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.jakarta.personapp.ejb.beans;

import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Profesion;
import jakarta.ejb.Local;

import java.util.List;

/**
 *
 * @author aasanchez
 */
@Local
public interface ProfesionFacadeLocal {

    void create(Profesion profesion);

    void edit(Profesion profesion);

    void remove(Profesion profesion);

    Profesion find(Object id);

    List<Profesion> findAll();

    List<Profesion> findRange(int[] range);

    int count();
    
}
