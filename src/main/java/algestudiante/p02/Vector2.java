package algestudiante.p02;

public class Vector2 {
		static int[] v;
	
	public static void main(String[] args) {
		int n = 180000000;
		v = new int[n];
		Vector1.rellena(v);
		
		long t1 = System.currentTimeMillis();
		Vector1.suma(v);
		long t2 = System.currentTimeMillis();
		
		long finalTime = t2-t1;
		
		System.out.println("\n Tiempo del método: " + finalTime);
	}
	

}
