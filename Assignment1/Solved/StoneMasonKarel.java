/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	
	/* this method moves karel forward if it's possible */
	private void moveIfItsPossible() {
		if (frontIsClear()) {
			move();
		}
	}
	
	/* this method moves Karel back to the masons's socle */
	private void backToBegin() {
		while (frontIsClear()) {
			move();
		}
	}
	
	/* this method fixes current mason */
	private void fixCurrentMason() {
		while (frontIsClear()) {
			if (!beepersPresent()) {
				putBeeper();
			}
			move();
		}
		if (!beepersPresent()) {
			putBeeper();
		}
	}
	
	/* this method fixes all masons */
	private void fixTheMasons () {
		while (frontIsClear()) {
			turnLeft();
			fixCurrentMason();
			turnAround();
			backToBegin();
			turnLeft();
			moveIfItsPossible();
			moveIfItsPossible();
			moveIfItsPossible();
			moveIfItsPossible();
		}
		turnLeft();
		fixCurrentMason();
	}
	
	public void run() {
		fixTheMasons();
	}
}
