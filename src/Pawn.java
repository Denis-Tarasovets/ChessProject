public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn) || line == toLine) {
            return false;
        } if (chessBoard.board[toLine][toColumn] != null && (chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()) || column == toColumn)) {
            return false;
        } else if (this.color.equals("White")) {
            if ((column == toColumn) && (line + 1 == toLine)) {
                return true;
            } else if ((column == toColumn) && (line == 1) && (toLine == 3)) {
                return true;
            } else if ((column - 1 == toColumn || column + 1 == toColumn) && (line + 1 == toLine)) {
                return true;  // eat
            } else {
                return false;
            }
        } else if (this.color.equals("Black")) {
            if ((column == toColumn) && (line - 1 == toLine)) {
                return true;
            } else if ((column == toColumn) && (line == 6) && (toLine == 4)) {
                return true;
            } else if ((column - 1 == toColumn || column + 1 == toColumn) && (line - 1 == toLine)){
                return true;  // eat
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
