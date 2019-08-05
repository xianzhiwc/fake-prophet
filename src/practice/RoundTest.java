package practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundTest {
	
	public static void main(String[] args) {
		double   f   =   -111231.5585;
		long g = 0x7ffL;
		long valBits = Double.doubleToLongBits(f);
		int sign = ((valBits >> 63)==0 ? 1 : -1);
		String a = Long.toBinaryString(valBits);
		String d = Long.toBinaryString((valBits >> 52) & g);
		BigDecimal   b   =   new   BigDecimal(f);
		//double   f1   =   b.setScale(2,   RoundingMode.HALF_UP).doubleValue();
		System.out.println(d);
		//System.out.println(valBits);
		System.out.println(a);
		
	}

}

