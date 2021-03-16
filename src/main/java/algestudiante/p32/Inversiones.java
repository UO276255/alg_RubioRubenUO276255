package algestudiante.p32;

import java.util.ArrayList;
import java.util.List;

public class Inversiones {
	public List<Integer> ranking;

	public Inversiones(List<Integer> ranking) {
		this.ranking = ranking;
	}

	public String start() {
		Mergesort(ranking,0,ranking.size()-1);
		   return "Logaritmica";
	}

	public static void Mergesort(List<Integer> ranking,int izq, int der){
	    if (izq < der){
	            int m=(izq+der)/2;
	            Mergesort(ranking,izq,m);
	            Mergesort(ranking,m+1, der);                                                                                
	            merge(ranking,izq, m, der);                                                                                 
	    }
	}
	
	public static void merge(List<Integer> A,int izq, int m, int der){
		   int i, j, k;
		   List<Integer> B = new ArrayList<Integer>(A); //array auxiliar

		   i=izq; j=m+1; k=izq;
		     
		   while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
		          if (B.get(i)<=B.get(j))
		              A.set(k++,B.get(i++));
		          else
		        	  A.set(k++,B.get(j++));
		        
		   while (i<=m)         //copia los elementos que quedan de la
			   A.set(k++,B.get(i++)); //primera mitad (si los hay)
		}
}
