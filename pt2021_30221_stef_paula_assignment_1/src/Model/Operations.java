package Model;

import Model.Monomial;
import Model.Polynomial;

import java.util.Collections;

public class Operations {

    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        Polynomial copyTwo = polynomial2;
        for (Monomial first : polynomial1.getPolynomial()) {
            boolean found = false;
            double coefficient = first.getCoefficient();
            for (Monomial second : polynomial2.getPolynomial()) {
                if (first.getDegree() == second.getDegree()) {
                    if (first.getCoefficient() + second.getCoefficient() != 0.0) {
                        coefficient += second.getCoefficient();
                        result.addMonomial(coefficient, first.getDegree());
                    }
                    found = true;
                    copyTwo.getPolynomial().remove(second);
                    break;
                }
            }
            if (!found) {
                result.addMonomial(coefficient, first.getDegree());
            }
        }
        for (Monomial monomial2 : polynomial2.getPolynomial()) {
            result.addMonomial(monomial2.getCoefficient(), monomial2.getDegree());
        }
        Collections.sort(result.getPolynomial());
        return result;
    }

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();
        Polynomial copyTwo = polynomial2;
        for (Monomial first : polynomial1.getPolynomial()) {
            double coefficient = first.getCoefficient();
            for (Monomial second : polynomial2.getPolynomial())
                if (first.getDegree().equals(second.getDegree())) {
                    coefficient -= second.getCoefficient();
                    copyTwo.getPolynomial().remove(second);
                    break;
                }
            if (coefficient != 0) {
                result.addMonomial(coefficient, first.getDegree());
            }
        }

        for(Monomial monomial2 : copyTwo.getPolynomial()) {
            result.addMonomial((-1) * monomial2.getCoefficient(), monomial2.getDegree());
        }
        Collections.sort(result.getPolynomial());
        return result;
    }


    public Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        for(Monomial monomialOne : polynomial1.getPolynomial()){
            Polynomial aux = new Polynomial();
            for(Monomial monomialTwo : polynomial2.getPolynomial()){
                aux.addMonomial(monomialOne.getCoefficient()*monomialTwo.getCoefficient(),monomialOne.getDegree()+monomialTwo.getDegree());
            }
            result = add(aux,result);
        }
        Collections.sort(result.getPolynomial());
        return result;
    }

    public Polynomial[] divide (Polynomial polynomial1, Polynomial polynomial2){
        Polynomial[] result = new Polynomial[2];
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(polynomial1);
        Monomial maxMonomial2 = polynomial2.getMaxMonomial();
        //System.out.println(maxMonomial2);
        if(maxMonomial2.getCoefficient() == 0) {
            result = null;
        }
        else {
            if (maxMonomial2.getDegree() == 0) {
                for (Monomial monomialX : polynomial1.getPolynomial()) {
                    quotient.addMonomial(monomialX.getCoefficient() / maxMonomial2.getCoefficient(), monomialX.getDegree());
                }
            }
            else {
                while(remainder.getMaxMonomial().getDegree() >= maxMonomial2.getDegree()){
                    Monomial devident = remainder.getMaxMonomial();
                    double coefficient = devident.getCoefficient() / maxMonomial2.getCoefficient();
                    int degree = devident.getDegree() - maxMonomial2.getDegree();
                    quotient.addMonomial(coefficient,degree);
                    Polynomial aux = new Polynomial();
                    aux.addMonomial(coefficient,degree);
                    Polynomial subtractionAux = multiplication(polynomial2, aux);
                    remainder = subtract(remainder,subtractionAux);
                }
            }
            result[0] = quotient;
            result[1] = remainder;
        }
        return result;
    }

    public Polynomial derivate(Polynomial polynomial){
        Polynomial result = new Polynomial();
        for(Monomial monomial : polynomial.getPolynomial()){
            if(monomial.getDegree() > 0 )
                result.addMonomial(monomial.getCoefficient()* monomial.getDegree(), monomial.getDegree() - 1 );
        }
        Collections.sort(result.getPolynomial());
        return result;
    }
    public Polynomial integrate(Polynomial polynomial){
        Polynomial result = new Polynomial();
        for(Monomial monomial : polynomial.getPolynomial()){
            result.addMonomial(monomial.getCoefficient()/(monomial.getDegree()+1), monomial.getDegree()+1);
        }
        Collections.sort(result.getPolynomial());
        return result;
    }

}
