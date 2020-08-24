package com.tttxdxd.tank;

import com.tttxdxd.game.Engine;
import com.tttxdxd.game.GameObject;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new MainTank(200, 200);

        for (int i = 0; i < 4; i++) {

            new Tank(100+i*100,500);
        }
        Engine.getInstance().Start();
    }
}
