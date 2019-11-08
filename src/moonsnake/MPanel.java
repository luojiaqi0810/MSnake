package moonsnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author LuoJiaQi
 * @Date 2019/11/8
 * @Time 12:02
 */
public class MPanel extends JPanel implements KeyListener, ActionListener {
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
    String fx = "R";

    boolean isStart = false;//开始与否状态
    Timer timer = new Timer(100, this);



    public MPanel() {
        initSnake();//初始化蛇的位置和长度
        this.setFocusable(true);//可以获取焦点
        this.addKeyListener(this);//键盘监听
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        title.paintIcon(this, g, 25, 11);

        g.fillRect(25, 75, 850, 600);

        //画蛇头
        if (fx == "R") {
            right.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx == "L") {
            left.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx == "U") {
            up.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (fx == "D"){
            down.paintIcon(this, g, snakex[0], snakey[0]);
        }

        //设置开始提示
        if (!isStart) {
            g.setColor(Color.WHITE);//设置画笔颜色
            g.setFont(new Font("arial", Font.BOLD, 40));//设置字体
            g.drawString("Press Space to Start", 250, 300);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获取哪个键被按下
        if (keyCode == KeyEvent.VK_SPACE) {
            isStart = !isStart;
            repaint();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        } else if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart) {
            for (int i = len - 1; i > 0; i--) {
                snakex[i] = snakex[i - 1];
                snakey[i] = snakey[i - 1];
            }
            if (fx == "R") {
                snakex[0] = snakex[0] + 25;
                if (snakex[0] > 850) {
                    snakex[0] = 25;
                }
            } else if (fx == "L") {
                snakex[0] = snakex[0] - 25;
                if (snakex[0] < 25) {
                    snakex[0] = 850;
                }
            } else if (fx == "U") {
                snakey[0] = snakey[0] - 25;
                if (snakey[0] < 75) {
                    snakey[0] = 650;
                }
            } else if (fx == "D") {
                snakey[0] = snakey[0] + 25;
                if (snakey[0] > 650) {
                    snakey[0] = 75;
                }
            }



            repaint();
        }
        timer.start();
    }
}