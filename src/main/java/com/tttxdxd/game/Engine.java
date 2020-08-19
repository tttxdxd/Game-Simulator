package com.tttxdxd.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    public static Engine instance = new Engine();

    public static Engine getInstance() {
        return instance;
    }

    private Engine() {
        this.width = 800;
        this.height = 600;
        render = new Render(width, height);
    }

    private Render render;

    public int width, height;
    public boolean bL, bR, bU, bD;
    public float fps = 60;
    public boolean fixed = false;

    private long now = System.currentTimeMillis();

    private List<GameObject> gameObjectList = new ArrayList<>();

    public void Start() throws InterruptedException {

        while (true) {
            long time = System.currentTimeMillis();
            float span = (time - now) * 0.001f;

            fps = 1 / span;
            update(span);
            render.repaint();
            now = time;
            Thread.sleep(1);
        }
    }

    private void update(float deltaTime) {

        for (int i = gameObjectList.size() - 1; i >= 0; i--) {
            GameObject object = gameObjectList.get(i);

            object.Update(deltaTime);
            if (!object.getActive()) {
                gameObjectList.remove(i);
            }
        }
    }

    public void Draw(Graphics g) {
        for (int i = gameObjectList.size() - 1; i >= 0; i--) {
            GameObject object = gameObjectList.get(i);

            object.Draw(g);
        }
    }

    public void RegisterGameObject(GameObject object) {
        object.setActive(true);
        gameObjectList.add(object);
    }

    public void UnregisterGameObject(GameObject object) {
        object.setActive(false);
    }
}
