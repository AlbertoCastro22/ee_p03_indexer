/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexador;

/**
 *
 * @author Usersone
 */
public class Persona {

    private String id;
    private String nombre;
    private String paterno;
    private String email;

    /**
     * primer constructor en el cual se le pasan como parametros los datos que
     * se requieren leer en el archivo
     * @param id
     * @param nombre
     * @param paterno
     * @param email
     */
    public Persona(String id, String nombre, String paterno, String email) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.email = email;
    }

    /**
     * segundo constructor en el cual se inicializan las variables
     */
    public Persona() {
        id = "";
        nombre = "";
        paterno = "";
        email = "";
    }

    /**
     *
     * @param nombre
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * setters y guetters de cada variable
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     *
     * @param paterno
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
