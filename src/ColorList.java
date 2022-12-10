import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Color;

public class ColorList {

    public static Color[] colorCodes = new Color[177];

    public ColorList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("assets/colorCodes.txt"));
            String line;
            int counter = 0;
            while (((line = reader.readLine()) != null) && (counter < 177)) {
                colorCodes[counter] = Color.decode(line);
                counter++;
            }
            reader.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
