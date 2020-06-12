package understandingJava.collections;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StringFrequency implements Comparable<StringFrequency> {
	private String string;
	private int frequency;

	public StringFrequency() {
		frequency = 1;
	}

	public int incrementFrequency() {
		frequency += 1;
		return frequency;
	}

	protected String getString() {
		return string;
	}

	protected StringFrequency setString(String string) {
		this.string = string;
		return this;
	}

	@Override
	public int compareTo(StringFrequency o) {

		return this.frequency - o.frequency;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringFrequency other = (StringFrequency) obj;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

}

class FrequencySort {

	/*
	 * {5(a),6(b),4(c),3(d),1(e)} - frequency of each key in keyset()->array
	 * frequency
	 * 
	 * 
	 * {"b" ,"a" ,"b" ,"a" ,"b" ,"a" ,"b", "a", "b","a" ,"b" , "e","d" ,"d" , "d","c", "e","c" , "c", "c"} 19 (5)
	 */

	private HashMap<String, StringFrequency> getFrequencyHashMapOfArray(String[] array) {
		HashMap<String, StringFrequency> hashMap = new HashMap<String, StringFrequency>();

		for (String elementOfArray : array) {
			if (hashMap.containsKey(elementOfArray)) {

				hashMap.get(elementOfArray).incrementFrequency();

			} else {
				StringFrequency stringFrequency = new StringFrequency().setString(elementOfArray);

				hashMap.put(elementOfArray, stringFrequency);
				
				
			}
		}
		
		return hashMap;

	}

	public String[] sortByFrequency(String[] array) {

		Map<String, StringFrequency> map = getFrequencyHashMapOfArray(array);
		
		StringFrequency[] stringFrequencies = new StringFrequency[map.size()];
		
		int iterationVariable = 0;
		for(Map.Entry<String, StringFrequency> entry : map.entrySet() ) {
			stringFrequencies[iterationVariable++] = entry.getValue();
		}
				
		Arrays.sort(stringFrequencies, Collections.reverseOrder());
		
		String[] strings = new String[stringFrequencies.length];
		
		for(iterationVariable = 0; iterationVariable<strings.length ; iterationVariable++)
		{
			strings[iterationVariable] = stringFrequencies[iterationVariable].getString();
		}
		
		return strings;
		
	}

	

}

public class MainFrequencySort{
	
	
	public static void main(String[] args) throws IOException
	{
		String[] strings = {"b" ,"a" ,"b" ,"a" ,"b" ,"a" ,"b", "a", "b","a" ,"b" , "e","d" ,"d" , "d","c", "e","c" , "c", "c"};
		String[] frequencyWiseSortedStrings  =  new FrequencySort().sortByFrequency(strings);	
	
		for(String element : frequencyWiseSortedStrings )
			System.out.println(element);
	}
	
}

