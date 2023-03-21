import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		ArrayList<BinarySearchTree<String, String>> Trees = FileReader();;
		String[] TextToTranslate = readTxtFileToList();
		Translator<String, String> translator = new Translator<>();
		
		BinarySearchTree<String, String> EngToSpa = Trees.get(0);
		BinarySearchTree<String, String> SpaToFre = Trees.get(1);
		System.out.println("\n");
		
		String option = "";
		Scanner scan = new Scanner(System.in);
		
		while(!option.equals("5")) {
			System.out.println("Bienvenido que desea hacer:\n" 
							+ "1.Traducir archivo de ingles a espaniol\n"
							+ "2.Traducir archivo de espaniol a frances\n"
							+ "3.Mostrar diccionarios ordenados\n"
							+ "4.Mostrar el texto presente en el archivo\n"
							+ "5.Salir");
			option = scan.nextLine();
			
			switch (option) {

			case "1":
				System.out.println(translator.Translate(EngToSpa, TextToTranslate));
				System.out.println("\n");
				
				break;
			
			case "2":
				System.out.println(translator.Translate(SpaToFre, TextToTranslate));
				System.out.println("\n");
				
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
				
				String Text = "";
				
				for (int i = 0; i < TextToTranslate.length; i++) {
					Text += TextToTranslate[i] + " ";
					
				}
				System.out.println("Texto a troducir:");
				System.out.println(Text);
				System.out.println("\n");
				
				break;
				
			case "5":
				System.exit(0);
				break;

			}
			
		}

	}
	
	public static ArrayList<BinarySearchTree<String, String>> FileReader() {
		String MyFile = "src/diccionario.txt";
		String line = ""; 
		
		BinarySearchTree<String, String> EngToSpa = new BinarySearchTree<>();
		BinarySearchTree<String, String> SpaToFre = new BinarySearchTree<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((line = reader.readLine())!=null) {
				String[] splitLine = line.split(","); 
				
				Association<String, String> Value1 = new Association<String, String>(splitLine[0], splitLine[1]);
				Association<String, String> Value2 = new Association<String, String>(splitLine[1], splitLine[2]);
				
				if(EngToSpa.getRoot() == null) {
					EngToSpa.InsertRoot(Value1);
				}
				
				else if(EngToSpa.getRoot() != null) {
					EngToSpa.Insert(EngToSpa.getRoot(), Value1);
				}
				
				if(SpaToFre.getRoot() == null) {
					SpaToFre.InsertRoot(Value2);
				}
				
				else if(SpaToFre.getRoot() != null) {
					SpaToFre.Insert(SpaToFre.getRoot(), Value2);
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
	
    public static String[] readTxtFileToList() {
    	 ArrayList<String> wordsList = new ArrayList<String>();
    	 String MyFile = "src/texto.txt";
    	 
         try {
             BufferedReader reader = new BufferedReader(new FileReader(MyFile));
             String line = reader.readLine();
             
             while (line != null) {
                 String[] words = line.split("\\s+");
                 for (String word : words) {
                     if (!word.trim().isEmpty()) {
                         wordsList.add(word.trim());
                     }
                 }
                 line = reader.readLine();
             }
             reader.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         String[] wordsArray = new String[wordsList.size()];
         wordsArray = wordsList.toArray(wordsArray);
         return wordsArray;
     }	
}
