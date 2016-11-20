package polygraphingcalculator;

public class PolyGraphingCalculator {
    static final double maxValue = Math.pow(2, 31)-1;
    
    public static void main(String[] args) {
        Polynomial test1 = new Polynomial("5x - 50x^2");
        System.out.println(test1.toString());
        //Polynomial test2 = new Polynomial(" -10x + 20x + 15");
       // System.out.println(test2.toString());
        GUI.main(args);
        
    }
    
}
