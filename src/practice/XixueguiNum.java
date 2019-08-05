package practice;

public class XixueguiNum {
  public void numMeth(int bitNum){
	  for (int  p = 1;  p < bitNum; p+=2) {
		  lable : for (int j = (int)Math.pow(10,p); j<Math.pow(10, p+10);j++){
			  Integer it = new Integer(j);
			  char[] ch = it.toString().toCharArray();
			  for (int k = 0; k < ch.length; k++) {
				  int mult1 = ((ch[k]-'0')+(ch[ch.length-1-k]-'0'));
				for (int l = 0; l < ch.length; l++) {
					if(l==k || l==ch[ch.length-1-k]-'0') continue;
					int mult2 = ((ch[l]-'0')+(ch[ch.length-1-l]-'0'));
					int rslt = mult1 * mult2;
					if (rslt==j){
						System.out.println(j+"ÎªÎüÑª¹íÊý×Ö");
						continue lable;
					}
				}
			}
		  }
	}
  }
  public static void main(String[] args) {
   XixueguiNum xxg = new XixueguiNum();
   xxg.numMeth(4);
}
}
