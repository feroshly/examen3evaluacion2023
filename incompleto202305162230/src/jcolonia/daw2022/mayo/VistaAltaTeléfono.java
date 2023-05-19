package jcolonia.daw2022.mayo;

import java.util.List;
import java.util.Vector;

/**
 * Vista usada con {@link AgendaTeléfonos} para la carga de cada pareja de numeros+texto.
 */
public class VistaAltaTeléfono extends Vista{
	List<AgendaTeléfonos> listaContactos;
	AgendaTeléfonos agendaLocal;
	/**
	 * Inicializa el nombre/titulo de la vista.
	 * @param nombre el nombre correspondiente
	 */
	public VistaAltaTeléfono(String nombre) {
		super(nombre);
		listaContactos=new Vector<>();
	}

	public boolean cargarTeléfono(AgendaTeléfonos agenda){
		agendaLocal=agenda;

			
		return false;
	}

}
