package algestudiante.p3;

/**
	Clase que modeliza T(n)= T(n-1) + O(n)
	La complejidad temporal es cuadr�tica O(n^2)
	y el gasto de pila es Mpila=O(n)
	En consecuencia la pila se desborda 
 */
public class Sustraccion2
{

	static long cont;

	public static boolean rec2 (int n)
	{
		if (n<=0) 
			cont++;
		else 
		{ 
			for (int i=0;i<n;i++) cont++; // O(n)
			rec2 (n-1);
			for (int i=0;i<n;i++) cont++; // O(n)
		}
		return true;   
	}

	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		int nVeces= Integer.parseInt (arg [0]);
		boolean b=true;
		for (int n=100;n<=100000;n*=2)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec2 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (b+" n="+n+ "**TIEMPO="+(float)(t2-t1)/nVeces+"**nVeces="+nVeces);
		}  // for
	} // main
} //class