class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        if(target.length != arr.length)
            return false;
        int i=-1;
        while(++i < arr.length)
            if(arr[i] != target[i])
                return false;
        return true;
    }
}