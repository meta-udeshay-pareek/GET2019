package dictionary;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BST implements Dictionary{

	//BstService reference variable
	BstService bstService;


	//root node of BST (binary search tree)
	Node root;

	/*****Getter Setter******/
	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}
	/*****Getter Setter******/


	/**
	 * Constructor
	 * */
	public BST() {
		this.root = null;
		bstService = new BstService();
	}

	/**
	 * Constructor which is taking json file path and creating dictionary
	 * @param jsonFilePath,path of json file
	 * */
	public BST(String jsonFilePath) {
		this();
		File jsonFile = new File(jsonFilePath);
		this.createDictionary(jsonFile);
	}



	/**
	 * @param jsonFile path of json File
	 * */
	private void createDictionary(File jsonFile) {

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			//getting data from json file
			Map<String, String> mapObject = objectMapper.readValue(jsonFile, new TypeReference<Map<String, String>>() {});

			//inserting each key:value pair into dictionary
			for (Map.Entry<String,String> entry : mapObject.entrySet()) {
				Node node = new Node(entry.getKey(),entry.getValue());//creating node of each key:value
				this.add(node);//adding node into tree
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param node,for adding in BST
	 * @return true after addition of node in BST else false
	 * */

	@Override
	public boolean add(Node node) {
		if(this.getRoot()==null) {
			this.setRoot(node);
			return true;
		}

		Node addedNode = bstService.addRecursive(this.getRoot(), node);

		if(addedNode!=null) {
			return true;
		}else {
			return false;
		}
	}




	/**
	 * @param key,deleting a node(Key:value pair) based on key
	 * @return @return true, false 
	 * */
	@Override
	public boolean delete(String key) {
		BstService.setDeleteStatu(false);
		bstService.deleteRecursive(this.getRoot(),key);
		
		if(BstService.getDeleteStatu()) {
			return true;
		}
		return false;
	}






	/**
	 * @param key, for getting value based on Key from BST
	 * @return value(ObjectType),if key found else return null
	 * */
	@Override
	public String getValue(String key) {

		Node node = bstService.search(root, key);

		if(node!=null) {
			return node.getValue();
		}
		return null;
	}





	/**
	 * @return sortedList of key:value pair based on key
	 * */
	@Override
	public List<String> getSortedList(){

		//firstly cleaning the list in which new data will store
		bstService.sortedList.clear();
		return bstService.inOrderTraversalForSortedList(this.getRoot(),null,null);
	}






	/**
	 * 
	 * method will return sorted list of key:value pair based on key condition:-for all the keys >=K1 and <=K2.

	 * @param key1
	 * @param key2
	 * @return sortedList of key:value pair based on key between key1 and key2
	 * */
	@Override
	public List<String> getSortedList(String key1,String key2){
		//firstly cleaning the list in which new data will store
		bstService.sortedList.clear();
		return bstService.inOrderTraversalForSortedList(this.getRoot(),key1,key2);
	}



	

}
