public class Snake {
    public int lenght = 3;//*
    public int direction = 3;//*
    public static int snakeX[] = new int[640];
    public static int snakeY[] = new int[640];
    public Snake(int x1, int y1, int x2, int y2) {
        snakeX[0] = x1;
        snakeX[1] = x2;
        snakeY[0] = y1;
        snakeY[1] = y2;
    }
    public void move() {
        for (int l = lenght; l > 0; l--) {
            snakeX[l] = snakeX[l - 1];
            snakeY[l] = snakeY[l - 1];
        }
        if (direction == 0) snakeY[0]--;//up
        if (direction == 1) snakeY[0]++;//down
        if (direction == 2) snakeX[0]--;//left
        if (direction == 3) snakeX[0]++;//right
    }
}

