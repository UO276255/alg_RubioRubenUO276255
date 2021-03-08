package algestudiante.p3;
/**
	Es un m�todo recursivo POR SUSTRACCION
	T(n)= 2 T(n-1) + O(1)
	Los par�metros son: a=3; b=2; k=0
	Luego la complejidad temporal es exponencial O(3^(n/2))
	y la complejidad MPILA es O(n), pero no se desborda
	porque mucho antes el tiempo de ejecuci�n se hace 
	intratable
*/
public class Sustraccion4 {
	

	static long cont;
	
	public static boolean rec4 (int n)
	{
		if (n<=0) 
			cont++;
		else
		{
			cont++;   // O(1)    
			rec4 (n-2);
			rec4 (n-2);
			rec4 (n-2);
		}
		return true;   
	}
	
	@SuppressWarnings("unused")
	public static void main (String arg []) 
	{
		long t1,t2,cont;
		int nVeces= Integer.parseInt (arg [0]);
		boolean b=true; 
		for (int n=5;n<=100;n++)
		{
			t1 = System.currentTimeMillis ();

			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
			{ 
				cont=0;
				b=rec4 (n);
			} 

			t2 = System.currentTimeMillis ();

			System.out.println (b+" n="+n+ "**TIEMPO="+(float)(t2-t1)/nVeces+"**nVeces="+nVeces);
		}
	}
}
