/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.net.ServerSocket;
import javax.print.attribute.standard.Severity;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.plaf.basic.BasicTreeUI;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author Admin
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 732;
    public static final int HEIGHT = 468;
    public boolean running;
    public static BufferedImage img_gameover;
    public static BufferedImage background;
    public static Ground ground;
    public static Bird bird;

    public static Button startButton;

    public static int score;
    Thread thread;
    ServerSocket serverSocket;

    public static void main(String[] args) {
        new Window(HEIGHT, WIDTH, "Mèo bay ", new Game());

    }

    public synchronized void start() {
        running = true;
        thread = new Thread();
        thread.start();
        run();
    }

    public void init() {
        addKeyListener(new KeyHandler());
        addMouseListener(new MouseHandler());
        img_gameover = GraphicsLoader.loadGraphics("gameover.png");
        background = GraphicsLoader.loadGraphics("background.png");
        ground = new Ground();
        bird = new Bird(50, 50, 51, 36);
        startButton = new Button(Game.WIDTH / 2 - 156 / 2, 200, 156,, 87, GraphicsLoader.loadGraphics("playbutton.png"));

    }

    public void tick() {
        if (!gameover) {
            ObjectHanler.tick();
            ground.tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;

        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(background, 0, 0, null);
        ground.render(g);

        ObjectHandler.render(g);

        if (gameover) {
            g.drawImage(img_gameover, Game.WIDTH / 2 - 288 / 2, 130, null);
            Game.startButton.render(g);
        }
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.setColor(Color.GREEN);

        String s = Integer.toString(score);
        int textWidth = g.getFontMetrics().stringWidth(s);

        g.drawString(s, Game.WIDTH / 2 - textWidth / 2, 40);

        //g.setColor(Color.CYAN);
        //g.fillRect(0, 0, WIDTH, HEIGHT);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        init();
        this.requestFocus();
        long passTime = System.nanoTime();
        double amountofTick = 60.0;
        double ns = 1000000000 / amountofTick;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - passTime) / ns;
            passTime = now;

            while (delta > 0) {
                tick();
                updates++;
                render();
                frames++;
                delta--;

            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS :" + frames + " | TICKS : " + updates);
                updates = 0;
                frames = 0;

            }

        }
    }
}
