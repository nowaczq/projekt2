/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;




/**
 *
 * @author Mateusz
 */
public class IoRead {
    
    BufferedReader br;
    String line;
    String inFile;
    String outFile;
    int copyOFboarfTable[][] = new int [50][50];
    
    public void readFile (TableBoard t) 
    {
        try 
        {
            br = new BufferedReader(new FileReader(this.inFile));
            while ((line=br.readLine()) != null)
            {
                String [] p = line.split ("\\s+");
                int x = Integer.parseInt(p[0]);
                int y = Integer.parseInt(p[1]);
                int cellState = Integer.parseInt(p[2]);
                
                for (int i = 0; i < 50; i++)
                {
                    for (int j = 0; j <50; j++)
                    {
                        if (x == i && y == j)
                        {
                            switch (cellState)
                            {
                                 case 0: t.setCell(y,x,new Insulator());
                                 break;
                                 case 1: t.setCell(y,x,new ElectronHead());
                                 break;
                                 case 3: t.setCell(y,x,new ElectronTail());
                                 break;
                                 case 4: t.setCell(y,x,new Conductor());
                                 break;
                            }
                        }                     
                    }
                }   
            }
            br.close ();
        }
        catch (IOException e){      
        }
    }
    public void saveFile(TableBoard t) throws FileNotFoundException
    {
      PrintWriter outputFile = new PrintWriter(this.outFile);
      for(int i = 0; i < 50; i++)
      {
          for(int j = 0; j < 50; j++)
          {
              if(t.getCell(j, i).getClass().equals(t.electronHead.getClass()))
                  outputFile.println(i + " " + j + " " + 1 );
              if(t.getCell(j, i).getClass().equals(t.electronTail.getClass()))
                  outputFile.println(i + " " + j + " " + 3 );
              if(t.getCell(j, i).getClass().equals(t.Conductor.getClass()))
                  outputFile.println(i + " " + j + " " + 4 );
          }
      }    
      outputFile.close();
    }
    
}
