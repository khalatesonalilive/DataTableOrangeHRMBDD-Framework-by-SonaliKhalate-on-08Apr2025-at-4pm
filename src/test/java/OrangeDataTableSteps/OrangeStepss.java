package OrangeDataTableSteps;

import java.util.List;

import org.openqa.selenium.By;

import BaseLayer.BaseClass;
import PageLayer.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class OrangeStepss extends BaseClass{
   public static LoginPage loginPage;
   public static String empid;
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
	    
		BaseClass.initialisation();
	}

	@When("user enter valid credentials")
	public void user_enter_valid_credentials(DataTable dataTable) {
		//| Admin | admin123 |
		
		List<List<String>>ls=dataTable.asLists();
		String uname=ls.get(0).get(0);
		String pass=ls.get(0).get(1);
		
		 loginPage=new LoginPage();
		 loginPage.loginFunctionality(uname, pass);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@When("user is on home page and validate the home page title")
	public void user_is_on_home_page_and_validate_the_home_page_title(DataTable dataTable) {
		 //| OrangeHRM |
		List<List<String>>ls=dataTable.asLists();
		String expectedTitle=ls.get(0).get(0);
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, expectedTitle);
		
	}

	@When("user validate the home page url")
	public void user_validate_the_home_page_url() {
	    
		String actualUrl=driver.getCurrentUrl();
		boolean url=actualUrl.contains("orangehrmlive");
		Assert.assertEquals(url, true);
	}

	@When("user validate the home page logo")
	public void user_validate_the_home_page_logo(DataTable dataTable) {
		// | true |
	String abc=dataTable.asLists().get(0).get(0);
	boolean xyz=Boolean.parseBoolean(abc);
	boolean logo=driver.findElement(By.xpath("//div[@class='oxd-brand-banner toggled']")).isDisplayed();
	Assert.assertEquals(logo, xyz);
	}

	@When("user click on pim page link")
	public void user_click_on_pim_page_link() throws Exception {
	    Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}

	@When("user validate the user is on pim page using the url")
	public void user_validate_the_user_is_on_pim_page_using_the_url(DataTable dataTable) {
		// | pim |
		List<List<String>>ls=dataTable.asLists();
		String expectedUrl=ls.get(0).get(0);
		String actualUrl=driver.getCurrentUrl();
		boolean url=actualUrl.contains(expectedUrl);
		Assert.assertEquals(url, true);
	}

	@When("user click add employee and enter firstname, lastname and click on save button")
	public void user_click_add_employee_and_enter_firstname_lastname_and_click_on_save_button(DataTable dataTable) throws Exception {
//		 | Shivanya | Bhosale  |
//	      | Siya     | Ram      |
//	      | radha    | shyam    |
//	      | vitthal  | RakhuMai |
		List<List<String>>ls=dataTable.asLists();
		
		for(int i=0;i<ls.size();i++)
		{
			driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
			String firstname=ls.get(i).get(0);
			String lastname=ls.get(i).get(1);
			Thread.sleep(5000);
			
//			driver.findElement(By.name("firstName")).sendKeys(firstname);
//			driver.findElement(By.name("lastName")).sendKeys(lastname);
//			driver.findElement(By.xpath("//button[text()=' Save ']")).click();
//			Thread.sleep(5000);
			
			 loginPage= new LoginPage();
			 loginPage.loginFunctionality(firstname, lastname);
			
		}
		
	}

	@When("user capture the employee id number and user click on employee list")
	public void user_capture_the_employee_id_number_and_user_click_on_employee_list() {
	    
	 empid=	driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).getAttribute("value");
	
	 driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	}

	@When("user enter employee id in employee id textbox and click on search button")
	public void user_enter_employee_id_in_employee_id_textbox_and_click_on_search_button() throws Exception {
	   Thread.sleep(5000);
	   
	   driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).sendKeys(empid);
	   
	   driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	   Thread.sleep(5000);
	}

	@When("user select the search employee and click on delete")
	public void user_select_the_search_employee_and_click_on_delete() throws Exception {
	    
		driver.findElement(By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")).click();
	
		driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
	}

	@Then("validate the employee is deleted or not")
	public void validate_the_employee_is_deleted_or_not() throws Exception {
	   
		driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]")).sendKeys(empid);
		   
		   driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		   Thread.sleep(5000);
		  String norecords= driver.findElement(By.xpath("//span[text()='No Records Found']")).getText();
	    Assert.assertEquals(norecords, "No Records Found");
	}

	@When("user click on profile and click on logout button")
	public void user_click_on_profile_and_click_on_logout_button() {
	    
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

}
