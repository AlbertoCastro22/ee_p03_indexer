/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

import java.io.*;
import java.util.*;

import javax.swing.*;

/**
 *
 * @author Usersone
 */
public class Archivo {

    ArbolAVL<String> nomb;
    ArbolAVL<String> ape;
    ArbolAVL<String> email;
    ArbolBinario<String> id;
    ArrayList<Persona> per = new ArrayList<Persona>();
    Iterator<Persona> it;
    Persona p;
    String arreglo[];

    /**
     *
     */
    public void abrirArchivo() {
        String linea = "";
        JFileChooser abrir = new JFileChooser();
        abrir.showOpenDialog(abrir);
        try {
            String archivo = abrir.getSelectedFile().getAbsolutePath();
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (Exception e) {
        }
    }

    /**
     * metodo para guardar el archivo en un ArrayList y este se utilizara mas
     * adelante al construir los arboles de cada dato
     * @param nombre
     */
    public void guardarDatos(String nombre) {
        String linea = "";
        try {
            FileReader fr = new FileReader(nombre + ".txt");
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            linea = br.readLine();
            while (linea != null) {
                arreglo = linea.split(",");
                p = new Persona(arreglo[0], arreglo[1], arreglo[2], arreglo[3]);
                //System.out.println(linea);
                per.add(p);
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * inserta los nombres de cada persona en el arbol
     */
    public void insertarNombresArbol() {
        nomb = new ArbolAVL<>();
        for (int i = 0; i < 100000; i++) {
            nomb.insertar(per.get(i).getNombre());
        }
        // nomb.inOrden(nomb.getRaizAVL());
    }

    /**
     * inserta el id de cada persona en su respectivo arbol
     */
    public void insertarId() {
        id = new ArbolBinario<>();
        for (int i = 0; i < per.size(); i++) {
            id.insertar(per.get(i).getId());
        }
        //  id.inOrden(id.getRaiz());
    }

    /**
     * inserta los apellidos en su arbol
     */
    public void insertarApellidos() {
        ape = new ArbolAVL<>();
        for (int i = 0; i < 100000; i++) {
            ape.insertar(per.get(i).getPaterno());
        }
        //  ape.inOrden(ape.getRaizAVL());
    }

    /**
     * inserta el correo electronico en el arbol
     */
    public void insertarEmail() {
        email = new ArbolAVL<>();
        for (int i = 0; i < 100000; i++) {
            email.insertar(per.get(i).getEmail());
        }
        // email.inOrden(email.getRaizAVL());
    }

    /**
     * metodo en el cual busca el nombre de la persona que se le pasa como
     * parametro en el cual retornara un true o false
     * @param nombre
     * @return 
     */
    public boolean buscarNombre(String nombre) {
        return nomb.buscar(nomb.getRaizAVL(), nombre);
    }

    /**
     * metodo en el cual busca el apellido de la persona que se le pasa como
     * parametro en el cual retornara un true o false
     * @param apellido
     * @return 
     */
    public boolean buscarApellido(String apellido) {
        return ape.buscar(ape.getRaizAVL(), apellido);
    }

    /**
     * metodo en el cual busca el correo elctronico de la persona que se le pasa
     * como parametro en el cual retornara un true o false
     * @param em
     * @return 
     */
    public boolean buscarEmail(String em) {
        return email.buscar(email.getRaizAVL(), em);

    }

    /**
     * metodo en el cual busca el id de la persona que se le pasa como parametro
     * en el cual retornara un true o false
     * @param idd
     * @return 
     */
    public boolean buscarId(String idd) {

        return id.buscar(id.getRaiz(), idd);

    }

    /**
     * metodo que leera el archivo el archivo
     * @param nombre
     */
    public void leerArchivo(String nombre) {
        String linea = "";
        try {
            FileReader fr = new FileReader(nombre + ".txt");
            BufferedReader br = new BufferedReader(fr);
            linea = br.readLine();
            linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }
}