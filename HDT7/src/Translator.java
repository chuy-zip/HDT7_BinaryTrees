
public class Translator<K, V> {
	
	public String Translate(BinarySearchTree<K, V> Tree, String[] Text) {
		
		String Translation = "";
		
		for (int i = 0; i < Text.length; i++) {
			
			Node<K, V> SearchResult = Tree.Search(Tree.getRoot(), Text[i]);
			
			if( SearchResult == null) {
				Translation += "*" + Text[i] + "* ";
			}
			else {
				Translation += SearchResult.getValue().getValue() + " ";
			}
			
		}
		
		return Translation;
	}

}
