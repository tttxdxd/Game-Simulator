package com.tttxdxd.tank;

import com.tttxdxd.game.Engine;
import com.tttxdxd.game.GameObject;
import com.tttxdxd.game.Vector;

public class Tank extends GameObject {

    public Tank(int x, int y) {
        super(x, y);
        this.transform.size = new Vector(20, 20);
    }

    @Override
    public void Update(float deltaTime) {
        super.Update(deltaTime);

        Engine engine = Engine.getInstance();

        if (!engine.bL && !engine.bR && !engine.bU && !engine.bD) {
            rigidBody.velocity = Vector.Zero.Clone();
            return;
        }

        if (engine.bL) {
            rigidBody.velocity = Vector.Left.Clone();
        } else if (engine.bR) {
            rigidBody.velocity = Vector.Right.Clone();
        } else if (engine.bU) {
            rigidBody.velocity = Vector.Up.Clone();
        } else if (engine.bD) {
            rigidBody.velocity = Vector.Down.Clone();
        }
    }
}
