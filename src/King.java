import static java.lang.Math.abs;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null) {
                   if (!board.board[i][j].getColor().equals(this.getColor()) &&
                       board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                     return true;
                   }
                }
            }
        }
        return false;
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn) ||
            (line == toLine && column == toColumn) ||
            abs(toLine - line) > 1 || abs(toColumn - column) > 1 ||
            (line != toLine && column != toColumn && abs(toLine - line) != abs(toColumn - column))) {
            return false;
        } if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        } else if (this.isUnderAttack(chessBoard, toLine, toColumn)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
