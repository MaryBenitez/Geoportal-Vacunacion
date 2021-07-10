package com.nikolas.leaflet.repository;

import com.nikolas.leaflet.domain.CentroVacunacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentroVacunacionRepository extends JpaRepository<CentroVacunacion,Integer> {


    CentroVacunacion findOne(Integer id);
    List<CentroVacunacion> findAll();

}
