import java.awt.*;
import java.awt.event.*;


public class source extends Panel implements ActionListener,ItemListener{

    Panel topPanel,bottomPanel,
            bottomPanel_left,bottomPanel_mid,bottomPanel_right;
    Checkbox ch1,ch2;
    Graphics gc;
    Scrollbar scrY,scrX;
    Label text;
    Font font;
    Choice chShape,chBg;
    Color shapeColor,bgColor;
    
    public void paint(Graphics g){
        if (ch1.getState()){

            gc.fillRect(10,10,10,10);
        }
        if (ch2.getState()){

            gc.fillOval(10,10,10,10);
        }
    }
    
    public source(){

        setLayout (new GridLayout(2,1));

        topPanel = new Panel(new BorderLayout());
        scrX = new Scrollbar(Scrollbar.HORIZONTAL, 1, 1, 10, 100);
        scrX.setEnabled(true);
        topPanel.add(scrX,BorderLayout.NORTH);
        scrY = new Scrollbar(Scrollbar.VERTICAL, 1, 1, 10, 100);
        scrY.setEnabled(true);
        topPanel.add(scrY,BorderLayout.WEST);
/*
        scrX.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (scrX == e.getSource()) {
                    gc = e.getValue();
                    text.setFont(new Font(font.getName(),font.getStyle(),g));
                }
                }
            });

        scrY.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (scrY == e.getSource()) {
                    gc = e.getValue();
                    text.setFont(new Font(font.getName(),font.getStyle(),g));
                }
                }
            });
*/

        

        add(topPanel);

        //нижняя панель
        bottomPanel = new Panel(new GridLayout());
        bottomPanel_left = new Panel (new GridLayout());

        //левая нижняя панель
        bottomPanel_left.setBackground(Color.GREEN);

        text = new Label("Выберите цвет фона:");
        font = new Font("Dialog",Font.PLAIN,14);
        text.setFont(font);
        bottomPanel_left.add(text);

        chBg = new Choice();
        chBg.addItem("Черный");
        chBg.addItem("Синий");
        chBg.addItem("Розовый");
        chBg.addItem("Красный");
        chBg.addItem("Зеленый");
        chBg.addItem("Белый");
        bottomPanel_left.add(chBg);

        chBg.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String name = (String) e.getItem();
                if (name!=null) {
                    switch (name) {
                        case "Черный":
                            topPanel.setBackground(Color.black);
                            break;
                        case "Синий":
                            topPanel.setBackground(Color.blue);
                            break;
                        case "Розовый":
                            topPanel.setBackground(Color.pink);
                            break;
                        case "Красный":
                            topPanel.setBackground(Color.red);
                            break;
                        case "Зеленый":
                            topPanel.setBackground(Color.green);
                            break;
                        case "Белый":
                            topPanel.setBackground(Color.white);
                            break;
                    }
                }
            }
        });

        bottomPanel.add(bottomPanel_left);

        //средняя нижняя панель
        bottomPanel_mid = new Panel(new GridLayout());
        bottomPanel_mid.setBackground(Color.gray);

        text = new Label("Фигура:");
        font = new Font("Dialog",Font.PLAIN,14);
        text.setFont(font);
        bottomPanel_mid.add(text);

        CheckboxGroup chGr = new CheckboxGroup();

        ch1 = new Checkbox("Квадрат",false,chGr);
	    ch1.addItemListener(this);
        bottomPanel_mid.add(ch1);

        ch2 = new Checkbox("Круг",false,chGr);
	    ch2.addItemListener(this);
        bottomPanel_mid.add(ch2);

        bottomPanel.add(bottomPanel_mid);

        //правая нижняя панель
        bottomPanel_right = new Panel(new GridLayout());
        bottomPanel_right.setBackground(Color.GREEN);

        text=new Label("Выберите цвет рисунка:");
        font= new Font("Dialog",Font.PLAIN,14);
        text.setFont(font);
        bottomPanel_right.add(text);

        chShape = new Choice();
        chShape.addItem("Черный");
        chShape.addItem("Синий");
        chShape.addItem("Розовый");
        chShape.addItem("Красный");
        chShape.addItem("Зеленый");
        chShape.addItem("Белый");
        bottomPanel_right.add(chShape);

        chShape.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String name = (String) e.getItem();
                if (name!=null) {
                    switch (name) {
                        case "Черный":
                            gc.setColor(Color.black);
                            break;
                        case "Синий":
                            gc.setColor(Color.blue);
                            break;
                        case "Розовый":
                            gc.setColor(Color.pink);
                            break;
                        case "Красный":
                            gc.setColor(Color.red);
                            break;
                        case "Зеленый":
                            gc.setColor(Color.green);
                            break;
                        case "Белый":
                            gc.setColor(Color.white);
                            break;
                    }
                }
            }
        });
        bottomPanel.add(bottomPanel_right);

        add(bottomPanel);
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