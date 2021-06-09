package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.CentroVacunacion;

import java.io.Serializable;
import java.util.List;

public interface CentroVacunacionService extends Serializable {
    CentroVacunacion centroVacunacionGetOne(Integer id);
    List<CentroVacunacion> centroVacunacionGetAll();
}
