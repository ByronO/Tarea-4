package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();

        try {
            int x = 0;
            int image = 0;
            while (true) {
                super.setX(x);
                Thread.sleep(5);
                super.setImage(sprite.get(image));
                image++;

                if (image == 7) {
                    image = 0;
                }
                x++;
                if (x == 800) {
                    x = 0;
                }
            }

        } catch (InterruptedException ex) {
        }
    }
}
