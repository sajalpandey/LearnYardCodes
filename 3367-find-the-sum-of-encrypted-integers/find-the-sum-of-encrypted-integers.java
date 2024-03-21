class Solution {
    public int encryptedValue(int num) {
        int a = Integer.MIN_VALUE;
        int count = 0;
        int ans = 0,rem=0;
        while (num != 0) {
            rem = num % 10;
            a = Math.max(a, rem);
            num=num/10;
            count++;
        } while(count-->0){
            ans=ans*10+a;
        }
        return ans;
    }

    public int sumOfEncryptedInt(int[] nums) {

        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
              nums[i] = encryptedValue(nums[i]);
              sum+=nums[i];
        }
        
        return sum;
    }
}