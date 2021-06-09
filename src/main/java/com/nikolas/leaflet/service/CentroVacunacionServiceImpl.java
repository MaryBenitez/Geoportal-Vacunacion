package com.nikolas.leaflet.service;

import com.nikolas.leaflet.domain.CentroVacunacion;
import com.nikolas.leaflet.repository.CentroVacunacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CentroVacunacionServiceImpl implements CentroVacunacionService{
    @Autowired
    CentroVacunacionRepository centroVacunacionRepository;

    @Override
    public CentroVacunacion centroVacunacionGetOne(Integer id) {

        return centroVacunacionRepository.findOne(id);
    }
}
