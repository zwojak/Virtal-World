/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;
import java.awt.event.*;
import programowanie.obiektowe.proj.Position;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kubaz
 */

public class KeyListenerFrame implements KeyListener{
    
    
    @Override
    public void keyPressed(KeyEvent event){
        Frame father=(Frame)event.getSource();
        switch (event.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                father.dispose();
                return;
                
            case KeyEvent.VK_UP:
                father.getWorldManager().executeTurn(new Position(0,-1));
                break;
                
            case KeyEvent.VK_DOWN:
                father.getWorldManager().executeTurn(new Position(0,1));
                break;
                
            case KeyEvent.VK_LEFT:
                father.getWorldManager().executeTurn(new Position(-1,0));
                break;
                
            case KeyEvent.VK_RIGHT:
                father.getWorldManager().executeTurn(new Position(1,0));
                break;
                
            case KeyEvent.VK_SPACE:
                father.getWorldManager().executeTurn(new Position(0,0));//special ability
                break;
        }
    }
   
    
    @Override
    public void keyReleased(KeyEvent event)
    {
        
    }
    
    @Override
    public void keyTyped(KeyEvent event)
    {
        
    }
}
