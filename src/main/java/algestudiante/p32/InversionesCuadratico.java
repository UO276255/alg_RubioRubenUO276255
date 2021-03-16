package algestudiante.p32;

import java.util.List;

public class InversionesCuadratico {
	private List<Integer> ranking;
	
	public InversionesCuadratico(List<Integer> ranking) {
		this.ranking = ranking;
	}

	public String start() {
		int count = 0;
		for (int i=0; i<ranking.size();i++) {
			for(int j=0; j<ranking.size();j++) {
				if(i<j && ranking.get(i)>ranking.get(j)) {
					int value = ranking.get(i);
						ranking.set(i, ranking.get(j));
						ranking.set(j,value);
						count++;
				}				
			}
		}
		return " "+count;
	}

}
