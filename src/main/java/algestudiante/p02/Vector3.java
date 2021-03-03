package algestudiante.p02;

public class Vector3 {
	
	static int[] v;
	
public static void main(String[] args) {
	System.out.println("Medicion tiempos de suma elementos vector");
	System.out.println("n\t\t\tt");
	for(int i=1000000 ; i<180000000;i+= 1000000) {
		v = new int[i];
		Vector1.rellena(v);
	
		long t1 = System.currentTimeMillis();
		Vector1.suma(v);
		long t2 = System.currentTimeMillis();
	
		long finalTime = t2-t1;
	
		
		System.out.println(i+"\t\t"+finalTime);
	}
}
}
