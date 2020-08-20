package com.tttxdxd.game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    private BufferedImage image;

    private int fps = 1;

    public Sprite() {
 
    }

    public void Draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
