package algestudiante.p7;

import algestudiante.p7.util.RamificaYPoda;

public class MejorListaRP extends RamificaYPoda{
	
	public static void main(String[] args) 
	{
		System.out.println("Problema de Agentes - tareas /// Ramificación y poda");
		
		// Creamos una instancia para resolver el problema
		MejorListaRP mejorListaCanciones = new MejorListaRP(); 

		// Ejecutamos el método que va recorriendo el espacio de soluciones con ramifica y poda
		mejorListaCanciones.ramificaYPoda(mejorListaCanciones.getNodoRaiz()); 
		// Solución final
		System.out.println("Solución óptima del problema $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(mejorListaCanciones.mejorSolucion);

//		if (traza)
//			problemaAsigna.mostrarTrazaSolucion(); 
	}
}
