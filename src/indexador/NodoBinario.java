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
public class NodoBinario<T> {

    T dato;
    NodoBinario<T> hijoIzquierdo;
    NodoBinario<T> hijoDerecho;

    /**
     * primer constructor al que se le pasa un tipo de dato e inicializara los
     * nodos en nulos
     * @param dato
     */
    public NodoBinario(T dato) {
        this.dato = dato;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    /**
     * segundo constructor(vacio) en el que inicializaremos las variables en
     * null
     */
    public NodoBinario() {
        dato = null;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    /**
     * setters y getters de cada parametro
     * @return 
     */
    public T getDato() {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public NodoBinario<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /**
     *
     * @param hijoIzquierdo
     */
    public void setHijoIzquierdo(NodoBinario<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /**
     *
     * @return
     */
    public NodoBinario<T> getHijoDerecho() {
        return hijoDerecho;
    }

    /**
     *
     * @param hijoDerecho
     */
    public void setHijoDerecho(NodoBinario<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
