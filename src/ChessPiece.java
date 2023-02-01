public abstract class ChessPiece {
    String color;
    boolean check;

    public ChessPiece(String color) {
        this.color = color;
        this.check = true;
    }

    public abstract String getColor(); // why abstract?
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
}
