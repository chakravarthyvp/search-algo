package io.varaga.ds.hash;

public class HashTableTest {

	static int[] boldI = new int[1001];

    public String addBoldTag(String s, String[] dict) {
        //edge cases what to return if s / dict is null or empty
        
        if(s == null || s.isEmpty()) {
            return null;
        }
        
        if(dict == null || dict.length == 0) {
            return s;
        }
        
        for(int i = 0; i < dict.length; i++) {
            String word = dict[i];
            int start = s.indexOf(word);
            while (start != -1){
                int endI = start + word.length();
                updateBold(start, endI);
                start = s.indexOf(word, start + 1);
            }
        }
        
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        if(boldI[0] == 1) {
            builder.append("<b>");   
        }
        builder.append(chars[0]);
        
        for(int i = 1; i < chars.length; i++) {
            if(boldI[i] > boldI[i-1]) {
                builder.append("<b>"); 
            }
            if (boldI[i] < boldI[i-1]) {
                builder.append("</b>"); 
            }
            builder.append(chars[i]);
        }
       
        if(boldI[chars.length] <  boldI[chars.length-1]) {
            builder.append("</b>");   
        }
        
        return builder.toString();
    }
    
    public void updateBold(int start, int end){
        while (start < end) {
            boldI[start] = 1;
            start++;
        }
    }
    
	public static void main(String ...args) {
		System.out.println(new HashTableTest().addBoldTag("aaabbcc", new String[] {"aaa","aab","bc"}));
		/**
		 * "aaabbcc"
["aaa","aab","bc"]
		 */
	}
}

