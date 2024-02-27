class Solution {
    static int[] sortArrayInWindow(int[] arr, int startIndex, int endIndex) {
        int[] window = Arrays.copyOfRange(arr, startIndex, endIndex + 1);
        Arrays.sort(window);
        return window;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for(int i=0; i<l.length; i++) {
            int num[] = sortArrayInWindow(nums,l[i],r[i]);
            int length = r[i]-l[i] + 1;
            if(length > 1) {
                int d = num[1] - num[0];
                int j=0;
                for(j=1; j<num.length; j++) {
                    if(d!=(num[j]-num[j-1])) {
                        result.add(false);
                        break;
                    }
                }
                if(j>=num.length)
                    result.add(true);
            } else
                result.add(true);
        }
        return result;
    }
}