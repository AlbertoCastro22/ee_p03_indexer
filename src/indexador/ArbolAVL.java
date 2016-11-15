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
public class ArbolAVL<T extends Comparable<T>> {

    NodoArbolAVL<T> raiz;

    /**
     * setter
     * @return 
     */
    public NodoArbolAVL<T> getRaizAVL() {
        return (NodoArbolAVL<T>) raiz;
    }

    /**
     * metodo en el que retorna un nodo de un arbol avl
     * @param nodo
     * @return 
     */
    public NodoArbolAVL castAVL(NodoArbolAVL<T> nodo) {
        return (NodoArbolAVL<T>) nodo;
    }

    /**
     * revisa por la rama izquierda en la cual si no esta valanceado se hacen
     * las rotaciones. La primera es izquierda, izquierda: la segunda es
     * izquierda, derecha. Siempre tomando en cuenta el factor de equilibrio
     * @param nodo
     * @param direccion
     */
    public void revisarI(NodoArbolAVL<T> nodo, Integer direccion) {
        NodoArbolAVL<T> nodo1, nodo2, nodo3;
        if (direccion == -1) {
            nodo1 = (NodoArbolAVL<T>) nodo.getNodoIzquierdo();
            nodo2 = (NodoArbolAVL<T>) nodo1.getNodoIzquierdo();
        } else {
            nodo1 = (NodoArbolAVL<T>) nodo.getNodoDerecho();
            nodo2 = (NodoArbolAVL<T>) nodo1.getNodoIzquierdo();
        }
        if (nodo2.getFe() == -1) {// Rotacion II
            nodo1.setNodoIzquierdo(nodo2.getNodoDerecho());
            nodo2.setNodoDerecho(nodo1);
            nodo1.setFe(0);
            if (direccion == -1) {
                nodo.setNodoIzquierdo(nodo2);
            } else {
                nodo.setNodoDerecho(nodo2);
            }
        } else { // Rotacion ID
            nodo3 = (NodoArbolAVL<T>) nodo2.getNodoDerecho();
            nodo1.setNodoIzquierdo(nodo3.getNodoDerecho());
            nodo3.setNodoDerecho(nodo1);
            nodo2.setNodoDerecho(nodo3.getNodoIzquierdo());
            nodo3.setNodoIzquierdo(nodo2);
            if (nodo3.getFe() == -1) {
                nodo1.setFe(1);
            } else {
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == 1) {
                nodo2.setFe(-1);
            } else {
                nodo2.setFe(0);
            }
            if (direccion == -1) {
                nodo.setNodoIzquierdo(nodo3);
            } else {
                nodo.setNodoDerecho(nodo3);
            }

        }
        nodo1.setFe(0);
    }

    /**
     * es parecido al metodo anterior pero en este caso es de la rama derecha y
     * sus rotaciones seran: derecha derecha y derecha izquierda
     * @param nodo
     * @param direccion
     */
    public void revisarD(NodoArbolAVL<T> nodo, Integer direccion) {
        NodoArbolAVL<T> nodo1, nodo2, nodo3;
        if (direccion == -1) {
            nodo1 = (NodoArbolAVL<T>) nodo.getNodoIzquierdo();
            nodo2 = (NodoArbolAVL<T>) nodo1.getNodoDerecho();
        } else {
            nodo1 = (NodoArbolAVL<T>) nodo.getNodoDerecho();
            nodo2 = (NodoArbolAVL<T>) nodo1.getNodoDerecho();
        }
        if (nodo2.getFe() == 1) {// Rotacion DD
            nodo1.setNodoDerecho(nodo2.getNodoIzquierdo());
            nodo2.setNodoIzquierdo(nodo1);
            nodo1.setFe(0);
            if (direccion == -1) {
                nodo.setNodoIzquierdo(nodo2);
            } else {
                nodo.setNodoDerecho(nodo2);
            }

        } else { // Rotacion DI
            nodo3 = (NodoArbolAVL<T>) nodo2.getNodoIzquierdo();
            nodo1.setNodoDerecho(nodo3.getNodoIzquierdo());
            nodo3.setNodoIzquierdo(nodo1);
            nodo2.setNodoIzquierdo(nodo3.getNodoDerecho());
            nodo3.setNodoDerecho(nodo2);
            if (nodo3.getFe() == 1) {
                nodo1.setFe(-1);
            } else {
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == -1) {
                nodo2.setFe(1);
            } else {
                nodo2.setFe(0);
            }
            if (direccion == -1) {
                nodo.setNodoIzquierdo(nodo3);
            } else {
                nodo.setNodoDerecho(nodo3);
            }

        }
        nodo1.setFe(0);
    }

