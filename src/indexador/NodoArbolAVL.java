/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

/**
 *
 * @author Usersone
 * @param <T>
 */
public class NodoArbolAVL<T extends Comparable<T>> {

    T dato;
    int Fe;
    private NodoArbolAVL<T> nodoIzquierdo;
    private NodoArbolAVL<T> nodoDerecho;

    /**
     * constructor en el cual se le pasa como parametro un tipo de dato y se
     * inicializan los nodos en null
     * @param dato
     */
    public NodoArbolAVL(T dato) {
        this.dato = dato;
        this.nodoIzquierdo = this.nodoDerecho = null;
    }

    /**
     * setters y getters
     * @param dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public T getDato() {
        return dato;
    }

    /**
     *
     * @param nodoDerecho
     */
    public void setNodoDerecho(NodoArbolAVL<T> nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    /**
     *
     * @return
     */
    public NodoArbolAVL<T> getNodoDerecho() {
        return nodoDerecho;
    }

    /**
     *
     * @param nodoIzquierdo
     */
    public void setNodoIzquierdo(NodoArbolAVL<T> nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    /**
     *
     * @return
     */
    public NodoArbolAVL<T> getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    /**
     *
     * @return
     */
    public int getFe() {
        return Fe;
    }

    /**
     *
     * @param Fe
     */
    public void setFe(int Fe) {
        this.Fe = Fe;
    }

    /**
     * metodo toString para sobreescribir cada dato en el arbol 
     * @return 
     */
    @Override
    public String toString() {
        String s = "";
        s += "(" + dato + "," + nodoIzquierdo + "," + nodoDerecho + ")";
        return s;
    }

    /**
     * metodo que no tevuelve nada poero sera para nuestro factor de equilibrio
     * @param r
     */
    public void llenado(NodoArbolAVL<Integer> r) {
        Integer respuesta = -1, respuesta2 = -1;
    }
}
