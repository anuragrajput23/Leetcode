// class Solution {
//     public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
//         List<Integer> list = new ArrayList<>();
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int bulb : bulbs){
//             map.put(bulb,map.getOrDefault(bulb,0)+1);
//         }
//         for(int ele : map.keySet()){
//             int freq = map.get(ele);
//             if(freq%2!=0){
//                 list.add(ele);
//             }
//         }
//         Collections.sort(list);
//         return list;
//     }
// }

//more intuitive and clear logic

class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set = new HashSet<>();
        for(int bulb : bulbs){
            if(set.contains(bulb)){
                set.remove(bulb);
            }else{
                set.add(bulb);
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;

    }
}