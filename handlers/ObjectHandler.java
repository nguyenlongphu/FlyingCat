/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author User
 */
public class ObjectHandler {
    public static LinkedList<GameObject> list = new LinkedList<GameObject>();
    
    public static void addObject(GameObject o){
        list.add(o);
    }
    public static void removeObject(GameObject o){
        list.remove(o);
    }
    
    public static void render(Graphics g){
        GameObject temp = null;
        
        for(int i=0;i<list.size();i++){
            temp = list.get(i);
            temp.render(g);
        }
    }
    public static void tick(){
        GameObject temp = null;
        
        for(int i=0;i<list.size();i++){
            temp = list.get(i);
            temp.tick();
        }
    }
}
