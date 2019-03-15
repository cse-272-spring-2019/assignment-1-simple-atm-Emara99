

public class Bank {
	
	private static String Passcode="12345";
	private static String Visa_id="1234";
	
	public boolean CheckPasscode(String s,String k) {
		
		if(Passcode.equals(k)&& Visa_id.equals(s)) {
			return true;
		}
		return false;
		}
	
			
	 
}

