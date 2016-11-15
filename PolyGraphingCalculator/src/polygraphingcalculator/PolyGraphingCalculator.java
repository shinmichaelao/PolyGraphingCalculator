
package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PolyGraphingCalculator {

    
    public static void main(String[] args) {
        GUI.main(args);
        
        Random rn = new Random(); //testing the sorting
        List<Term> array = new ArrayList();
        for (int i = 0; i < 10; i++) {
            array.add(new Term(rn.nextInt(10),rn.nextInt(3)));
        }
        
        Polynomial testPoly = new Polynomial(array); //sorting opop

        testPoly.sortByDegree();


        Polynomial kappa = new Polynomial("-x^2 - 5 + 12341 - 8"); //testing string to polynomial
        System.out.println(kappa.toString());
    }
    
}
