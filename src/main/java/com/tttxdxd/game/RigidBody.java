package com.tttxdxd.game;

public class RigidBody {
    public float mass;
    public Vector velocity = new Vector();
    public Vector acceleration = new Vector();

    public RigidBody() {

    }

    public void AddForce() {

    }

    public void Update(float deltaTime) {
        velocity.Add(acceleration.Clone().Mul(deltaTime));
    }
}
