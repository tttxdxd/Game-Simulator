package com.tttxdxd.tank;

import com.tttxdxd.game.Animation;
import com.tttxdxd.game.GameObject;

import java.awt.*;

public class Explode extends GameObject {

    private long _explodeTime;
    private int fps = 16;
    private long _fpsTimeSpan;

    public Explode(float x, float y) {
        super(x, y);
        this.sprite = new Animation(new String[]{
                "images/e1.gif",
                "images/e2.gif",
                "images/e3.gif",
                "images/e4.gif",
                "images/e5.gif",
                "images/e6.gif",
                "images/e7.gif",
                "images/e8.gif",
                "images/e9.gif",
                "images/e10.gif",
                "images/e11.gif",
                "images/e12.gif",
                "images/e13.gif",
                "images/e14.gif",
                "images/e15.gif",
                "images/e16.gif",
        });

        _explodeTime = System.currentTimeMillis();
        _fpsTimeSpan = 1000 / fps;
    }

    @Override
    public void Draw(Graphics g) {
        super.Draw(g);

        long now = System.currentTimeMillis();
        if (now - _explodeTime > _fpsTimeSpan) {
            _explodeTime = now;
            if (this.sprite.next() == 0) {
                this.Destroy();
            }
        }
    }
}
