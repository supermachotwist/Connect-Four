import java.util.*;
public class ConnectFour {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		char[][] board = createBoard();
		int playerTurn = 0; //player 0 is red, 1 is yellow
		System.out.println("Red player goes first");
		while (!checkWinner(board)) {
			try {
				if (playerTurn == 0) {
					showBoard(board);
					System.out.print("Drop a red disk at column (0 - 6):");
					placeRed(board, stdin.nextInt());
					playerTurn = 1;
				}
				else if (playerTurn == 1) {
					showBoard(board);
					System.out.print("Drop a yellow disk at column (0 - 6):");
					placeYellow(board, stdin.nextInt());
					playerTurn = 0;
				}
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Column is full or out of bounds, please try again");
			}
			catch (InputMismatchException e) {
				System.out.println("Incorrect input, please try again");
				stdin.next();
			}
		}
		showBoard(board);
		if (playerTurn == 0) {
			System.out.println("Yellow player wins");
		}
		else if (playerTurn == 1) {
			System.out.println("Red player wins");
		}

	}
	
	public static boolean checkWinner(char[][] m) {
		boolean winner = false;
		int red = 0;
		int yellow = 0;
		for (int r = 0; r < 6; r++) { // check horizontal
			red = 0;
			yellow = 0;
			for (int c = 0; c < 7; c++) {
				if (m[r][c] == 'R') {
					red++;
					yellow = 0;
				}
				else if (m[r][c] == 'Y') {
					yellow++;
					red = 0;
				}
				if(red == 4 | yellow == 4) {
					winner = true;
				}
			}
		}
		for (int c = 0; c < 7; c++) { //check vertical
			red = 0;
			yellow = 0;
			for (int r = 0; r < 6; r++) {
				if (m[r][c] == 'R') {
					red++;
					yellow = 0;
				}
				else if (m[r][c] == 'Y') {
					yellow++;
					red = 0;
				}
				if(red == 4 | yellow == 4) {
					winner = true;
				}
			}
		}
		for (int r = 0; r < 6; r++) { //check minor diagonal direction (left column)
			red = 0;
			yellow = 0;
			int i = 0;
			for (int c = 0; c <= r ; c++) {
				if (m[r - i][c] == 'R') {
					red++;
					yellow = 0;
				}
				else if (m[r - i][c] == 'Y') {
					yellow++;
					red = 0;
				}
				if(red == 4 | yellow == 4) {
					winner = true;
				}
				i++;
			}
		}
		for (int r = 0; r < 6; r++) { //check minor diagonal direction along right column
			red = 0;
			yellow = 0;
			int i = 0;
			for (int c = 5; c >= r ; c--) {
				if (m[r + i][c] == 'R') {
					red++;
					yellow = 0;
				}
				else if (m[r + i][c] == 'Y') {
					yellow++;
					red = 0;
				}
				if(red == 4 | yellow == 4) {
					winner = true;
				}
				i++;
			}
		}
		for (int r = 0; r < 6; r++) { //check major diagonal direction along left column
			red = 0;
			yellow = 0;
			int i = 0;
			for (int c = 0; c <= 5 - r ; c++) {
				if (m[r + i][c] == 'R') {
					red++;
					yellow = 0;
				}
				else if (m[r + i][c] == 'Y') {
					yellow++;
					red = 0;
				}
				if(red == 4 | yellow == 4) {
					winner = true;
				}
				i++;
			}
		}
		for (int r = 0; r < 6; r++) { //check major diagonal direction along right column
			red = 0;
			yellow = 0;
			int i = 0;
			for (int c = 5; c >= 5 - r ; c--) {
				if (m[r - i][c] == 'R') {
					red++;
					yellow = 0;
				}
				else if (m[r - i][c] == 'Y') {
					yellow++;
					red = 0;
				}
				if(red == 4 | yellow == 4) {
					winner = true;
				}
				i++;
			}
		}
		return winner;
	}
	
	public static void placeRed(char[][] m, int c) throws IndexOutOfBoundsException {
		int r = 5;
		while (r >= -1) {
				if (m[r][c] == ' ') {
					m[r][c] = 'R';
					break;
				}
				r--;
		}
	}
	
	public static void placeYellow(char[][] m, int c) throws IndexOutOfBoundsException {
		int r = 5;
		while (r >= -1) {
				if (m[r][c] == ' ') {
					m[r][c] = 'Y';
					break;
				}
				r--;
		}
	}
	
	public static char[][] createBoard() {
		char[][] board = new char[6][7];
		for (int r = 0; r < 6; r ++) {
			for (int c = 0; c < 7; c++) {
				board[r][c] = ' ';
			}
		}
		return board;
	}
	
	public static void showBoard(char[][] m) {
		for (int r = 0; r < 6; r ++) {
			System.out.print("|");
			for (int c = 0; c < 7; c++) {
				System.out.print(m[r][c] + "|");;
			}
			System.out.print("\n");
		}
	}

}
