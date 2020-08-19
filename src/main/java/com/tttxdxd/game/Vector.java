package com.tttxdxd.game;

public class Vector {
    public float x;
    public float y;

    public Vector() {
        this(0, 0);
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector Add(Vector ano) {
        this.x += ano.x;
        this.y += ano.y;
        return this;
    }

    public Vector Mul(float val) {
        this.x *= val;
        this.y *= val;
        return this;
    }

    public Vector Clone() {
        return new Vector(x, y);
    }

    public final static Vector Zero = new Vector();
    public final static Vector Left = new Vector(-1, 0);
    public final static Vector Right = new Vector(1, 0);
    public final static Vector Up = new Vector(0, 1);
    public final static Vector Down = new Vector(0, -1);
}
