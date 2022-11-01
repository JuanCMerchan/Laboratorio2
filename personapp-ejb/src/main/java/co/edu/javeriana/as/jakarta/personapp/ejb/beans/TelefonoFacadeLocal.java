/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.jakarta.personapp.ejb.beans;

import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Telefono;
import jakarta.ejb.Local;

import java.util.List;

/**
 *
 * @author aasanchez
 */
@Local
public interface TelefonoFacadeLocal {

    void create(Telefono telefono);

    void edit(Telefono telefono);

    void remove(Telefono telefono);

    Telefono find(Object id);

    List<Telefono> findAll();

    List<Telefono> findRange(int[] range);

    int count();
    
}
