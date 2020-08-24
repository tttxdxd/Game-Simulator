package com.tttxdxd.game;

public class Transform {
    public Vector position;
    public Vector size;
    public float rotate;

    public Transform(float x, float y) {
        position = new Vector(x, y);
        size = new Vector(1, 1);
    }

    public Transform(int x, int y) {
        position = new Vector(x, y);
        size = new Vector(1, 1);
    }
}
