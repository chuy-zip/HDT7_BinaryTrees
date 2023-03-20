
public class Node<K, V> {
	private Node<K, V> left;
	private Node<K, V> right;
	private Association<K, V> value;
	
	public Node(Association<K, V> val) {
		left = null;
		right = null;
		value = val;
	}

	public Node<K, V> getLeft() {
		return left;
	}

	public void setLeft(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> getRight() {
		return right;
	}

	public void setRight(Node<K, V> right) {
		this.right = right;
	}

	public Association<K, V> getValue() {
		return value;
	}

	public void setValue(Association<K, V> value) {
		this.value = value;
	}
	
}
