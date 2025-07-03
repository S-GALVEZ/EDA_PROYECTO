/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASES;

/**
 *
 * @author Sebastian
 */
import java.time.LocalDateTime; //Cambio para añadir finalizacion

public class Expediente extends DatosInt{
    private String identificador;
    private int prioridad;
    private String asunto;
    private String documento;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin; //Cambio para añadir finalizacion

    public Expediente(String identificador, int prioridad, String asunto, String documento, String DNI, String nombre, String telefono, String email) {
        super(DNI, nombre, telefono, email);
        this.identificador = identificador;
        this.prioridad = prioridad;
        this.asunto = asunto;
        this.documento = documento;
        this.fechaInicio = LocalDateTime.now();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getPrioridad() {
        return prioridad; 
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public void setFechaFin(LocalDateTime fechaFin) { //Cambio para añadir finalizacion
    this.fechaFin = fechaFin;
}

    public boolean estaFinalizado() { //Cambio para añadir finalizacion
        return fechaFin != null;
    }
    
    public LocalDateTime getFechaInicio() {
    return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
    return fechaFin;
    }
    
    
    
}
