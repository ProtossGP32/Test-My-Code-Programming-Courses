
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public int getSquares() {
        return squares;
    }

    public int getPrincePerSquare() {
        return princePerSquare;
    }

    public int fullPrice() {
        return this.getSquares() * this.getPrincePerSquare();
    }
    public boolean largerThan(Apartment compared) {
        if (this.getSquares() > compared.getSquares()) {
            return true;
        }
        return false;
    }

    public int priceDifference(Apartment compared) {
        return Math.abs(this.fullPrice() - compared.fullPrice());
    }

    public boolean moreExpensiveThan(Apartment compared) {
        if (this.fullPrice() > compared.fullPrice()) {
            return true;
        }
        return false;
    }

}
