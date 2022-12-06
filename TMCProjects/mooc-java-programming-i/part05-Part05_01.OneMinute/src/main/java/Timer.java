public class Timer {
    private ClockHand hundreths;
    private ClockHand seconds;

    public Timer() {
        this.hundreths = new ClockHand(100);
        this.seconds = new ClockHand(60);
    }

    public void advance() {
        hundreths.advance();
        if (hundreths.value() == 0) {
            seconds.advance();
        }
    }
    public String toString() {
        return this.seconds + ":" + this.hundreths;
    }
}
