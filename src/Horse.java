public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) {
            return false;
        } if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        } else if ((column - 2 == toColumn) && ((line - 1 == toLine) || (line + 1 == toLine))) {        // left
            return true;
        } else if ((column + 2 == toColumn) && ((line - 1 == toLine) || (line + 1 == toLine))) { // right
            return true;
        } else if ((line + 2 == toLine) && ((column - 1 == toColumn) || (column + 1 == toColumn))) { // top
            return true;
        } else if ((line - 2 == toLine) && ((column - 1 == toColumn) || (column + 1 == toColumn))) { // bottom
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
