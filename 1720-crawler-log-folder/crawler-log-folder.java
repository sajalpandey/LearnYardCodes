class Solution {
    public int minOperations(String[] logs) {
        int operations = 0;
        for(String str : logs) {
            if(str.equals("../"))
                operations = Math.max(0, --operations);
            else if(str.equals("./")) {
                //do nothing
            } else {
                operations++;
            }
        }
        return operations;
    }
}