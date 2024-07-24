class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int number = nums[i];
            int new_num = 0, mul = 1;
            if(number == 0)
                new_num = mapping[0];
            else {
                while(number > 0) {
                    int digit = number%10;
                    //System.out.println("digit = "+digit+" --mapping[digit] "+mapping[digit]);

                    new_num = new_num + mapping[digit] * mul;
                    mul *= 10;
                    //System.out.println("new_num = "+new_num);
                    number /= 10;
                }
            }
            
            //System.out.println(i+" -- "+new_num.reverse());
            list.add(new int[] { i,  new_num});
            //list.add(new int[] {i, Integer.parseInt(new_num.toString)});
        }
        Collections.sort(list, (a, b) -> ((a[1] != b[1] ? a[1] - b[1] : a[0] - b[0])));

        int[] result = new int[nums.length];
        int k = 0;
        for(int[] p : list) {
            //System.out.println(p[0]+" "+p[1]);
            result[k++] = nums[p[0]];
        }
        return result;
    }
}