import java.util.ArrayList;
import java.util.Scanner;

class ohhi {
	public static void main(String[] args) {
		int rowcount = 0;
		int totalrows = 1;
		String[] rows = new String[0];
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		String input;
		while (rowcount < totalrows) {
			input = scanner.next();
			if (rowcount == 0) {
				totalrows = input.length();
				rows = new String[totalrows];
			}
			rows[rowcount] = input;
			rowcount++;
		}
		scanner.close();
		Board board = new Board(rows);
		int changes = 1;
		while (changes != 0) {
			changes = board.fillTriples();
			changes += board.completeMissing();
		}
		System.out.println(board);
	}
}