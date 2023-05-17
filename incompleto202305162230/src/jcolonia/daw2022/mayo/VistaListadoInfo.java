package jcolonia.daw2022.mayo;

import java.util.Vector;


public class VistaListadoInfo {
	Vector<AgendaTeléfonos> listaInfo;
	
	public VistaListadoInfo(AgendaTeléfonos listadoEntrada) {
		listaInfo=new Vector<>();
		listaInfo.add(listadoEntrada);
	}

	public void mostrar() {
	    for (AgendaTeléfonos info : listaInfo) {
	            System.out.println(info);
	    }
		
	}

	
}
