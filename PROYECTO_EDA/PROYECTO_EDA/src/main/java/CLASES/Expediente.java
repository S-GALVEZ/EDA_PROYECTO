/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASES;

/**
 *
 * @author Sebastian
 */
public class Expediente extends DatosInt{
    private String identificador;
    private int prioridad;
    private String asunto;
    private String documento;

    public Expediente(String identificador, int prioridad, String asunto, String documento, String DNI, String nombre, String telefono, String email) {
        super(DNI, nombre, telefono, email);
        this.identificador = identificador;
        this.prioridad = prioridad;
        this.asunto = asunto;
        this.documento = documento;
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
    
    
    
    
}
