package algestudiante.p6;

import java.util.ArrayList;
import java.util.List;

public class SongParser {
	
	private static final String SEPARATOR = "\t";
	private static final String SEPARATOR_TIME = ":";

	public static List<Cancion> parser(List<String> lines){
		
		List<Cancion> songs = new ArrayList<Cancion>();
		
		int counter = 0;
		for (String line : lines) {
			if(counter != 0) {
				songs.add(parseLine(line));
			}
			counter ++;
		}
		
		return songs;
	}
	
	private static Cancion parseLine(String line) {
		String[] parts  = line.split(SEPARATOR);
		
		String[] time = parts[1].split(SEPARATOR_TIME);
		
		return new Cancion(parts[0], Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(parts[2]));
	}
	
}
