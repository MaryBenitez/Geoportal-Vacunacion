package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.CentroVacunacion;
import com.nikolas.leaflet.domain.PersonaVacunada;
import com.nikolas.leaflet.repository.PersonaVacunadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PersonaVacunadaServiceImpl implements PersonaVacunadaService{

    @Autowired
    PersonaVacunadaRepository personaVacunadaRepository;

    @PersistenceContext(unitName="capas")
    private EntityManager entityManager;

    @Override
    public PersonaVacunada personaVacunadaGetOne(Integer id) {
        return personaVacunadaRepository.findOne(id);
    }

    @Override
    public List<PersonaVacunada> personaVacunadaGetAll() {
        return personaVacunadaRepository.findAll();
    }

    @Override
    public void insert(PersonaVacunada personaVacunada) {
        entityManager.persist(personaVacunada);
    }
}
