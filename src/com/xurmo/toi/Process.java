package com.xurmo.toi;

public class Process {

	int moveNumber;
	int numberOfRings;
	Tower tower0, tower1, tower2;

	public Process(int numberOfRings) {

		this.numberOfRings = numberOfRings;
		tower0 = new Tower(0, numberOfRings);
		tower1 = new Tower(1, 0);
		tower2 = new Tower(2, 0);

	}

	public void MovebyAlg(int moveNum) {
		
		if (tower1.NumberOfRings() == numberOfRings) {
			
			System.out.println("*********Final Condition*************");
			viewAllRings();
			System.out.println("***************************************");
			System.out.println("Process Finished");
			System.exit(0);
		} else {
			
			if (moveNum % 2 == 0) {
				System.out.println("Even Move.");
				performEvenMove();

			} else {
				System.out.println("Odd Move.");
				performOddMove();
			}
			
			viewAllRings();
			MovebyAlg(moveNum + 1);
		}
	}

	public void performEvenMove() {

		Tower srcTower, desTower;
		srcTower = getTowerWithSecondLargestRing();
		
		if(srcTower != null){
			desTower = getTowerAfterLogicalEval(srcTower.getRingOnTop().getiD());
		
			System.out.println("@@@@@@@@");
			System.out.println(srcTower);
		
			if (srcTower.getRingOnTop().getiD() != numberOfRings) {
				performRingMove(srcTower, desTower);
			}
		}
	}

	private Tower getTowerAfterLogicalEval(int i) {

		if (tower0.getRingOnTop() == null)
			return tower0;

		else if (tower1.getRingOnTop() == null)
			return tower1;

		else if (tower2.getRingOnTop() == null)
			return tower2;

		else if (tower0.getRingOnTop().getiD() < i) {
			return tower0;
		}

		else if (tower1.getRingOnTop().getiD() < i) {
			return tower1;
		}

		else {
			return tower2;
		}

	}

	public Tower getTowerWithSecondLargestRing() {
		Ring ring0, ring1, ring2;
		ring0 = tower0.getRingOnTop();
		ring1 = tower1.getRingOnTop();
		ring2 = tower2.getRingOnTop();

		Tower srctower = null;

		if (ring0 != null && ring1 != null && ring2 != null) {
			if ((ring0.getiD() > ring1.getiD()) && (ring2.getiD() >  ring0.getiD())) 
				return tower0;
			
			else if((ring0.getiD() > ring2.getiD()) && (ring1.getiD() > ring0.getiD()))
				return tower0;
			
			else if((ring1.getiD() > ring0.getiD())&& (ring2.getiD() > ring1.getiD()))
				return tower1;
			
			else if((ring1.getiD() > ring2.getiD()) && (ring0.getiD() > ring2.getiD()))
				return tower1;
			
			else if((ring2.getiD() > ring0.getiD()) && (ring1.getiD() > ring2.getiD()))
				return tower2;
			
			else if((ring2.getiD() > ring1.getiD()) && (ring0.getiD() > ring2.getiD()))
				return tower2;
		}

		else if (ring0 != null && ring1 != null) {
			if (ring0.getiD() > ring1.getiD()) {
				srctower = tower1;
			} else {
				srctower = tower0;
			}
		}

		else if (ring1 != null && ring2 != null) {
			if (ring1.getiD() > ring2.getiD()) {
				srctower = tower2;
			} else {
				srctower = tower1;
			}
		}

		else if (ring0 != null && ring2 != null) {
			if (ring0.getiD() > ring2.getiD()) {
				srctower = tower2;
			} else {
				srctower = tower0;
			}
		}

//		else if (ring0 != null) {
//			srctower = tower0;
//		}
//
//		else if (ring1 != null) {
//			srctower = tower1;
//		}
//
//		else if (ring2 != null) {
//			srctower = tower2;
//		}
		
		System.out.println("------>" + srctower);
		
		return srctower;

	}

	public void performOddMove() {
		Tower srctower = findLocationOfLargestRing();
		Tower desttower = findTowerClockwise(srctower);
		performRingMove(srctower, desttower);
	}

	private void performRingMove(Tower srctower, Tower desttower) {
		Ring ringToMove = srctower.getRingOnTop();
		desttower.rings.add(ringToMove);
		srctower.rings.remove(ringToMove);
	}

	private Tower findTowerClockwise(Tower tower) {

		if (tower.getId() == 0) {
			return tower2;
		} else if (tower.getId() == 1) {
			return tower0;
		} else
			return tower1;

	}

	public Tower findLocationOfLargestRing() {

		Ring ring0, ring1, ring2;
		ring0 = tower0.getRingOnTop();
		ring1 = tower1.getRingOnTop();
		ring2 = tower2.getRingOnTop();

		Tower towerWithLargestRing = null;

		if (ring0 != null && ring1 != null && ring2 != null) {
			
			if (ring0.getiD() > ring1.getiD()) {
				if (ring0.getiD() > ring2.getiD()) {
					towerWithLargestRing = tower0;
				} else {
					towerWithLargestRing = tower2;
				}
			} else {
				if (ring1.getiD() > ring2.getiD()) {
					towerWithLargestRing = tower1;
				} else {
					towerWithLargestRing = tower2;
				}
			}

		}

		else if (ring0 != null && ring1 != null) {

			if (ring0.getiD() > ring1.getiD()) {
				towerWithLargestRing = tower0;
			} else {
				towerWithLargestRing = tower1;
			}

		}

		else if (ring1 != null && ring2 != null) {

			if (ring1.getiD() > ring2.getiD()) {
				towerWithLargestRing = tower1;
			} else {
				towerWithLargestRing = tower2;
			}

		}

		else if (ring2 != null && ring0 != null) {

			if (tower2.getRingOnTop().getiD() > tower0.getRingOnTop().getiD()) {
				towerWithLargestRing = tower2;
			} else {
				towerWithLargestRing = tower0;
			}
		}

		else if (ring1 == null && ring2 == null) {
			towerWithLargestRing = tower0;
		}

		else if (ring0 == null && ring2 == null) {
			towerWithLargestRing = tower1;
		}

		else if (ring0 == null && ring1 == null) {
			towerWithLargestRing = tower2;
		}

		return towerWithLargestRing;

	}

	public void viewAllRings() {

		
		System.out.println("=============================");
		System.out.println("*****Tower0*****");
		for (Ring ring : tower0.getRings())
			System.out.println(ring.getiD());

		System.out.println("*****Tower1*****");
		for (Ring ring : tower1.getRings())
			System.out.println(ring.getiD());

		System.out.println("*****Tower2*****");
		for (Ring ring : tower2.getRings())
			System.out.println(ring.getiD());

	}

}
