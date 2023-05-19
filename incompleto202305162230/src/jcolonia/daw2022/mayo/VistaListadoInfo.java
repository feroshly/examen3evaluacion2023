package jcolonia.daw2022.mayo;

import java.util.List;
import java.util.Vector;


/**
 * Vista para mostrar colecciones de textos, numeradas o no.
 * @author dawm1-08
 *
 */
public class VistaListadoInfo extends Vista{
	List<String> listaInfo;

	/**Inicializa el nombre/titulo de la vista.
	 * @param nombre el nombre correspondiente
	 */
	public VistaListadoInfo(String nombre, List<String> listadoEntrada) {
		super(nombre);
		listaInfo=new Vector<>();
		listaInfo.addAll(listadoEntrada);
	}
//	public VistaListadoInfo(String nombre) {
//		super(nombre);
////		listaInfo=new Vector<>();
////		listaInfo.add(listadoEntrada);
//	}

	/**
	 * Envia a la consola de salida una lista de textos, uno por linea.
	 */
	public void mostrar() {
		int i=0;
	    for (String info : listaInfo) {
	            System.out.printf("%d.- %s%n",++i, info);
	    }
	}
	
//	@Override
//	public String toString(){
//	 String texteado="";
//		for (AgendaTeléfonos info : listaInfo) {
//			texteado=String.format("%|s: %d", info);
//	}
//	return texteado;
//	}
	
}
