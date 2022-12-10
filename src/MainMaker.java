import java.io.IOException;

public class MainMaker {

    public static void main(String[] args) throws IOException {

        MyCanvas m = new MyCanvas();

        int numSnakes = 100;

        for (int i = 0; i < numSnakes; i++) {
            m.createImage(new ID());
        }
    }
}
