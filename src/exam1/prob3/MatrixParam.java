package exam1.prob3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixParam {
	
	public static void main(String[] args) {
		// categories=Laptop,Tablet;brands=Google,Dell
		try (BufferedReader inFile = 
				new BufferedReader(new FileReader("param/matrix.txt"))) {
			String paramStr = inFile.readLine();
			MatrixParam matrixParam = new MatrixParam();
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
		String[] rows = params.split("[ ]*;[ ]*");
		for (String row : rows) {
			String key = row.substring(0, row.indexOf("="));
			String valueStr = row.substring(row.indexOf("=")+1);
			String[] values = valueStr.split("[ ]*,[ ]*");
			List<String> valueList = Arrays.asList(values);
			paramMap.put(key, valueList);
		}
		return paramMap;
	}
}
