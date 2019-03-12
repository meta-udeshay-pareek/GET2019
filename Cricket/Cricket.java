
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cricket {

	public static int [] findOrderOfBolres(int numberOfBalls,int numberOfBowler,int ballsForEachBowler[]) throws Exception {


		//if bowls allocation per boller is incorrect then throw exception
		if(numberOfBowler!=ballsForEachBowler.length) {
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


		HashMap<Integer, Integer> bowlerData = new HashMap<Integer, Integer>();
		int key=0;
		for(int i=0;i<numberOfBowler;i++) {
			bowlerData.put(++key, ballsForEachBowler[i]);
		}

		//LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();

		//sorting HashMap by Value and storing it into reverseSortedMap
		bowlerData.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));



		//setting sorted keys based on value in array
		int arrangedOrderBowler[] = new int[numberOfBowler];
		int i=0;
		for (Entry<Integer, Integer> entry : reverseSortedMap.entrySet()) {
			arrangedOrderBowler[i++] = entry.getKey();
		}


		return arrangedOrderBowler;
	}



}
