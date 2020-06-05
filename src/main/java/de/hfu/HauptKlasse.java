package de.hfu;

import java.util.Scanner;

public class HauptKlasse{
	/**
	 * Das ist die Hauptklasse, darin enthalten ist die Main Methode.
	 */
	public static void main(String[] args){
		/**
		 * Anfang der Main
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s1 = scanner.nextLine();
		 
		System.out.print(s1.toUpperCase());
		/**
		 * Ende der Main
		 */
	}

}


