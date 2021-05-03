/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;

/**
 *
 * @author kubaz
 */
public class Position {
    
   public int x;
   
   public int y;
   
   public Position(int x, int y){
       this.x=x;
       this.y=y;
   }
   
   public boolean isEqual(Position p)
    {
        if(this.x==p.x && this.y==p.y)return true;
        return false;
    }
}
