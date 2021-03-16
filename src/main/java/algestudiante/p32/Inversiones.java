package algestudiante.p32;

import java.util.ArrayList;
import java.util.List;

public class Inversiones {
	public List<Integer> ranking;
	public static int count = 0;

	public Inversiones(List<Integer> ranking) {
		this.ranking = ranking;
	}

	public String start() {
		Mergesort(ranking,0,ranking.size()-1);
		   return " "+ count;
	}

	public static void Mergesort(List<Integer> ranking,int izq, int der){
	    if (izq < der){
	            int m=(izq+der)/2;
	            Mergesort(ranking,izq,m);
	            Mergesort(ranking,m+1, der);                                                                                
	            sort(ranking,izq, m, der);
	            count = count +1;
	    }
	}
	
	public static void sort(List<Integer> A,int izq, int m, int der){
		   int i, j, k;
		   List<Integer> B = new ArrayList<Integer>(A);
		   i=izq; j=m+1; k=izq;     
		   while (i<=m && j<=der)                                  
		          if (B.get(i)<=B.get(j))
		              A.set(k++,B.get(i++));
		          else
		        	  A.set(k++,B.get(j++));	        
		   while (i<=m)        
			   A.set(k++,B.get(i++));
		}
}
