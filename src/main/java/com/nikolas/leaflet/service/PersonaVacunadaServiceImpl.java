package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.CentroVacunacion;
import com.nikolas.leaflet.domain.PersonaVacunada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonaVacunadaServiceImpl implements PersonaVacunadaService{


    @PersistenceContext(unitName="persistenceUnit")
    private EntityManager entityManager;


    @Override
    public List<PersonaVacunada> personaVacunadaGetAll() {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.persona_vacunada");
        Query query = entityManager.createNativeQuery(sb.toString(),PersonaVacunada.class);
        List<PersonaVacunada> resulset = query.getResultList();
        return resulset;
    }

    @Transactional
    public void insert(PersonaVacunada personaVacunada) {
        entityManager.persist(personaVacunada);
    }
}
