package algestudiante.p7;

import java.util.Arrays;
import java.util.ArrayList;

import algestudiante.p6.Cancion;
import algestudiante.p7.util.Estado;

public class EstadoMejorListaRP extends Estado {
	private static int tiempoBloque;	// tiempo maximo por bloque
	private Cancion[] canciones;		// array de canciones
	private static boolean traza= true;	// permite activar o desactivar traza
	
	private Cancion[] solParcial;				// lista con las canciones de la solucion parcial
	private boolean[] marcaCanciones;	// Marca las tareas ya asignadas
	
	
	public EstadoMejorListaRP(EstadoMejorListaRP padre, int j) {
		super();
		solParcial = Arrays.copyOf(padre.solParcial,canciones.length);
		profundidad = padre.profundidad;
		idPadre = padre.idPadre;
		//solParcial[profundidad] = j;
		marcaCanciones[j] = true;
		profundidad ++;
		calcularValorHeuristico();
		
		if (profundidad==canciones.length-1)
		{
			int cancionPorAsignar= -1;
			// Busca última tarea por asignar
			for (int k= 0; k<canciones.length; k++)
				if (!marcaCanciones[k])
					cancionPorAsignar= k;
			
			//solParcial[profundidad] = cancionPorAsignar;		// profundidad se corresponde con la primera c sin asignar
			marcaCanciones[cancionPorAsignar]= true;	// marcamos la cancion como asignada
			profundidad++;							
			calcularValorHeuristico();
		}
	}
	
	@Override
	public void calcularValorHeuristico() {
	}

	@Override
	public ArrayList<Estado> expandir() {
		ArrayList<Estado> listaHijos= new ArrayList<Estado>();
		//Recorre todas las canciones
		for (int j=0; j<canciones.length; j++)
			if (!marcaCanciones[j])  // Crea hijo sólo para canciones no metidas
			{
				Estado estadoHijo = new EstadoMejorListaRP(this,j); 
				listaHijos.add(estadoHijo);
				
				if (traza)  // imprimimos estado hijo generado
				{
					System.out.println("Nivel: "+profundidad+" - Hijo: "+j);
					System.out.println(estadoHijo);
				}
			}

		return listaHijos;
	}

	@Override
	public boolean solucion() {
		
		if (profundidad == canciones.length)
			return true;
		else
			return false;
	}

}
