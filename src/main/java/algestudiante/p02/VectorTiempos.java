package algestudiante.p02;

public class VectorTiempos {
	
	static int[] v;
	
public static void main(String[] args) {
	int Nveces = Integer.parseInt(args[0]);
	System.out.println("Medicion tiempos de suma elementos vector");
	System.out.println("n\tt");
	int sumatorio = 0;
	for(int i=10 ; i<999999999;i*=3) { 
		
		v = new int[i];
		Vector1.rellena(v);
		//int [] m = new int [2];
		long t1 = System.currentTimeMillis();
		for(int repeticion = 0; repeticion < Nveces; repeticion++) {
			sumatorio = Vector1.suma(v);
		}
		long t2 = System.currentTimeMillis();
	
		long finalTime = t2-t1;	
		System.out.println(i+"\t"+(float)finalTime/Nveces+"\t"+sumatorio);
	}
}
}
