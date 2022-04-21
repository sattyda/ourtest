import myclass.*;

public class Sorting {
	public static void main(String[] args) {
		
		Test1 t1 = new Test1();
	
//		System.out.println(Test1.counter);
	
		Test1 t2 = new Test1();
		
//		System.out.println(Test1.counter);
		
		Test1 t3 = new Test1();
		
//		System.out.println(Test1.counter);	
		
		
		
		int[] numbers = new int[300000000];
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i*2+1;
//			System.out.println(numbers[i]);
		}
		
		/// Linear Search /// 
		int search = 6;
		
		boolean checker = false;
		
		int looper = 0;
//		
//		for(int i = 0; i < numbers.length; i++) {
//			if(search == numbers[i]) {
//				checker = true;
//				break;	
//			}
//			looper++;
//		}
//		
//	
//		System.out.println(checker);
//		System.out.println(looper);
		
		int first  = 0;
		int last = numbers.length-1;
		
		while( first < last) {
			int mid = (first+last)/2;
			if(numbers[mid] == search) {
				checker = true;
				break;
			} else if( numbers[mid] > search ) {
				last= mid;
			}else if( numbers[mid] < search ) {
				first= mid+1;
			}
			
			looper++;
		}

		System.out.println(checker);
		System.out.println(looper);
		
	}
}