    /**
     * este primer metodo sera para unsertar en un nodo un dato en la cual
     * recursivamente se comprobara su insercion
     */
    private Integer _insertar(NodoArbolAVL<T> nodo, T dato) {
        Integer resultado = 0;
        if (dato.compareTo(nodo.getDato()) < 0) {
            if (nodo.getNodoIzquierdo() == null) {
                nodo.setNodoIzquierdo(new NodoArbolAVL<T>(dato));
                switch (castAVL(nodo).getFe()) {
                    case 1: // El arbol se balanceÃ³
                        castAVL(nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se cargÃ³ del lado izquierdo
                        castAVL(nodo).setFe(-1);
                        resultado = 1;
                        break;
                }
                //resultado = 1;

            } else {
                switch (_insertar(nodo.getNodoIzquierdo(), dato)) {
                    case 1: // Se insrtÃ³ un dato nuevo, revisar.
                        switch (castAVL(nodo).getFe()) {
                            case 1: // El arbol se balanceÃ³
                                castAVL(nodo).setFe(0);
                                resultado = 0;
                                break;
                            case 0: // Se cargÃ³ del lado izquierdo
                                castAVL(nodo).setFe(-1);
                                resultado = 1;
                                break;
                            case -1: // Reestructuracion del arbol
                                //if (nodo == raiz){
                                resultado = -1;
                                //}else{                                     
                                //}
                                break;
                        }
                        break;
                    case -1:
                        revisarI(castAVL(nodo), -1);
                        break;
                    case -2:
                        revisarD(castAVL(nodo), -1);
                        break;
                }
            }
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            if (nodo.getNodoDerecho() == null) {
                nodo.setNodoDerecho(new NodoArbolAVL(dato));
                switch (castAVL(nodo).getFe()) {
                    case -1: // El arbol se balanceÃ³
                        castAVL(nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se cargÃ³ del lado izquierdo
                        castAVL(nodo).setFe(1);
                        resultado = 1;
                        break;
                }
            } else {
                switch (_insertar(nodo.getNodoDerecho(), dato)) {
                    case 1: // Se insrtÃ³ un dato nuevo, revisar.
                        switch (castAVL(nodo).getFe()) {
                            case -1: // El arbol se balanceÃ³
                                castAVL(nodo).setFe(0);
                                resultado = 0;
                                break;
                            case 0: // Se cargÃ³ del lado der
                                castAVL(nodo).setFe(1);
                                resultado = 1;
                                break;
                            case 1: // Reestructuracion del arbol
                                resultado = -2;
                        }
                        break;
                    case -1:
                        revisarI(castAVL(nodo), 1);
                        break;
                    case -2:
                        revisarD(castAVL(nodo), 1);
                        break;
                }
            }
        }
        return resultado;
    }

    /**
     * este segundo metodo insertar manda a llamar al anterior y revisa que la
     * raiz sea diferente de nula, en caso contrario hara su insercion sea el
     * caso (rama izquierda o derecha)
     * @param dato
     * @return 
     */
    public Integer insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoArbolAVL<T>(dato);
        } else {
            Integer result = _insertar(raiz, dato);
            if (result == -1) {

                // ReestructuraciÃ³n del arbol
                NodoArbolAVL<T> nodo1, nodo2;
                nodo1 = (NodoArbolAVL) raiz.getNodoIzquierdo();

                if (nodo1.getFe() == -1) {// Rotacion II
                    raiz.setNodoIzquierdo(nodo1.getNodoDerecho());
                    nodo1.setNodoDerecho(raiz);
                    castAVL(raiz).setFe(0);
                    raiz = nodo1;
                } else { // Rotacion ID
                    nodo2 = (NodoArbolAVL<T>) nodo1.getNodoDerecho();
                    raiz.setNodoIzquierdo(nodo2.getNodoDerecho());
                    nodo2.setNodoDerecho(raiz);
                    nodo1.setNodoDerecho(nodo2.getNodoIzquierdo());
                    nodo2.setNodoIzquierdo(nodo1);
                    if (nodo2.getFe() == -1) {
                        castAVL(raiz).setFe(1);
                    } else {
                        castAVL(raiz).setFe(0);
                    }
                    if (nodo2.getFe() == 1) {
                        nodo1.setFe(-1);
                    } else {
                        nodo1.setFe(0);
                    }
                    raiz = nodo2;
                }
                castAVL(raiz).setFe(0);
            } else if (result == -2) {
                // ReestructuraciÃ³n del arbol
                NodoArbolAVL<T> nodo1, nodo2;
                nodo1 = (NodoArbolAVL) raiz.getNodoDerecho();

                if (nodo1.getFe() == 1) {// Rotacion DD
                    raiz.setNodoDerecho(nodo1.getNodoIzquierdo());
                    nodo1.setNodoIzquierdo(raiz);
                    castAVL(raiz).setFe(0);
                    raiz = nodo1;
                } else { // Rotacion DI
                    nodo2 = (NodoArbolAVL<T>) nodo1.getNodoIzquierdo();
                    raiz.setNodoDerecho(nodo2.getNodoIzquierdo());
                    nodo2.setNodoIzquierdo(raiz);
                    nodo1.setNodoIzquierdo(nodo2.getNodoDerecho());
                    nodo2.setNodoDerecho(nodo1);
                    if (nodo2.getFe() == 1) {
                        castAVL(raiz).setFe(-1);
                    } else {
                        castAVL(raiz).setFe(0);
                    }
                    if (nodo2.getFe() == -1) {
                        nodo1.setFe(1);
                    } else {
                        nodo1.setFe(0);
                    }
                    raiz = nodo2;

                }
                castAVL(raiz).setFe(0);
            }
        }
        return 0;
    }

