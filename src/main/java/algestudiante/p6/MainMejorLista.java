package algestudiante.p6;

public class MainMejorLista {

	public static void main(String[] args) {
		for(int i = 5 ; i < 31 ; i+=5) {			
			int nVeces = Integer.parseInt(args[0]);
			Cancion[] canciones = new Cancion[i];
			
			for(int j = 0; j<canciones.length;j++) {
				canciones[j] = new Cancion("code "+j,(int) Math.random() * (6-2) + 2,(int) Math.random() * (61), (int) Math.random() * (5001-1000) + 1000 );
			}
			
			MejorLista  mj = new MejorLista(canciones, i);
			long t1 = System.currentTimeMillis();
			for(int k = 0; k < nVeces ; k++) {
				mj.backtracking(0);
			}
			
			long t2 = System.currentTimeMillis();	
			
			mj.printTimeForamt();
			System.out.println("Tiempo para n = " + i );
			System.out.println( (float) (t2-t1)/nVeces);
			System.out.println();
		}
	}

}
