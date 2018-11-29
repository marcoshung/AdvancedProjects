
public class BST {
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void insert(int data) {
		insert(root, data);
	}
	
	private Node insert(Node node, int data) {
		if(node == null) {
			//base case
			node = new Node(data);
		}else {
			if(data < node.data) {
				//has to run recursivly to find empty node and insert it in
				node.left = insert(node.left, data);
			}else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	
	public int countNodes() {
		return countNodes(root);
	}
	
	private int countNodes(Node n) {
		if(n == null) {
			return 0;
		}else {
			return 1 + countNodes(n.left) + countNodes(n.right);
		}
	}
	
	public boolean search(int val) {
		return search(root, val);
	}
	
	private boolean search(Node n, int val) {
		if(n == null) {
			return false;
		}else if(n.data == val) {
			return true;
		}else{
			return search(root.left,val) || search(root.right,val);
		}
	}
	
	public Node minNode() {
		return minNode(root);
	}
	
	private Node minNode(Node node) {
		if(node.left == null) {
			return node;
		}
		return minNode(node.left);
	}
}
