/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Window extends JFrame{

    public Window(int height,int width,String title,Game game)  {
        try {
            game.serverSocket=new ServerSocket(9999);
        } catch (IOException ex) {
            System.out.println("siuuuu");
            System.exit(0);
        }
        
        setTitle(title);
        pack();
        setSize(width +getInsets().left+getInsets().right,height+getInsets().top+getInsets().bottom);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(game);
        game.start();
    }
    
    
    
}
