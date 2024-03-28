class StockPrice {
    HashMap<Integer,Integer> timeToPrice;
    TreeMap<Integer,Integer> priceToFreq;
    int latestTime;
    public StockPrice() {
        latestTime = 0;
        timeToPrice = new HashMap<>();
        priceToFreq = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        // update latestTime
        latestTime = Math.max(latestTime, timestamp);

        //update in priceToFreq map

        //1. If map contains this price then update its freq + 1
        //2. If not then put new price with freq in map
        if(timeToPrice.containsKey(timestamp)) {
            int oldPrice = timeToPrice.get(timestamp);
            int oldPriceFreq = priceToFreq.get(oldPrice);
            if(oldPriceFreq == 1) 
                priceToFreq.remove(oldPrice);
            else
                priceToFreq.put(oldPrice, oldPriceFreq - 1);
        }

        int newPriceFreq = priceToFreq.getOrDefault(price,0);
        priceToFreq.put(price, newPriceFreq + 1);

        // update in timeToPrice map
        timeToPrice.put(timestamp, price);

    }
    
    public int current() {
        return timeToPrice.get(latestTime);
    }
    
    public int maximum() {
        return priceToFreq.lastKey();
    }
    
    public int minimum() {
        return priceToFreq.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */