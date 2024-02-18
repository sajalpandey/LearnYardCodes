class Solution {
    public int jump(int[] nums) {
        int last_index = nums.length-1;
        int reach[] = new int[nums.length];
        Arrays.fill(reach,Integer.MAX_VALUE);
        reach[last_index] = 0;
        for(int i=last_index-1; i>=0; i--) {
            int value = nums[i];
            System.out.println("value = "+value);
            int mn = Integer.MAX_VALUE;
            for(int j=1; j<=value && j+i<=last_index; j++)
                mn = Math.min(mn,reach[i+j]);
            System.out.println("mn = "+mn);
            if(mn!=Integer.MAX_VALUE)
            reach[i] = 1 + mn;
        }

        for(int ele : reach)
            System.out.print(ele+" ");
        System.out.println();
        return reach[0];
    }
}