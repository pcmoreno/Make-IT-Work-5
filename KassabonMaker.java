package javatoets;

import java.util.Scanner;

public class KassabonMaker {

	public static void main(String[] args) {

		System.out.println("Dit programma is gemaakt door " + "Paulo da Cruz Moreno " + "(" + 500767246 + ")" + "\n");

		String[] things = { "Papier", "Pennen", "Paperclips", "Potloden" };
		double[] prices = { 2.50, 1.12, 3.60, 4.00 };

		System.out.println("Product Catalogus:");
		printArray(things, prices);

		System.out.print("\n" + "Hoeveel producten wilt u bestellen? ");
		System.out.println();
		Scanner reader = new Scanner(System.in);
		int aantalProducten = pickFromNullToMax(reader, 5);
		
		int[] product = new int[aantalProducten];
		int[] productquantity = new int[aantalProducten];

		for (int counter = 0; counter < aantalProducten; counter++) {
			System.out.print("Welk product wil u kopen? ");
			int choice = pickFromNullToMax(reader, things.length);
			product[counter] = (choice - 1);
			System.out.print("Hoeveel " + things[choice - 1] + " a " + prices[choice - 1] + " wilt u kopen? ");
			productquantity[counter] = getInteger(reader);
			System.out.println();
		}
		System.out.println("\n" + "Bestellingsoverzicht:" + "\n");
		double TotaalPrijs = 0;
		for (int f = 0; f < product.length; f++) {
			System.out.println(productquantity[f] + " ex. " + things[product[f]] + " a " + prices[product[f]] + " = "
					+ thePriceIs(prices[product[f]], productquantity[f]));
			TotaalPrijs += thePriceIs(prices[product[f]], productquantity[f]);
		}
		System.out.println("\n" + "Totaal: " + TotaalPrijs);
	}

	private static double thePriceIs(double price, int howMany) {
		return (double) Math.round((price * howMany) * 1000d) / 1000d;
	}

	private static void printArray(String[] x, double[] y) {
		for (int i = 0; i < x.length; i++) {
			System.out.println((i + 1) + ": " + x[i] + " " + y[i]);
		}
	}

	private static int pickFromNullToMax(Scanner readme, int max) {
		int choice = 9;
		while (true) {
			choice = getInteger(readme);
			if (!(choice > max || choice <= 0)) {
				break;
			} else {
				System.out.println("min is 1, max is " + max);
			}
		}
		return choice;
	}

	private static int getInteger(Scanner reader) {
		while (!reader.hasNextInt()) {
			System.out.println("That's not an Integer!");
			reader.next();
			System.out.print("Type an integer....  ");
		}
		return reader.nextInt();
	}
}
