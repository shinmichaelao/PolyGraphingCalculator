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
public class MergeSort {
    
    public static List<Term> mergeSort(List<Term> a){
        int length = a.size();
        if(length <= 1){
            return a;
        }
        
        List<Term> kappa = new ArrayList();
        for(Term i: a.subList(0, length/2)){
                kappa.add(i);
        }
        List<Term> kappa2 = new ArrayList();
        for(Term i: a.subList(length/2, length)){
                kappa2.add(i);
        }
        List<Term> half1 = mergeSort(kappa);
        List<Term> half2 = mergeSort(kappa2);
        
        return merge(half1,half2);
    }
    
    public static List<Term> merge(List<Term> a1,List<Term> a2){
        List<Term> result = new ArrayList();
        
        while(a1.size() > 0 && a2.size() > 0){
            if(a1.get(0).degree == a2.get(0).degree){
                result.add(new Term(a1.get(0).coeff + a2.get(0).coeff, a1.get(0).degree));
                a1.remove(0);
                a2.remove(0);
            }
            else if(a1.get(0).degree > a2.get(0).degree){
                result.add(a1.get(0));
                a1.remove(0);
            }
            else{
                result.add(a2.get(0));
                a2.remove(0);
            }
        }
        
        if(a1.isEmpty()){
            for(Term i: a2){
                result.add(i);
            }
        }
        else{
            for(Term i: a1){
                result.add(i);
            }
        }
        
        return result;
    }
}
