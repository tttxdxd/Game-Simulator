package com.tttxdxd.tank;

import com.tttxdxd.game.GameObject;
import com.tttxdxd.game.Layer;
import com.tttxdxd.game.Sprite;
import com.tttxdxd.game.Vector;

public class Bullet extends GameObject {
    public Bullet(float x, float y) {
        super(x, y);
        this.sprite = new Sprite(new String[]{
                "images/bulletU.gif",
                "images/bulletD.gif",
                "images/bulletL.gif",
                "images/bulletR.gif",
        });
        this.sprite.fitTransform(this.transform);
    }

    public void SetDir(Dir dir) {
        switch (dir) {
            case Up:
                this.rigidBody.velocity = Vector.Up.Clone();
                this.sprite.setIndex(0);
                break;
            case Down:
                this.rigidBody.velocity = Vector.Down.Clone();
                this.sprite.setIndex(1);
                break;
            case Left:
                this.rigidBody.velocity = Vector.Left.Clone();
                this.sprite.setIndex(2);
                break;
            case Right:
                this.rigidBody.velocity = Vector.Right.Clone();
                this.sprite.setIndex(3);
                break;
        }
    }

    @Override
    protected void onCollision(GameObject object) {
        if ((layer == Layer.Player && object.layer == Layer.Enemy)
                || (layer == Layer.Enemy && object.layer == Layer.Player)) {
            this.Destroy();
            object.Destroy();
        }
    }
}
