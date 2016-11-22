package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;


public class Polynomial {
    List<Term> terms = new ArrayList();    
    
    public Polynomial(List<Term> t){
        this.terms = t;
        this.sortByDegree();
    }
    
    public Polynomial(String s){
        if(s.equals("0")){
            this.terms.add(new Term(0,0));
        }
        else{
            s = s.replaceAll("\\s+",""); //removes the white space
            //the variable i will be the current pointer
            int i = 0;
            while(i < s.length()){
                String coeff = "";
                String degree = "0";
                String cur_char = "";

                //get the coefficient
                while(i < s.length()){
                    cur_char = s.substring(i,i+1);
                    if(cur_char.equals("x")){
                        break;
                    }
                    else if(cur_char.equals("-")){
                        if(coeff.equals("-")){
                            coeff = "+";
                            i++;
                            continue;
                        }
                        else if(coeff.equals("+")){
                            coeff = "-";
                            i++;
                            continue;
                        }
                        else if(!coeff.equals("")){
                            break;
                        }
                    }
                    else if(cur_char.equals("+")){
                        if(coeff.equals("-")){
                            coeff = "-";
                            i++;
                            continue;
                        }
                        else if(coeff.equals("+")){
                            coeff = "+";
                            i++;
                            continue;
                        }
                        else if(!coeff.equals("")){
                            break;
                        }
                    }
                    coeff += cur_char;
                    i++;
                }

                //special cases
                if(coeff.equals("")){ //nothing in front of an x
                    coeff = "1";
                }
                else if(coeff.equals("-")){//negative sign in front of x
                    coeff = "-1";
                }
                else if(coeff.equals("+")){//only a + sign in front of x
                    coeff = "1";
                }

                //check if there is an "x" portion, otherwise coefficient is 0 like before
                if(cur_char.equals("x")){
                    //if theres nothing after the x, then the degree is 1
                    if(i == s.length()-1){
                        i++;
                        degree = "1";
                    }
                    else{
                    //check the next few characters until we get to a " " or  "+" or "-"
                        i++;
                        while(i<s.length()){
                            cur_char = s.substring(i,i+1);
                            if(cur_char.equals("+") || cur_char.equals("-")){
                                break;
                            }

                            if(cur_char.equals("^")){//skip the carat
                                i++;
                                continue;
                            }
                            degree += cur_char;
                            i++;
                        }

                        if(degree.equals("0")){// Example: x+1 when we get to the + sign, the loop breaks and the degree variable never changes but the degree should be 1
                            degree = "1";
                        }
                    }
                }
                Term newTerm = new Term(Double.parseDouble(coeff),Integer.parseInt(degree));
                this.terms.add(newTerm); //put together the term
            }

            this.sortByDegree(); //sort this mf
        }
    }
    
    public Polynomial polyAdd(Polynomial poly){
        List<Term> myTerms = new ArrayList();
        myTerms.addAll(this.terms);
        myTerms.addAll(poly.terms);
        return new Polynomial(myTerms);
    }
    public Polynomial polySubtract(Polynomial poly){
        List<Term> myTerms = new ArrayList();
        myTerms.addAll(this.terms);
        for(Term t: poly.terms){
            myTerms.add(new Term(-t.coeff,t.degree));
        }
        return new Polynomial(myTerms);
    }
    
    public Polynomial polyMultiply(Polynomial poly){
        Term termA = null;
        Term termB = null;
        List<Term> myTerms = new ArrayList();
        for (int i = 0; i < this.terms.size(); i++) {
            termA = this.terms.get(i);
            for (int j = 0; j < poly.terms.size(); j++) {
                termB = poly.terms.get(j);
                myTerms.add(termA.multiply(termB));
            }
        }        
        return new Polynomial(myTerms);
    }
    
    public Polynomial[] polyDivide(Polynomial poly){
        List<Term> quotient = addZeroes(this.terms);
        List<Term> divisor = addZeroes(poly.terms);
        double botCoeff = divisor.get(0).coeff;
        for(int i = 0; i < quotient.size() - divisor.size() + 1;i++){
            Term qCurTerm = quotient.get(i);
            qCurTerm.coeff /= botCoeff;
            
            double curCoeff = qCurTerm.coeff;
            if(curCoeff != 0){
                for(int j = 1;j < divisor.size();j++){
                    Term qModTerm = quotient.get(i+j);
                    qModTerm.coeff += -divisor.get(j).coeff * curCoeff;
                }
            }
        }
        
        Polynomial actualQuotient = new Polynomial(quotient.subList(0, quotient.size()-divisor.size()+1));
        for(Term t: actualQuotient.terms){
            t.degree -= divisor.size()-1;
        }
        Polynomial remainder = new Polynomial(quotient.subList(quotient.size()-divisor.size()+1, quotient.size()));
        
        Polynomial[] returnStuff = {actualQuotient, remainder};
        return returnStuff;
    }
    
    public static List<Term> addZeroes(List<Term> myTerms){
        for(int i = 0; i<myTerms.size();i++){
            Term curTerm = myTerms.get(i);
            if(curTerm.degree == 0){
                break;
            }
            else if(i == myTerms.size() - 1){
                myTerms.add(new Term(0,curTerm.degree - 1));
            }
            else{
                Term nextTerm = myTerms.get(i+1);
                if(curTerm.degree != nextTerm.degree + 1){
                    myTerms.add(i+1, new Term(0,curTerm.degree-1));
                }
            }
        }
        return myTerms;
    }
    
    public Polynomial getDerivative(){
        List<Term> myTerms = new ArrayList();
        for (int i = 0; i < this.terms.size(); i++) {
            myTerms.add(this.terms.get(i).getDerivative());
        }
        return new Polynomial(myTerms);
    }
    
    public Polynomial getIntegral(){
        List<Term> myTerms = new ArrayList();
        for (int i = 0; i < this.terms.size(); i++) {
            myTerms.add(this.terms.get(i).getIntegral());
        }
        return new Polynomial(myTerms);
    }
    
    public String toString(){
        String newString = "";
        for (Term t: this.terms) {
           String term = t.toString();
           newString += term;
        }
        int indexOfPlus = newString.indexOf("+");
        int indexOfMinus = newString.indexOf("-");
        
        if(newString.equals("")){
            return "0";
        }
        else if (indexOfPlus == 1 || indexOfMinus == 1){
            String a = newString.substring(3);
           
            if (indexOfMinus == 1)
                return ("-" + a);
            else
                return a;

        }
        else
            return newString;
 
    }
    
    public void sortByDegree(){
        this.terms = MergeSort.mergeSort(terms);
    }
    
    public double evaluateAt(double x) throws java.lang.ArithmeticException{
        double value = 0;
        double next, exp;
        for (Term t: this.terms){
            //Check whether an exponentiation causes overflow
            if (t.degree*Math.log(Math.abs(x)) > PolyGraphingCalculator.lnMaxValue){
                throw new java.lang.ArithmeticException();
            }
            next = t.coeff * Math.pow(x, t.degree);
            //Check whether addition causes overflow
            if (next > (PolyGraphingCalculator.maxValue - value) || next < -(PolyGraphingCalculator.maxValue + value)){
                throw new java.lang.ArithmeticException();
            }
            value += next;
        }
        return value;
    }
}
