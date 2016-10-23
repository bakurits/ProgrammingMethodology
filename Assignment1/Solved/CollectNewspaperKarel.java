/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

	/* this method moves Karel to Newspaper */
	private void goForNeswpaper() {
		while (frontIsClear()) {
			move();
		}
		turnRight();
		move();
		turnLeft();
		move();
	}

	/* in this method Karel picks newspaper and turns around */
	private void pickAndTurn() {
		pickBeeper();
		turnAround();
	}

	/* this method moves Karel Back to the begin */
	private void backToBegin() {
		move();
		turnRight();
		move();
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}

	public void run() {
		goForNeswpaper();
		pickAndTurn();
		backToBegin();
	}

}
