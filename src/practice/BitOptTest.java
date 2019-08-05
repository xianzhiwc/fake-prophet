package practice;

/**
 * @author ProphetWC
 *
 */
public class BitOptTest {	
	public static void bitNoSignRightMove(int ob,int op) {
		System.out.println(Integer.toBinaryString(ob));
		System.out.println(Integer.toBinaryString(ob>>>=op));
	}
	public static void bitLeftMove(int ob,int op) {
		System.out.println(Integer.toBinaryString(ob));
		System.out.println(Integer.toBinaryString(ob<<=op));
	}
	public static void bitSignRightMove(int ob,int op) {
		System.out.println(Integer.toBinaryString(ob));
		System.out.println(Integer.toBinaryString(ob>>=op));
	}
	public static void main(String[] args) {
		BitOptTest.bitSignRightMove(-2, 10);
		BitOptTest.bitNoSignRightMove(-2, 10);
		BitOptTest.bitLeftMove(-2, 10);
		
	}
}
