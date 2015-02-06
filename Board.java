class Board {
	private Tile[][] board;

	Board(String[] rows) {
		this.board = new Tile[rows.length][rows.length];
		int j;
		for (int i = 0; i < rows.length; i++) {
			for (j = 0; j < rows.length; j++) this.board[i][j] = Tile.fromChar(rows[i].charAt(j));
		}
	}

	private Tile getAt(int i, int j) {
		if (i < 0 || i > this.board.length - 1 || j < 0 || j > this.board.length - 1) return Tile.EMPTY;
		return this.board[i][j];
	}
	public int fillTriples() {
		int changes = 0;
		for (int i = 0, j; i < this.board.length; i++) {
			for (j = 0; j < this.board.length; j++) {
				if (!this.board[i][j].equals(Tile.EMPTY)) continue;
				if (!this.getAt(i, j - 1).equals(Tile.EMPTY)) {
					if (this.getAt(i, j - 1).equals(this.getAt(i, j + 1)) || this.getAt(i, j - 1).equals(this.getAt(i, j - 2))) {
						this.board[i][j] = this.board[i][j - 1].inverse();
						changes++;
						continue;
					}
				}
				if (!this.getAt(i - 1, j).equals(Tile.EMPTY)) {
					if (this.getAt(i - 1, j).equals(this.getAt(i + 1, j)) || this.getAt(i - 1, j).equals(this.getAt(i - 2, j))) {
						this.board[i][j] = this.board[i - 1][j].inverse();
						changes++;
						continue;
					}
				}
				if (!this.getAt(i, j + 1).equals(Tile.EMPTY)) {
					if (this.getAt(i, j + 1).equals(this.getAt(i, j + 2))) {
						this.board[i][j] = this.board[i][j + 1].inverse();
						changes++;
						continue;
					}
				}
				if (!this.getAt(i + 1, j).equals(Tile.EMPTY)) {
					if (this.getAt(i + 1, j).equals(this.getAt(i + 2, j))) {
						this.board[i][j] = this.board[i + 1][j].inverse();
						changes++;
					}
				}
			}
		}
		return changes;
	}
	public int completeMissing() {
		int changes = 0;
		int r, b;
		Tile fillTile;
		for (int i = 0, j; i < this.board.length; i++) {
			r = 0;
			b = 0;
			for (j = 0; j < this.board.length; j++) {
				if (this.board[i][j].equals(Tile.RED)) r++;
				else if (this.board[i][j].equals(Tile.BLUE)) b++;
			}
			System.out.println(new Integer(r).toString() + new Integer(b).toString());
			fillTile = Tile.EMPTY;
			if (r == 5 && b != 5) fillTile = Tile.BLUE;
			else if (b == 5 && r != 5) fillTile = Tile.RED;
			if (!fillTile.equals(Tile.EMPTY)) {
				for (j = 0; j < this.board.length; j++) {
					if (this.board[i][j].equals(Tile.EMPTY)) {
						this.board[i][j] = fillTile;
						changes++;
					}
				}
			}
		}
		for (int i = 0, j; i < this.board.length; i++) {
			r = 0;
			b = 0;
			for (j = 0; j < this.board.length; j++) {
				if (this.board[j][i].equals(Tile.RED)) r++;
				else if (this.board[j][i].equals(Tile.BLUE)) b++;
			}
			fillTile = Tile.EMPTY;
			if (r == 5 && b != 5) fillTile = Tile.BLUE;
			else if (b == 5 && r != 5) fillTile = Tile.RED;
			if (!fillTile.equals(Tile.EMPTY)) {
				for (j = 0; j < this.board.length; j++) {
					if (this.board[j][i].equals(Tile.EMPTY)) {
						this.board[j][i] = fillTile;
						changes++;
					}
				}
			}
		}
		return changes;
	}
	public String toString() {
		String result = "";
		for (int i = 0, j; i < this.board.length; i++) {
			for (j = 0; j < this.board.length; j++) result += this.board[i][j].toString();
			if (i != this.board.length - 1) result += "\n";
		}
		return result;
	}
}