package StringBuilderPrac;


public class AlphaOnlyRev {

    public static StringBuilder reverseAlpha(String text) {
    	
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 0;

        while (end < text.length()) {
            if (Character.isLetter(text.charAt(end)) ) {
                end++;
            } else if(Character.isDigit(text.charAt(end))&& start==end)
            {
            	result.append(text.charAt(end));
                start=end;start++;end++;continue;
            }
            else if(Character.isDigit(text.charAt(end))&& Character.isLetter(text.charAt(end-1))){
                result.append(reverseWord(text, start, end)).append(text.charAt(end));
                start = end++;
            }else {result.append(text.charAt(end));
            start=end;start++;end++;}
        }
        result.append(reverseWord(text, start, end));
        return result;
    }
    private static String reverseWord(String text, int start, int end) {
        char[] chars = text.substring(start, end).toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "123test123test";
        String reversed = reverseAlpha(input).toString();
        System.out.println("Reversed string: " + reversed); // Output: tset1234tset
    }
}


