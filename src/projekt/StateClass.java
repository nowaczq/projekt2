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
public class StateClass implements State
{
    private State cellState;

    public StateClass()
    {

    }

    public StateClass(State state)
    {
        cellState = state;
    }

    public void setState(State state)
    {
        cellState = state;
    }

    public State getState()
    {
        return cellState;
    }

    @Override
    public State nextState(int x, int y, TableBoard board)
    {
        return cellState.nextState(x, y, board);
    }

}
