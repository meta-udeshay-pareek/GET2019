package string;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UniqueCharacter
{

	//HashMap for storing results
	HashMap<String, Integer> cache= new HashMap<>();


	/**
	 * @param input, input string for applying operation on it
	 * @return result
	 * */
	public int numberOfUniqueCharacter(String input)
	{
		int result=0;

		//firstly checking do we have result for the same string from earlier
		if(cache.containsKey(input))
		{
			result = cache.get(input);
			return result;
		}

		//for storing character one by one uniquely character is key and value is  of character in that string
		HashMap<Character, Integer> uniquecharacter= new HashMap<>();

		for(int i=0;i<input.length();i++)
		{
			char tempChar= input.charAt(i);
			
			//if character is already exist in map then update it's value 
			if(uniquecharacter.containsKey(tempChar))
			{
				int val= uniquecharacter.get(tempChar);
				uniquecharacter.put(tempChar,val+1);
			}

			//if not exist then put in hashMap
			else
				uniquecharacter.put(tempChar, 1);

		}
		
		//creating a set of keySet of HashMap
		Set<Character> keyset= uniquecharacter.keySet();



		//creating a iterator for traversing set
		Iterator<Character> iterator = keyset.iterator(); 

		while(iterator.hasNext())
		{
			//if character occurence (stored in map as value) is one then increment result value
			if(uniquecharacter.get(iterator.next()) == 1 )
				result ++;
		}

		//put result in cash hashMap for future use
		cache.put(input, result);
		
		//return result
		return result;
	}


	public static void main(String args[])
	{
		UniqueCharacter nu= new UniqueCharacter();
		int value=nu.numberOfUniqueCharacter("aqwe@#$qwea@#");
		System.out.println(value);
		System.out.println(nu.numberOfUniqueCharacter("paravijay"));

		System.out.println(nu.numberOfUniqueCharacter("paravijay"));

	}


}




