package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.PersonaMunicipio;
import com.nikolas.leaflet.domain.PersonaVacunada;
import org.springframework.dao.DataAccessException;

import java.io.Serializable;
import java.util.List;

public interface PersonaVacunadaService extends Serializable {

    List<PersonaVacunada> personaVacunadaGetAll();
    void insert(PersonaVacunada personaVacunada) throws DataAccessException;
}
