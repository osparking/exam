package exam1.prob3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Somebody {
	
	public static void main(String[] args) {
		// categories=Laptop,Tablet;brands=Google,Dell
		try (BufferedReader inFile = 
				new BufferedReader(new FileReader("param/matrix.txt"))) {
			String paramStr = inFile.readLine();
			Somebody matrixParam = new Somebody();
			Map<String, List<String>> params = 
					matrixParam.stringToMap(paramStr); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Map<String, List<String>> stringToMap(String params) {
		Map<String, List<String>> paramMap = new HashMap<>();
		String[] split = params.split(";");
		for (int i = 0; i <split.length; i++) {
			String a = split[i];
			String[] temp = a.split("=");
			List<String> list = new ArrayList<>();
			list.add(temp[1]);
			paramMap.put(temp[0], list);
		}
		return paramMap;
	}
}
