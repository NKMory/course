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
    Canvas canvas;
    int coordX = 1, coordY = 1;
    
    public source(){

        setLayout (new GridLayout(2,1));

        topPanel = new Panel(new BorderLayout());

        canvas = new Canvas(){
            public void paint(Graphics g){
                System.out.println("Вызван метод paint()");
                g = canvas.getGraphics();
                if (ch1.getState()){
                g.setColor(shapeColor);
                g.fillRect(coordX,coordY,10,10);
                System.out.println("Отрисован квадрат");
                }
                if (ch2.getState()){
                g.setColor(shapeColor);
                g.fillOval(coordX,coordY,10,10);
                System.out.println("Отрисован круг");
                }
            }
        };

        topPanel.add(canvas,BorderLayout.CENTER);

        
        scrX = new Scrollbar(Scrollbar.HORIZONTAL, 1, 1, 1, 100);
        scrX.setEnabled(true);
        topPanel.add(scrX,BorderLayout.NORTH);
        scrY = new Scrollbar(Scrollbar.VERTICAL, 1, 1, 1, 100);
        scrY.setEnabled(true);
        topPanel.add(scrY,BorderLayout.WEST);

        scrX.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (scrX == e.getSource()) {
                    int curValue = scrX.getValue();
                    
                    coordX += 1;
                    canvas.repaint();
                }
            }
        });

        scrY.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (scrY == e.getSource()) {
                    coordY += 1;
                    canvas.repaint();
                }
                }
            });

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
                    System.out.println("Меняем цвет фона на");
                    switch (name) {
                        case "Черный":
                            System.out.println("черный");
                            canvas.setBackground(Color.black);
                            break;
                        case "Синий":
                            System.out.println("синий");
                            canvas.setBackground(Color.blue);
                            break;
                        case "Розовый":
                            System.out.println("розовый");
                            canvas.setBackground(Color.pink);
                            break;
                        case "Красный":
                            System.out.println("красный");
                            canvas.setBackground(Color.red);
                            break;
                        case "Зеленый":
                            System.out.println("зеленый");
                            canvas.setBackground(Color.green);
                            break;
                        case "Белый":
                            System.out.println("белый");
                            canvas.setBackground(Color.white);
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
	    ch1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println("Выбран квадрат");
                canvas.paint(gc);
                gc = canvas.getGraphics();
                canvas.update(gc);
            }
        });
        bottomPanel_mid.add(ch1);

        ch2 = new Checkbox("Круг",false,chGr);
	    ch2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                System.out.println("Выбран круг");
                canvas.paint(gc);
                gc = canvas.getGraphics();
                canvas.update(gc);
            }
        });
        bottomPanel_mid.add(ch2);

        bottomPanel.add(bottomPanel_mid);

        //правая нижняя панель
        bottomPanel_right = new Panel(new GridLayout());
        bottomPanel_right.setBackground(Color.GREEN);

        text = new Label("Выберите цвет рисунка:");
        font = new Font("Dialog",Font.PLAIN,14);
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
                    System.out.println("Меняем цвет фигуры на");
                    switch (name) {
                        case "Черный":
                            System.out.println("черный");
                            shapeColor = Color.black;
                            break;
                        case "Синий":
                            System.out.println("синий");
                            shapeColor = Color.blue;
                            break;
                        case "Розовый":
                            System.out.println("розовый");
                            shapeColor = Color.pink;
                            break;
                        case "Красный":
                            System.out.println("красный");
                            shapeColor = Color.red;
                            break;
                        case "Зеленый":
                            System.out.println("зеленый");
                            shapeColor = Color.green;
                            break;
                        case "Белый":
                            System.out.println("белый");
                            shapeColor = Color.white;
                            break;
                    }
                    canvas.repaint();
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