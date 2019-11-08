package moonsnake;

import javax.swing.*;
import java.awt.*;

/**
 * @author LuoJiaQi
 * @Date 2019/11/8
 * @Time 12:02
 */
public class MPanel extends JPanel {
    public MPanel() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.GREEN);
    }
}