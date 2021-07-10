package com.nikolas.leaflet.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "centros_de_vacunacion")
public class CentroVacunacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "centros_de_vacunacion_id_seq", sequenceName = "centros_de_vacunacion_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "centros_de_vacunacion_id_seq")
    private Integer id;

    @Column(name = "coor_x")
    private Double coorX;
    @Column(name = "coor_y")
    private Double coorY;

    @Column(name = "nombre")
    private String nombreCentro;

    @Column(name = "direccion")
    private String direccionCentro;

    @Column(name="municipio")
    private String municipioCentro;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCoorX() {
        return coorX;
    }

    public void setCoorX(Double coorX) {
        this.coorX = coorX;
    }

    public Double getCoorY() {
        return coorY;
    }

    public void setCoorY(Double coorY) {
        this.coorY = coorY;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccionCentro() {
        return direccionCentro;
    }

    public void setDireccionCentro(String direccionCentro) {
        this.direccionCentro = direccionCentro;
    }

    public String getMunicipioCentro() {
        return municipioCentro;
    }

    public void setMunicipioCentro(String municipioCentro) {
        this.municipioCentro = municipioCentro;
    }
}
