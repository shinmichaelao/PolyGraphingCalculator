
package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PolyGraphingCalculator {

    
    public static void main(String[] args) {
        Random rn = new Random();
        List<Term> array = new ArrayList();
        for (int i = 0; i < 10; i++) {
            array.add(new Term(rn.nextInt(10),rn.nextInt(3)));
        }
        
        Polynomial testPoly = new Polynomial(array);
        testPoly.printPolynomial();
        testPoly.sortByDegree();
        testPoly.printPolynomial();
    }
    
}
