package stepsdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class parameterization {
	
	
	int a,b,result = 0;
	@Given("I have numbers {int} and {int}")
	public void acceptNumbers(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@When("I add them")
	public void Addition() {
		this.result = a+b;
	}
	
	@Then("check if the result is prime")
	public void checkIfAdditionIsPrime() {
		int count=1;
		for(int i = 1; i<=result/2; i++) {
			if(result%i==0) {
				count++;
			}
		}
		if (count>2) {
			System.out.println("Number "+result+ " not prime");
		}else {
			System.out.println("Number " +result+ " is prime");
		}
	}
	
	String name;
	@Given("I have first name {word}")
	public void acceptName(String name) {
		this.name = name;
	}
	
	@Then("print the first name")
	public void printName() {
		System.out.println("First name is "+name);
	}

	

	String pincode;
	String city;
	@Given("I have {string}{string}")
	public void acceptPincode(String pincode, String city) {
		this.pincode = pincode;
		this.city = city;
	}
	
	@Then("print the {string}")
	public void printPincode() {
		System.out.println(this.city);
	}
	
}








	
