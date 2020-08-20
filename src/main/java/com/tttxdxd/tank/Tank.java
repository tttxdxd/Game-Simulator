package com.tttxdxd.tank;

import com.tttxdxd.game.Engine;
import com.tttxdxd.game.GameObject;
import com.tttxdxd.game.Vector;

import java.awt.event.KeyEvent;

public class Tank extends GameObject {

    private boolean moving = false;
    private Dir dir = Dir.Up;

    public Tank(int x, int y) {
        super(x, y);
        this.transform.size = new Vector(20, 20);
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
                    this.rigidBody.velocity = Vector.Up.Clone();
                    break;
                case KeyEvent.VK_DOWN:
                    this.rigidBody.velocity = Vector.Down.Clone();
                    break;
                case KeyEvent.VK_LEFT:
                    this.rigidBody.velocity = Vector.Left.Clone();
                    break;
                case KeyEvent.VK_RIGHT:
                    this.rigidBody.velocity = Vector.Right.Clone();
                    break;
                default:
                    break;
            }
        }
    }
}
