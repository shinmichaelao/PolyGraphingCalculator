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
        String c;
        if (this.coeff == (int) this.coeff){
            if (this.coeff != 0)
                c = Integer.toString((int) this.coeff);
            else                
                return "";
        }
        else
            c = String.format(".03f", this.coeff);
        if (this.degree < 1)
            return c;
        else if (this.degree < 2)
            return String.format("%sx", c);
        else
            return String.format("%sx^%d", c, this.degree);
    }
}
