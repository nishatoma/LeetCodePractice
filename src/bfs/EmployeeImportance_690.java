package bfs;

import oop.Employee;

import java.util.*;

public class EmployeeImportance_690 {
    public int getImportance(List<Employee> employees, int id) {
        // Use hashmap to map ids -> employees
        Map<Integer, Employee> map = new HashMap<>();
        // For each employee, add them to the map
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        // Store result variable
        int res = 0;
        // Make a q for BFS
        Deque<Employee> q = new ArrayDeque<>();
        q.offer(map.get(id));
        // Iterate
        while (!q.isEmpty()) {
            // Get employee
            Employee emp = q.poll();
            // Get importance and add it
            res += emp.importance;
            // Iterate over children and add to Q
            for (Integer empId : emp.subordinates) {
                // Add to Q
                q.offer(map.get(empId));
            }
        }
        return res;
    }
}
