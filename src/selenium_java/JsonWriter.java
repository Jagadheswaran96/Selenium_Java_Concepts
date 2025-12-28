package selenium_java;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriter {

	public static void main(String[] args) throws IOException {
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "jagadhes");
		jsonObject.put("age", 20);		
		JSONArray array=new JSONArray();
		array.add("magic");
		array.add("magnetic");		
		jsonObject.put("special objects", array);		
		FileWriter fileWriter=new FileWriter("Writer.json");
		fileWriter.write(jsonObject.toString());
		fileWriter.close();
	}

}
