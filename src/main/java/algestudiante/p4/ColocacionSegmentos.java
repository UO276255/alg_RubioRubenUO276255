package algestudiante.p4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ColocacionSegmentos {

	public static List<Integer> game;
	
	public static void main(String[] args) {
		ColocacionSegmentos sm = new ColocacionSegmentos();
		sm.reedGameFile(1);
		System.out.println("Devorador1: "+sm.Devorador1(sm.game)+" pufosos");
		System.out.println("Devorador2: "+sm.Devorador2(sm.game)+" pufosos");
		System.out.println("Devorador3: "+sm.Devorador3(sm.game)+" pufosos");
	}
	
	public double Devorador1(List<Integer> game) {
		int value1 = 0;
		int value2 = 0;
		double count = 0;
		for(int i=1; i<game.size();i++) {
			if(i == 1) {				
				value1 = 0;
				value2 = game.get(i);
				count+= (double)(value1+value2)/2;
			} else {
				value1 = value2;
				value2 = value1+game.get(i);
				count+= (double)(value1+value2)/2;
			}
			
		}
		return count;
	}
	
	public double Devorador2(List<Integer> game) {
		order();
		int value1 = 0;
		int value2 = 0;
		double count = 0;
		for(int i=1; i<game.size();i++) {
			if(i == 1) {				
				value1 = 0;
				value2 = game.get(i);
				count+= (double)(value1+value2)/2;
			} else {
				value1 = value2;
				value2 = value1+game.get(i);
				count+= (double)(value1+value2)/2;
			}
			
		}
		return count;
		
	}
	
	public double Devorador3(List<Integer> game) {
		InverseOrder();
		int value1 = 0;
		int value2 = 0;
		double count = 0;
		for(int i=1; i<game.size();i++) {
			if(i == 1) {				
				value1 = 0;
				value2 = game.get(i);
				count+= (double)(value1+value2)/2;
			} else {
				value1 = value2;
				value2 = value1+game.get(i);
				count+= (double)(value1+value2)/2;
			}
			
		}
		return count;
		
	}
		
	
	public void reedGameFile(int numberFile) {
		String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/algestudiante/p4/juego"+numberFile+".txt";	
		game = readGameFromFile(fileName);
	}
	
	public static List<Integer> readGameFromFile(String file)
	{
		BufferedReader fich = null;
		String line;
		List<Integer> elements = new ArrayList<Integer>();

		try {
			// abrimos el fichero
			fich = new BufferedReader(new FileReader(file));
			line = fich.readLine(); // Primer elemento del fichero
			while (line != null) {
				elements.add(Integer.parseInt(line));
				line = fich.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero: "+file);
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero: "+file);
		} finally {
			if (fich!=null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error cerrando el fichero: "+file);
					e.printStackTrace();
				}
		}
		
		return elements;
	
	}
	
	private static void order() {
		for(int i=1; i<game.size();i++) {
			for(int j=1; j<game.size()-1;j++) {
				if(game.get(j) < game.get(j+1)) {
					int x = game.get(j);
					game.set(j,game.get(j+1));
					game.set(j+1,x);
				}
			}
		}			
		
	}
	
	private static void InverseOrder() {
		for(int i=1; i<game.size();i++) {
			for(int j=game.size()-1; j>1;j--) {
				if(game.get(j-1) > game.get(j)) {
					int x = game.get(j);
					game.set(j,game.get(j-1));
					game.set(j-1,x);
				}
			}
		}			
	}
	
}
