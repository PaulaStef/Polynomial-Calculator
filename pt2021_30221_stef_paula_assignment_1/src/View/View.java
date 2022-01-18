package View;

import Controller.ActionHandler;
import Controller.Permissions;

import javax.swing.*;
import java.awt.*;

public class View {
    public static class ViewPage {
        private JFrame framePP;
        private JPanel panelPP;
        private JButton add;
        private JButton subtract;
        private JButton divide;
        private JButton multiply;
        private JButton derive;
        private JButton integrate;
        private JButton button0;
        private JButton button1;
        private JButton button2;
        private JButton button3;
        private JButton button4;
        private JButton button5;
        private JButton button6;
        private JButton button7;
        private JButton button8;
        private JButton button9;
        private JButton buttonMinus;
        private JButton buttonPlus;
        private JButton buttonClear;
        private JButton buttonPower;
        private JButton buttonX;
        private JButton buttonDelete;
        private JTextField polynomialOne;
        private JTextField polynomialTwo;
        private JTextField result;
        private JTextField reminder;
        private Permissions permissions = new Permissions(this);
        private ActionHandler actionHandler = new ActionHandler();

        public ViewPage() {
            initialize();
        }

        private void setButtons(){
            button0 = new JButton("0");
            button0.setBounds(70,200,50,50);
            button0.setFont(new Font("Ariel",Font.PLAIN,17));
            button0.setFocusable(false);
            button0.addActionListener(actionHandler);
            panelPP.add(button0);

            button1 = new JButton("1");
            button1.setBounds(120,200,50,50);
            button1.setFont(new Font("Ariel",Font.PLAIN,17));
            button1.setFocusable(false);
            button1.addActionListener(actionHandler);
            panelPP.add(button1);

            button2 = new JButton("2");
            button2.setBounds(170,200,50,50);
            button2.setFont(new Font("Ariel",Font.PLAIN,17));
            button2.setFocusable(false);
            button2.addActionListener(actionHandler);
            panelPP.add(button2);

            button3 = new JButton("3");
            button3.setBounds(220,200,50,50);
            button3.setFont(new Font("Ariel",Font.PLAIN,17));
            button3.setFocusable(false);
            button3.addActionListener(actionHandler);
            panelPP.add(button3);

            button4 = new JButton("4");
            button4.setBounds(70,250,50,50);
            button4.setFont(new Font("Ariel",Font.PLAIN,17));
            button4.setFocusable(false);
            button4.addActionListener(actionHandler);
            panelPP.add(button4);

            button5 = new JButton("5");
            button5.setBounds(120,250,50,50);
            button5.setFont(new Font("Ariel",Font.PLAIN,17));
            button5.setFocusable(false);
            button5.addActionListener(actionHandler);
            panelPP.add(button5);

            button6 = new JButton("6");
            button6.setBounds(170,250,50,50);
            button6.setFont(new Font("Ariel",Font.PLAIN,17));
            button6.setFocusable(false);
            button6.addActionListener(actionHandler);
            panelPP.add(button6);

            button7 = new JButton("7");
            button7.setBounds(220,250,50,50);
            button7.setFont(new Font("Ariel",Font.PLAIN,17));
            button7.setFocusable(false);
            button7.addActionListener(actionHandler);
            panelPP.add(button7);

            button8 = new JButton("8");
            button8.setBounds(70,300,50,50);
            button8.setFont(new Font("Ariel",Font.PLAIN,17));
            button8.setFocusable(false);
            button8.addActionListener(actionHandler);
            panelPP.add(button8);

            button9 = new JButton("9");
            button9.setBounds(120,300,50,50);
            button9.setFont(new Font("Ariel",Font.PLAIN,17));
            button9.setFocusable(false);
            button9.addActionListener(actionHandler);
            panelPP.add(button9);

            buttonX = new JButton("x");
            buttonX.setBounds(170,300,50,50);
            buttonX.setFont(new Font("Ariel",Font.PLAIN,17));
            buttonX.setFocusable(false);
            buttonX.addActionListener(actionHandler);
            panelPP.add(buttonX);

            buttonDelete = new JButton("Del");
            buttonDelete.setBounds(220,300,50,50);
            buttonDelete.setFont(new Font("Ariel",Font.PLAIN,10));
            buttonDelete.setFocusable(false);
            buttonDelete.addActionListener(actionHandler);
            panelPP.add(buttonDelete);

            buttonMinus = new JButton("-");
            buttonMinus.setBounds(70,350,50,50);
            buttonMinus.setFont(new Font("Ariel",Font.PLAIN,17));
            buttonMinus.setFocusable(false);
            buttonMinus.addActionListener(actionHandler);
            panelPP.add(buttonMinus);

            buttonPlus = new JButton("+");
            buttonPlus.setBounds(120,350,50,50);
            buttonPlus.setFont(new Font("Ariel",Font.PLAIN,17));
            buttonPlus.setFocusable(false);
            buttonPlus.addActionListener(actionHandler);
            panelPP.add(buttonPlus);

            buttonPower = new JButton("^");
            buttonPower.setBounds(170,350,50,50);
            buttonPower.setFont(new Font("Ariel",Font.PLAIN,17));
            buttonPower.setFocusable(false);
            buttonPower.addActionListener(actionHandler);
            panelPP.add(buttonPower);

            buttonClear = new JButton("C");
            buttonClear.setBounds(220,350,50,50);
            buttonClear.setFont(new Font("Ariel",Font.PLAIN,17));
            buttonClear.addActionListener(permissions);
            panelPP.add(buttonClear);

        }

