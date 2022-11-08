/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loaders;

import java.io.InputStream;

/**
 *
 * @author User
 */
public class ResourceLoader {
    public static InputStream load(String path){
        InputStream input = ResourceLoader.class.getResourceAsStream(path);
        if(input == null){
            input = ResourceLoader.class.getResourceAsStream("/"+path);
            
        }
        return input;
    }
}
