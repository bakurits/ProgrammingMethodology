/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	/* this method moves karel toward if it's possible */
	private void moveIfItsPossible() {
		if (frontIsClear()) {
			move();
		}
	}

	/* this method checks if it's necessary to put beeper on it */
	private void checkLastCell() {
		turnAround();
		moveIfItsPossible();
		if (!beepersPresent()) {
			turnAround();
			moveIfItsPossible();
			if (!beepersPresent()) {
				putBeeper();
			}
		} else {
			turnAround();
			moveIfItsPossible();
		}

	}

	/* this method turns karel back to begin */
	private void moveBack() {
		while (frontIsClear()) {
			move();
		}
		turnAround();
	}

	/* this method colors first line in a bad way for future good */
	private void colorFakeFirstLine() {
		moveIfItsPossible();
		while (frontIsClear()) {
			putBeeper();
			moveIfItsPossible();
			moveIfItsPossible();
		}
		checkLastCell();
		turnAround();
		moveBack();
	}

	/* this method flips cell, cell with beeper becomes empty and vice-versa */
	private void flipCell() {
		if (beepersPresent()) {
			pickBeeper();
		} else {
			putBeeper();
		}
	}

	/* this method flips line, all cells with beeper becomes empty and vice-versa */
	private void flipTheline() {
		while (frontIsClear()) {
			flipCell();
			move();
		}
		flipCell();
	}

	/* this method copys cell and pastes in top cell */
	private void copyToTopCell() {
		if (beepersPresent()) {
			turnLeft();
			move();
			putBeeper();
			turnAround();
			move();
			turnLeft();
		}
	}
	/* this method copys line and pastes in top */
	private void copyToTopLine() {
		while (frontIsClear()) {
			copyToTopCell();
			move();
		}
		copyToTopCell();
	}

	/* this method colors whole board */
	private void colorBoard() {
		turnLeft();
		while (frontIsClear()) {
			turnRight();
			flipTheline();
			turnAround();
			moveBack();
			copyToTopLine();
			turnAround();
			moveBack();
			turnLeft();
			move();
		}
		turnRight();
		flipTheline();
	}

	public void run() {
		colorFakeFirstLine();
		colorBoard();

	}
}
