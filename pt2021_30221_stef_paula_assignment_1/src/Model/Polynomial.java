package Model;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
    private ArrayList<Monomial> polynomial;

    public Polynomial() {
        this.polynomial = new ArrayList<Monomial>();
    }

    public Polynomial(Polynomial polynomial1) {
        this.polynomial = new ArrayList<Monomial>();
        for(Monomial monomial : polynomial1.getPolynomial()){
            this.addMonomial(monomial.getCoefficient(), monomial.getDegree());
        }
    }


    public ArrayList<Monomial> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(ArrayList<Monomial> polynomial) {
        this.polynomial = polynomial;
    }

    public void addMonomial(double coefficient, int degree){
        Monomial monomial1 = new Monomial(coefficient,degree);
        boolean found = false;
        for(Monomial monomialX : polynomial){
            if(monomialX.getDegree() == monomial1.getDegree()){
                double coefficient1 = coefficient + monomialX.getCoefficient();
                monomialX.setCoefficient(coefficient1);
                found = true;
            }
        }
        if(!found){
            polynomial.add(monomial1);
        }
    }

    public double findCoef(String str) {
        double coefficient = Integer.MIN_VALUE;
        int i = str.indexOf("x");
        if(i == 0) {
            coefficient = 1;
        }
        else
        if(i == 1 && str.charAt(0)=='-') {
            coefficient = -1;
        }
        else
        if(i== -1){
            coefficient = Integer.parseInt(str);
        }
        else {
            coefficient = Integer.parseInt(str.substring(0,i));
        }
        return coefficient;
    }
    public Integer findDegree(String str){
        Integer degree = Integer.MIN_VALUE;
        int i = str.indexOf("x");
        if(i == -1){
            degree = 0;
        }
        else {
            int j = str.indexOf("^");
            if(j == -1 ){
                degree = 1;
            }
            else {
                //System.out.println(str.substring(j+1));
                degree = Integer.parseInt(str.substring(j+1));
            }
        }
        return degree;
    }

    public void split (String strPol) throws InvalidInputException {
        try {
            String replacedStr = strPol.replace("-", "+-");
            replacedStr = replacedStr.replace("^+-", "^-");
            if (replacedStr.charAt(0) == '+') {
                replacedStr = replacedStr.substring(1);
            }
            String[] monomials = replacedStr.split("\\+");
            for (String monomialX : monomials) {
                addMonomial(findCoef(monomialX), findDegree(monomialX));
            }
        }catch (Exception e){
            throw new InvalidInputException("Invalid Input");
        }
    }

    @Override
    public String toString() {
        return "Model.Polynomial{" +
                "polynomial=" + polynomial +
                '}';
    }

    public Monomial getMaxMonomial(){
        Collections.sort(this.polynomial);
        if(polynomial.isEmpty())
            return new Monomial((double) 0,0);
        else
            return this.polynomial.get(0);
    }


}

