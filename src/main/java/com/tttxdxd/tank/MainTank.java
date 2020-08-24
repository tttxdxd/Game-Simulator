package com.tttxdxd.tank;

import com.tttxdxd.game.Engine;
import com.tttxdxd.game.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainTank extends Tank {

    private long fileSpanTime = 300;
    private long _lastFileTime;

    public MainTank(int x, int y) {
        super(x, y);
        this.layer = Layer.Player;
    }

    @Override
    public void Update(float deltaTime) {
        super.Update(deltaTime);

        Engine engine = Engine.getInstance();

        if (engine.operations.isEmpty()) {
            this.rigidBody.velocity = Vector.Zero.Clone();
        } else {
            Integer code = engine.operations.get(engine.operations.size() - 1);

            switch (code) {
                case KeyEvent.VK_UP:
                    this.rigidBody.velocity = Vector.Up.Clone().Mul(this.speed);
                    this.dir = Dir.Up;
                    this.sprite.setIndex(0);
                    break;
                case KeyEvent.VK_DOWN:
                    this.rigidBody.velocity = Vector.Down.Clone().Mul(this.speed);
                    this.dir = Dir.Down;
                    this.sprite.setIndex(1);
                    break;
                case KeyEvent.VK_LEFT:
                    this.rigidBody.velocity = Vector.Left.Clone().Mul(this.speed);
                    this.dir = Dir.Left;
                    this.sprite.setIndex(2);
                    break;
                case KeyEvent.VK_RIGHT:
                    this.rigidBody.velocity = Vector.Right.Clone().Mul(this.speed);
                    this.dir = Dir.Right;
                    this.sprite.setIndex(3);
                    break;
                default:
                    break;
            }
        }


        if (Engine.getInstance().hit) {
            long now = System.currentTimeMillis();

            if (_lastFileTime + fileSpanTime < now) {
                _lastFileTime = now;
                this.fire();
                System.out.println(_lastFileTime);
            }
        }
    }

    @Override
    public void Draw(Graphics g) {
        super.Draw(g);

        g.drawString("pos: (" + transform.position.x + ", " + transform.position.y + ")", 20, 80);
    }
}
