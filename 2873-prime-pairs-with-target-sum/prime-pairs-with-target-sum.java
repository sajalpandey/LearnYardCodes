class Solution {
    public void calculatePrime(int arr[]) {
        // arr[1] == 1 // not prime
        // arr[i] == 0 // prime
        arr[0] = arr[1] = 1;
        int n = arr.length;
        for(int i=2; i*i<=n; i++) {
            if(arr[i]==0) {
                for(int j = i*i; j<n; j=j+i) {
                    arr[j] = 1;
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> l = new ArrayList<>();
        int [] sieve = new int[1000001];
        calculatePrime(sieve);
        for(int i=2; i<=n/2; i++)
            if(sieve[i]==0 && sieve[n-i]==0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(n-i);
                l.add(new ArrayList(temp));
            }
        return l;
    }
}