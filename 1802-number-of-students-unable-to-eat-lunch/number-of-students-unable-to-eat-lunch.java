class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroType = 0, oneType = 0;
        for(int i=0; i<students.length; ++i) {
            int k = students[i] == 0 ? zeroType++ : oneType++;
        }
        for(int i=0; i<sandwiches.length; i++){
            if(sandwiches[i] == 0) {
                if(zeroType == 0)
                    return (students.length-i);
                zeroType--;
            } else {
                if(oneType == 0)
                    return (students.length-i);
                oneType--;
            }
        }
        return 0;
    }
}