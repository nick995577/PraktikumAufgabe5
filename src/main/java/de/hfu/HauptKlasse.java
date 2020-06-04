package de.hfu;

import java.util.Scanner;

public class HauptKlasse{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s1 = scanner.nextLine();
		 
		System.out.print(s1.toUpperCase());
	}

}


