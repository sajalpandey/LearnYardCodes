class RandomizedSet {
    ArrayList<Integer> arr;
    HashMap<Integer,Integer> map;
    public RandomizedSet() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } 
        arr.add(val);
        map.put(val,arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index = map.get(val);
        int temp = arr.get(arr.size()-1);
        arr.set(index,temp);
        arr.removeLast();
        map.put(temp,index);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random() * arr.size());
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */