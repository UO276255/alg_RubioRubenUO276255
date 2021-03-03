package algestudiante.p01;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase para las operaciones de una matriz
 * @author ruben
 *
 */
public class MatrizOperaciones {

	public int[][] matriz;
	public int tam;
	public int max;
	public int min;
	
	/**
	 *  Crea una matriz de tama�o nxn y
	 *  la rellena con valores aleatorios, estos valores aleatorios deben de ser parametrizables
	 *  entre un m�ximo (max) y un m�nimo (min).
	 * @param n tama�o de la matriz
	 * @param min valor minimo de ella 
	 * @param max valor maximo de ella 
	 */
	public MatrizOperaciones(int n, int min, int max) {
		tam = n;
		matriz = new int[tam][tam];
		this.max = max;
		this.min = min;
		rellenarMatriz(min,max);
	}
	
	/**
	 * Crea una matriz a partir de los datos del fichero
	 * @param nomFich nombre del fichero
	 */
	public MatrizOperaciones(String nomFich){
		
		    String linea;
		    String[] lineaMatriz;
		    int row = 0;	    
		    try {
		    	   BufferedReader fichero = new BufferedReader(new FileReader(nomFich));
		    		linea = fichero.readLine();
		    		tam= Integer.parseInt(linea);
		    		this.matriz = new int[tam][tam]; 
		    		while (fichero.ready()) {
			    	  	linea = fichero.readLine();
		    			lineaMatriz = linea.split("\t");
		    			for(int i=0;i<tam;i++) {
		    				this.matriz[row][i] = Integer.parseInt(lineaMatriz[i]);
		    			}
		    			row++;
		    			
		    		}
		    		fichero.close();
		    }
		    catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha encontrado.");
		    }
		    catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida.");
		    } 
		  }

	/**
	 * M�todo privado que rellena la matriz aleatoriamente 
	 * en funcion del maximo o del minimo establecido
	 * @param min valor minimo
	 * @param max valor maximo
	 */
	private void rellenarMatriz(int min, int max) {
		int numero =  (int) (Math.random()* (max-min) + min);
		for(int i=0; i<tam;i++) {
			for(int j=0; j<tam;j++) {
				matriz[i][j] = numero;
				numero =  (int) (Math.random()* (max-min) + min+1);
			}
		}		
	}
	
	/**
	 * M�todo que imprime por pantalla la matriz correspondiente
	 */
	public void escribir() {
		for(int i=0; i<tam;i++) {
			System.out.println();
			for(int j=0; j<tam;j++) {
				System.out.print(""+matriz[i][j]+ "	");
			}
		}	
	}
	
	/**
	 * M�todo que devuelve el tama�o de la matriz
	 * @return tama�o de la matriz
	 */
	public int getTam() {
		return this.tam;
	}
	
	/**
	 * Calcula de forma iterativa la suma de la diagonal. Forma 1:
	 * recorrer toda la matriz, pero s�lo sumando los elementos de la diagonal
	 * @return valor de la diagonal
	 */
	public int sumaDiagonal2() {
		int resultado = 0;
		for(int i=0; i<tam;i++) {
			resultado = resultado + matriz[i][i];
		}
		return resultado;
	}
	
	/**
	 * Calcula de forma iterativa la suma de la diagonal. Forma 2:
	 * recorrer los elementos de la diagonal sum�ndolos
	 * @return valor de la diagonal
	 */
	public int sumaDiagonal1() {
		int resultado = 0;
		for(int i=0; i<tam;i++) {
			for(int j=0; j<tam;j++) {
				if(i == j) {
					resultado = resultado + matriz[i][j];
				}
			}
		}
		return resultado;
	}
	
	/**
	 *  M�todo que crea un camino en la matriz utilizando los valores 
	 *  como c�digos de direcci�n: 1 - arriba, 2 - derecha, 3 - abajo, 4 � izquierda. 
	 *  Se va marcando con el valor -1	El proceso finalizar� cuando el camino salga de los
	 *   l�mites de la matriz o bien alcance una casilla ya recorrida
	 * @param i fila desde la que se empieza
	 * @param j columna desde la que se empieza
	 */
	public void recorrerCamino(int i,int j) {
			int row = i;
			int column = j;
			if(inLimints(row,column) && matriz[row][column] != -1) {
				switch (matriz[row][column]) {
				case 1:
						matriz[row][column] = -1;
						row--;
						break;
				case 2:
						matriz[row][column] = -1;
						column++;
						break;
				case 3:
						matriz[row][column] = -1;
						row++;
						break;
				case 4:
						matriz[row][column] = -1;
						column--;
						break;
				}
				recorrerCamino(row, column);
			}
			
		}

	private boolean inLimints(int row, int column) {
		if(row < tam && row >= 0) {
			if(column < tam && column >= 0) {
				return true;
			}
		}
		return false;
	}
}
