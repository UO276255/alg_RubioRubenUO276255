package algestudiante.p5;

public class MscTiempos {
	
	static String mode =  "DV";   
	static int nTimes = 500;
	
	public static void main(String args[]) {
		long t1 = 0;
		long t2 = 0;
		float total = 0;
		
		System.out.println("MODO: " + mode);
		
		if (mode.equals("progdin")) {
			MSC msc;	
			for (int n=100; n<=12800; n*=2) { 
				msc = new MSC(n);
				msc.iniTabla();
			    msc.rellenaTabla();
				t1 = System.currentTimeMillis();
				for(int i = 0; i< nTimes;i++) {
					msc.encontarMSC(false);
				}  
			    t2 = System.currentTimeMillis();
			    total= (float) (t2 - t1);
				
				System.out.println("Tiempo [ms]= " + (float)total/nTimes + ", n=" + n);
			}
		}
		else {            
			MSCRec lcs_rec;
			String str1, str2;
			for (int n=2; n<=12800; n*=2) { 
				lcs_rec = new MSCRec();
				str1 = lcs_rec.genSecuenciaAleatoria(n);
				str2 = lcs_rec.genSecuenciaAleatoria(n);
				t1 = System.currentTimeMillis();
				for(int i = 0; i< nTimes;i++) {
					lcs_rec.encontrarMSC(str1, str2);
				}
			    t2 = System.currentTimeMillis();
			    total= (float) (t2 - t1);

			    System.out.println("Tiempo [ms]= " + (float)total/nTimes + ", n=" + n);
			}
		}
		
	}

}
