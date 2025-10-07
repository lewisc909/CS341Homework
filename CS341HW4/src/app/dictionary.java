package app;

public class dictionary {
//Implement a Dictionary class using a Binary Search Tree. Create your own implementation of the BST.
	//Node class
	private class Node{
		String word;
		Node left;
		Node right;
		
//constructor
		public Node(String word) {
			this.word=word;
			this.left=null;
			this.right=null;
		}
	}
	private Node root;
	
	//constructor
	public dictionary() {
		this.root=null;
	}
	//method, functions
	public void insertWordNode(String word) {
		//insert value into binary search tree
		//Inserts must occur at a leaf, and the respective child pointers should be assigned correctly
		root=insertFunction(root,word);
		
	}
	//recursive insert function
	private Node insertFunction(Node root, String word) {
		if(root==null) {
			root=new Node(word);
			return root;
		}
		if(word.compareTo(root.word)<0) {
			root.left=insertFunction(root.left,word);
		}
		else if(word.compareTo(root.word)>0) {
			root.right=insertFunction(root.right,word);
		}
		return root;
	}
	
	public boolean checkWord(String word) {
		//A public method that removes a specified node from the Binary Search Tree. Consider
		//the possible scenarios for deletion. For example (a) the node to be removed is not in
		//the tree, (b) the node to be removed has no children, (c) the node to be removed had
		//one child, and (d) the node to be removed has two children. Following a deleted node,
		//respective node pointers much be correctly re-assigned
		return checkWordFunction(root,word);
	}
	
	private boolean checkWordFunction(Node root, String word) {
		if(root==null) {
			return false;
		}
		if(word.equals(root.word)) {
			return true;
		}
		if(word.compareTo(root.word)<0) {
			return checkWordFunction(root.left,word);
		}
		else {
			return checkWordFunction(root.right,word);
		}
	}	
	
	public void deleteWordNode(String word) {
		root=deleteFunction(root,word);
}
	
	private Node deleteFunction(Node root, String word) {
		if(root==null) {
			return root;
		}
		if(word.compareTo(root.word)<0) {
		root.left=deleteFunction(root.left,word);
		}
		else if(word.compareTo(root.word)>0) {
			root.right=deleteFunction(root.right,word);
		}
		else {
	
			if(root.left==null) {
			return root.right;
		}
		else if(root.right==null) {
			return root.left;
		}
		root.word=minValue(root.right);
		root.right=deleteFunction(root.right,root.word);
	}
			return root;
	}
	
	private String minValue(Node root) {
		String minv=root.word;
			while(root.left!=null) {
			minv=root.left.word;

			root=root.left;
		}
		return minv;
	
}
	@Override
	public String toString() {
		String result="";
			Node ptr=root;
	
			while(ptr!=null) {
				result+=ptr.word+" ";
				  ptr=ptr.left;
	}
		return result;

}
	public boolean spellCheck() {
		//returns true if word is spelled correctly, false if not recognized
		if(root!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	}
