/**
 * DEBDIO A QUE CUANDO PASABAMOS EL ARCHIVO Y DATOS, ASI COMO LOS ARBOLES A LA
 * INTERZAS NOS GENERABA MUCHOS ERRORES AL MOMENTO DE COMPILAR DECIDIOS HACER
 * ESTE PEQUENIO MENU 
 */
package indexador;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Usersone
 */
public class PruebaIndexador {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Archivo in = new Archivo();
        int opcion = -1, opcion2 = -1;
        Date inicio = Calendar.getInstance().getTime();
        String strMenu, menudos;

        do {
            strMenu = JOptionPane.showInputDialog("Bienvenido\n Menú:  \n1.- ingrese el nombre del archivo \n2.-Buscar por tipo de dato  \n3.-Salir", 3);
            opcion = Integer.parseInt(strMenu);
            switch (opcion) {
                case 1:
                    /**
                     * este primer cae es para ingresar el nombre del archivo,
                     * poder leerlo y poder guardar los datos. Tambien imprime
                     * cuanto tiempo se tarda en leer el archivo
                     */
                    in.leerArchivo(JOptionPane.showInputDialog("ingrese el nombre del archivo sin la extension .txt"));
                    in.guardarDatos("datos");
                    Date fin = Calendar.getInstance().getTime();
                    System.out.println("Tiempo de ejecucion: ");
                    System.out.println(new Date(fin.getTime() - inicio.getTime()));
                    break;

                case 2:
                    do {
                        menudos = JOptionPane.showInputDialog("Bienvenido\n Menú:  \n1.- Buscar por id \n2.- Buscar por nombre \n3.- Buscar por apellido \n4.- Buscar por correo electronico\n5.-Salir", 5);
                        opcion2 = Integer.parseInt(menudos);
                        switch (opcion2) {
                            case 1:
                                /**
                                 * en este primer case del submenu es para
                                 * insertar los id de cada persona al arbol y
                                 * poderlo buscar, en el cual si se encuentra el
                                 * dato retornara un true y si no un false, asi
                                 * mismo imprime el tiempo de ejecucion
                                 */
                                in.insertarId();
                                System.out.println(in.buscarId("[" + JOptionPane.showInputDialog("Ingrese el id a buscar")) + " ]");
                                Date fin2 = Calendar.getInstance().getTime();
                                System.out.println("Tiempo de ejecucion: ");
                                System.out.println(new Date(fin2.getTime() - inicio.getTime()));
                                break;
                            case 2:
                                /**
                                 * en este segundo case del submenu es para
                                 * insertar los nombres de cada persona al arbol
                                 * y poderlo buscar, en el cual si se encuentra
                                 * el dato retornara un true y si no un false,
                                 * asi mismo imprime el tiempo de ejecucion
                                 */
                                in.insertarNombresArbol();
                                System.out.println("[ " + in.buscarNombre(JOptionPane.showInputDialog("Ingrese el nombre a buscar")) + " ]");
                                Date fin3 = Calendar.getInstance().getTime();
                                System.out.println("Tiempo de ejecucion: ");
                                System.out.println(new Date(fin3.getTime() - inicio.getTime()));
                                break;
                            case 3:
                                /**
                                 * en este primer case del submenu es para
                                 * insertar los apellidos de cada persona al
                                 * arbol y poderlo buscar, en el cual si se
                                 * encuentra el dato retornara un true y si no
                                 * un false, asi mismo imprime el tiempo de
                                 * ejecucion
                                 */
                                in.insertarApellidos();
                                System.out.println("[ " + in.buscarApellido(JOptionPane.showInputDialog("Ingrese el apellido a buscar")) + " ]");
                                Date fin4 = Calendar.getInstance().getTime();
                                System.out.println("Tiempo de ejecucion: ");
                                System.out.println(new Date(fin4.getTime() - inicio.getTime()));
                                break;
                            case 4:
                                /**
                                 * en este primer case del submenu es para
                                 * insertar los correos electronicos de cada
                                 * persona al arbol y poderlo buscar, en el cual
                                 * si se encuentra el dato retornara un true y
                                 * si no un false, asi mismo imprime el tiempo
                                 * de ejecucion
                                 */
                                in.insertarEmail();
                                System.out.println("[ " + in.buscarEmail(JOptionPane.showInputDialog("Ingrese el correo electronico a buscar")) + " ]");
                                Date fin5 = Calendar.getInstance().getTime();
                                System.out.println("Tiempo de ejecucion: ");
                                System.out.println(new Date(fin5.getTime() - inicio.getTime()));
                                break;
                        }
                    } while (opcion2 != 5);
                    break;
            }
        } while (opcion != 3);

    }
}
