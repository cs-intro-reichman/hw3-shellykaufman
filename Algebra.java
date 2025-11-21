// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x2 < 0){
			for(int i = x2; i < 0; i++)
			{
				sum --;
			}
		}
		else{
			for(int i = 0; i < x2; i++){
				sum ++;
			}
		}	
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if(x2 < 0){
			for(int i = x2; i < 0; i++)
			{
				sum ++;
			}
		}
		else{
			for(int i = 0; i < x2; i++){
				sum --;
			}
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if(x2 < 0)
		{
			if(x1 > 0){
				x2 = minus(0, x2);
				for(int i = 0; i < x2; i++){
					sum = plus(sum, x1);
				}
				sum = minus(0, sum);
			}
			if(x1 < 0){
				x1 = minus(0, x1);
				x2 = minus(0, x2);
				for(int i = 0; i < x2; i++){
					sum = plus(sum, x1);
				}
			}
		}
		else if(x2 > 0){
			if(x1 < 0){
				x1 = minus(0, x1);
				for(int i = 0; i < x2; i++){
					sum = plus(sum, x1);
					}
				sum = minus(0, sum);
			}
			if(x1 > 0){
				for(int i = 0; i < x2; i++){
					sum = plus(sum, x1);
				}
			}

		}
		return sum;
	}


	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(n == 0){
			return 1;
		}
		else{
			int sum = 1;
			for(int i = 0; i < n; i++)
			{
				sum = times(sum, x);
			}
			return sum;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count_times = 1;
		int sumx2 = x2;
		if(x1 == 0 || x2 == 0){
			return 0;
		}
		if(x1 == x2){
			return 1;
		}
		if (x1 < 0) {
			if(x2 < 0){
				x1 = minus(0, x1);
				x2 = minus(0, x2);
				while (x1 > sumx2) {
					count_times++;
					sumx2 = times(x2, count_times);
				}
				if(x1 != sumx2){
					count_times--;
				} 	
			}
			if(x2 > 0){
				x1 = minus(0, x1);
				while (x1 > sumx2) {
					count_times++;
					sumx2 = times(x2, count_times);
				}
				if(x1 != sumx2){
					count_times--;
				} 
				count_times = minus(0, count_times);
				}
		}
		if (x1 > 0){
			if(x2 < 0){
				x2 = minus(0, x2);
				while (x1 > sumx2) {
					count_times++;
					sumx2 = times(x2, count_times);
				}
				if(x1 != sumx2){
					count_times--;
				} 
				count_times = minus(0, count_times);
				
			}
			
			if(x2 > 0){
				while(x1 > sumx2){
					count_times++;
					sumx2 = times(x2, count_times);
				}
				if(x1 != sumx2){
					count_times--;	
				} 
			}
		}
		return count_times;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
	int divXY = div(x1, x2);
	int minusTimes = times(divXY, x2);
	int modolu = minus(x1, minusTimes);
	return modolu;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 0;
		int square = 0;
		while (square <= x){
			root++;
			square = times(root, root);
		}
		int toReturn = minus(root, 1);
		return toReturn;
	}	  	  
}