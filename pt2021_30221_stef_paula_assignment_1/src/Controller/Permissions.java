package Controller;

import Model.InvalidInputException;
import Model.Monomial;
import Model.Operations;
import Model.Polynomial;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Permissions implements ActionListener {
    View.ViewPage page ;
    Operations operations= new Operations();

    public Permissions() {

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String str = page.getPolynomialOne().getText();
        Polynomial polynomial1 = new Polynomial();
        Polynomial reminder = new Polynomial();
        if(!isEmptyString(str)) {
            try {
                polynomial1.split(str);
            }catch (InvalidInputException e1){
                page.getReminder().setText(e1.getMessage());
            }
        }
        else {
            try {
                polynomial1.split("0");
            } catch (InvalidInputException invalidInputException) {
                page.getReminder().setText(invalidInputException.getMessage());
            }
        }
        str = page.getPolynomialTwo().getText();
        Polynomial polynomial2 = new Polynomial();
        if(!isEmptyString(str)) {
            try {
                polynomial2.split(str);
            } catch (InvalidInputException invalidInputException2) {
                page.getReminder().setText(invalidInputException2.getMessage());
            }
        }
        else
        {
            try {
                polynomial2.split("0");
            } catch (InvalidInputException invalidInputException3) {
                page.getReminder().setText(invalidInputException3.getMessage());
            }
        }
        Polynomial result = new Polynomial();
        if(e.getSource() == page.getAdd()){
            result = operations.add(polynomial1,polynomial2);
            if(result == null){
                page.getReminder().setText("Invalid Input");
            }
            page.getReminder().setText("");
        }
        else if(e.getSource() == page.getSubtract()){
            result = operations.subtract(polynomial1,polynomial2);
            page.getReminder().setText("");
        }
        else if(e.getSource() == page.getMultiply()){
            result = operations.multiplication(polynomial1,polynomial2);
            page.getReminder().setText("");
        }
        else if(e.getSource() == page.getDivide()){
            Polynomial[] polynomialDivide = new Polynomial[2];
            polynomialDivide = operations.divide(polynomial1,polynomial2);
            if(polynomialDivide == null || polynomialDivide[0].getPolynomial().isEmpty())
                page.getReminder().setText("Invalid Input !");
            else {
                result = polynomialDivide[0];
                reminder = polynomialDivide[1];
                page.getReminder().setText(printPolynomial(reminder));
            }
        }
        else if(e.getSource() == page.getDerive()){
            result = operations.derivate(polynomial1);
            page.getReminder().setText("");
        }
        else if(e.getSource() == page.getIntegrate()){
            result = operations.integrate(polynomial1);
            page.getReminder().setText("");
        }
        else if(e.getSource() == page.getButtonClear()){
            page.getPolynomialOne().setText("");
            page.getPolynomialTwo().setText("");
            result = new Polynomial();
            try {
                result.split("");
            } catch (InvalidInputException invalidInputException) {
                page.getReminder().setText(invalidInputException.getMessage());
            }
            page.getReminder().setText("");
        }
        page.getResult().setText(printPolynomial(result));
    }

    public Permissions(View.ViewPage page) {
        this.page = page;
    }

    boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }

    public static String printPolynomial(Polynomial polynomial){
        String s = new String("");
        int i = -1;
        for(Monomial monomial : polynomial.getPolynomial()) {
            i++;
            if (monomial.getCoefficient() != 0) {
                if (monomial.getCoefficient() > 0 && i != 0) {
                    s += "+";
                }
                if (monomial.getCoefficient() == 1) {
                    if (monomial.getDegree() == 0) {
                        s += "1";
                    } else if (monomial.getDegree() == 1) {
                        s += "x";
                    } else {
                        s += "x^" + monomial.getDegree();
                    }
                } else if (monomial.getCoefficient() == -1) {
                    if (monomial.getDegree() == 0) {
                        s += "-1";
                    } else if (monomial.getDegree() == 1) {
                        s += "-x";
                    } else {
                        s += "-x^" + monomial.getDegree();
                    }
                } else {
                    s += monomial.getCoefficient();
                    if (monomial.getDegree() == 1) {
                        s += "x";
                    } else if (monomial.getDegree() != 0) {
                        s += "x^" + monomial.getDegree();
                    }
                }
            }
        }
        return s;
    }
}
