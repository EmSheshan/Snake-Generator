import java.util.Random;

public class ID {
    public int addon,tongue,eye,belly,face,markings,colorBody,colorMarking; // the different parameters that are randomized for each snake.
    public ID() {   // Generate a new randomized ID code
        Random rand = new Random();
        addon = rand.nextInt(32)+1;
        tongue = rand.nextInt(2)+1;
        eye = rand.nextInt(4)+1;
        belly = rand.nextInt(5)+1;
        face = rand.nextInt(6)+1;
        markings = rand.nextInt(6)+1;
        colorBody = rand.nextInt(177);
        colorMarking = rand.nextInt(177);
    }   // fun fact: there's over 1.4 billion possible unique snake IDs.
}
