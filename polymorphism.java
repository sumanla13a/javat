import java.util.*;
/**
  * Test to check polymorphism using interface
  * @namespace polymorphism
  * @description
  * Calculates the sum of total balances using polymorphism and interface 
  */
public class polymorphism {
	/**
	  * @name main
      * @memberof polymorphism
      * @description
      * main function, execution starts from here
      * creates two account saving and checking, then calculates total
      * @param {String[]} args, Command line arguments
	  */
	public static void main(String[] args) {
		checking checkingClient = new checking("Suman", 30.0);
		saving savingClient = new saving("Suman1", 31.0);
		List<BankInterface> listOfClient = new ArrayList<BankInterface>();
		listOfClient.add(checkingClient);
		listOfClient.add(savingClient);
		bank newBank = new bank();
		System.out.println(newBank.calculateTotal(listOfClient));
	}
}
/**
  * Bank class that calculates total
  * @namespace bank
  * @description
  * Calculates the sum of total balances 
  */
class bank {
	/**
	  * @name calculateTotal
      * @memberof bank
      * @description
      * calculates total for all accounts
      * @param {List<BankInterface>} clientList, List of clients
	  */
	public double calculateTotal(List<BankInterface> clientList) {
		int size = clientList.size();
		double sum = 0.0;
		for(int i = 0; i < size; i++) {
			sum += clientList.get(i).calculateFinal();
		}
		return sum;
	}
}
/**
  * checking class
  * @namespace checking
  * @description
  * Creates checking class
  * @property {String} name, name of the client
  * @property {double} balance, balance of the employee 
  */
class checking implements BankInterface {
	String name;
	double balance;

	checking(String givenName, double initialBalance) {
		name = givenName;
		balance = initialBalance;
	}
	/**
	  * @name calculateFinal
      * @memberof checking
      * @description
      * calculates total for given checking account
	  */
	public double calculateFinal() {
		return balance * 10;
	}
}
/**
  * saving class
  * @namespace saving
  * @description
  * Creates saving class
  * @property {String} name, name of the client
  * @property {double} balance, balance of the client 
  */
class saving implements BankInterface {
	String name;
	double balance;

	saving(String givenName, double initialBalance) {
		name = givenName;
		balance = initialBalance;
	}
	/**
	  * @name calculateFinal
      * @memberof saving
      * @description
      * calculates total for given saving account
	  */
	public double calculateFinal() {
		return balance * 100;
	}
}
/**
  * BankInterface interface
  * @namespace BankInterface
  * @description
  * Creates BankInterface interface
  */
interface BankInterface {
	public double calculateFinal();
}