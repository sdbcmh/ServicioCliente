/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.MarcaVerificacion;
import com.distribuidas.csc.servicio.MarcaVerificacionServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Stephen
 */
@ManagedBean
@ViewScoped
public class MarcaVerificacionBean {
    
    @EJB
    private MarcaVerificacionServicio marcaVerificacionServicio;

    private List<MarcaVerificacion> marcaVerificaciones;
    private MarcaVerificacion marcaVerificacion;
    private MarcaVerificacion marcaVerificacionSeleccionada;

    private Boolean desplegarVista = false;
    private Boolean desplegarNuevo = false;

    private String tituloFormulario;
    private Boolean enNuevo;
    private Boolean enModificar;

    private Boolean activarNuevo;
    private Boolean activarModificar;
    private Boolean activarEliminar;
    private Boolean activarCambiarEstado;

    @PostConstruct
    public void init() {
        this.marcaVerificaciones = this.marcaVerificacionServicio.obtenerTodos();
    }

    public void vista() {
        this.desplegarVista = true;
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.marcaVerificacion = new MarcaVerificacion();
    }

    public void guardar() {
        if (this.enNuevo) {
            this.marcaVerificacionServicio.crear(this.marcaVerificacion);
            this.desplegarNuevo = false;
            this.marcaVerificaciones.add(this.marcaVerificacion);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.marcaVerificacionServicio.actualizar(this.marcaVerificacion);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.marcaVerificacion = this.marcaVerificacionSeleccionada;
    }

    public void eliminar() {
        this.marcaVerificacionServicio.eliminar(this.marcaVerificacionSeleccionada);
        this.marcaVerificaciones.remove(this.marcaVerificacionSeleccionada);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<MarcaVerificacion> getMarcaVerificaciones() {
        return marcaVerificaciones;
    }

    public MarcaVerificacion getMarcaVerificacion() {
        return marcaVerificacion;
    }

    public void setMarcaVerificacion(MarcaVerificacion marcaVerificacion) {
        this.marcaVerificacion = marcaVerificacion;
    }

    public MarcaVerificacion getMarcaVerificacionSeleccionada() {
        return marcaVerificacionSeleccionada;
    }

    public void setMarcaVerificacionSeleccionada(MarcaVerificacion marcaVerificacionSeleccionada) {
        this.marcaVerificacionSeleccionada = marcaVerificacionSeleccionada;
    }

    public Boolean getDesplegarVista() {
        return desplegarVista;
    }

    public void setDesplegarVista(Boolean desplegarVista) {
        this.desplegarVista = desplegarVista;
    }

    public Boolean getDesplegarNuevo() {
        return desplegarNuevo;
    }

    public void setDesplegarNuevo(Boolean desplegarNuevo) {
        this.desplegarNuevo = desplegarNuevo;
    }

    public String getTituloFormulario() {
        return tituloFormulario;
    }

    public void setTituloFormulario(String tituloFormulario) {
        this.tituloFormulario = tituloFormulario;
    }

    public Boolean getEnNuevo() {
        return enNuevo;
    }

    public void setEnNuevo(Boolean enNuevo) {
        this.enNuevo = enNuevo;
    }

    public Boolean getEnModificar() {
        return enModificar;
    }

    public void setEnModificar(Boolean enModificar) {
        this.enModificar = enModificar;
    }

    public Boolean getActivarNuevo() {
        return activarNuevo;
    }

    public void setActivarNuevo(Boolean activarNuevo) {
        this.activarNuevo = activarNuevo;
    }

    public Boolean getActivarModificar() {
        return activarModificar;
    }

    public void setActivarModificar(Boolean activarModificar) {
        this.activarModificar = activarModificar;
    }

    public Boolean getActivarEliminar() {
        return activarEliminar;
    }

    public void setActivarEliminar(Boolean activarEliminar) {
        this.activarEliminar = activarEliminar;
    }

    public Boolean getActivarCambiarEstado() {
        return activarCambiarEstado;
    }

    public void setActivarCambiarEstado(Boolean activarCambiarEstado) {
        this.activarCambiarEstado = activarCambiarEstado;
    }
    
}
