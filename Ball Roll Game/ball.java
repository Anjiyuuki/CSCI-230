// Angie Bui,Buia@g.cofc.edu
// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
// Status: // Enter n, x, y, in the argument to run program
// This code is 100% tested and correct
//
import java.util.*;
public class ball {
	public static void main(String[] args) {
		//random location of spaces
		Random random = new Random();
		
		//play area 
		int n = Integer.parseInt(args[0]);

		
		//this create boardLayout 2 times rows 
		//1 row for " " or = sign
		//other row for the ball "O"
		char[][] boardLayout = new char[n * 2][n];

		
		// x percentage of space
		int x = Integer.parseInt(args[1]);
		
		// y percentage of equals
		int y = Integer.parseInt(args[2]);

		// total spaces
		int totalSpaces = (int) ( (x/100.0) * (n*n));

		// total equals
		int totalEquals = (n * n) - totalSpaces;

		
		//iterate over row and column of boardLayout
		for (int i = 0; i < boardLayout.length; i++) {
			for (int j = 0; j < boardLayout[i].length; j++) {
				//fill the spaces of row with 0 in even indexes
				if (i % 2 == 0) {
					boardLayout[i][j] = ' ';
				} else {
					//row odd indexes : randomly generate a space 
					// or equal at current column of current row
					boolean hasSpace = random.nextInt(totalSpaces + totalEquals) < totalSpaces;
					if (hasSpace) {
						if (totalSpaces > 0) {
							boardLayout[i][j] = ' ';
							totalSpaces--;
						} else if (totalEquals > 0) {
							boardLayout[i][j] = '=';
							totalEquals--;
						}
					} else {
						if (totalEquals > 0) {
							boardLayout[i][j] = '=';
							totalEquals--;
						} else {
							boardLayout[i][j] = ' ';
							totalSpaces--;
						
						}
					}
				}

			}
		}
	

		
		//roll the ball on the boardLayout 1-0 loc
		int i = 1, j = 0;

		//iterate over the boardLayout until all rows are covered
		//or the ball reaches the end of boardLayout horizontally
		while (i < boardLayout.length && j < boardLayout.length / 2) {

			//iterate over each row horizontally
			while (j < boardLayout.length / 2) {
				
				//if current row and column is empty
				//drop the ball to the next row
				if (boardLayout[i][j] == ' ') {
					//create O and goto the next row
					boardLayout[i - 1][j] = 'O';
					boardLayout[i][j] = 'O';
					i = i + 2;
					break;
				} else {
					// SEES 'O' 
					// move the ball horizontally
					boardLayout[i - 1][j] = 'O';
					j++;
				}

			}
		}

		printboardLayout(boardLayout);

	}

	public static void printboardLayout(char[][] boardLayout) {
		for (int i = 0; i < boardLayout.length; i++) {
			for (int j = 0; j < boardLayout[i].length; j++) {
				System.out.print(boardLayout[i][j] + " ");
			}
			System.out.println();
		}
	}

}

	
