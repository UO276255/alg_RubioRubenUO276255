package algestudiante.p01;

public class MatrizOperacionesTiempos {

	static MatrizOperaciones m;
	public static void main(String[] args) {
		int Nveces = Integer.parseInt(args[0]);
		System.out.println("Medicion tiempos de suma elementos vector");
		System.out.println("n\tt");
		
		for(int i=3 ; i<999999999;i*=2) { 
			
			m = new MatrizOperaciones(i,100,500);
			
			long t1 = System.currentTimeMillis();
			for(int repeticion = 0; repeticion < Nveces; repeticion++) {
				m.sumaDiagonal2();
			}
			long t2 = System.currentTimeMillis();
		
			long finalTime = t2-t1;
			
			System.out.println(i+"\t"+(float)finalTime/Nveces);
		}
	}

	}
