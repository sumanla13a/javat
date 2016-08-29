import java.util.*;
/**
  * Test to remove duplicates from a list
  * @namespace app
  * @description
  * Checks if list with duplicates removed is same as the test data 
  */
public class app {
	/**
	  * @name main
      * @memberof app
      * @description
      * main function, execution starts from here
      * @param {String[]} args, Command line arguments
	  */
	public static void main(String[] args) {
		List<employee> employeeList = new ArrayList<employee>();

		for(int i = 0; i< 10; i++) {
			employee emp = new employee("Suman" + i, 5000 + i);
			employeeList.add(emp);
		}
		for(int i = 0; i< 10; i++) {
			employee emp = new employee("Suman" + i, 5000 + i);
			employeeList.add(emp);
		}
		System.out.println(employeeList.size());
		dups removeDuplicate = new dups();
		List<employee> newList = removeDuplicate.removeDups(employeeList);
		
		test isSame = new test();
		System.out.println(isSame.isSame(newList));
	}
}
/**
  * Employee class
  * @namespace employee
  * @description
  * Creates employee class
  * @property {String} name, name of the employee
  * @property {int} Salary, salary of the employee 
  */
class employee {
	String name;
	int Salary;

	employee(String givenName, int givenSalary) {
		name = givenName;
		Salary = givenSalary;
		// System.out.println(name + ' ' + Salary);
	}

	employee() {
		name = "";
		Salary = 0;
	}

	public boolean isEqual(employee emp) {
		if(emp.name.equals(name)) {
			return true;
		}
		else return false;
	}
}
/**
  * dups class
  * @namespace dups
  * @description
  * Class to remove duplicate employees from the list
  */
class dups {
	/**
	  * @name removeDups
      * @memberof dups
      * @description
      * removes duplicate employees
      * @param {List<employee>} empList, The whole list of employees
	  */
	public List<employee> removeDups(List<employee> empList) {
		// Logic to be implemented here
		int size = empList.size();
		List<employee> newEmployeeList = new ArrayList<employee>();
		// Removing duplicate
		// can be implemented by using .contains method of List
		for(int i = 0; i < size; i++) {
			int j = 0;
			for(; j<i; j++) {
				if(empList.get(i).isEqual(empList.get(j))) {
					break;
				}
			}
			if(i==j) newEmployeeList.add(empList.get(i));
		}
		System.out.println(newEmployeeList.size());
		return newEmployeeList;
	}
}
/**
  * Employee test
  * @namespace test
  * @description
  * Creates employee test
  */
class test {
	/**
	  * @name isSame
      * @memberof test
      * @description
      * Checks if the given employee list is same as the test data generated below
      * @param {List<employee>} empList, The whole list of employees
	  */
	public boolean isSame(List<employee> empList) {
		int size = empList.size();
		List<employee> testEmployeeList = new ArrayList<employee>();

		for(int i = 0; i< 10; i++) {
			employee emp = new employee("Suman" + i, 5000 + i);
			testEmployeeList.add(emp);
		}
		for(int i = 0; i < size; i++) {
			int count = 0;
			for(int j = 0; j<10; j++) {
				if(empList.get(i).name.equals(testEmployeeList.get(j).name)) count++;
				if(count>1) return false;
			}
			if(count == 0) return false;
		}
		return true;
	}
}