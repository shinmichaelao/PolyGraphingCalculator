/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Polynomial {
    List<Term> terms = new ArrayList();
    
    public Polynomial(List<Term> t){
        this.terms = t;
    }
    
    public void printPolynomial(){
        System.out.println("");
        for(Term t: this.terms){
            System.out.print(t.coeff+"x^"+t.degree + " ");
        }
    }
    
    public void sortByDegree(){
        this.terms = MergeSort.mergeSort(terms);
    }
}
