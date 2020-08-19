package com.tttxdxd.tank;

import com.tttxdxd.game.Engine;
import com.tttxdxd.game.GameObject;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Tank(200, 200);


        Engine.getInstance().Start();
    }
}
