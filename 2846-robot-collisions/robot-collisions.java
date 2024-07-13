class Robot {
    int positions;
    int health;
    char dir;
    int index;
    Robot(int p, int h, char d, int i) {
        this.positions = p;
        this.health = h;
        this.dir = d;
        this.index = i;
    }
    @Override
    public String toString() {
        return "Robot{" +
                "positions=" + positions +
                ", health=" + health +
                ", direction=" + dir +
                ", index=" + index +
                '}';
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = healths.length;
        List<Robot> robots = new ArrayList<>();
        for(int i=0; i<n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }

        Collections.sort(robots, (a, b) -> (a.positions - b.positions));

        Stack<Robot> st = new Stack<>();
        for(Robot r : robots) {
            //System.out.println(r);
            //if stack is empty and dir is L OR dir is R then push it
            if(r.dir == 'R') {
                //System.out.println("Case -0 ");
                st.push(r);
                continue;
            }

            //stack is not empty and directions is left
            if(r.dir == 'L') {

                //Case -2 : when curr robot health is greater than st.top, elimination till st is not empty or greater not found
                while(!st.isEmpty() && st.peek().health < r.health && st.peek().dir == 'R') {
                    st.pop();
                    //System.out.println("Case -2 ");
                    r.health--;
                }

                //Case -3 : if we have found a st.top which is greater than curr robot then , this r will be eleiminated
                if(!st.isEmpty() && st.peek().health > r.health && st.peek().dir == 'R') {
                    st.peek().health--;
                    //System.out.println("Case -3 ");
                    continue;
                }
                //Case -1 : when robot health is equal to st.top health , both elimination case
                if(!st.isEmpty() && st.peek().health == r.health && st.peek().dir == 'R') {
                    st.pop();
                    //System.out.println("Case -1 ");
                    continue;
                }

                //Case -4 : if curr robot eliminated all stack robots or incase st is empty
                //simply add
                //System.out.println("Case -4 : Reached ");
                st.push(r);
            }
        }
        List<Robot> l = new ArrayList<>(st);
        Collections.sort(l, (a, b) -> (a.index - b.index));
        List<Integer> result = new ArrayList<>();
        for(Robot r : l)
            result.add(r.health);

        return result;
    }
}