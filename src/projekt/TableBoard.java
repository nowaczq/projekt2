/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projekt;

/**
 *
 * @author Mateusz
 */
public class TableBoard {
     StateClass board[][];
    
    public  TableBoard ()
    {
        board = new StateClass [50][50];
         for(int i=0; i<50 ; i++)
            for(int j=0 ; j<50 ; j++)
                board[i][j] = new StateClass(new Insulator() );
    }
    public void setCell(int x, int y,State state)
    {
        board[x][y].setState(state);
    }
    public State getCell(int x, int y)
    {
        return board[x][y].getState();
    }
    public void writeTable()
    {
        for(int i=0;i<50;i++)
            {
            for(int j=0;j<50;j++)
                System.out.print( getCell(i,j) + " " );
            System.out.print("\n");
            }
    }
    public void clearTable()
    {
        for(int i=0;i<50;i++)
            for(int j=0;j<50;j++)
                board[i][j].setState(new Insulator());
    }
    public int neighboursCounter (int x,int y)
    {
        int sum = 0;
        
        if (x == 0 && y ==0)
        {
            if (getCell(x,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            else if (getCell(x+1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            else if (getCell(x+1,y).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if(x == 0 && y == 9 )
        {
            if (getCell(x+1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y-1).getClass().equals(new ElectronHead().getClass())) sum++; 
            if (getCell(x,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if (x == 9 && y == 0)
        {
            if (getCell(x-1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if (x == 9 && y == 9)
        {
            if (getCell(x-1,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if (y == 0)
        {
            if (getCell(x-1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if (y == 9)
        {
            if (getCell(x-1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if (x == 0)
        {
            if (getCell(x,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else if (x == 9)
        {
            if (getCell(x-1,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        else
        {
            if (getCell(x-1,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x-1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y+1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x+1,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
            if (getCell(x,y-1).getClass().equals(new ElectronHead().getClass())) sum++;
        }
        
        
        return sum;
    }

}