    /**
     * metodo para recorrer un arbol binario en el cual va primero visitar,
     * izquierda, derecha
     * @param r
     */
    public void preOrden(NodoArbolAVL<T> r) {
        if (r != null) {
            System.out.println(r.getDato() + ",");
            preOrden(r.getNodoIzquierdo());
            preOrden(r.getNodoDerecho());

        }
    }

    /**
     * metodo inorden para recorrer de cierta manera el arbol izquierda primero
     * y despues derecha
     * @param r
     */
    public void inOrden(NodoArbolAVL<T> r) {
        try {
            if (r != null) {
                if (r.getNodoIzquierdo() != null) {
                    inOrden(r.getNodoIzquierdo());
                    System.out.println(r.getDato() + ",");
                    inOrden(r.getNodoDerecho());
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * metodo para recorrer un arbol en donde primero va izquierda, derecha,
     * visitar
     * @param r
     */
    public void postOrden(NodoArbolAVL<T> r) {
        if (r != null) {
            postOrden(r.getNodoIzquierdo());
            postOrden(r.getNodoDerecho());
            System.out.println(r.getDato() + ",");
        }
    }

    /**
     * metodo para buscar en un nodo un dato retornando true si lo encuentra y
     * false si no...
     * @param a
     * @param dato
     * @return 
     */
    public boolean buscar(NodoArbolAVL<T> a, T dato) {
        boolean encontrado = false;
        if (a != null) {
            if (dato.compareTo(a.getDato()) == 0) {
                return true;
            }
            if (dato.compareTo(a.getDato()) < 0) {
                encontrado = buscar(a.getNodoIzquierdo(), dato);
            } else if (dato.compareTo(a.getDato()) > 0) {
                encontrado = buscar(a.getNodoDerecho(), dato);
            }
        }
        return encontrado;
    }
}
