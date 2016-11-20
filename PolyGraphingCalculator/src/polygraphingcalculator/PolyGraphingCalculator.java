
package polygraphingcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PolyGraphingCalculator {

    
    public static void main(String[] args) {
        Polynomial test1 = new Polynomial("4x^2 + 3x + 5x");
        System.out.println(test1.getIntegral().toString());
        //System.out.println(test1.toString());
        //Polynomial test2 = new Polynomial(" -10x + 20x + 15");
       // System.out.println(test2.toString());
        GUI.main(args);
        
    }
    
}
