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
		
		BinarySearchTree<String, String> EngToSpa= new BinarySearchTree<>();
		BinarySearchTree<String, String> SpaToFre= new BinarySearchTree<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((line = reader.readLine())!=null) {
				String[] splitLine = line.split(","); 
				System.out.println(splitLine[0] + " " + splitLine[1] + " " + splitLine[2]);
				
				Association<String, String> Value1 = new Association<String, String>(splitLine[0], splitLine[1]);
				Association<String, String> Value2 = new Association<String, String>(splitLine[1], splitLine[2]);
				
				if(EngToSpa.getRoot() == null) {
					EngToSpa.InsertRoot(Value1);
					System.out.println("Agregado a engspa: " + Value1.getKey() + " " + Value1.getValue());
				}
				
				else if(EngToSpa.getRoot() != null) {
					EngToSpa.Insert(EngToSpa.getRoot(), Value1);
					System.out.println("Agregado a engspa rama:" + Value1.getKey() + " " + Value1.getValue());
				}
				
				if(SpaToFre.getRoot() == null) {
					SpaToFre.InsertRoot(Value2);
					System.out.println("Agregado a SpaFran: " + Value2.getKey() + " " + Value2.getValue());
					
				}
				
				else if(SpaToFre.getRoot() != null) {
					SpaToFre.Insert(SpaToFre.getRoot(), Value2);
					System.out.println("Agregado a SpaFran rama: " + Value2.getKey() + " " + Value2.getValue());
					
				}

			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al leer el archivo");
		}
		
	}
	
	
}
