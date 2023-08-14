package Practice;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

class onlyinterger extends Exception {
	public onlyinterger() {
		System.out.println("only enter integer values from 1 to 50");
	}
}

public class GuessTheNumberGame {
	private static Scanner sc;
	public static void main(String[] args) {
		try {
			Random ran = new Random();
			int numberToGuess = ran.nextInt(50) + 1;
			int numberOfTries = 0;
			sc = new Scanner(System.in);
			int guess;
			boolean win = false;
			while (win == false) {
				System.out.println("Guess a number from 1 to 50!");
				guess = sc.nextInt();
				numberOfTries++;
				if (guess <= 0) {
					throw new onlyinterger();
				}
				if (guess > 50) {
					throw new onlyinterger();
				}
				if (guess == numberToGuess) {
					win = true;
				} else if (guess < numberToGuess) {
					System.out.println("Too low. Try again.");
				} else if (guess > numberToGuess) {
					System.out.println("Too high. Try again.");
				}
			}
			System.out.println("You got it in " + numberOfTries + "attempt(s)!");
		} catch (onlyinterger E) {
			System.out.println("exception caught");
		} catch (InputMismatchException E) {
			System.out.println("input mismatch only enter numeric values");
		} catch (Exception E) {
			System.out.println(E);
		} finally {
			System.out.println("thankyou for playing");
		}
	}
}