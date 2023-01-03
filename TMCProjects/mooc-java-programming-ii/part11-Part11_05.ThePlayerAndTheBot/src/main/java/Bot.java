import java.util.ArrayList;
import java.util.List;
public class Bot extends Player{
    @Override
    public void play() {
        super.play();
        System.out.println("This is a bot");
    }

    public void addMove(String move) {
        this.printName();
        System.out.println(move);
    }
}
