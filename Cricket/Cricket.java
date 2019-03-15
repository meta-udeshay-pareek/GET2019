
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cricket {

	/**
	 * @param numberOfBalls  which virat going to play
	 * @param numberOfBowlers
	 * @param ballsForEachBowler[]
	 * 
	 * @return arrangedOrderOfBowlers[] order of bowlers for each balls which virat going to play
	 * i.e. which ball will throw by which bowler
	 * */
	public static int [] findOrderOfBolres(int numberOfBalls,int numberOfBowlers,int ballsForEachBowler[]) throws Exception {

		//for storing arranging of bowler 
		int arrangedOrderOfBowlers[] = new int[numberOfBalls];

		
		/*************Validation checking******************/
		
		//if bowls allocation per baller is incorrect then throw exception
		if(numberOfBowlers!=ballsForEachBowler.length) {
			throw new Exception("bowls allocation per boller is incorrect");
		}


		//adding all the allocated balls that should be equal to numberOfBalls virat going to play
		int sum = 0;
		for(int bowls : ballsForEachBowler) {
			sum+=bowls;
		}

		//if all the allocated balls sum aren't equal to numberOfBalls virat going to play then throw exception
		if(sum!= numberOfBalls) {
			throw new Exception("numberOfBalls and sum of all allocated balls to bowler are not equal");
		}

		/****************************************************/
		

		
		//putting data in hashmap
		//Key is BowlerNumber Value balls associated with that bowler
		HashMap<Integer, Integer> bowlerData = new HashMap<Integer, Integer>();
		int key=0;
		for(int i=0;i<numberOfBowlers;i++) {
			bowlerData.put(++key, ballsForEachBowler[i]);
		}


		
		//Main Logic for storing arranging order of bowler
		for(int i=0;i<numberOfBalls;i++) {	

			//Calling sort method which is returning entry set and getting it's first key(bowlerNumber) because it is descending sorted manner
			int bowlerNumber = (int) sort(bowlerData).entrySet().iterator().next().getKey();
			//storing order in array
			arrangedOrderOfBowlers[i]=bowlerNumber;
			//getting balls associated with that bowler
			Integer balls = bowlerData.get(new Integer(bowlerNumber));
			//updating the number of balls associated with that bowler as he
			bowlerData.put(bowlerNumber, --balls);

		}




		return arrangedOrderOfBowlers;
	}



	/**
	 * @param bowlerData
	 * @return reverseSortedMap,sorted map based on values in descending order
	 *  */
	private static LinkedHashMap<Integer, Integer> sort(HashMap<Integer, Integer> bowlerData){
		//LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();

		//sorting HashMap by Value and storing it into reverseSortedMap
		bowlerData.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		return reverseSortedMap;
	}



}
