package nestedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import org.json.simple.JsonObject;


public class NestedListOperation implements NestedList {
	private List<Object> nestedList = new ArrayList<Object>(); // nested List
	private long value; // value evaluated for string input
	private JsonObject  JsonObject;
	
	public NestedListOperation(JsonObject JsonObject) {
		if (JsonObject != null) {
			this.JsonObject = JsonObject;
		}
	}

	public void createNestedList() {
		if (JsonObject != null) {
			this.nestedList = createNestedListRecursive(JsonObject);
		} else {
			throw new NullPointerException("Empty JSON Object");
		}
	}

	/**
	 * private helper method to create nested list after parsing it from json
	 * file
	 * 
	 * @param JsonObject
	 *            json object which contains input nested list
	 * @return list of objects
	 */
	private List<Object> createNestedListRecursive(JsonObject JsonObject) {
		LinkedList<Object> nestedList = new LinkedList<>();
		try {
			for (Object key : JsonObject.keySet()) {
				if (key != null) {
					if (JsonObject.get(key) instanceof Long) {
						long value = (Long) JsonObject.get(key);
						nestedList.add(value);
					} else {
						JsonObject newJson = (JsonObject) JsonObject.get(key);
						List<Object> list = createNestedListRecursive(newJson);
						nestedList.add(list);
					}
				} else {
					throw new NullPointerException("Empty key value");
				}
			}
			return nestedList;
		} catch (NullPointerException e) {
			throw new NullPointerException("Empty key value");
		}
	}

	@Override
	public long sumOfAllValues()  {
		try {
			if (nestedList != null) {
				return sumOfAllValues(nestedList);
			} else {
				throw new AssertionError("Empty nested list");
			}
		} catch (AssertionError e) {
			throw new AssertionError("Empty nested list");
		}

	}

	/**
	 * private helper method to get the sum of all values of nested list
	 * 
	 * @param nestedList
	 *            whose value's sum is to be calculated
	 * @return sum of all values of nested list
	 * @throws Assertion error
	 */
	private long sumOfAllValues(List<Object> nestedList){
		try {
			long sum = 0;
			for (Object object : nestedList) {
				if (object instanceof List) {
					sum += sumOfAllValues((List<Object>) object);
				} else if (object instanceof Long) {
					sum += (long) object;
				} else {
					throw new AssertionError("Invalid Input");
				}
			}
			return sum;
		} catch (AssertionError e) {
			throw new AssertionError("Invalid Input");
		}
	}

	@Override
	public long largestValue()  {
		try {
			if (nestedList != null) {
				return largestValue(nestedList);
			} else {
				throw new AssertionError("Empty nested list");
			}
		} catch (AssertionError e) {
			throw new AssertionError("Empty nested list");
		}
	}

	/**
	 * largest value from nested list
	 * 
	 * @param nestedList
	 *            whose largest value is to be find
	 * @return largest value of nested list
	 * @throws Assertion error
	 */
	private long largestValue(List<Object> nestedList) {
		try {
			long max = 0;
			long temp = 0;
			for (Object object : nestedList) {
				if (object instanceof List) {
					temp = largestValue((List<Object>) object);
				} else if (object instanceof Long) {
					temp = (long) object;
				} else {
					throw new AssertionError("Invalid Input");
				}
				if (temp > max) {
					max = temp;
				}
			}
			return max;
		} catch (AssertionError e) {
			throw new AssertionError("Invalid Input");
		}
	}

	@Override
	public boolean searchValue(int element)  {
		try {
			if (nestedList != null) {
				return searchValue(nestedList, element);
			} else {
				throw new AssertionError("Empty nested list");
			}
		} catch (AssertionError e) {
			throw new AssertionError("Empty nested list");
		}

	}

	@SuppressWarnings("unchecked")
	/**
	 * search value in nested list
	 * @param nestedList in which element is to be searched
	 * @param element which is to be searched in list
	 * @return true if element is present in list else false
	 */
	private boolean searchValue(List<Object> nestedList, int element){
		try {
			boolean flag = false;
			for (Object object : nestedList) {
				if (object instanceof List) {
					if (searchValue((List<Object>) object, element)) {
						return true;
					}
				} else if (object instanceof Long) {
					if ((long) object == element) {
						flag = true;
						return flag;
					}
				} else {
					throw new AssertionError("Invalid Input");
				}

			}
			return flag;
		} catch (AssertionError e) {
			throw new AssertionError("Invalid Input");
		}
	}

	
}
