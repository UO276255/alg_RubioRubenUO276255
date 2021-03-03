package DivideVenceras.p32;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InversionesTiempos {
	private static List<Integer> ranking;
	
	public static void main(String args[]) { 
		int numberFiles = 7;
		
		//we don't take times for the first execution since first execution is usually slower than normal
		for (int i = 1; i <= numberFiles; i++) {
			//Check if the path is correct for you
			String fileName = Paths.get("").toAbsolutePath().toString() + "/src/main/java/alg77777777/p32/ranking" + i + ".txt";
			System.out.println("FILE: " + fileName);
			
			ranking = readRankingFromFile(fileName);
	        Inversiones inv1 = new Inversiones(ranking);	
	        long  t1 = System.currentTimeMillis();              
	        System.out.println("Number of inversions = " + inv1.start());                 				
	        long  t2 = System.currentTimeMillis();              
	        if(i>1) System.out.println("The time for the algorithm O(n logn) is: " + (t2-t1) + " milliseconds");
	        
	        //Fork/join Framework
	        ranking = readRankingFromFile(fileName);
	        InversionesCuadratico inv2 = new InversionesCuadratico(ranking);	
	        t1 = System.currentTimeMillis();              
	        System.out.println("Number of inversions = " + inv2.start());                 				
	        t2 = System.currentTimeMillis();              
	        if(i>1)  System.out.println("The time for the algorithm O(n^2) is: " + (t2-t1) + " milliseconds");

	        System.out.println("\n****************************\n");
		}	

	}
	
	public static List<Integer> readRankingFromFile(String file)
	{
		BufferedReader fich = null;
		String line;
		List<Integer> elements = new ArrayList<Integer>();

		try {
			//we open the file
			fich = new BufferedReader(new FileReader(file));
			line = fich.readLine(); //first element of the file
			while (line != null) {
				elements.add(Integer.parseInt(line));
				line = fich.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("There is no file: "+file);
		} catch (IOException e) {
			System.out.println("Error reading the file: "+file);
		} finally {
			if (fich!=null)
				try {
					fich.close();
				} catch (IOException e) {
					System.out.println("Error closing the file: "+file);
					e.printStackTrace();
				}
		}

		return elements;
	}
	
}
