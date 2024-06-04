class Trio implements Comparable<Trio> {
    double fraction;
    int a;
    int b;

    public Trio(double fraction, int a, int b) {
        this.fraction = fraction;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Trio other) {
        return Double.compare(this.fraction, other.fraction);
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Trio> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                Trio t = new Trio(((double)arr[i]/arr[j]), arr[i], arr[j]);
                pq.add(t);
                if(pq.size() > k)
                    pq.poll();
            }
        }
        // for (Trio trio : pq) {
        //     System.out.println(trio.fraction + " " + trio.a + " " + trio.b);
        // }

        Trio temp = pq.poll();

        return new int[] {temp.a,temp.b};
    }
}