package liug.ds.learn.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amazfit
 * @date 2022-06-13 下午8:11
 **/
public class PraticeDay1 {

    public static class Employee{
        private String name;
        private String dept;
        private int salary;
        private List<Employee> employeeList;

        public Employee(String name, String dept, int salary) {
            this.name = name;
            this.dept = dept;
            this.salary = salary;
            this.employeeList = new ArrayList<>();
        }

        public void add(Employee employee){
            employeeList.add(employee);
        }

        public void remove(Employee employee){
            employeeList.remove(employee);
        }

        public List<Employee> getEmployeeList(){
            return employeeList;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    ", employeeList=" + employeeList +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("华子","java开发",18000);
        Employee employee2 = new Employee("希子","java开发",18000);
        Employee employee3 = new Employee("逗子","java开发",18000);

        Employee employee4 = new Employee("刚子","java开发",15000);
        employee1.add(employee2);
        employee1.add(employee3);
        employee1.add(employee4);

        System.out.println(employee1);
    }
}
