import static java.lang.Math.abs;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn) ||
                line == toLine || column == toColumn || abs(toLine - line) != abs(toColumn - column)) {
            return false;
        } if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        } else {
            int dx = toColumn > column ? 1 : - 1;
            int dy = toLine > line ? 1 : -1;
            int x = column;
            int y = line;

            while(true) {
                x = x + dx;
                y = y + dy;
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

    @Override
    public String getSymbol() {
        return "B";
    }
}
