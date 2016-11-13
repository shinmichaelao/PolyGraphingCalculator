
package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;


public class Polynomial {
    List<Term> terms = new ArrayList();
    
    public Polynomial(List<Term> t){
        this.terms = t;
    }
    
    public Polynomial(String s){
        //the variable i will be the current pointer
        int i = 0;
        //while(i < s.length()){
            String coeff = "0";
            String degree = "0";
            String cur_char = "imapotato";
            
            //get the coefficient
            while(i < s.length()){
                cur_char = s.substring(i,i+1);
                if(cur_char.equals("x") || cur_char.equals("+") || cur_char.equals("-") || cur_char.equals(" ")){
                    break;
                }
                coeff += cur_char;
                i++;
                System.out.println("pos: "+i);
            }
            System.out.print(Double.parseDouble(coeff));
            
            //check if there is an "x" portion, otherwise coefficient is 0 like before
            if(cur_char.equals("x")){
                //if theres nothing after the x, then the degree is 1
                if(i == s.length()-1){
                    degree = "1";
                }
                //check the next few characters until we get to a " ", "+","-"
            }
            
            System.out.println("x^" + Integer.parseInt(degree));
       // }
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
