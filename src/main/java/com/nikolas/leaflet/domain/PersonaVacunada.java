package com.nikolas.leaflet.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="persona_vacunada")
public class PersonaVacunada implements Serializable {
    @Id
    @Column(name="id")
    @SequenceGenerator(name = "persona_vacunada_id_seq", sequenceName = "persona_vacunada_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_vacunada_id_seq")
    private Integer id;

    @Column(name="dui")
    private String dui;

    @Column(name="municipio")
    private String municipioPersona;

    @Column(name="edad")
    private String edadPersona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getMunicipioPersona() {
        return municipioPersona;
    }

    public void setMunicipioPersona(String municipioPersona) {
        this.municipioPersona = municipioPersona;
    }

    public String getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(String edadPersona) {
        this.edadPersona = edadPersona;
    }

    public PersonaVacunada(Integer id, String dui, String municipioPersona) {
        this.id = id;
        this.dui = dui;
        this.municipioPersona = municipioPersona;
    }
    public PersonaVacunada(){

    }
}
