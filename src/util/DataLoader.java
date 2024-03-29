package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * Load Binary data back into the objects
 * @author Michael Campos
 *
 */
public class DataLoader {
	/**
	 * Read binary data file back into an object
	 * @param src Filepath to read the object from FileInputStream
	 * @return Object read by ObjectInputStream
	 */
	public static Object readObject(String src) {
		Object o = null;
		try {
			File file = new File(src);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			o = ois.readObject();
			ois.close();
//			System.out.println("Successfully loaded Object from: " + file);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
}
