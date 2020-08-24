package com.tttxdxd.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class ResourceManager {

    public static BufferedImage LoadImage(String url) {
        BufferedImage res = null;

        try {
            InputStream resourceAsStream = ResourceManager.class.getClassLoader().getResourceAsStream(url);

            if (resourceAsStream == null) {
                res = null;
            } else {
                res = ImageIO.read(resourceAsStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
