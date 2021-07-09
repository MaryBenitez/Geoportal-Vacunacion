package com.nikolas.leaflet.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

public class PersonaMunicipio implements Serializable {


    private String municipio;

    
    private Integer conteo;

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getConteo() {
        return conteo;
    }

    public void setConteo(Integer conteo) {
        this.conteo = conteo;
    }

    public PersonaMunicipio(String municipio, Integer conteo) {
        this.municipio = municipio;
        this.conteo = conteo;
    }

    public PersonaMunicipio() {
    }
}
