import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class MyCanvas extends Canvas {

    static ColorList colorList = new ColorList();
    private final static int size = 150;
    private BufferedImage markings,addonColor,face,belly,tongue,shading,eye,lineArt,addon;

    public void createImage(ID id) throws IOException {

        BufferedImage bodyColor = ImageIO.read(new File("assets/basecolor.png"));
        markings = ImageIO.read(new File("assets/marking (" + id.markings + ").png"));
        addon = ImageIO.read(new File("assets/addon" + id.addon + ".png"));
        try {
            addonColor = ImageIO.read(new File("assets/addon" + id.addon + "c.png"));
        } catch (IOException e) {
            addonColor = null;
        }
        face = ImageIO.read(new File("assets/face (" + id.face + ").png"));
        belly = ImageIO.read(new File("assets/belly (" + id.belly + ").png"));
        tongue = ImageIO.read(new File("assets/tonguecolor" + id.tongue + ".png"));
        shading = ImageIO.read(new File("assets/shading.png"));
        eye = ImageIO.read(new File("assets/eye" + id.eye + ".png"));
        lineArt = ImageIO.read(new File("assets/lineart.png"));

        applyColorFilter(bodyColor, id.colorBody);
        applyColorFilter(markings, id.colorMarking);
        if (addonColor != null) {
            applyColorFilter(addonColor, id.colorBody);
        }

        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(bodyColor, 0, 0, this);
        g2d.drawImage(markings, 0, 0, this);
        g2d.drawImage(belly, 0, 0, this);
        g2d.drawImage(face, 0, 0, this);
        g2d.drawImage(tongue, 0, 0, this);
        g2d.drawImage(shading, 0, 0, this);
        g2d.drawImage(eye, 0, 0, this);
        g2d.drawImage(lineArt, 0, 0, this);
        g2d.drawImage(addonColor, 0, 0, this);
        g2d.drawImage(addon, 0, 0, this);
        g2d.dispose();

        try {
            ImageIO.write(bufferedImage, "png", new File(
                    "generatedImages/Noodle_" + (id.colorBody + 1) + "_" + (id.colorMarking + 1) + "_" + id.addon + "_" + id.eye + id.belly + id.face + id.markings + id.tongue + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void applyColorFilter(BufferedImage image, int colorID) {
        WritableRaster raster = image.getRaster();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int[] pixels = raster.getPixel(x, y, (int[]) null);
                pixels[0] = colorList.colorCodes[colorID].getRed();
                pixels[1] = colorList.colorCodes[colorID].getGreen();
                pixels[2] = colorList.colorCodes[colorID].getBlue();
                raster.setPixel(x, y, pixels);
            }
        }
    }
}