package test;

import static org.junit.jupiter.api.Assertions.*;
import app.dictionary;
import org.junit.jupiter.api.Test;
//test cases for dictionary
class TestAssertions {

	@Test
	void test() {
		dictionary dict=new dictionary();
		//words in the dictionary
		dict.insertWordNode("apple");
		dict.insertWordNode("banana");
		dict.insertWordNode("cherry");
		
		//check if words are in the dictionary
		assertTrue(dict.checkWord("apple"));
		assertTrue(dict.checkWord("banana"));
		assertTrue(dict.checkWord("cherry"));
		
		//words not in the dictionary
		assertFalse(dict.checkWord("date"));
		assertFalse(dict.checkWord("fig"));
		assertFalse(dict.checkWord("grape"));
		
		//delete a word and check if it is deleted
		 dict.deleteWordNode("banana");
	        assertFalse(dict.checkWord("banana"), "banana should have been deleted");

	        //deletes word again to see if it handles non-existent word deletion gracefully
	        dict.deleteWordNode("banana");
	        
	        // Re-insert the deleted word and check if it is present
	        dict.insertWordNode("banana");
	        assertTrue(dict.checkWord("banana"), "banana should be re-inserted");

	        // Delete the root node and check if it is deleted
	        dict.deleteWordNode("apple");
	        assertFalse(dict.checkWord("apple"), "apple (root) should be deleted");
		
	        // Check BST structure using toString()
	        String bst = dict.toString();
	        
	        assertFalse(bst.contains("apple"), "Deleted word should not appear in bst");
	        assertTrue(bst.contains("banana"), "Inserted word should appear in bst");

	        // Ensure the string representation is not null
	        assertNotNull(bst, "string should not be empty");
	        
	        System.out.println("Successful");
		
	}
	
	//Look at potential problems, such
	//as ending up with a pointer pointing to the wrong node

	//Make sure there are no cycles in the tree.
	//Make sure that pointers to child nodes are consistent, that is, if some
	//node points to its child, then it if it’s smaller than it is a left child and if
	//greater than then it is a right child.
	//Write a tester to execute some experiments. For every method that makes alterations to the Binary Search Tree, the
	//assertion should be invoked. When all of the assertions pass, then output “Successful”.
	
}
