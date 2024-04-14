package practice;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

	public static void main(String[] args) throws Exception {
		
		JSONParser jsonParser=new JSONParser();
		
		FileReader fileReader=new FileReader("Writer.json");
		
		Object object=jsonParser.parse(fileReader);
		
		JSONObject jsonObject= (JSONObject) object;
		String name=(String) jsonObject.get("name");
		long age=(Long) jsonObject.get("age");
		JSONArray array=(JSONArray) jsonObject.get("special objects");
		
		Iterator iterator=array.iterator();
		System.out.println("name is " + name);
		System.out.println("age is " + age);
		while (iterator.hasNext()) {
			System.out.println("special obeject is " + iterator.next());
			
		}
	}

}
