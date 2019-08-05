package practice;


public class SortTest {
     public void popSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i]>a[j]) {
					int tmp = a[i];
					a[i]=a[j];
					a[j]=tmp;					
				}
			}
		}
	}
     public static void main(String[] args) {
		int[] a={1,5,6,8,9,4,3,7,2};
		SortTest sort = new SortTest();
		sort.popSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		
	}
}
