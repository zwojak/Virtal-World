/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;
import programowanie.obiektowe.proj.WorldManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author kubaz
 */
public class MouseMenu extends MouseAdapter{
    
    private int x;
    
    private int y;
    
    private WorldManager worldManager;
    
    public MouseMenu(int x, int y, WorldManager worldManager){
        this.worldManager=worldManager;
        this.x=x;
        this.y=y;
    }
    
    @Override
    public void mouseClicked(MouseEvent event)
    {
        if(MouseEvent.BUTTON3==event.getButton()){
            RightClickPopUp menu=new RightClickPopUp(x,y,worldManager);
            menu.show(event.getComponent(),event.getX(),event.getY());
        }
        if(MouseEvent.BUTTON1==event.getButton()){
            LeftClickPopUp menu=new LeftClickPopUp(x,y,worldManager);
            menu.show(event.getComponent(),event.getX(),event.getY());
        }
    }
    
}
