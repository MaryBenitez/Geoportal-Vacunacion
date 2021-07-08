package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.PersonaVacunada;

import java.io.Serializable;
import java.util.List;

public interface PersonaVacunadaService extends Serializable {
    PersonaVacunada personaVacunadaGetOne(Integer id);
    List<PersonaVacunada> personaVacunadaGetAll();
    void insert(PersonaVacunada personaVacunada);
}
