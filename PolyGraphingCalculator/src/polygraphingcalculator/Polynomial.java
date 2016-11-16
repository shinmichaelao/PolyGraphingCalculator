
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
        s = s.replaceAll("\\s+",""); //cleanse the MISOGYNISTIC WHITE SPACES xd
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
                else if(cur_char.equals("+") || cur_char.equals("-")){
                    if(!coeff.equals("")){
                        break;
                    }
                }
                coeff += cur_char;
                i++;
            }
            
            if(coeff.equals("")){
                coeff = "1";
            }
            else if(coeff.equals("-")){
                coeff = "-1";
            }
            else if(coeff.equals("+")){
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
                        
                        if(cur_char.equals("^")){
                            i++;
                            continue;
                        }
                        degree += cur_char;
                        i++;
                    }
                    
                    if(degree.equals("0")){
                        degree = "1";
                    }
                }
            }
            Term newTerm = new Term(Double.parseDouble(coeff),Integer.parseInt(degree));
            this.terms.add(newTerm); //put together the term
        }
        
        this.sortByDegree(); //sort this mf
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

    
    public String toString(){
        String qwer = "";
        for (Term t: this.terms) {
           String term = t.toString();
           if (t.coeff > 0)
              qwer = qwer.concat( "+ " );
//           else if (t.coeff < 0)
//               qwer = qwer.concat ("- ");
           
           qwer = qwer.concat(term + " ");
           
           
            
        }
        return qwer;
    }
    
    public void sortByDegree(){
        this.terms = MergeSort.mergeSort(terms);
    }
}
