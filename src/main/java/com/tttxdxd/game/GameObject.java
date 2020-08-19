package com.tttxdxd.game;

import java.awt.*;

public class GameObject {
    public Transform transform;
    public RigidBody rigidBody;

    private boolean active = false;

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

    public void Update(float deltaTime) {
        rigidBody.Update(deltaTime);
        transform.position.Add(rigidBody.velocity);
    }

    public void Draw(Graphics g) {
        int x = (int) (transform.position.x);
        int y = (int) (Engine.getInstance().height - transform.position.y);
        int w = (int) (transform.size.x);
        int h = (int) (transform.size.y);

        g.fillRect(x, y, w, h);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }
}