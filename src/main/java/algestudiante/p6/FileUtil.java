package algestudiante.p6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readLines(String inFileName) throws FileNotFoundException {

		List<String> res = new ArrayList<String>();

		BufferedReader reader = new BufferedReader(new FileReader(inFileName));

		try {
			try {
				while (reader.ready()) {
					res.add(reader.readLine());
				}
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return res;
	}
	
}
