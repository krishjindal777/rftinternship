import java.util.*;

public class Day8 {
    public static void main(String[] args) {
        List<Integer> userIds = new ArrayList<>();
        userIds.add(101);
        userIds.add(102);
        userIds.add(103);
        userIds.add(101);
        userIds.add(104);
        userIds.add(102);
        Set<Integer> uniqueUsers = new HashSet<>(userIds);

     
        System.out.println("Unique User IDs: " + uniqueUsers);

    
        System.out.println("Total Unique Visitors: " + uniqueUsers.size());

 
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int id : userIds) {
            if (countMap.containsKey(id)) {
                countMap.put(id, countMap.get(id) + 1);
            } else {
                countMap.put(id, 1);
            }
        }

        System.out.println("Duplicate Entries:");
        for (int id : countMap.keySet()) {
            if (countMap.get(id) > 1) {
                System.out.println("User ID " + id + " appears " + countMap.get(id) + " times");
            }
        }
    }
}
