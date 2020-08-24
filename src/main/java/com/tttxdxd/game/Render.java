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
        g.drawString("fps: "+Engine.getInstance().fps + "", 20, 40);

        Engine.getInstance().Draw(g);
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Integer code = e.getKeyCode();

            switch (code) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    if (!Engine.getInstance().operations.contains(code)) {
                        Engine.getInstance().operations.add(code);
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    Engine.getInstance().hit=true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            Integer code = e.getKeyCode();

            switch (code) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    Engine.getInstance().operations.remove(code);
                    break;
                case KeyEvent.VK_SPACE:
                    Engine.getInstance().hit = false;
                    break;
                default:
                    break;
            }
        }
    }
}

