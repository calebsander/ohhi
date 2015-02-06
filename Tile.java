class Tile {
	private boolean empty;
	private boolean blue;

	private Tile(boolean empty) {
		this.empty = empty;
	}
	private Tile(boolean empty, boolean blue) {
		this.empty = empty;
		this.blue = blue;
	}

	public static Tile fromChar(char rep) {
		switch (rep) {
			case 'R':
				return Tile.RED;
			case 'B':
				return Tile.BLUE;
			default:
				return Tile.EMPTY;
		}
	}
	public String toString() {
		if (this.empty) return " ";
		if (this.blue) return "B";
		return "R";
	}
	public boolean equals(Tile tile) {
		if (this.empty != tile.empty) return false;
		if (this.empty && tile.empty) return true;
		if (this.blue == tile.blue) return true;
		return false;
	}
	public Tile inverse() {
		if (this.blue) return Tile.RED;
		return Tile.BLUE;
	}

	public static final Tile EMPTY = new Tile(true);
	public static final Tile RED = new Tile(false, false);
	public static final Tile BLUE = new Tile(false, true);
}