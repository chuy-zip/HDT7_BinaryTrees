import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class main {
	
	public static void main(String[] args) {
		System.out.println("Hello , World");
		FileReader();
		
		

	}
	
	public static void FileReader() {
		String MyFile = "src/diccionario.txt";
		String line = ""; 
		ArrayList<String> Test = new ArrayList(); 
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((line = reader.readLine())!=null) {
				String[] splitLine = line.split(","); 
				
				System.out.println(splitLine[0] + " " + splitLine[1] + " " + splitLine[2]);


			}
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}
		
	}
	
	
}
