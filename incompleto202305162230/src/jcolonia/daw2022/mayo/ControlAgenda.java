package jcolonia.daw2022.mayo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gestión de números de teléfono.
 * 
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 * @version 2023.3.2_incompleta (20230516)
 */
public class ControlAgenda {
	/**
	 * Texto identificativo de las funciones de la aplicación que aparecerán en el
	 * menú principal.
	 */
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Agregar teléfono", "Mostrar agenda", "Mostrar estado",
			"Restablecer", "SALIR" };

	/** Título de la aplicación. Se mostrará como encabezado del menú principal. */
	private static final String TÍTULO_MENÚ_PRINCIPAL = "Agenda telefónica";

	/** Almacen de números de teléfono. */
	private AgendaTeléfonos agenda;
	/** Marca de que la agenda actual fue importada. */
	private boolean agendaFueImportada;
	/** Marca de que la agenda actual fue exportada. */
	private boolean agendaFueExportada;
	/** Marca de que la agenda actual fue borrada. */
	private boolean agendaFueBorrada;

	/** Vista del menú principal. */
	private VistaMenúBásico menúPrincipal;

	/**
	 * Crea una nueva agenda y quita todas las marcas de estado.
	 * 
	 * @see #agendaFueImportada
	 * @see #agendaFueExportada
	 * @see #agendaFueBorrada
	 */
	public ControlAgenda() {
		agenda = new AgendaTeléfonos();

		agendaFueImportada = false;
		agendaFueExportada = false;
		agendaFueBorrada = false;
	}

	/**
	 * Gestiona el menú principal y ejecuta las operaciones elegidas.
	 */
	private void buclePrincipal(){
		int opciónElegida;
		boolean fin = false;

		menúPrincipal = new VistaMenúBásico(TÍTULO_MENÚ_PRINCIPAL, OPCIONES_MENÚ_PRINCIPAL);

		// Bucle general
		do {
			menúPrincipal.mostrarTítulo1();
			menúPrincipal.mostrarOpciones();
			opciónElegida = menúPrincipal.pedirOpción();
			switch (opciónElegida) {
			case 0:
			case 5: // SALIR
				fin = true;
				Vista.mostrarAviso("¡¡¡A-D-I-O-S!!");
				break;
			case 1: // Opción 1: Entrada datos
				gestionarCargarTeléfono();
				break;
			case 2: // Opción 2: Mostrar listado
				gestionarMostrarAgenda();
				break;
			case 3: // Opción 3: Mostrar estado
				mostrarEstado();
				break;
			case 4: // Opción 4: Reset
				restablecer();
				break;
			default: // Opción no esperada: abortar
				ejecutarGenérico(opciónElegida);
				Vista.mostrarError("Error interno de programa - operación pendiente de desarrollo");
				System.exit(1);
			}
		} while (!fin);
	}

	private void restablecer() {
//		agenda.borrar();
//		if(agenda.tamaño()==0){
//			agendaFueBorrada=true;
//			Vista.mostrarAviso("agendaFueBorrada");
//		}

		agenda=new AgendaTeléfonos();
		agendaFueBorrada=true;
		agendaFueImportada=false;
		agendaFueExportada=false;
	}

	private void mostrarEstado() {
		VistaListadoInfo vista;
		String mensaje;
		vista=new VistaListadoInfo(agenda);
		//vista=new VistListadoInfo("Estado de la agenda");
		//---------------------------------------------
		List<String> listaInformaciones;
		listaInformaciones=new ArrayList<>();
		mensaje = String.format("Hay %d telefonos",agenda.tamaño());
		listaInformaciones.add(mensaje);

		mensaje = String.format("Hay %s ha sido importada",(agendaFueImportada) ? "" : "no ");
		listaInformaciones.add(mensaje);
		
		mensaje = String.format("Hay %s ha sido importada",(agendaFueExportada) ? "" : "no ");
		listaInformaciones.add(mensaje);
		
		mensaje = String.format("Hay %s ha sido importada",(agendaFueBorrada) ? "" : "no ");
		listaInformaciones.add(mensaje);
		//------------//
//		vista.mostrar(listaInformaciones);
//		vista.mostrarEstado(this);
		Vista.pedirContinuar();				
		
		//---------------------------------------------			
		Vista.mostrarTexto("agendaFueImportada");
		Vista.mostrarAviso("agendaFueExportada");
		Vista.mostrarAviso("agendaFueBorrada");
		
	}

	private void gestionarMostrarAgenda() {
		VistaListadoInfo vista;
		String mensaje;
		
		vista=new VistaListadoInfo("Listado telefono", agenda.toListaTextos());
		vista.mostrar();
		
		mensaje=String.format("hay %d telefonos", agenda.tamaño());
		Vista.mostrarAviso(mensaje);
		Vista.pedirContinuar();
		
		
	}

	private void gestionarCargarTeléfono() {
		String preguntarNumero="Introduzca un numero de 9 digitos: ";
		String preguntarNombre="Introduzca un Nombre: ";
		AgendaTeléfonos cargador=new AgendaTeléfonos();
	
		//Silenciado TEMPORALMENTE-Codigo BUENO
		VistaAltaTeléfono vista;
		vista=new VistaAltaTeléfono("Alta Telefono");
		vista.cargarTelefono(agenda);
		
		boolean huboCambios=false;
		huboCambios=vista.cargarTeléfono();
		//3 Linea de POCA importancia
		String mensaje = String.format("%s cambios : ahora hay %d telefonos",
				(huboCambios) ? "Hubo" : "No hubo",  agenda.tamaño());		
//		String mensaje = String.format("Hay %d telefonos",agenda.tamaño());
		
		Vista.mostrarAviso(mensaje);
		Vista.pedirContinuar();
		
		try {
			String nombre;
			int numero;
		
			nombre=Vista.pedirTexto(preguntarNombre);
			numero=Vista.pedirEntero(preguntarNumero,1,999999999);
			cargador.añadir(nombre, numero);
			
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}

	/**
	 * Proporciona al usuario un mensaje informativo sobre la opción elegida.
	 * Operación «comodín» a ejecutar para opciones no implementadas.
	 * 
	 * @param id el número de la opción elegida
	 */
	private void ejecutarGenérico(int id) {
		String mensaje;
		mensaje = String.format("%n  Ha elegido la opción %d: «%s»", id, OPCIONES_MENÚ_PRINCIPAL[id - 1]);
		Vista.mostrarTexto(mensaje);
	}

	/**
	 * Activa el programa con el menú principal.
	 * 
	 * @param argumentos opciones en la línea de ejecución —no se usan—
	 */
	public static void main(String[] argumentos) {
		ControlAgenda control = new ControlAgenda();
		control.buclePrincipal();
	}
}
