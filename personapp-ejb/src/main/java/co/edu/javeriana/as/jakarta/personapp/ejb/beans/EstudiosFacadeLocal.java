/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.jakarta.personapp.ejb.beans;

import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Estudios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aasanchez
 */
@Local
public interface EstudiosFacadeLocal {

    void create(Estudios estudios);

    void edit(Estudios estudios);

    void remove(Estudios estudios);

    Estudios find(Object id);

    List<Estudios> findAll();

    List<Estudios> findRange(int[] range);

    int count();
    
}
