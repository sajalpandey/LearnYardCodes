class Solution {
    public String updateEmail(String str) {
        StringBuilder result = new StringBuilder();

        int atIndex = str.indexOf('@');
        for (int i = 0; i < atIndex; i++) {
            char c = str.charAt(i);
            if (c == '+') {
                break;
            } else if (c == '.') {
                continue;
            } else {
                result.append(c);
            }
        }
        result.append(str.substring(atIndex));
        return result.toString();
    }

    public int numUniqueEmails(String[] emails) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : emails) {
            String newEmail = updateEmail(str);
            map.put(newEmail,map.getOrDefault(newEmail,0)+1);
        }
        return map.size();
    }
}