class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //First approach to append all elements in array then sort it
        //Find median TC: O((n+m)log(n+m))

        //Second approach to merge sorted array like we do in merge sort
        //then find median TC: O(m+n)

        //Third approach to binary search on smaller array
        //Find how many elements from one array to be on left and other on right
        //TC: (min(logm + logn))

        int n1 = nums1.length, n2 = nums2.length;

        //always binary search on smaller array
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int n = n1 + n2;
        //how many ele we need to keep on left

        int left = (n1 + n2 + 1)/2; //this will work for both even and odd
        /**
        If you set high to n1 - 1, mid1 can only range from 0 to 2, 
        which means you're not able to test the scenario where mid1 = 3 
        (which means taking all elements from nums1)
         */
        int low = 0, high = n1;
        while(low <= high) {

            int mid1 = (low + high)/2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 < n1)
                r1 = nums1[mid1];
            if(mid2 < n2)
                r2 = nums2[mid2];

            if(mid1-1 >= 0)
                l1 = nums1[mid1 - 1];
            if(mid2-1 >= 0)
                l2 = nums2[mid2 - 1];

            //case when we found the valid sequence
            if(l1 <= r2 && l2 <= r1) {
                //when merged array size is odd
                if(n % 2 != 0)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if(l1 >= r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }
}