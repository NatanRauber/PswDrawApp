package models;

public class Point {
    public float x;
    public float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distance(float x, float y) {
        return (float) Math.sqrt(((this.x - x) * (this.x - x)) + ((this.y - y) * (this.y - y)));
    }
}
