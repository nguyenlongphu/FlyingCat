/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author User
 */
public class GraphicsLoader {
    public static BufferedImage loadGraphics(String path){
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(ResourceLoader.load("/" + path));
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return image;
    }
}
