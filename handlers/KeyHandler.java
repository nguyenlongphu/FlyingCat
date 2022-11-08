/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author User
 */
public class KeyHandler implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_SPACE){
          Game.bird.setVelY(-5);
      }
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
