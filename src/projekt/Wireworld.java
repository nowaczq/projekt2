/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projekt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateusz
 */
public class Wireworld implements Subject, Game
{
    private ArrayList<Observer> observers;
    private TableBoard table;
    
    public Wireworld()
    {
        observers = new ArrayList<>();
        table =new TableBoard();
        table.clearTable();
    }
    @Override
    public void registerAction (Observer o)
    {
        observers.add(o);
    }
    public void unregisterAction (Observer o)
    {
        observers.remove(o);
    }
    public void notifyObservers()
    {
        for(Observer o : observers)
        {
                o.update(table);
        }
    }
    @Override
    public void wireworldGame(TableBoard board)
    {
        TableBoard board2 = new TableBoard ();
        board2.clearTable();
        for(int j=0; j < 50 ; j++)
            for(int k=0; k < 50 ; k++)
            {
                board2.setCell(j,k,board.getCell(j,k).nextState(j,k, board) );
            }
        for (int i = 0; i<50;i++)
        {
            for (int j = 0;j<50;j++)
                board.board[i][j] = board2.board[i][j];
        }
        notifyObservers();    
            
    }

 
}

  
 

