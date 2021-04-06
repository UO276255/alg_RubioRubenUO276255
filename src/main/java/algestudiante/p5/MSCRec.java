package algestudiante.p5;

import java.util.Random;

public class MSCRec {
	
	/**
	 * Genera una secuencia aleatoria 
	 * @param n tama�o de la secuencia
	 * @return secuencia aleatoria, una cadena con caracters A, C, G and T.
	 */
	public String genSecuenciaAleatoria(int n){
		char[] dna_elements = {'A', 'C', 'G', 'T'};
		String result = "";
		Random r = new Random();
		for (int i=0; i<n; i++)
			result += dna_elements[r.nextInt(4)];
		return result;
	}
	
	/**
	 * Encuentra un MSC directamente a trav�s de una aproximaci�n recursiva 
	 */
	public String encontrarMSC(String s1, String s2){
		// TODO: encuentra un MSC de dos secuencias directamente (sin usar una tabla) mediante recursion;
		if (s1.length()==0 || s2.length()==0)  // caso base 
			return "";
		else 
		  {
			String ss1 = s1.substring(0, s1.length()-1); // se quita ultimo
		    String ss2 = s2.substring(0, s2.length()-1); // se quita ultimo
		    
		    String l1 = encontrarMSC(ss1, s2);   //llamada rec 1
		    String l2 = encontrarMSC(s1, ss2);   //llamada rec 2
		    String l3 = encontrarMSC(ss1, ss2);  //llamada rec3
		    
		    String c1 = s1.substring(s1.length()-1, s1.length());
		    String c2 = s2.substring(s2.length()-1, s2.length());
		    
		    if (c1.equals(c2))  // se le adjunta el caracter  
		   	 l3=l3.concat(c1);
		    
		    if (l3.length()>=l1.length() && l3.length()>=l2.length()) 
		         return l3;
		    else if (l2.length()>=l1.length())
		    	 return l2;
		    return l1; 
		}
	}
	
	/**
	 * Devuelva el indice de la cadena m�s larga introducida
	 * @param l1 e.g. input L1=MSC(S1�, S2). S1� S1 without its last char
	 * @param l2 e.g. input L1=MSC(S1, S2'). S2' S2 without its last char
	 * @param l3 e.g. input L3=MSC(S1�, S2�) or L3+1 when both current chars are equal
	 * @return �ndice de la cadena m�s larga
	 */
//	private int maxima(String l1, String l2, String l3) {
//		return 0;
//	}
	
}
