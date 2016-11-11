package polygraphingcalculator;


public class Term {
    double coeff;
    final int degree;

    
    public Term(double c, int d) {
        this.coeff = c;
        this.degree = d;
    }
    
    public Term getDerivative(){      
        return new Term(this.coeff*this.degree, this.degree-1);
    }
    
    public Term getIntegral(){
        return new Term(this.coeff/this.degree, this.degree+1);
    }
    
    public Term add(Term t){
        assert this.degree == t.degree;
        return new Term(this.coeff+t.coeff, this.degree);
    }
    
    public Term multiply(Term t){
        return new Term(this.coeff*t.coeff, this.degree+t.degree);
    }
    
    public String toString(){
        return String.format("%.03fx^%d", this.coeff, this.degree);
    }
}
