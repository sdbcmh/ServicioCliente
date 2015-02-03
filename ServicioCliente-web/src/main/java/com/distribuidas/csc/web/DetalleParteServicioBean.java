/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidas.csc.web;

import com.distribuidas.csc.persistencia.DetalleParteServicio;
import com.distribuidas.csc.servicio.DetalleParteServicioServicio;
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
public class DetalleParteServicioBean {
    
    @EJB
    private DetalleParteServicioServicio detalleParteServicioServicio;

    private List<DetalleParteServicio> detalleParteServicios;
    private DetalleParteServicio detalleParteServicio;
    private DetalleParteServicio detalleParteServicioSeleccionado;

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
        this.detalleParteServicios = this.detalleParteServicioServicio.obtenerTodos();
    }

    public void vista() {
        this.desplegarVista = true;
    }

    public void nuevo() {
        this.desplegarNuevo = true;
        this.enNuevo = true;
        this.enModificar = false;
        this.detalleParteServicio = new DetalleParteServicio();
    }

    public void guardar() {
        if (this.enNuevo) {
            this.detalleParteServicioServicio.crear(this.detalleParteServicio);
            this.desplegarNuevo = false;
            this.detalleParteServicios.add(this.detalleParteServicio);
            this.enNuevo = false;
        } else if (this.enModificar) {
            System.err.println("modificar");
            this.detalleParteServicioServicio.actualizar(this.detalleParteServicio);
            this.desplegarNuevo = false;
            this.enModificar = false;
        }
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo = false;
        this.desplegarNuevo = true;
        this.detalleParteServicio = this.detalleParteServicioSeleccionado;
    }

    public void eliminar() {
        this.detalleParteServicioServicio.eliminar(this.detalleParteServicioSeleccionado);
        this.detalleParteServicios.remove(this.detalleParteServicioSeleccionado);
    }

    public void cancelar() {
        this.desplegarNuevo = false;
    }

    public void onRowSelect(SelectEvent event) {

    }

    public void onRowUnselect(UnselectEvent event) {

    }

    public List<DetalleParteServicio> getDetalleParteServicios() {
        return detalleParteServicios;
    }

    public DetalleParteServicio getDetalleParteServicio() {
        return detalleParteServicio;
    }

    public void setDetalleParteServicio(DetalleParteServicio detalleParteServicio) {
        this.detalleParteServicio = detalleParteServicio;
    }

    public DetalleParteServicio getDetalleParteServicioSeleccionado() {
        return detalleParteServicioSeleccionado;
    }

    public void setDetalleParteServicioSeleccionado(DetalleParteServicio detalleParteServicioSeleccionado) {
        this.detalleParteServicioSeleccionado = detalleParteServicioSeleccionado;
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
