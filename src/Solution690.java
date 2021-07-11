import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class Solution690 {
    private HashMap<Integer, Employee> map;

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

//        System.out.println(map);

        return repeat(id);
    }

    private int repeat(int id) {
        Employee employee = map.get(id);
        int totalImportance = employee.importance;
        // If for loop has empty list, java will not run the for loop.
        for (int subordinateId : employee.subordinates) {
            totalImportance += repeat(subordinateId);
        }
        return totalImportance;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, Arrays.asList());
        Employee e3 = new Employee(3, 3, Arrays.asList());
        int id = 1;
        Solution690 sol = new Solution690();
        int answer = sol.getImportance(Arrays.asList(e1, e2, e3), id);
        System.out.println("Answer: " + answer);
    }
}