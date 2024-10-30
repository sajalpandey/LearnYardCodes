class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        //first we will find how many triplets are of no use
        //if its equal to n means, not possible to reach to target
        int[] temp = {target[0], target[1], target[2]};
        for(int[] row : triplets) {
            int p1 = row[0];
            int p2 = row[1];
            int p3 = row[2];
            //Not possible to use this triplet
            if(p1 > target[0] || p2 > target[1] || p3 > target[2])
                continue;
            if(temp[0] == p1)
                temp[0] = 0;
            if(temp[1] == p2)
                temp[1] = 0;
            if(temp[2] == p3)
                temp[2] = 0;
        }
        //System.out.println(temp[0]+" -- "+temp[1]+" -- "+temp[2]);
        if(temp[0] == 0 && temp[1] == 0 && temp[2] == 0)
            return true;
        return false;
    }
}