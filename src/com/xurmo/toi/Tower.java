package com.xurmo.toi;

/*
 * @Author : Sreejith S
 */

import java.util.ArrayList;
import java.util.List;

public class Tower {
	
	int id;
	List<Ring> rings = new ArrayList<Ring>();
	int i;
	
	public Tower(int id, int numberOfRings) {
		this.id = id;
		for(i=0;i<numberOfRings;i++){
			rings.add(new Ring(i));
		}
		
	}
	
	public List<Ring> getRings() {
		return rings;
	}

	public void setRings(List<Ring> rings) {
		this.rings = rings;
	}

	public Ring getRingOnTop(){
		if(rings.size() > 0)
			return rings.get(rings.size()-1);
		return null;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int NumberOfRings(){
		return rings.size();
	}
	
	

}
