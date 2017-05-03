package com.fourbits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenList {
	
	private List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,4,6,8,10));

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}	
	
	
}
