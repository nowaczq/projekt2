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
public class XorGate
{
    public XorGate(int X, int Y, TableBoard table)
    {
        table.setCell(X, Y, new Conductor());
        table.setCell(X+1, Y-1, new Conductor());
        table.setCell(X+2, Y-1, new Conductor());
        table.setCell(X+3, Y, new Conductor());
        table.setCell(X+3, Y+1, new Conductor());
        table.setCell(X+2, Y+1, new Conductor());
        table.setCell(X+2, Y+2, new Conductor());
        table.setCell(X+2, Y+3, new Conductor());
        table.setCell(X+3, Y+3, new Conductor());
        table.setCell(X+4, Y+3, new Conductor());
        table.setCell(X+5, Y+3, new Conductor());
        table.setCell(X+5, Y+2, new Conductor());
        table.setCell(X+5, Y+1, new Conductor());
        table.setCell(X+4, Y+1, new Conductor());
        table.setCell(X+6, Y+2, new Conductor());
        table.setCell(X+3, Y+4, new Conductor());
        table.setCell(X+2, Y+5, new Conductor());
        table.setCell(X+1, Y+5, new Conductor());
        table.setCell(X, Y+4, new Conductor());
    }
}
