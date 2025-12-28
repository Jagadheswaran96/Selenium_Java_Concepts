package selenium_java;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

	public static void main(String[] args) throws Exception {
				
		FileReader fileReader=new FileReader("Writer.json");
		JSONParser jsonParser=new JSONParser();		
		Object object=jsonParser.parse(fileReader);
		JSONObject jsonObject= (JSONObject) object;
		String name=(String) jsonObject.get("name");
		long age=(Long) jsonObject.get("age");
		System.out.println("name is " + name);
		System.out.println("age is " + age);
		JSONArray array=(JSONArray) jsonObject.get("special objects");
		Iterator<?> iterator=array.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
		    String item = (String) obj;
			System.out.println("special obeject is " + item);			
		}
	}

}
