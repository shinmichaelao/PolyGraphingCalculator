
package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;


public class MergeSort {
    //implementation of mergeSort from greatest to smallest degree
    public static List<Term> mergeSort(List<Term> a){
        int length = a.size();
        //if the list has a size of 1 or 0, just return the list
        if(length <= 1){
            return a;
        }
        
        //split the list into two halves
        List<Term> kappa = new ArrayList();
        for(Term i: a.subList(0, length/2)){
                kappa.add(i);
        }
        List<Term> kappa2 = new ArrayList();
        for(Term i: a.subList(length/2, length)){
                kappa2.add(i);
        }
        
        //recursively sort each half of the list
        List<Term> half1 = mergeSort(kappa);
        List<Term> half2 = mergeSort(kappa2);
        
        //merge the sorted halves
        return merge(half1,half2);
    }
    
    public static List<Term> merge(List<Term> a1,List<Term> a2){
        //empty list that will be filled by the sorted terms in each list
        List<Term> result = new ArrayList();
        
        //compares each element of the two halves until one list is empty
        while(a1.size() > 0 && a2.size() > 0){
            //if their degrees are the same, add a term with the sum of their coefficients to the result list and compare the next terms
            if(a1.get(0).degree == a2.get(0).degree){
                result.add(new Term(a1.get(0).coeff + a2.get(0).coeff, a1.get(0).degree));
                a1.remove(0);
                a2.remove(0);
            }
            //if the degree of a1 is larger than a2, put the term from a1 into result and compare the next term from a1
            else if(a1.get(0).degree > a2.get(0).degree){
                result.add(a1.get(0));
                a1.remove(0);
            }
            //otherwise, stick a2 into result and compare the next term from a2
            else{
                result.add(a2.get(0));
                a2.remove(0);
            }
        }
        
        //put the rest of the terms in the non-empty array into result
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
        
        //return sorted list
        return result;
    }
}
