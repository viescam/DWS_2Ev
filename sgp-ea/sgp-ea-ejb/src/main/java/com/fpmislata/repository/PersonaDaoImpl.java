/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author alumno
 */
@Stateless
public class PersonaDaoImpl implements PersonaDaoImplLocal {

    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;
    
    @Override
    public List listPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class,persona.getId());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("from Persona where p.email = :email");
        query.setParameter("email", persona.getEmail());
        try{
            return (Persona)query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }catch(NonUniqueResultException nur){
            return (Persona)query.getResultList().get(0);
        }
    }

    @Override
    public void deletePersona(Persona persona) {
        persona = findPersonaById(persona);
        em.remove(persona);
    }
    
    
    
}
