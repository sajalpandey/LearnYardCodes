class Solution {
    public static int helper(int []arr, int n, int k,int s,int e) {
        //System.out.println(s+" - mid - "+mid" - "+e);
        if(s > e)
            return -1;
        int mid = (s+e)/2;
        System.out.println(s+" - mid - "+mid+" - "+e);

        int ans = -1;
        //search on left side
        ans = helper(arr,n,k,s,mid-1);
        
        if(ans==-1) {
            if(arr[mid] == k)
                return mid;
            ans = helper(arr,n,k,mid+1,e);
        }
            
        return ans;
    }
    public boolean search(int[] arr, int target) {
        int n = arr.length - 1;
        if(arr.length == 1 && target==arr[0])
            return true;
        int ans = helper(arr,n,target,0,n);
        return (ans==-1 ? false : true);
    }
}