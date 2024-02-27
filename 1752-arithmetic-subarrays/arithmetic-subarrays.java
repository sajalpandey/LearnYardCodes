class Solution {
    static int[] sortArrayInWindow(int[] arr, int startIndex, int endIndex) {
        // Check if the indices are valid
        if (startIndex < 0 || endIndex >= arr.length || startIndex > endIndex) {
            System.out.println("Invalid window indices.");
            return arr;
        }

        // Create a copy of the window
        int[] window = Arrays.copyOfRange(arr, startIndex, endIndex + 1);

        // Sort the window
        Arrays.sort(window);
        // for(int ele : window)
        //     System.out.print(ele+" ");
        // Copy the sorted window back to the original array
        // for (int i = startIndex, j = 0; i <= endIndex; i++, j++) {
        //     arr[i] = window[j];
        // }
        return window;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        for(int i=0; i<l.length; i++) {
            int num[] = sortArrayInWindow(nums,l[i],r[i]);
            int length = r[i]-l[i] + 1;
            if(length > 1) {
                int d = num[1] - num[0];
                System.out.println(num[0]+" -- "+num[1]+" -- "+d);
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