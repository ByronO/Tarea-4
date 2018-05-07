package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));

        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();

        int y = 370;
        int image = 2;
        while (true) {
            try {
                Thread.sleep(5);
                this.setY(y);
                image = 0;
                super.setImage(sprite.get(image));
                y--;

                if (y == 200) {
                    image = 1;
                    super.setImage(sprite.get(image));
                    while (y < 370) {
                        this.setY(y);
                        y++;
                        Thread.sleep(5);
                        if (y == 350) {
                            image = 2;
                            super.setImage(sprite.get(image));
                        }
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
