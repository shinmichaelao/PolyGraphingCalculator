package polygraphingcalculator;


public class Term {
    //terms have a coefficient and a degree
    double coeff;
    int degree;
    
    public Term(double c, int d) {
        //creates term given coefficient and degree
        this.coeff = c;
        this.degree = d;
    }
    
    public Term getDerivative(){ 
        //basic derivative rules state that the derivative of ax^b is equal to (a*b)x^(b-1)
        return new Term(this.coeff*this.degree, this.degree-1);
    }
    
    public Term getIntegral(){
        //basic integral rules state that the indefinite integral of ax^b is equal to (a/(b+1) ) x^(b+1)
        return new Term(this.coeff/(this.degree+1), this.degree+1);
    }
    
    public Term add(Term t){
        //adds two terms while making sure their degrees match
        assert this.degree == t.degree;
        return new Term(this.coeff+t.coeff, this.degree);
    }
    
    public Term multiply(Term t){
        //multiplies two terms
        return new Term(this.coeff*t.coeff, this.degree+t.degree);
    }
    
    public String toString(){
        //converts a term into a string representation
        String c;
        if (this.coeff == (int) this.coeff){
            if (this.coeff == 1 && this.degree == 0)
                c = " + 1";
            else if (this.coeff == 1)
                c = " + ";
            else if (this.coeff == -1 && this.degree == 0)
                c = " - 1";
            else if (this.coeff == -1)
                c = " - ";
            else if (this.coeff > 0)
                c = " + " + Integer.toString((int) this.coeff);
            else if(this.coeff < 0){
                c = " - " + Integer.toString((int) -this.coeff);
            }
            else                
                return "";
        }
        else if(this.coeff > 0){
            c = String.format(" + %.03f", this.coeff);
        }
        else{
            c = String.format(" - %.03f", -this.coeff);
        }
        if (this.degree < 1)
            return c;
        else if (this.degree < 2)
            return String.format("%sx", c);
        else
            return String.format("%sx^%d", c, this.degree);
    }
}
