import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main extends JPanel implements ActionListener {
    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;
    public static int speed = 10;
    public static int different = 0;
    public static int color = 1;
    public static Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};

    Snake snake = new Snake(5, 6, 5, 5);
    Timer timer = new Timer(1000 / speed, this);
    Point point = new Point(Math.abs((int) (Math.random() * Main.WIDTH - 1)),
            Math.abs((int) (Math.random() * Main.HEIGHT - 1)));

    public Main() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public static void run() {
        jFrame = new JFrame("Игра Змейка");
        jFrame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.add(new Main());
        jFrame.setLocationRelativeTo(null);
    }

    public void close() {
        showMessageDialog(null, "Вы проиграли");
        jFrame.dispose();
        timer.stop();
    }

    public void closeWin() {
        if (snake.lenght == 360) {
            showMessageDialog(null, "Поздравляю, Вы выиграли!");
            jFrame.dispose();
            timer.stop();
        }
        if ((snake.lenght == 360) && (different != 0)) {
            showMessageDialog(null, "Что ты такое?О_о\n" +
                    "Тащить - твое призвание");
            jFrame.dispose();
            timer.stop();

        }
    }

    public void paint(Graphics g) {
        {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

            for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
                g.setColor(Color.gray);
                g.drawLine(x, 0, x, HEIGHT * SCALE);
            }

            for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
                g.setColor(Color.gray);
                g.drawLine(0, y, WIDTH * SCALE, y);
            }
        }
        g.setColor(Color.YELLOW);
        g.fillOval(point.posX * SCALE + 4, point.posY * SCALE + 4,
                SCALE - 8, SCALE - 7);

        for (int l = 0; l < snake.lenght; l++) {
            g.setColor(Color.white);
            g.fillRect(snake.snakeX[0] * SCALE + 4, snake.snakeY[0] * SCALE + 4,
                    SCALE - 6, SCALE - 6);
            g.setColor(colors[color]);
            g.fillRect(snake.snakeX[l] * SCALE + 4, snake.snakeY[l] * SCALE + 4,
                    SCALE - 6, SCALE - 6);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        differentMove(different);
        if ((snake.snakeX[0] == point.posX) && (snake.snakeY[0] == point.posY)) {
            point.setRandomLocation();
            snake.lenght++;
            closeWin();
        }
        for (int l = 1; l < snake.lenght; l++) {
            if ((snake.snakeX[l] == point.posX) && (snake.snakeY[l] == point.posY)) {
                point.setRandomLocation();
            }
            if ((snake.snakeX[0] == snake.snakeX[l]) && (snake.snakeY[0] == snake.snakeY[l])) {
                close();
            }
            repaint();
        }
    }

    public void differentMove(int x) {
        if (x != 0) {
            if ((Snake.snakeY[0] > Main.WIDTH) || (Snake.snakeY[0] < 0) ||
                    (Snake.snakeX[0] > Main.HEIGHT) || (Snake.snakeX[0] < 0)) {
                close();
            }
        } else {
            if (snake.snakeY[0] > Main.WIDTH - 1) snake.snakeY[0] = 0;
            if (snake.snakeY[0] < 0) snake.snakeY[0] = Main.WIDTH;
            if (snake.snakeX[0] > Main.HEIGHT - 1) snake.snakeX[0] = 0;
            if (snake.snakeX[0] < 0) snake.snakeX[0] = Main.HEIGHT;
        }
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();
            if ((key == KeyEvent.VK_W || key == KeyEvent.VK_UP) && (snake.direction != 1)) snake.direction = 0;
            if ((key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) && (snake.direction != 0)) snake.direction = 1;
            if ((key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) && (snake.direction != 3)) snake.direction = 2;
            if ((key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) && (snake.direction != 2)) snake.direction = 3;
        }

    }

}
