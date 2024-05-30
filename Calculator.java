package calculator_pac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private  String[] symbols= {"AC", "+/-", "%", "/", "7","8","9","X","4","5","6","-","1","2","3","+","0",".","Mod","="};
    private  int operator=0;
    Font font=new Font("arial",Font.BOLD,20);
    private JPanel panel=new JPanel(new BorderLayout(2,2));
    private  JPanel btnPanel=new JPanel(new GridLayout(5,5,2,2));
    private  JButton[] btns=new  JButton[20];
    private JTextArea screen=new JTextArea(2,40);

    private  double firstNum=0,secondNum=0;
    private JTextField calculatingTf=new JTextField(40);


    public  Calculator()
    {
        init();
    }
    private  void init()
    {

        screen.setFont(font);
        btnPanel.setFont(font);

        setTitle("Calculator");

        screen.setBackground(Color.WHITE);
        panel.setBackground(Color.GRAY);
        btnPanel.setBackground(Color.BLACK);
        screen.setForeground(Color.BLACK);
        for(int i=0;i<btns.length;i++)
        {

            btns[i]=new JButton(symbols[i]);
            btns[i].setOpaque(true);
            btns[i].setBorderPainted(false);

            btns[i].setBackground(Color.BLACK);
            if(i==0)
            btns[i].setForeground(Color.RED);
            else btns[i].setForeground(Color.WHITE);
            btns[i].addActionListener(this);

            btnPanel.add(btns[i]);
        }
        calculatingTf.setForeground(Color.BLACK);
        panel.add(calculatingTf,BorderLayout.SOUTH);
        panel.add(btnPanel,BorderLayout.CENTER);
        panel.add(screen,BorderLayout.NORTH);

        add(panel);
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand().toString();
        switch (cmd)
        {
            case ".":
                if(!screen.getText().contains("."))
                {
                    screen.setText(screen.getText()+".");


                }
                break;
            case "0":
                screen.setText(screen.getText()+"0");
                break;
            case "1":
                screen.setText(screen.getText()+"1");
                break;
            case "2":
                screen.setText(screen.getText()+"2");
                break;
            case "3":

                screen.setText(screen.getText()+"3");
                break;
            case "4":
                screen.setText(screen.getText()+"4");
                break;
            case "5":
                screen.setText(screen.getText()+"5");
                break;
            case "6":
                screen.setText(screen.getText()+"6");
                break;
            case "7":
                screen.setText(screen.getText()+"7");
                break;
            case "8":
                screen.setText(screen.getText()+"8");
                break;
            case "9":
                screen.setText(screen.getText()+"9");
                break;
            case "+":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText("");
                    operator=1;
                }
                break;
            case "-":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText("");
                    operator=2;
                }
                break;
            case "X":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText("");
                    operator=3;

                }
                break;

            case "/":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText("");
                    operator=4;
                }
                break;
            case "Mod":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText("");
                    operator=5;
                }
                break;
            case "%":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText(String.valueOf(firstNum/100));
                    calculatingTf.setText(String.valueOf("%"+firstNum+"= "+(firstNum/100)));

                }
                break;
            case "+/-":
                if(!screen.getText().isEmpty()) {

                    firstNum=Double.parseDouble(screen.getText().toString());
                    screen.setText(String.valueOf(firstNum*(-1)));
                    calculatingTf.setText(String.valueOf("-"+firstNum+"= "+(firstNum*(-1))));

                }
                break;
            case "AC":
                screen.setText("");

            default:




        }
        if(cmd.equalsIgnoreCase("="))
        {
           if (!screen.getText().isEmpty())
           {
               secondNum=Double.parseDouble(screen.getText().toString());
               switch(operator)
               {
                   case  1:
                       screen.setText(String.valueOf(firstNum+secondNum));
                       calculatingTf.setText(String.valueOf(firstNum+" + "+secondNum+ " = "+(firstNum+secondNum)));
                       break;
                   case  2:
                       screen.setText(String.valueOf(firstNum-secondNum));
                       calculatingTf.setText(String.valueOf(firstNum+" - "+secondNum+ " = "+(firstNum-secondNum)));
                       break;
                   case  3:
                       screen.setText(String.valueOf(firstNum*secondNum));
                       calculatingTf.setText(String.valueOf(firstNum+" X "+secondNum+ " = "+(firstNum*secondNum)));
                       break;
                   case  4:
                       screen.setText(String.valueOf(firstNum/secondNum));
                       calculatingTf.setText(String.valueOf(firstNum+" / "+secondNum+ " = "+(firstNum/secondNum)));
                       break;
                   case  5:
                       screen.setText(String.valueOf(firstNum%secondNum));
                       calculatingTf.setText(String.valueOf(firstNum+" Mod "+secondNum+ " = "+(firstNum%secondNum)));
                       break;

                   default:
               }
           }
        }

    }
}
