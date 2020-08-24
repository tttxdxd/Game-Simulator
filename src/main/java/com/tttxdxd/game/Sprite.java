package com.tttxdxd.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    private BufferedImage image;
    private BufferedImage[] images;

    private int index = 0;

    private Transform transform;

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    public Sprite(BufferedImage[] images) {
        this.images = images;
    }

    public Sprite(String url) {
        this.image = ResourceManager.LoadImage(url);
    }

    public Sprite(String[] urls) {
        this.images = new BufferedImage[urls.length];

        for (int i = 0; i < urls.length; i++) {
            this.images[i] = ResourceManager.LoadImage(urls[i]);
        }
    }

    public void fitTransform(Transform transform) {
        this.transform = transform;
        this.setIndex(0);
    }

    public void setIndex(int index) {
        this.index = index % images.length;

        if (transform != null) {
            transform.size = new Vector(images[index].getWidth(), images[index].getHeight());
        }
    }

    public int next() {
        this.setIndex(index + 1);

        return this.index;
    }

    public void Draw(Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
        } else {
            g.drawImage(images[index], x - images[index].getWidth() / 2, y - images[index].getHeight() / 2, null);
        }
    }
}
