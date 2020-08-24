package com.tttxdxd.game;

import com.tttxdxd.tank.Layer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public Transform transform;
    public RigidBody rigidBody;
    public Sprite sprite = null;
    public Layer layer = Layer.Normal;

    private boolean active = false;

    public GameObject(float x, float y) {
        transform = new Transform(x, y);
        rigidBody = new RigidBody();
        Awake();
    }

    public GameObject(int x, int y) {
        transform = new Transform(x, y);
        rigidBody = new RigidBody();
        Awake();
    }

    public void Awake() {
        Engine.getInstance().RegisterGameObject(this);
    }

    public void Destroy() {
        Engine.getInstance().UnregisterGameObject(this);
    }

    public void Start() {

    }

    protected void onCollision(GameObject object){

    }

    public void Update(float deltaTime) {
        rigidBody.Update(deltaTime);
        transform.position.Add(rigidBody.velocity);
    }

    public void Draw(Graphics g) {
        int x = (int) (transform.position.x);
        int y = (int) (Engine.getInstance().height - transform.position.y);
        int w = (int) (transform.size.x);
        int h = (int) (transform.size.y);

        if (sprite == null) {
            g.fillRect(x, y, w, h);
        } else {
            sprite.Draw(g, x, y);
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }
}
