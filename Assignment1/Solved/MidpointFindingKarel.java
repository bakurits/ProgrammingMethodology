/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	
	/* this method puts beeper on every cell of first line */
	private void colorLine() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
		turnAround();
	}
	
	/* this method turns karel back to begin */
	private void moveBack() {
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	/* this method moves karel to further beeper on current direction */ 
	private void moveToFurtherBeeper() {
		while (beepersPresent() && frontIsClear()) {
			move();
		}
		if (!beepersPresent()) {
			turnAround();
			move();
			turnAround();
		}
	}
	
	/* this method actually solves this problem and finds middle point */
	private void getMidPoint() {
		while(beepersPresent()) {
			moveToFurtherBeeper();
			pickBeeper();
			turnAround();
			if (frontIsClear()) {
				move();
			}
		}
		turnAround();
		if (frontIsClear()) {
			move();
		}
		putBeeper();
	}
	
	public void run() {
		colorLine();
		moveBack();
		getMidPoint();
	}

}
