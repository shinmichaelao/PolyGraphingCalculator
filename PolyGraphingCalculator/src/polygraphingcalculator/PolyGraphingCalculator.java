package polygraphingcalculator;

public class PolyGraphingCalculator {
    //values used to avoid double overflows
    static final double maxValue = Math.pow(2, 28);
    static final double lnMaxValue = 20*Math.log(2);
    
    public static void main(String[] args) {
        GUI.main(args);
    }
    
}
