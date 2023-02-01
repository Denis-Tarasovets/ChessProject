public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn) ||
                (line == toLine && column == toColumn)) {
            return false;
        } if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        } else {
            int dx, dy;
            int x = column;
            int y = line;

            if (toColumn == column)
                dx = 0;
            else
                dx = toColumn > column ? 1 : - 1;

            if (toLine == line)
                dy = 0;
            else
                dy = toLine > line ? 1 : -1;

            if (dx != 0 && dy != 0) { // move only by one axis
                return false;
            } else {
                while(true) {
                    x = x + dx;
                    y = y + dy;  // TO_DO: add existing ChessPiece check
                    if (!chessBoard.checkPos(x) || !chessBoard.checkPos(y)) {
                        return false;
                    } else if (x == toColumn && y == toLine) {
                        return true; // eat or empty cell
                    } else if (chessBoard.board[y][x] != null) {
                        return false;  // non-empty cell on path
                    }
                }
            }
        }
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
