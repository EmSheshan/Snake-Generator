import java.io.IOException;

public class MainMaker {

    public static void main(String[] args) throws IOException {
        MyCanvas canvas = new MyCanvas();
        int numSnakes = 100;  // the number of snakes to be generated and saved to generatedImages.
        for (int i = 0; i < numSnakes; i++) {
            canvas.createImage(new ID());
        }
    }
}
