/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supers;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public abstract class GameObject {

    protected int x;
    protected int y;
    protected int height;
    protected int weight;
    
    protected float velX;
    protected float velY;

    public GameObject(int x, int y, int height, int weight) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.weight = weight;
       
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public Rectangle getBounds ()
    {
        return new Rectangle(x, y, weight, height);
        
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }
    
    

   
    
    
    
    
    
    

}
