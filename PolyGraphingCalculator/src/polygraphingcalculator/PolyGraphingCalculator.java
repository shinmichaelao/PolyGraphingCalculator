package polygraphingcalculator;

public class PolyGraphingCalculator {
    static final double maxValue = Math.pow(2, 28);
    static final double lnMaxValue = 20*Math.log(2);
    
    public static void main(String[] args) {
        Polynomial test1 = new Polynomial("4x^2 + 2x + 1");
        Polynomial test2 = new Polynomial("2x^2 + 2x + 1");
        Polynomial[] test3 = test1.polyDivide(test2);
        System.out.println(test3[0].toString());
        System.out.println(test3[1].toString());
        //System.out.println(test1.toString());
        //Polynomial test2 = new Polynomial(" -1.01x^2 + 1.1x + 15");
       // System.out.println(test2.toString());
        GUI.main(args);
        
    }
    
}
