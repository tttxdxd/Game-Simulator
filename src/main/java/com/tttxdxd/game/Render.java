package com.tttxdxd.game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Render extends Frame {
    private Color background = Color.black;
    private Image offScreenImage = null;
    private int width, height;

    public Render(int width, int height) {
        this.width = width;
        this.height = height;

        setTitle("Hello Frame");
        setResizable(false);
        setSize(width, height);
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(width, height);
        }

        Graphics gOffScreen = offScreenImage.getGraphics();
        gOffScreen.setColor(background);
        gOffScreen.fillRect(0, 0, width, height);

        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString(Engine.getInstance().fps + "", 20, 40);

        Engine.getInstance().Draw(g);
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    Engine.getInstance().bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    Engine.getInstance().bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    Engine.getInstance().bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    Engine.getInstance().bR = true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    Engine.getInstance().bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    Engine.getInstance().bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    Engine.getInstance().bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    Engine.getInstance().bR = false;
                    break;
                default:
                    break;
            }
        }
    }
}

