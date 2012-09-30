package org.hedspi.posgresql.hedspi_student_manager.model.hedspi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class HedspiObjects<T extends HedspiObject> extends HashMap<String, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_CODE = "DT#";
	public static final String NAME_CODE = "Name";
	
	private String name;

	public void put(T value){
		super.put(value.getId(), value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<T> getSortedList(){
		ArrayList<T> arr = new ArrayList<>();
		for(T it : super.values())
			arr.add(it);
		Collections.sort(arr, new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				return arg0.toString().compareTo(arg1.toString());
			}});
		return arr;
	}
	public ArrayList<T> getSortedListIgnoreCase(){
		ArrayList<T> arr = new ArrayList<>();
		for(T it : super.values())
			arr.add(it);
		Collections.sort(arr, new Comparator<T>(){

			@Override
			public int compare(T arg0, T arg1) {
				return arg0.toString().compareToIgnoreCase(arg1.toString());
			}});
		return arr;
	}

}
