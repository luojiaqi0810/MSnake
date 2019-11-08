package moonsnake;

import javax.swing.*;
import java.awt.*;

/**
 * @author LuoJiaQi
 * @Date 2019/11/8
 * @Time 12:02
 */
public class MPanel extends JPanel {
    String path = "src/resource/";

    ImageIcon title = new ImageIcon(path + "title.jpg");
    ImageIcon body = new ImageIcon(path + "body.png");
    ImageIcon up = new ImageIcon(path + "up.png");
    ImageIcon down = new ImageIcon(path + "down.png");
    ImageIcon left = new ImageIcon(path + "left.png");
    ImageIcon right = new ImageIcon(path + "right.png");
    ImageIcon food = new ImageIcon(path + "food.png");


    int len = 3;
    int[] snakex = new int[750];
    int[] snakey = new int[750];
    String fx = "L";



    public MPanel() {
        initSnake();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        title.paintIcon(this, g, 25, 11);

        g.fillRect(25, 75, 850, 600);

        if (fx == "R") {
            right.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx == "L") {
            left.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx == "U") {
            up.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx == "D"){
            down.paintIcon(this, g, snakex[0], snakey[0]);
        }


        for (int i = 0; i < len; i++) {
            body.paintIcon(this, g, snakex[i], snakey[i]);
        }
    }

    public void initSnake() {
        len = 3;
        snakex[0] = 100;
        snakey[0] = 100;
        snakex[1] = 75;
        snakey[1] = 100;
        snakex[2] = 50;
        snakey[2] = 100;
    }
}