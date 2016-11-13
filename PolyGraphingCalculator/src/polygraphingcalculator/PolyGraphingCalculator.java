
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
        testPoly.printPolynomial();
        testPoly.sortByDegree();
        testPoly.printPolynomial();

        Polynomial kappa = new Polynomial("2x^2 - 5 + 12341 + 5x^2 - 8"); //testing string to polynomial
        kappa.printPolynomial();
    }
    
}
