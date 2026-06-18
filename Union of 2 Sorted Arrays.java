class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : a) set.add(ele);
        for(int el : b) set.add(el);
        ArrayList<Integer> list = new ArrayList<>();
        for(int el : set){
            list.add(el);
        }
        Collections.sort(list);
        return list;
    }
}
