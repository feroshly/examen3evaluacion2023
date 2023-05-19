package jcolonia.daw2022.mayo;

//COPIADO DE DIEGO------------------------------COPIADO DE DIEGO
public class VistaEstado {
	/**Se ha borrado dos posiboles valores S/N*/
	private boolean agendaFueBorrada;
	/**Se ha exportado dos posiboles valores S/N*/
	private boolean agendaFueExportada;
	/**Se ha importado dos posiboles valores S/N*/
	private boolean agendaFueImportada;
	/**Agenda con los telefonos*/
	private AgendaTeléfonos agenda;
	
	public VistaEstado(boolean agendaFueBorrada, boolean agendaFueExportada, boolean agendaFueImportada, AgendaTeléfonos agenda) {
		this.agendaFueBorrada = agendaFueBorrada;
		this.agendaFueExportada = agendaFueExportada;
		this.agendaFueImportada = agendaFueImportada;
		this.agenda = agenda;
	}
	
	public void mostrarEstado() {
		
		System.out.printf("Se ha borrado la agenda: %s.%nSe ha exportado la agena: %s.%n Se ha importado la agenda: %s.%n"
				+ "Tiene %d elementos la lista", agendaFueBorrada, agendaFueExportada, agendaFueImportada, agenda.tamaño());
	}

//COPIADO DE DIEGO------------------------------COPIADO DE DIEGO
}
