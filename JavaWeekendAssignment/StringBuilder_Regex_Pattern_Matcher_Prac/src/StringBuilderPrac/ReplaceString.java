package StringBuilderPrac;

public class ReplaceString {

	public static void main(String[] args) {
		String str = "My name is Atharva and Atharva";
		String str2 = "Atharva";
		StringBuilder sb = new StringBuilder(str);
		
		if(str.contains(str2)) {
			str = str.replace(str2, "%");
			System.out.println(str);
		}

		int index = -1;
	       while ((index = sb.indexOf(str2)) != -1) {
	           sb.replace(index, index + str2.length(), "5");
	       }

	       String replacedString = sb.toString();
	       System.out.println("Output: " + replacedString);
	}
}
