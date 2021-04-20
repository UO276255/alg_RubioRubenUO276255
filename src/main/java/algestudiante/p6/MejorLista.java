package algestudiante.p6;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class MejorLista {
	
	private int tiempoBloque;
	private Cancion[] canciones;
	private boolean[][] marca;
	private int[] tiempoFinal;
	private boolean[][] mejorSolucion;
	private int puntuacionActual;
	private int mejorPuntuacion;

	public MejorLista(String fileName, int minsPerBlock) {
		this.tiempoBloque = minsPerBlock * 60;
		canciones = readFile(fileName);
		marca = new boolean[2][canciones.length];		
		mejorSolucion = new boolean[2][canciones.length];		
		tiempoFinal = new int[canciones.length];

	}

	public MejorLista(Cancion[] canciones, int minsPerBlock) {
		this.tiempoBloque = minsPerBlock * 60;
		this.canciones = canciones;
		marca = new boolean[2][canciones.length];		
		mejorSolucion = new boolean[2][canciones.length];		
		tiempoFinal = new int[canciones.length];
	}

	public void backtracking(int nivel) {
		if(nivel == canciones.length){
			isBetterSolution();
		}
		else {
			for(int i = 0; i<=1; i++) {
				if (i==0) {
					backtracking(nivel +1);
				}
				else {
					for(int j = 0; j <= marca.length-1; j++) {
						if(tiempoFinal[j] + canciones[nivel].getTime() <= tiempoBloque) {
							marca[j][nivel] = true;
							tiempoFinal[j] += canciones[nivel].getTime();
							
							puntuacionActual += canciones[nivel].getPuntuacion();
							backtracking(nivel +1);
							puntuacionActual -= canciones[nivel].getPuntuacion();
							marca[j][nivel] = false;
							tiempoFinal[j] -= canciones[nivel].getTime();
						}
					}
				}
			}
		}
	}

	
	public void imprimirResultado() {
		for(int i = 0; i < marca.length; i++) {
			System.out.println("Bloque " + (i+1));
			for(int j = 0; j < marca[i].length; j++) {
				if(mejorSolucion[i][j]) {
					System.out.println(canciones[j].getTime() + "	" +  canciones[j].getCode());
				}
			}
		}
	}
	
	public void printTimeForamt() {
		double countTiempo =  0 ;
		for(int i = 0; i < marca.length; i++) {
			for(int j = 0; j < marca[i].length; j++) {
				if(mejorSolucion[i][j]) {
					countTiempo += (canciones[j].getTime());
				}
			}
		}
		
		System.out.println("n canciones de " + tiempoTotalMinutos() + " segundos");
		System.out.println(countTiempo + " segundos");
		System.out.println("Dos bloques de " + countTiempo / 2 + " segundos");
		System.out.println();
	}

	public int tiempoTotalMinutos() {
		int tiempoTodasCanciones = 0;
		for(int i = 0; i < canciones.length; i++) {
			tiempoTodasCanciones += (canciones[i].getTime());
		} 
		
		return tiempoTodasCanciones;
	}

	
	private boolean isBetterSolution() {
		if(puntuacionActual > mejorPuntuacion) {
			for(int i = 0; i < mejorSolucion.length; i++) {
				for(int j = 0; j< mejorSolucion[i].length; j++) {
					mejorSolucion[i][j] = marca[i][j];
				}
			}
			mejorPuntuacion = puntuacionActual;
			return true;
		}
		
		return false;
		
		
	}

	private Cancion[] readFile(String fileName) {

		List<Cancion> fileData = new ArrayList<Cancion>();

		try {
			fileData = SongParser.parser(FileUtil.readLines(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cancion[] songs = new Cancion[fileData.size()];

		int counter = 0;
		for (Cancion song : fileData) {
			songs[counter++] = song;
		}

		return songs;
	}

}
