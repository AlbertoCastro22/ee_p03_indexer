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
public class ArbolBinario<T extends Comparable<T>> {

    NodoBinario<T> raiz;

    /**
     * constructor vacio en el cual se inicializa nuestra raiz del arbol en nulo
     */
    public ArbolBinario() {
        raiz = null;
    }

    /**
     * setters y getters
     * @return 
     */
    public NodoBinario<T> getRaiz() {
        return raiz;
    }

    /**
     *
     * @param raiz
     */
    public void setRaiz(NodoBinario<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * metodo insertar en el cual se le pasa como parametro un tipo de dato y si
     * la raiz es nula, el primer dato sera la raiz de lo contrario se iran
     * creando nstros hijos
     * @param d
     */
    public void insertar(T d) {
        NodoBinario<T> nuevo = new NodoBinario<T>(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoBinario<T> aux = getRaiz();
            NodoBinario<T> padre = null;
            while (true) {
                padre = aux;
                if (d.compareTo(aux.getDato()) < 0) {
                    aux = aux.getHijoIzquierdo();
                    if (aux == null) {
                        padre.setHijoIzquierdo(nuevo);
                        return;
                    }
                } else {
                    aux = aux.getHijoDerecho();
                    if (aux == null) {
                        padre.setHijoDerecho(nuevo);
                        return;
                    }
                }
            }
        }
    }

    /**
     * metodo inorden para recorrer de cierta manera el arbol izquierda primero
     * y despues derecha
     * @param r
     */
    public void inOrden(NodoBinario<T> r) {
        if (r != null) {
            inOrden(r.getHijoIzquierdo());
            System.out.println(r.getDato());
            inOrden(r.getHijoDerecho());
        }
    }

    /**
     * metodo para recorrer un arbol binario en el cual va primero visitar,
     * izquierda, derecha
     * @param r
     */
    public void preOrden(NodoBinario<T> r) {
        if (r != null) {
            System.out.println(r.getDato());
            preOrden(r.getHijoIzquierdo());
            preOrden(r.getHijoDerecho());
        }
    }

    /**
     * metodo para recorrer un arbol en donde primero va izquierda, derecha,
     * visitar
     * @param r
     */
    public void postOrden(NodoBinario<T> r) {
        if (r != null) {
            postOrden(r.getHijoIzquierdo());
            postOrden(r.getHijoDerecho());
            System.out.println(r.getDato());
        }
    }

    /**
     * metodo para buscar en un nodo un dato retornando true si lo encuentra y
     * false si no...
     * @param a
     * @param dato
     * @return 
     */
    public boolean buscar(NodoBinario<T> a, T dato) {
        boolean encontrado = false;
        if (a != null) {
            if (dato.compareTo(a.getDato()) == 0) {
                return true;
            }
            if (dato.compareTo(a.getDato()) < 0) {
                encontrado = buscar(a.getHijoIzquierdo(), dato);
            } else if (dato.compareTo(a.getDato()) > 0) {
                encontrado = buscar(a.getHijoDerecho(), dato);
            }
        }
        return encontrado;
    }
}