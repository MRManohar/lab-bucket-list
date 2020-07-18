package service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import model.TouristPlace;

public class MapOperations {
	public Map<Integer, String> add(TouristPlace places) {
		int rank = Integer.parseInt(places.getRank());
		Map<Integer,String> hashMap = new HashMap<Integer,String>();
		hashMap.put(rank, places.getDestination());
		return hashMap;
	}
	public Map<Integer,String> sortRandomly(TouristPlace places) {
		int rank = Integer.parseInt(places.getRank());
		Map<Integer,String> hashMap = new HashMap<Integer,String>();
		hashMap.put(rank, places.getDestination());
		return hashMap;
	}
	public Map<Integer,String> sortInEntryOrder(Map<Integer,String> places) {
		LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<Integer,String>(places);
		return linkedHashMap;
	}
	public Map<Integer,String> sortAlphabetically(Map<Integer,String> places) {
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>(places);
		return treeMap;
	}
	public Object reset(Map<Integer,String> places) {
		places.clear();
		return places;
	}
	public HashMap<Integer,String> remove(TouristPlace places) {
		int rank = Integer.parseInt(places.getRank());
		HashMap<Integer, String> hashMap = new HashMap<Integer,String>();
		hashMap.remove(rank);
		return hashMap;
	}
}