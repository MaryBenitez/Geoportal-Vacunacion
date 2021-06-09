package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.CentroVacunacion;

import java.io.Serializable;

public interface CentroVacunacionService extends Serializable {
    CentroVacunacion centroVacunacionGetOne(Integer id);
}
