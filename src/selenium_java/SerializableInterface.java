package selenium_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* Serialization in Java is the process of converting an object into a byte stream to save it to a file, send it over a network, or store it in a database. The object can later be deserialized to recreate the original object.

Steps to Handle Serialization:

Implement the Serializable interface in the class.
Use ObjectOutputStream to write the object to a file.
Use ObjectInputStream to read the object from a file. */

class Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7038948375760731463L;
	private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class SerializableInterface {

	public static void main(String[] args) {
		
Person person = new Person("John", 30);
        
        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

}
