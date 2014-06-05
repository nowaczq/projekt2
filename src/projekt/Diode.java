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
public class Diode 
{
    public Diode (int X, int Y, TableBoard table)
    {
        table.setCell(X, Y, new Conductor());
        table.setCell(X+1, Y, new Conductor());
        table.setCell(X+1, Y-1, new Conductor());
        table.setCell(X+1, Y+1, new Conductor());
        table.setCell(X+2, Y-1, new Conductor());
        table.setCell(X+2, Y+1, new Conductor());
        table.setCell(X+3, Y, new Conductor());
    }
}
