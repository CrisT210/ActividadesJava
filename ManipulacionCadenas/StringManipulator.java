
public class StringManipulator {
	
	public String trimAndConcat(String strA, String strB) {
		String str = strA.trim().concat(strB.trim()); 
		return str;
		
	}
	
	public int getIndexOrNull(String strA, char n) {
		int idx = strA.indexOf(n);   
		return idx;
	}
	
	public int getIndexOrNull(String strA, String strB) {
		int idx = strA.indexOf(strB);
		return idx;
	}
	
	public String concatSubstring(String strA, int a, int b, String strB) {
		String sub = strA.substring(a, b);
		String res = sub.concat(strB);
		return res;
	}
}
