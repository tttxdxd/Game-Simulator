package com.tttxdxd.tank;

import com.tttxdxd.game.*;

public class Tank extends GameObject {

    protected boolean moving = false;
    protected Dir dir = Dir.Up;
    protected float speed = 0.5f;

    public Tank(int x, int y) {
        super(x, y);
        this.sprite = new Sprite(new String[]{
                "images/tankU.gif",
                "images/tankD.gif",
                "images/tankL.gif",
                "images/tankR.gif",
        });
        this.sprite.fitTransform(this.transform);
        this.layer = Layer.Enemy;
    }

    public void fire() {
        Vector pos = transform.position.Clone();

        switch (dir) {
            case Up:
                pos.Add(Vector.Up.Clone().Mul(30));
                break;
            case Down:
                pos.Add(Vector.Down.Clone().Mul(30));
                break;
            case Left:
                pos.Add(Vector.Left.Clone().Mul(30));
                break;
            case Right:
                pos.Add(Vector.Right.Clone().Mul(30));
                break;
        }

        Bullet bullet = new Bullet(pos.x, pos.y);

        bullet.layer = this.layer;
        bullet.SetDir(dir);
    }

    @Override
    public void Destroy() {
        super.Destroy();
        new Explode(transform.position.x, transform.position.y);
    }

    @Override
    public void onUpdate(float deltaTime) {
        if (transform.position.x <= transform.size.x/2) {
            rigidBody.velocity.x = Math.max(0, rigidBody.velocity.x);
        }

        if (transform.position.y <= transform.size.y/2) {
            rigidBody.velocity.y = Math.max(0, rigidBody.velocity.y);
        }

        if (transform.position.x + transform.size.x/2 >= Engine.getInstance().width) {
            rigidBody.velocity.x = Math.min(0, rigidBody.velocity.x);
        }

        if (transform.position.y + transform.size.y >= Engine.getInstance().height) {
            rigidBody.velocity.y = Math.min(0, rigidBody.velocity.y);
        }
    }
}
