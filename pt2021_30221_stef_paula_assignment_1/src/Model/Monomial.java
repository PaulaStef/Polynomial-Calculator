package Model;

public class Monomial implements Comparable<Monomial>{
    private Double coefficient;
    private int degree;

    public Monomial(Double coefficient, Integer degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Model.Monomial{" +
                "coefficient=" + coefficient +
                ", degree=" + degree +
                '}';
    }

    @Override
    public int compareTo(Monomial o) {
        if(this.degree <= o.degree)
            return 1;
        else return -1;
    }
}
