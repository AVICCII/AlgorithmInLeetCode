package 牛客.剑指OFFER;

/**
 * @author aviccii 2021/8/3
 * @Discrimination
 */
public class JZ12_数值的整数次方 {
    public double Power(double base, int exponent) {
        double tmp = base;
        if (exponent >= 0){
            for (int i = 1; i < exponent; i++) {
                base *=tmp;
            }
        }
        else {
            exponent = - exponent;
            for (int i = 1; i < exponent; i++) {
                base *= tmp;
            }
            base = 1/base;
        }
        return base;
    }

    public static void main(String[] args) {
    }
}
