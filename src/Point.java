public class Point {
    public int posY;
    public int posX;

    public Point(int x, int y) {
        posX = x;
        posY = y;
    }

    public void setRandomLocation() {
        posX = Math.abs((int) (Math.random() * Main.WIDTH - 1));
        posY = Math.abs((int) (Math.random() * Main.HEIGHT - 1));
    }

}
