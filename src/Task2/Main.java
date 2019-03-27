public class Main{
	private static String testLengthString;
	private static String[] testPassword;
	private static long start;
	private static long end;
	private static long elapsedTime;


	public static void main(String[] args) {
		Secret s = new Secret();
		testLengthString = "";
		while(true) {
			testLengthString = testLengthString.concat("0");
			try {
				s.verifyPassword(testLengthString);
				break;
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}


		testingPassword(s);
		System.out.println("The password is: " + toString(testPassword));
		System.out.println("The secret is: " + s.getSecret());
	}

	public static String toString(String[] theArray){       //converts string array to string
		String theString = "";
		for(int i = 0; i < theArray.length; i++)
			theString = theString.concat(theArray[i]);
		return theString;
	}


	public static void testingPassword(Secret s){
		String inString = "";
		String[] integers = new String[]{"0","1","2","3","4","5","6","7","8","9"};      //string array containing numbers 1-9 in string
		testPassword = new String[testLengthString.length()];       //the String array to be tested against the password

		for(int i = 0; i < testPassword.length; i++){       //sets all indexes to string "0"
			testPassword[i] = "0";
		}


		//each character takes 10ms to check
		//if it exceeds 10ms, the first character is correct, exceeding 20ms means the second character is correct, and so on
		while(true) {
			try {
				for (int i = 0; i < testPassword.length; i++) {	//loop through the length of the length of the password
					System.out.println("(i=" + i + ")");
					for (int j = 0; j < integers.length; j++) {	//loop through the number of integers if 0 is incorrect (1-9)
						inString = toString(testPassword);
						start = System.currentTimeMillis();
						s.verifyPassword(inString);
						end = System.currentTimeMillis();

						elapsedTime = end - start;
						System.out.println("The code " + inString + " took " + elapsedTime + "ms (j=" + j + ")");
						if(elapsedTime >= 10*(i+1)){		//if character is correct, break the loop
							break;
						}else
						testPassword[i] = integers[j];	//go
					}
				}
				break;
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		//return testPassword;
	}
}