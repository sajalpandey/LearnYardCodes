import java.util.StringTokenizer;
class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            tokens.add(token);
        }
        StringBuilder result = new StringBuilder();
        for(int i=tokens.size()-1; i>=0; i--) {
            result.append(tokens.get(i));
            if(i != 0)
                result.append(' ');
        }
        return result.toString();
    }
}