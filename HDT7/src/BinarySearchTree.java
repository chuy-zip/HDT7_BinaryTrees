
public class BinarySearchTree<K, V> {
	
	private Node<K, V> Root;
	
	public BinarySearchTree(){
		this.Root = null;
	}
	
	public void InsertRoot(Association<K, V> value) {// this is for setting the root of the binary tree
		this.Root = new Node<K, V>(value);
	}
	
	public void Insert(Node<K, V> currentRoot, Association<K, V> value) {
		String rootValue = (String) currentRoot.getValue().getKey();
		String nodeValue = (String) value.getKey();
		
		int result = nodeValue.compareTo(rootValue);
		
		if(result == 0) {
			System.out.println("Node key values cannot be duplicate");
			System.exit(0);
		}
		
		if(result < 0 ) {
			if(currentRoot.getLeft() == null) {// this means there is nothing on the left side
				currentRoot.setLeft(new Node<K, V>(value));
			}
			else {
				Insert(currentRoot.getLeft(), value);
			}	
		}
		
		else{// Case if the value is greater than the one in the root
			if(currentRoot.getRight() == null) {// this means there is nothing on the Right side
				currentRoot.setRight(new Node<K, V>(value));
			}
			else {
				Insert(currentRoot.getRight(), value);
			}
		}
		
	}

	public Node<K, V> getRoot() {
		return Root;
	}
	
	public void PrintInOrder(Node<K, V> currentRoot){
		if (currentRoot == null) {
			return;
		}
		
		PrintInOrder(currentRoot.getLeft());
		
		System.out.println( currentRoot.getValue().getKey() + ", " + currentRoot.getValue().getValue());
		
		PrintInOrder(currentRoot.getRight());
	}
	

}