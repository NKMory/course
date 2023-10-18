import java.awt.*;
import java.awt.event.*;

import javax.swing.Box;
import javax.swing.BoxLayout; 

import javax.swing.border.Border;



public class source extends Panel implements ActionListener,ItemListener{

    Panel topPanel,bottomPanel,
            bottomPanel_left,bottomPanel_mid,bottomPanel_right;


    Checkbox ch1,ch2;
    CheckboxGroup chGr;
    Graphics gc;
    Label text;
    Font font;

    
    public void paint(Graphics g){
        if (ch1.getState()){

            gc.drawRect(10,10,10,10);
            gc.fillRect(10,10,10,10);
        }
        if (ch2.getState()){

            gc.drawOval(10,10,10,10);
            gc.fillOval(10,10,10,10);
        }
    }
    
    public source(){

        setLayout (new GridLayout(2,3));

        topPanel = new Panel(new BorderLayout());
        
        //topPanel.add();

        //левая нижняя панель
        bottomPanel = new Panel((new GridLayout(1,3)));

        bottomPanel_left.setLayout(new BoxLayout(bottomPanel_left,BoxLayout.Y_AXIS));
        bottomPanel_left.setBackground(Color.GREEN);

        text=new Label("Выберите цвет фона:");
        font= new Font("Dialog",Font.PLAIN,14);
        text.setFont(font);
        bottomPanel_left.add(text);

        add(bottomPanel_left);

        //средняя нижняя панель
        bottomPanel_mid.setLayout(new BoxLayout(bottomPanel_mid, BoxLayout.Y_AXIS));

        text=new Label("Фигура:");
        font= new Font("Dialog",Font.PLAIN,14);
        text.setFont(font);
        bottomPanel_mid.add(text);

        ch1 = new Checkbox("Квадрат",false,chGr);
	    ch1.addItemListener(this);
        bottomPanel_mid.add(ch1);

        ch2 = new Checkbox("Круг",false,chGr);
	    ch2.addItemListener(this);
        bottomPanel_mid.add(ch2);


    }

    public static void main(String args[]) 
 {
	source panel = new source ();   
  
	Frame frame = new Frame("An AWT-Based Application");	
	frame.add(panel);
	frame.setSize(1260, 660);
	frame.setLocation(100, 100);
	frame.setVisible(true);
	frame.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e){
               System.exit(0);
		}
	});
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    } 
}