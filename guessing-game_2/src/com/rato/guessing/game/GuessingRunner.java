package com.rato.guessing.game;

/*Guessing game
Source code at: https://hackr.io/blog/java-projects
List of implements made by myself:
	- Limit of attempts
	- Continue option after game over*/

import javax.swing.JOptionPane;

public class GuessingRunner {


	public static void main(String[] args) {

		int computerNumber = (int) ((Math.random() * 100 + 1));
		int userAnswer = 0;

		// System.out.println("The correct guess would be " + computerNumber);

		int count = 1;

		while (userAnswer != computerNumber) {
			String response = JOptionPane.showInputDialog(null, "Enter a guess between 1 and 100", "Guessing game", 3);

			userAnswer = Integer.parseInt(response);
			JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, computerNumber, count));

			count++;

			if (count > 10) {
				JOptionPane.showMessageDialog(null, "" + gameOver(count - 1));
				userAnswer = computerNumber;
			}

		}



	}

	public static String determineGuess(int userAnswer, int computerNumber, int count) {
		if (userAnswer <= 0 || userAnswer > 100) {
			return "Your guess is invalid";
		} else if (userAnswer == computerNumber) {
			return "Correct!\nTotal Guesses:" + count;
		} else if (userAnswer > computerNumber) {
			return "Your guess is too high, try again \nTry Number: " + count;
		} else if (userAnswer < computerNumber) {
			return "Your guess is too low, try again \nTry Number: " + count;
		} else {
			return "Your guess is incorrect \nTry Number: " + count;
		}

	}

	public static String gameOver(int count) {

		return "Game over! Too many tries. Nº of tries: " + count;

	}

}
