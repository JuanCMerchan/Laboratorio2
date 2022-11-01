/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.jakarta.personapp.ejb.beans.impl;

import co.edu.javeriana.as.jakarta.personapp.ejb.beans.AbstractFacade;
import co.edu.javeriana.as.jakarta.personapp.ejb.beans.PersonaFacadeLocal;
import co.edu.javeriana.as.jakarta.personapp.ejb.entities.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aasanchez
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "persona_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
}
