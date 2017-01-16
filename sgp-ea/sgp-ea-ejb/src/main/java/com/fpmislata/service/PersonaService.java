/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Persona;
import com.fpmislata.repository.PersonaDaoImplLocal;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersonaService implements PersonaServiceLocal {

    @EJB
    private PersonaDaoImplLocal personaDaoImpl;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")  

    @Override
    public List listPersonas() {
        return personaDaoImpl.listPersonas();
    }

    @Override
    public void addPersona(Persona persona) {
        //comprobamos que la persona no existe por el email
        Persona p = personaDaoImpl.findPersonaByEmail(persona);
        if(p==null){
            personaDaoImpl.addPersona(persona);
        }
    }

    @Override
    public void updatePersona(Persona persona) {
        personaDaoImpl.updatePersona(persona);
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return personaDaoImpl.findPersonaById(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        personaDaoImpl.deletePersona(persona);
    }
    
    
    
}
