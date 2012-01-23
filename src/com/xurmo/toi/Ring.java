package com.xurmo.toi;

public class Ring {

	int iD;

	public Ring(int iD) {
		this.iD = iD;
	}
	
	
	public void move(Tower srcTower, Tower destTower){
		if(srcTower.getRingOnTop().getiD() < destTower.getRingOnTop().getiD())
			destTower.rings.add(srcTower.getRingOnTop());
	}


	public int getiD() {
		return iD;
	}


	public void setiD(int iD) {
		this.iD = iD;
	}
	
	
}
