package org.hedspi.posgresql.hedspi_student_manager.model.util;

import java.util.ArrayList;

public class NewLineUtil {
	public static ArrayList<String> parse(String string){
		ArrayList<String> val = new ArrayList<>();
		String[] vals = string.split("\n");
		for(String it : vals)
			val.add(it);
		return val;
	}

}
