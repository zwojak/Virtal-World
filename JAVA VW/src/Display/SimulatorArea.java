/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;
import programowanie.obiektowe.proj.WorldManager;
import javax.swing.JPanel;
import java.awt.GridLayout;
/**
 *
 * @author kubaz
 */
public class SimulatorArea extends JPanel{
    
    private WorldFieldJPanel[][] animalMatrix;
    
    private final int sizeX;
    
    private final int sizeY;
    
    public SimulatorArea(int xBeg, int yBeg, WorldManager worldManager){
        sizeX=xBeg;
        sizeY=yBeg;
        setLayout(new GridLayout(xBeg,yBeg,3,3));
        this.animalMatrix= new WorldFieldJPanel[xBeg][yBeg];
        for(int y=0;y<sizeY;y++){
            for(int x=0;x<sizeX;x++){
                animalMatrix[x][y]=new WorldFieldJPanel(x,y,worldManager);
                add(animalMatrix[x][y]);
            }
        }
    }
    
    public void setFieldText(String text, int x, int y){
        animalMatrix[x][y].setText(text);
    }
    
    public void clearArea(){
        for(int i=0;i<sizeY;i++)
        {
            for(int j=0;j<sizeX;j++)
            {
                animalMatrix[j][i].clearField();
            }
        }
    }
    
}