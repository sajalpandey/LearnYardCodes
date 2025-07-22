class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0, j = people.length - 1;
        while(i <= j) {
            int sum = people[i] + people[j];
            if(sum > limit) {
                ans++;
                j--;
            } else {
                i++;
                j--;
                ans++;
            }
        }
        return ans;
    }
}