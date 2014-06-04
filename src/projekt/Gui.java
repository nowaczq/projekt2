

package projekt;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener,ItemListener{
    JButton startButton[];
    int numberOfIterations = 1000000;
    int speed = 1000;
    JFileChooser fileChoose;
    JButton tab[][];
    JMenu optionsMenu = new JMenu("Opcje");
    JMenuItem exit = new JMenuItem("Zamknij grę");
    JMenuItem fileChooser = new JMenuItem("Wczytaj plik");
    JMenuItem help = new JMenuItem("Pomoc");
    JLabel inputLabel[];
    JTextField inputFile[];
    Choice xDimm;
    Choice yDimm;
    boolean change = false;
    Choice list;
    int X=0;
    int Y=0;
    Game game =new Game();
    TableBoard table = new TableBoard();
    IoRead read = new IoRead();
    public Gui() throws InterruptedException
    {
        
        setSize(1000,700);
        setTitle("Wireworld");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        tab = new JButton [50][50];
        startButton = new JButton[10];
        inputLabel = new JLabel[10];
        inputFile = new JTextField[10];
        setJMenuBar(getJMenuBar());
        choiceMenu();
        setLayout(null);
        setResizable(false);
        setVisible(true);
        

        
        
        startButton[1]= new JButton("Start");
        startButton[1].setBounds(800,3,180,30);
        startButton[1].setBackground(Color.green);
        startButton[1].setBorder(null);
        startButton[1].addActionListener(this);
        startButton[1].setFocusPainted(false);
        add(startButton[1]);
        inputLabel[2] = new JLabel("Szybkość");
        inputLabel[2].setBounds(800,70,180,30);
        add(inputLabel[2]);
        inputLabel[3] = new JLabel("X");
        inputLabel[3].setBounds(800,130,50,20);
        add(inputLabel[3]);
        inputLabel[4] = new JLabel("Y");
        inputLabel[4].setBounds(850,130,50,20);
        add(inputLabel[4]);
        startButton[2]= new JButton("Stop");
        startButton[2].setBounds(800,36,180,30);
        startButton[2].setBackground(Color.green);
        startButton[2].setBorder(null);
        startButton[2].addActionListener(this);
        startButton[2].setFocusPainted(false);
        add(startButton[2]);
        startButton[3]= new JButton("Przewodnik");
        startButton[3].setBounds(800,200,180,30);
        startButton[3].setBackground(Color.yellow);
        startButton[3].setBorder(null);
        startButton[3].addActionListener(this);
        startButton[3].setFocusPainted(false);
        add(startButton[3]);
        startButton[4]= new JButton("Głowa elektronu");
        startButton[4].setBounds(800,240,180,30);
        startButton[4].setBackground(Color.red);
        startButton[4].setBorder(null);
        startButton[4].addActionListener(this);
        startButton[4].setFocusPainted(false);
        add(startButton[4]);
        startButton[5]= new JButton("Ogon elektronu");
        startButton[5].setBounds(800,280,180,30);
        startButton[5].setBackground(Color.blue);
        startButton[5].setBorder(null);
        startButton[5].addActionListener(this);
        startButton[5].setFocusPainted(false);
        add(startButton[5]);
        
        
        for (int r =0; r<50;r++)
           for(int q=0;q<50;q++)
           { 
               tab[r][q] =new JButton();
               add(tab[r][q]);
               tab[r][q].setBounds(r*15,q*15,15,15);
               tab[r][q].setBorder(null);
               tab[r][q].setBackground(Color.black);
          }
          
           drawGame();      
           System.out.println(numberOfIterations); 
        
    }
    public void choiceMenu()
    {
        list = new Choice();
        list.setBackground(Color.white);
        list.setBounds(800,100,100,30);
        list.add(String.valueOf(50));
        list.add("100");
        list.add("200");
        list.add("500");
        list.add("1000");
        add(list);
        list.addItemListener(this); 
        
        xDimm = new Choice();
        xDimm.setBackground(Color.white);
        xDimm.setBounds(800,150,50,20);
        for (int f =0; f <50; f++)
            xDimm.add(String.valueOf(f));
        add(xDimm);
        xDimm.addItemListener(this);
        
        yDimm = new Choice();
        yDimm.setBackground(Color.white);
        yDimm.setBounds(850,150,50,20);
        for (int f =0; f <50; f++)
            yDimm.add(String.valueOf(f));
        add(yDimm);
        yDimm.addItemListener(this);
    }
    public void drawGame() throws InterruptedException
    {
              
        for (int k =0 ;k<numberOfIterations;k++)
        {
            for (int i =0; i <50;i++)
            {
                for (int j =0; j<50;j++)
                {
                    
                    tab[i][j].setBounds(i*15,j*15,15,15);
                    if (table.getCell(i,j).getClass().equals(table.Insulator.getClass()))
                    {
                        tab[i][j].setBackground(Color.black);
                       
                    }
                    if (table.getCell(i,j).getClass().equals(table.electronHead.getClass()))
                    {
                        tab[i][j].setBackground(Color.red);
                        
                    }
                    if (table.getCell(i,j).getClass().equals(table.electronTail.getClass()))
                    {
                        tab[i][j].setBackground(Color.blue);
                       
                    }
                    if (table.getCell(i,j).getClass().equals(table.Conductor.getClass()))
                    {
                        tab[i][j].setBackground(Color.yellow);
                       
                    }
                }
            }
            if (change == true)
                game.game(table);
            TimeUnit.MILLISECONDS.sleep(speed);
        }
    }
    @Override
    public JMenuBar getJMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.green);
        menuBar.setBorder(null);
        optionsMenu.add(fileChooser);
        optionsMenu.add(help);
        optionsMenu.add(exit);
        exit.addActionListener(this);
        fileChooser.addActionListener(this);
        help.addActionListener(this);
	menuBar.add(optionsMenu);
	return menuBar;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Component c = (Component)e.getSource();
	if(c == exit)
            System.exit(0);
	if(c == fileChooser)
        {
            FileDialog fd =new FileDialog(this,"Wczytaj",FileDialog.LOAD);
            fd.setVisible(true);
            String directoryInput=fd.getDirectory();
            String fileInput=fd.getFile();
            table.clearTable();
            read.inFile = directoryInput+fileInput;
            read.readFile(table);        
        }
        if(c == help)
        {
            JOptionPane.showMessageDialog(this,"Tu będzie pomoc");
        }
        if(c == startButton[1])
        {
            change = true;
        }
        if(c == startButton[2])
        {
            change =false;
        }
        if(c == startButton[3])
        {
            table.setCell(X, Y, State.Conductor);
        }
        if(c == startButton[4])
        {
            table.setCell(X, Y, State.ElectronHead);
        }
        if(c == startButton[5])
        {
            table.setCell(X, Y, State.ElectronTail);
        }       
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        switch(list.getSelectedIndex( )) 
        {
            case 0: 
                speed = 50;  
                break; 

            case 1: 
                speed = 100; 
                break; 

            case 2: 
                speed = 200; 
                break; 

            case 3: 
                speed = 500; 
                break; 

            case 4: 
                speed = 1000; 
                break;
        }
        switch(xDimm.getSelectedIndex())
        {
            case 0: X=0;break;case 1: X=1;break;case 2: X=2;break;case 3: X=3;break;
            case 4: X=4;break;case 5: X=5;break;case 6: X=6;break;case 7: X=7;break;
            case 8: X=8;break;case 9: X=9;break;case 10: X=10;break;case 11: X=11;break;
            case 12: X=12;break;case 13: X=13;break;case 14: X=14;break;case 15: X=15;break;
            case 16: X=16;break;case 17: X=17;break;case 18: X=18;break;case 19: X=19;break;
            case 20: X=20;break;case 21: X=21;break;case 22: X=22;break;case 23: X=23;break;
            case 24: X=24;break;case 25: X=25;break;case 26: X=26;break;case 27: X=27;break;
            case 28: X=28;break;case 29: X=29;break;case 30: X=30;break;case 31: X=31;break;
            case 32: X=32;break;case 33: X=33;break;case 34: X=34;break;case 35: X=35;break;
            case 36: X=36;break;case 37: X=37;break;case 38: X=38;break;case 39: X=39;break;
            case 40: X=40;break;case 41: X=41;break;case 42: X=42;break;case 43: X=43;break;
            case 44: X=44;break;case 45: X=45;break;case 46: X=46;break;case 47: X=47;break;
            case 48: X=48;break;case 49: X=49;break;
        }
        switch(yDimm.getSelectedIndex())
        {
            case 0: Y=0;break;case 1: Y=1;break;case 2: Y=2;break;case 3: Y=3;break;
            case 4: Y=4;break;case 5: Y=5;break;case 6: Y=6;break;case 7: Y=7;break;
            case 8: Y=8;break;case 9: Y=9;break;case 10: Y=10;break;case 11: Y=11;break;
            case 12: Y=12;break;case 13: Y=13;break;case 14: Y=14;break;case 15: Y=15;break;
            case 16: Y=16;break;case 17: Y=17;break;case 18: Y=18;break;case 19: Y=19;break;
            case 20: Y=20;break;case 21: Y=21;break;case 22: Y=22;break;case 23: Y=23;break;
            case 24: Y=24;break;case 25: Y=25;break;case 26: Y=26;break;case 27: Y=27;break;
            case 28: Y=28;break;case 29: Y=29;break;case 30: Y=30;break;case 31: Y=31;break;
            case 32: Y=32;break;case 33: Y=33;break;case 34: Y=34;break;case 35: Y=35;break;
            case 36: Y=36;break;case 37: Y=37;break;case 38: Y=38;break;case 39: Y=39;break;
            case 40: Y=40;break;case 41: Y=41;break;case 42: Y=42;break;case 43: Y=43;break;
            case 44: Y=44;break;case 45: Y=45;break;case 46: Y=46;break;case 47: Y=47;break;
            case 48: Y=48;break;case 49: Y=49;break;
        }
    }



}




