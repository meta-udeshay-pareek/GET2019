package dictionary;


import java.util.LinkedList;
import java.util.List;




public class BstService {


	//will hold status of deletion of node
	static boolean deleteStatus=false;
	
	
	
	public static boolean getDeleteStatu() {
		return deleteStatus;
	}

	public static void setDeleteStatu(boolean deleteStatus) {
		BstService.deleteStatus = deleteStatus;
	}


	//for purpose of returning a sorted list of BST element
	List<String> sortedList;

	public BstService(){
		sortedList  = new LinkedList<String>();
	}


	


	/**
	 * @param root, root of BST
	 * @param node for adding in binary 
	 * @return root, the addedNode will return or if node with same key already exist then "null" will return 
	 *  */
	public Node addRecursive(Node root,Node node){

		//if tree is empty
		if (root == null) { 
			root = node;
			return root; 
		} 

	

		//if key is larger than current node then move right of current node 
		if (node.getKey().compareTo(root.getKey())>=1) { 
			root.setRight(addRecursive(root.getRight(), node));
		}
		//if key is lesser than current node then move left of current node 
		else if(node.getKey().compareTo(root.getKey())<0) { 
			root.setLeft(addRecursive(root.getLeft(), node));
		}
		//dupicate entries are nor allowed in BSt
		else {
			return null;
		}


		return root;
	}





	/**
	 * Private helper method
	 * @param root,BST root node
	 * @param key , for deleting the node which contain this key
	 * @return root, the deleted node else "null" if node not found with given key
	 * */
	public Node deleteRecursive(Node root,String key) {

		
		//If tree is empty
		if (root == null)  return root; 

	

		//if key is greater than current node then move right of current node 
		if (key.compareTo(root.getKey())>=1) {
			root.setRight(deleteRecursive(root.getRight(), key)); //deleteRecursive(
		}   
		//if key is lesser than current node then move left of current node 
		else if (key.compareTo(root.getKey())<0) { 
			root.setLeft(deleteRecursive(root.getLeft(), key));
		}

		// if key is same as root's key, then This is the node 
		// to be deleted 
		else
		{ 
			System.out.println("Hello");
			deleteStatus = true;//setting node deetion status
			// node with only one child or no child 
			if (root.getLeft() == null) 
				return root.getRight(); 
			else if (root.getRight() == null) 
				return root.getLeft(); 

			// node with two children: Get the inorder successor (smallest in the right subtree) 
			//setting root node as smallest node in it's right subtree
			Node root1 = (minValue(root.getRight())); 
			root.setKey(root1.getKey());
			root.setValue(root1.getValue());

			// Delete the inorder successor the smallest key value node which has put as a root node now
			root.setRight(deleteRecursive(root.getRight(), root.getKey())); 
		} 
		
		return root;
	}


	/**
	 * Private helper method which is returning the smallest node from the BST
	 * @param root, the root node of BST
	 * @return root, the node which contain smallest key
	 */
	private Node minValue(Node root) 
	{  
		while (root.getLeft() != null) 
		{ 
			root = root.getLeft(); 
		} 
		return root; 
	} 

	/**
	 * @param root,root node of BST
	 * @param key, the Key for which method will search node
	 * @return Node, the node which contain the given key
	 * */
	public Node search(Node root, String key) 
	{ 
		// Base Cases: root is null or key is present at root 
		if (root==null || root.getKey().compareTo(key)==0) 
			return root; 

		// val is greater than root's key 
		if (key.compareTo(root.getKey())>=1) 
			return search(root.getRight(), key); 

		// val is less than root's key 
		return search(root.getLeft(), key); 
	} 


	/**
	 * 
	 * this method is working for both, one is for sorted list in which limits are not given second is for where limit is given
	 * @param root, root node of the tree
	 * @param k1,key1 for lower limit 
	 * @param k2, key2 for upper limit
	 * @return sortedList
	 * */

	public List<String> inOrderTraversalForSortedList(Node root,String k1,String k2) {

		if (root == null) 
			return null; 

		/* first recur on left child */
		inOrderTraversalForSortedList(root.getLeft(),k1,k2); 

		if(k1 == null && k2 == null) {
			/* then add node to List*/
			sortedList.add(root.getKey()+" : "+root.getValue());
		}else {
			String value = root.getKey();
			if(value.compareTo(k1)>=0 && value.compareTo(k2)<=0) {
				/* then add node to List*/
				sortedList.add(root.getKey()+" : "+root.getValue());
			}
		}

		/* now recur on right child */
		inOrderTraversalForSortedList(root.getRight(),k1,k2); 

		return sortedList;
	}

}
