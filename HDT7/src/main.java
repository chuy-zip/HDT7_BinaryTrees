import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		System.out.println("Hello , World");
		
		ArrayList<BinarySearchTree<String, String>> Trees = FileReader();;
		
		BinarySearchTree<String, String> EngToSpa = Trees.get(0);
		BinarySearchTree<String, String> SpaToFre = Trees.get(1);
		System.out.println("\n");
		
		System.out.println(EngToSpa.getRoot().getValue().getKey());
		System.out.println(SpaToFre.getRoot().getValue().getKey());
		System.out.println("\n");
		
		String option = "";
		Scanner scan = new Scanner(System.in);
		
		while(!option.equals("4")) {
			System.out.println("Bienvenido que desea hacer:\n" 
							+ "1.Traducir archivo de ingles a espaniol\n"
							+ "2.Traducir archivo de espaniol a frances\n"
							+ "3.Mostrar diccionarios ordenados\n"
							+ "4.Salir");
			option = scan.nextLine();
			
			switch (option) {

			case "1":
				System.out.println(EngToSpa.Search(EngToSpa.getRoot(), "a"));
				System.out.println(EngToSpa.Search(EngToSpa.getRoot(), "DOG"));
				
				
				break;
			
			case "2":
				
				break;

			case "3":
				System.out.println("PALABRA, TRADUCCION A ESPANIOL");
				
				EngToSpa.PrintInOrder(EngToSpa.getRoot());
				
				System.out.println("\n");
				
				System.out.println("PALABRA, TRADUCCION A FRANCES");
				SpaToFre.PrintInOrder(SpaToFre.getRoot());
				
				System.out.println("\n");
				
				break;
				
			case "4":
				System.exit(0);
				break;

			}
			
		}

	}
	
	public static ArrayList<BinarySearchTree<String, String>> FileReader() {
		String MyFile = "src/diccionario.txt";
		String line = ""; 
		
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
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al leer el archivo");
		}
		
		
		ArrayList<BinarySearchTree<String, String>> List = new ArrayList<>();
		List.add(EngToSpa);
		List.add(SpaToFre);
		return List;
		
	}
	
	public static void TextReader() {
		
	}
	
	
}
