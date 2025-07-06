*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASES;

/**
 *
 * @author Sebastian
 */
public class GestionExpediente {
    private Nodo primero;

    public GestionExpediente() {
        primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    // Agrega al inicio (LIFO)
    public void agregarComoPila(Expediente exp) {
        Nodo nuevo = new Nodo(exp);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }

    // Elimina el expediente más reciente (el primero)
    public Expediente eliminarUltimoAgregado() {
        if (primero == null) return null;
        Expediente eliminado = (Expediente) primero.getElemento();
        primero = primero.getSiguiente();
        return eliminado;
    }

    // Buscar expediente por ID
    public Expediente buscarPorID(String id) {
        Nodo actual = primero;
        while (actual != null) {
            Expediente exp = (Expediente) actual.getElemento();
            if (exp.getIdentificador().equalsIgnoreCase(id)) {
                return exp;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Contar cuántos expedientes hay
    public int contarExpedientes() {
        int contador = 0;
        Nodo actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
}
