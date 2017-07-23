package game;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import game.bases.Contraints;
import game.bases.GameObject;
import game.enemies.Enemy;
import game.inputs.InputManager;
import game.player.Player;
import game.player.PlayerSpell;
import game.screnes.BackGround;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static sun.misc.PostVMInitHook.run;

/**
 * Created by VALV on 7/9/2017.
 */
public class GameWindow extends JFrame{

    BackGround  backGroud = new BackGround();

    private BufferedImage backBufferImage;

    private Graphics2D backBufferGraphic2D;

    InputManager inputManager = new InputManager();
    public GameWindow(){

        setUpWindow();
//        loadImage();
        addBackground();
        addPlayer();

        addEnemySpawner();

        backBufferImage = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic2D = (Graphics2D) backBufferImage.getGraphics();

        setupInput();
        this.setVisible(true);
    }

    private void addBackground() {
        backGroud = new BackGround();
        backGroud.position.y = this.getHeight();
        GameObject.add(backGroud);
    }

    private void addEnemySpawner() {
        Enemy enemy = new Enemy();
        enemy.position.set(backGroud.renderer.getWidth()/2, 0);
        GameObject.add(enemy);

    }

    private void addPlayer() {
        Player player = new Player();
        player.setContraints(new Contraints(20,this.getHeight(),0,backGroud.renderer.getWidth()));
        player.position.set(backGroud.renderer.getWidth() / 2, this.getHeight() - 50);
        player.setInputManager(inputManager);
        GameObject.add(player);
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyRelease(e);
            }
        });

    }

    long lastUpdateTime;

    public void loop(){
        while (true){

            long  currentTime = System.currentTimeMillis();

            if (currentTime - lastUpdateTime > 17){
                lastUpdateTime = currentTime;
                render();
                run();
            }


        }
    }

    private void run(){
        GameObject.runAll();
    }

    private void render() {
        backBufferGraphic2D.setColor(Color.BLACK);
        backBufferGraphic2D.fillRect(0,0,this.getWidth(),this.getHeight());

        GameObject.renderAll(backBufferGraphic2D);

        Graphics2D g2d = (Graphics2D)this.getGraphics();
        g2d.drawImage(backBufferImage,0,0,null);
    }

    private void setUpWindow() {
        this.setSize(800, 600);

        this.setResizable(false);
        this.setTitle("Touhou - remade by Vũ Cơ");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}