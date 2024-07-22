class Person {
    String name;
    int height;
    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> list = new ArrayList<>();
        String[] result = new String[names.length];
        for(int i=0; i<names.length; i++) {
            list.add(new Person(names[i], heights[i]));
        }
        Collections.sort(list, (a,b) -> (b.height - a.height));
        int k = 0;
        for(Person p : list)
            result[k++] = p.name;
        return result;
    }
}