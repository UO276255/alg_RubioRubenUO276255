package algestudiante.p4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TiemposColocacionSegmentos {

	public static void main(String[] args) {
		ColocacionSegmentos sm = new ColocacionSegmentos();
		int nVeces= Integer.parseInt (args [0]);
		for(int i= 100; i<12801;i*=2) {
			List<Integer> testGame = new ArrayList<Integer>();
			testGame.add(i);
			for(int j=0; j<i;j++) {
				Random rm = new Random();
				testGame.add(rm.nextInt(99)+1);
			}
		
			long t1 = System.currentTimeMillis(); ;
		
			for (int repeticiones=1; repeticiones<=nVeces;repeticiones++){
				double p = sm.Devorador1(testGame); 
				//double p = sm.Devorador2(testGame); 
				//double p = sm.Devorador3(testGame);  
			}
		
			long t2 = System.currentTimeMillis();
			System.out.println ("Tiempo = "+(float)(t2-t1)/nVeces+" nVeces = "+nVeces);
		}
	}
}
