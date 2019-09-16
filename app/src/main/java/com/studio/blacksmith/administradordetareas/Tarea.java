package com.studio.blacksmith.administradordetareas;

import java.util.Date;

/**
 * Created by Blacksmith on 07/08/2014.
 */
public class Tarea {
    protected int id;
    protected String titulo;
    protected String descripcion;
    protected String fechaInicio;
    protected String fechaFin;
    protected boolean estado;
    //done or pending

    public int getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    protected int prioridad;


    public Tarea(int id, String titulo, String descripcion, String fechaInicio, String fechaFin, boolean estado, int prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.prioridad = prioridad;

    }
    public Tarea(int id) {
        this.id=id;
        this.titulo="";
        this.descripcion = "";
        this.fechaInicio = "YYYY-MM-DD";
        this.fechaFin = "YYYY-MM-DD";
        this.estado = false;
        this.prioridad = 0;

    }
}
