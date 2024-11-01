class Solution {
    public int findSquare(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        HashSet<Integer> set = new HashSet<>();
        while(n > 1) {
            int new_num = findSquare(n);
            if(set.contains(new_num))
                break;
            if(new_num == 1)
                return true;
            n = new_num;
            set.add(n);
        }
        return false;
    }
}