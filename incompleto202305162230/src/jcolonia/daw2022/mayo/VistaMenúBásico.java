package jcolonia.daw2022.mayo;

import java.util.Scanner;
import java.util.Vector;


/**
 * Proporciona funcionalidades (como un menu) para que el usuario interactue con la aplicacion.
 * @author dawm1-08
 *
 */
public class VistaMenúBásico extends Vista{
	Vector<String> listaOpcionesMenu;
	String nombre;
	String[] listaNombres;
	Scanner scEntrada;
	
	
	public VistaMenúBásico(String nombre, Scanner scEntrada) throws VistaException {
		super(nombre, scEntrada);
		//listaOpcionesMenu=new Vector<>();
		this.nombre=nombre;
		this.scEntrada=scEntrada;		
	}


	public <T> VistaMenúBásico(String títuloMenúPrincipal, T[] opcionesMenúPrincipal) {
		super(títuloMenúPrincipal);
		listaOpcionesMenu=new Vector<>();
		for(T opciones:opcionesMenúPrincipal){
			listaOpcionesMenu.add(opciones.toString());
		}
	}

	/**
	 * Muestra las lista de opciones del menu por pantalla.
	 */
	public void mostrarOpciones() {		
		int i =0;
		for(String linea: listaOpcionesMenu){
			System.out.printf("[%d] %s%n",++i,linea);
		}
		System.out.println("[0] Salir");
	}


	/**
	 * Pide al usuario que seleccione una opcion del menu intoduciendo un numero por consola.
	 * @return numOpcion El numero de la opcion seleccionada
	 * @throws VistaException La excepcion adecuada
	 */
	public int pedirOpción() throws VistaException{
		int numOpcion=0;

			int max=9;
			int min=9;
			numOpcion=pedirEntero("Introduzca la opcion deseada", max, min);
			//numOpcion=pedirEntero("Introduzca la opcion deseada");

		return numOpcion;
	}
	
//	/**
//	 * Inicializa los elementos de cualquier tipo que le dan y los usa 
//	 * para conformar con ellos un menu flexible de proposito general .
//	 * @param <T> el tipo correspondiente
//	 * @param listaOpciones las opciones del menu
//	 */
//	public <T> VistaMenúBásico(T[] listaOpciones) {
//		super(nombre, scEntrada);
//		listaOpcionesMenu=new Vector<>();
//		for(T opciones:listaOpciones){
//			listaOpcionesMenu.add(opciones.toString());
//		}
//	}


}
