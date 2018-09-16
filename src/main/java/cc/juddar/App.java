package cc.juddar;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //此方式可以用来判断两个bigdecimal数字相乘会不会有小数产生
        BigDecimal boostMoney =new BigDecimal("3");
        BigDecimal assitMultiple = new BigDecimal("1.5");

        BigDecimal resMultiplyUP = boostMoney.multiply(assitMultiple).setScale(0, RoundingMode.UP);
        BigDecimal resMultiplyDOWN = boostMoney.multiply(assitMultiple).setScale(0, RoundingMode.DOWN);
        System.err.println("resMultiplyDOWN:" + resMultiplyDOWN + " resMultiplyUP:" + resMultiplyUP+ "  " + resMultiplyDOWN.compareTo(resMultiplyUP));
    }
}