        public void setOperations(){
            add = new JButton("Add");
            add.setBounds(340,200,100,50);
            add.setFont(new Font("Ariel",Font.PLAIN,17));
            add.addActionListener(permissions);
            panelPP.add(add);

            subtract = new JButton("Subtract");
            subtract.setBounds(340,250,100,50);
            subtract.setFont(new Font("Ariel",Font.PLAIN,17));
            subtract.addActionListener(permissions);
            panelPP.add(subtract);

            multiply = new JButton("Multiply");
            multiply.setBounds(340,300,100,50);
            multiply.setFont(new Font("Ariel",Font.PLAIN,17));
            multiply.addActionListener(permissions);
            panelPP.add(multiply);

            divide = new JButton("Divide");
            divide.setBounds(440,300,100,50);
            divide.setFont(new Font("Ariel",Font.PLAIN,17));
            divide.addActionListener(permissions);
            panelPP.add(divide);

            integrate = new JButton("Integrate");
            integrate.setBounds(440,200,100,50);
            integrate.setFont(new Font("Ariel",Font.PLAIN,17));
            integrate.addActionListener(permissions);
            panelPP.add(integrate);

            derive = new JButton("Derive");
            derive.setBounds(440,250,100,50);
            derive.setFont(new Font("Ariel",Font.PLAIN,17));
            derive.addActionListener(permissions);
            panelPP.add(derive);

        }

        public void setFields(){
            polynomialOne = new JTextField();
            polynomialOne.setBounds(200, 1,300,30);
            JLabel label_1 = new JLabel("First Model.Polynomial: ");
            label_1.setBounds(70,1,100,30);
            panelPP.add(label_1);
            panelPP.add(polynomialOne);

            polynomialTwo = new JTextField();
            polynomialTwo.setBounds(200, 35,300,30);
            JLabel label_2 = new JLabel("Second Model.Polynomial: ");
            label_2.setBounds(70,35,120,30);
            panelPP.add(label_2);
            panelPP.add(polynomialTwo);

            result = new JTextField();
            result.setBounds(200, 70,300,30);
            JLabel label_3 = new JLabel("Result: ");
            label_3.setBounds(70,70,100,30);
            panelPP.add(label_3);
            panelPP.add(result);

            reminder = new JTextField();
            reminder.setBounds(200, 105,300,30);
            JLabel label_4 = new JLabel("Remainder: ");
            label_4.setBounds(70,105,100,30);
            panelPP.add(label_4);
            panelPP.add(reminder);
        }

        private void initialize(){
            framePP = new JFrame();
            framePP.setSize(550, 550);
            framePP.setBounds(600, 600, 700, 500);
            framePP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framePP.getContentPane().setLayout(null);
            panelPP = new JPanel();
            panelPP.setBounds(20, 20, 600, 500);
            framePP.getContentPane().add(panelPP);
            panelPP.setLayout(null);
            setButtons();
            setOperations();
            setFields();
            framePP.add(panelPP);
            framePP.setVisible(true);
        }

        public JTextField getPolynomialOne() {
            return polynomialOne;
        }

        public void setPolynomialOne(JTextField polynomialOne) {
            this.polynomialOne = polynomialOne;
        }

        public JTextField getPolynomialTwo() {
            return polynomialTwo;
        }

        public void setPolynomialTwo(JTextField polynomialTwo) {
            this.polynomialTwo = polynomialTwo;
        }

        public JTextField getResult() {
            return result;
        }

        public void setResult(JTextField result) {
            this.result = result;
        }

        public JTextField getReminder() {
            return reminder;
        }

        public void setReminder(JTextField reminder) {
            this.reminder = reminder;
        }

        public JButton getAdd() {
            return add;
        }


        public JButton getSubtract() {
            return subtract;
        }

        public JButton getDivide() {
            return divide;
        }

        public JButton getMultiply() {
            return multiply;
        }

        public JButton getDerive() {
            return derive;
        }


        public JButton getIntegrate() {
            return integrate;
        }


        public JButton getButton0() {
            return button0;
        }

        public JButton getButton1() {
            return button1;
        }

        public JButton getButton2() {
            return button2;
        }

        public JButton getButton3() {
            return button3;
        }

        public JButton getButton4() {
            return button4;
        }

        public JButton getButton5() {
            return button5;
        }

        public JButton getButton6() {
            return button6;
        }

        public JButton getButton7() {
            return button7;
        }

        public JButton getButton8() {
            return button8;
        }

        public JButton getButton9() {
            return button9;
        }

        public JButton getButtonMinus() {
            return buttonMinus;
        }

        public JButton getButtonPlus() {
            return buttonPlus;
        }

        public JButton getButtonClear() {
            return buttonClear;
        }

        public JButton getButtonPower() {
            return buttonPower;
        }

        public JButton getButtonX() {
            return buttonX;
        }

        public JButton getButtonDelete() {
            return buttonDelete;
        }
    }
}
