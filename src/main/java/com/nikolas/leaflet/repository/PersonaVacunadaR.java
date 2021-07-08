package com.nikolas.leaflet.repository;

import com.nikolas.leaflet.domain.PersonaVacunada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonaVacunadaR {

    PersonaVacunada findOne(Integer id);
    List<PersonaVacunada> findAll();
    void insert(PersonaVacunada personaVacunada);
}
