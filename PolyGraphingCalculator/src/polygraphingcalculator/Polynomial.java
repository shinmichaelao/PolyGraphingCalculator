
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
            
            
            //check if there is an "x" portion, otherwise coefficient is 0 like before
            if(cur_char.equals("x")){
                //if theres nothing after the x, then the degree is 1
                if(i == s.length()-1){
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
            
            this.terms.add(new Term(Double.parseDouble(coeff),Integer.parseInt(degree))); //put together the term
        }
        
        this.sortByDegree(); //sort this mf
    }
    
    public void printPolynomial(){
        System.out.println("");
        for(Term t: this.terms){
            System.out.print(t.toString()+" ");
        }
    }
    
    public void sortByDegree(){
        this.terms = MergeSort.mergeSort(terms);
    }
}
