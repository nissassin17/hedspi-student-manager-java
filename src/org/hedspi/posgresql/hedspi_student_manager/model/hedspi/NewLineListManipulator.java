package org.hedspi.posgresql.hedspi_student_manager.model.hedspi;

import java.util.ArrayList;


public class NewLineListManipulator extends java.util.ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NewLineListManipulator(String endlInput){
		super();
		parse(endlInput);
	}
	
	public NewLineListManipulator(ArrayList<String> email) {
		super(email);
	}

	public void parse(String endlInput){
		super.clear();
		String[] vals = endlInput.split("\n");
		for(String it : vals)
			super.add(it);
	}
	
	public String toString(){
		String result = "";
		for(int i = 1; i < super.size(); i++)
			if (i == super.size() - 1)
				result += super.get(i);
			else
				result += super.get(i) + "\n";
		return result;
	}
	
}
