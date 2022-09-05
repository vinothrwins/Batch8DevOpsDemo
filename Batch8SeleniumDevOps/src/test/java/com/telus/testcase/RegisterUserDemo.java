package com.telus.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RegisterUserDemo {

	// Code added by Vinoth - 5th Sep 2022
	public WebDriver driver;

	//Initializing String variables
	String applicationURL="https://nxtgenaiacademy.com/";
	String regFormURL="https://nxtgenaiacademy.com/demo-site/";
	String expectedTitleRegistration="Demo Site – Registration Form – NxtGen A.I Academy";
	String firstNameInput="Harshita";
	String lastNameInput="Singh";
	String streetAddress="H.No-122(B), LIG-1";
	String suiteAddress="Gomti Nagar";
	String cityName="Lucknow";
	String postalCode="879543";
	String stateName="Uttar Pradesh";
	String countryName="India";
	String emailID="singh.harshita34@gmail.com";
	String dateOfDemo="30/07/2022";
	String timeHH="17";
	String timeMM="05";
	String mobNumber="9876543210";
	String query="What is the duration of course?";
	String confirmationMsg="Registration Form is Successfully Submitted";

	@Test(priority=1)
	public void launchApplication() {

		//Setting system property for chrome driver.
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");

		//Creating instance variable of chrome driver.
		driver=new ChromeDriver();

		// page load wait - updated by Vinoth
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Code updated by Paras - 29th Agu 2022 - Increased the implicit wait time to avoid sync issue
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launching the application
		driver.get(applicationURL);

		//Printing the confirmation message after launching application. 
		System.out.println("URL of application is: "+applicationURL);

		System.out.println("Application launched successfully.");

		// Maximizing the window
		driver.manage().window().maximize();
		System.out.println("Window maximized.");
		System.out.println("-------------------------------------------------------------------------------------");
	
		System.out.println("Application is launched Successfully");	  
	}

	@Test(priority=2)
	public void navigateToRegistrationForm() {

		//Creating instance for action class.
		Actions action=new Actions(driver);

		//Web element object declaration for QA AUTOMATION link.
		WebElement qaAutomationLink=driver.findElement(By.linkText("QA AUTOMATION"));
		//Hovering mouse over QA AUTOMATION link.
		action.moveToElement(qaAutomationLink).perform();
		System.out.println("Mouse hover action performed for QA AUTOMATION link. ");

		//Web element object declaration for Practice Automation link.
		WebElement pracAutomation=driver.findElement(By.xpath("//*[@id=\"menu-item-4157\"]/a/span"));
		//Hovering mouse over Practice Automation link.
		action.moveToElement(pracAutomation).perform();
		System.out.println("Mouse hover action performed for Practice Automation link.");

		//Web element object declaration for Demo Site-registration Link
		WebElement regForm=driver.findElement(By.xpath("//*[@id=\"menu-item-4134\"]/a/span"));
		//Generating click event to open registration form.
		regForm.click();
		System.out.println("Mouse click action performed for Demo Site-Registration Form link.");
		System.out.println("-------------------------------------------------------------------------------------");


		System.out.println("Application is Navigated Successfully");	
	}

	@Test(priority=3)
	public void registerUser() {
		String currentURL=driver.getCurrentUrl();
		if(regFormURL.equals(currentURL)){
			System.out.println("Registration page displayed successfully.");
			System.out.println("The current URL of Registration page is: "+currentURL);
			System.out.println("The expected URL of Registration page is: "+regFormURL);
			System.out.println("-------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("Failed to open Registration form. Current and expected URL are not same.");
			System.out.println("The current URL of Registration page is: "+currentURL);
			System.out.println("The expected URL of Registration page is: "+regFormURL);
			System.out.println("-------------------------------------------------------------------------------------");
		}

		//Retrieving title 
		String actualTitleRegistration=driver.getTitle();

		//Validating actual and expected title of web page
		if(expectedTitleRegistration.equals(actualTitleRegistration)) {
			System.out.println("The actual title of web page and expected title of web page are same.");
			System.out.println("Actual title of page is: "+actualTitleRegistration);
			System.out.println("Expected title of page is: "+expectedTitleRegistration);
			System.out.println("-------------------------------------------------------------------------------------");
		}
		else
		{
			System.out.println("The actual title of web page and expected title of web page are not same.");
			System.out.println("Actual title of page is: "+actualTitleRegistration);
			System.out.println("Expected title of page is: "+expectedTitleRegistration);
			System.out.println("-------------------------------------------------------------------------------------");
		}

		/* Text box validation and input for First Name
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Object declaration for web element-First Name
		WebElement firstName=driver.findElement(By.id("vfb-5"));
		if(firstName.isDisplayed()) 
		{
			System.out.println("Text box for First Name is displayed");
			if(firstName.isEnabled())
			{
				System.out.println("Text box for First Name is enabled");
				//Entering first name using sendKeys() method.
				firstName.sendKeys(firstNameInput);
				System.out.println("First Name is: "+firstNameInput);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for First Name is not enabled");
			}

		}
		else
		{
			System.out.println("Text box for First Name is not displayed");
		}

		/* Text box validation and input for Last Name
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Object declaration for web element- Last Name
		WebElement lastName=driver.findElement(By.id("vfb-7"));
		if(lastName.isDisplayed()) 
		{
			System.out.println("Text box for Last Name is displayed");

			if(lastName.isEnabled()) 
			{
				System.out.println("Text box for Last Name is enabled");

				//Entering last name using sendKeys() method.
				lastName.sendKeys(lastNameInput);
				System.out.println("Last Name is: "+lastNameInput);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for Last Name is not enabled");
			}

		}
		else
		{
			System.out.println("Text box for Last Name is not displayed");
		}

		/* Radio button validation and selection for Gender
		 * Displayed-true/false
		 * Enabled-true/false
		 * Selected-true/false 
		 */

		//Object declaration for web element-Gender
		WebElement gender=driver.findElement(By.id("vfb-8-2"));
		if(gender.isDisplayed())
		{
			System.out.println("Gender radio button is displayed.");
			if(gender.isEnabled())
			{
				System.out.println("Gender radio button is enabled.");
				if(gender.isSelected()) 
				{
					System.out.println("Gender is selected");
				}
				else 
				{
					//Selecting gender using click() method.
					gender.click();
					String genderSelected=gender.getAttribute("value");
					System.out.println("Gender selected: "+genderSelected);
					System.out.println("-------------------------------------------------------------------------------------");
				}				
			}
			else
			{
				System.out.println("Gender radio button is not enabled.");
			}
		}
		else
		{
			System.out.println("Gender radio button is not displayed.");
		}

		/* Test box validation and input for Address
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Street Address
		//Object declaration for web element-Street Address
		WebElement streetAddElement=driver.findElement(By.id("vfb-13-address"));
		if(streetAddElement.isDisplayed()) 
		{
			System.out.println("Text box for Street Address is displayed");
			if(streetAddElement.isEnabled())
			{
				System.out.println("Text box for Street Address is enabled");
				//Entering street address using sendKeys() method.
				streetAddElement.sendKeys(streetAddress);
				System.out.println("Street Address is: "+streetAddress);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for Street Address is disabled");
			}
		}
		else 
		{
			System.out.println("Text box for Street Address is not displayed");		
		}

		//Suite Address
		//Object declaration for web element-Suite address
		WebElement suiteAddElement=driver.findElement(By.id("vfb-13-address-2"));

		if(suiteAddElement.isDisplayed()) 
		{
			System.out.println("Text box for Suite Address is displayed");
			if(suiteAddElement.isEnabled())
			{
				System.out.println("Text box for Suite Address is enabled");
				//Entering suite address using sendKeys() method.
				suiteAddElement.sendKeys(suiteAddress);
				System.out.println("Suite address is: "+suiteAddress);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for Suite Address is disabled");	
			}			
		}
		else 
		{
			System.out.println("Text box for Suite Address is not displayed");
		}

		//City Name
		//Object declaration for web element-City
		WebElement cityElement=driver.findElement(By.id("vfb-13-city"));

		if(cityElement.isDisplayed()) 
		{

			System.out.println("Text box for City name is displayed");
			if(cityElement.isEnabled())
			{
				System.out.println("Text box for City name is enabled");
				//Entering city name using sendKeys() method.
				cityElement.sendKeys(cityName);
				System.out.println("City Name is: "+cityName);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for City Name is disabled");
			}


		}
		else 
		{
			System.out.println("Text box for City Name is not displayed");
		}

		//Postal/Zip code
		//Object declaration for web element-Postal/Zip code
		WebElement postalCodeElement=driver.findElement(By.id("vfb-13-zip"));

		if(postalCodeElement.isDisplayed()) 
		{
			System.out.println("Text box for Postal/Zip code is displayed");
			if(postalCodeElement.isEnabled())
			{
				System.out.println("Text box for Postal/Zip code is enabled");
				//Entering zip code using sendKeys() method.
				postalCodeElement.sendKeys(postalCode);
				System.out.println("Zip code is: "+postalCode);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for Postal/Zip code is disabled");
			}

		}
		else 
		{
			System.out.println("Text box for Postal/Zip code is not displayed");
		}

		//State
		//Object declaration for web element-State
		WebElement stateNameElement=driver.findElement(By.id("vfb-13-state"));
		if (stateNameElement.isDisplayed()) 
		{
			System.out.println("Text box for State Name is displayed");
			if(stateNameElement.isEnabled())
			{
				System.out.println("Text box for State Name is enabled");
				//Entering state name using sendKeys() method.
				stateNameElement.sendKeys(stateName);
				System.out.println("State Name is: "+stateName);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for State Name is disabled");
			}

		}
		else
		{
			System.out.println("Text box for State Name is not displayed");
		}

		//Country Drop Down
		//Object declaration for web element-Country Drop Down
		WebElement countryDropDown= driver.findElement(By.id("vfb-13-country"));
		if(countryDropDown.isDisplayed()){
			System.out.println("Drop down for country is displayed");
			if(countryDropDown.isEnabled())
			{
				System.out.println("Drop down for country is enabled");
				if(countryDropDown.isSelected())
				{
					System.out.println("Drop down for country is selected");	
				}
				else
				{
					Select country=new Select(countryDropDown);
					country.selectByValue(countryName);
					System.out.println("Country selected: "+countryName);
					System.out.println("-------------------------------------------------------------------------------------");

				}
			}
			else
			{
				System.out.println("Drop down for country is disabled");
			}

		}
		else 
		{
			System.out.println("Drop down for country is not displayed");
		}

		/* Text box validation and input for Email ID
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Email ID
		//Object declaration for web element
		WebElement emailElement=driver.findElement(By.id("vfb-14"));

		if(emailElement.isDisplayed())
		{
			System.out.println("Text box for Email ID is displayed");
			if(emailElement.isEnabled())
			{
				System.out.println("Text box for Email ID is enabled");
				//Entering email ID  using sendKeys() method.
				emailElement.sendKeys(emailID);
				System.out.println("Email ID is: "+emailID);
				System.out.println("-------------------------------------------------------------------------------------");


			}
			else
			{
				System.out.println("Text box for Email ID is disabled");

			}

		}
		else
		{
			System.out.println("Text box for Email ID is not displayed");

		}

		/* Text box validation and input for Date
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Date
		//Object declaration for web element-Date
		WebElement dateElement=driver.findElement(By.id("vfb-18"));
		if(dateElement.isDisplayed())
		{
			System.out.println("Text box for date is displayed");
			if(dateElement.isEnabled())
			{
				System.out.println("Text box for date is enabled");
				dateElement.sendKeys(dateOfDemo);
				System.out.println("Date selected is: "+dateOfDemo);
				System.out.println("-------------------------------------------------------------------------------------");

			}
			else
			{
				System.out.println("Text box for date is disabled");
			}

		}
		else
		{
			System.out.println("Text box for date is not displayed");
		}

		/* Radio button validation and selection for time
		 * Displayed-true/false
		 * Enabled-true/false
		 * Selected-true/false 
		 */

		//Convenient Time-HH
		//Object declaration for web element-Convenient Time HH
		WebElement convenientTimeHH=driver.findElement(By.id("vfb-16-hour"));

		if(convenientTimeHH.isDisplayed()) 
		{
			System.out.println("Drop down list for Time(HH) is displayed");
			if(convenientTimeHH.isEnabled())
			{
				System.out.println("Drop down list for Time(HH) is enabled");
				if(convenientTimeHH.isSelected())
				{
					System.out.println("Drop down list for Time(HH) is selected");	
				}
				else 
				{
					//Selecting time in hours using select() method.
					Select hour=new Select(convenientTimeHH);
					hour.selectByValue(timeHH);
					System.out.println("Time selected in hours is "+timeHH);
					System.out.println("-------------------------------------------------------------------------------------");

				}
			}
			else
			{
				System.out.println("Drop down list for Time(HH) is disabled");	
			}
		}
		else
		{
			System.out.println("Drop down list for Time(HH) is not displayed");
		}

		/* Radio button validation and selection for time
		 * Displayed-true/false
		 * Enabled-true/false
		 * Selected-true/false 
		 */

		//Convenient Time MM
		//Object declaration for web element-Convenient Time MM
		WebElement convenientTimeMM=driver.findElement(By.id("vfb-16-min"));

		if(convenientTimeMM.isDisplayed()) 
		{
			System.out.println("Drop down list for Time(MM) is displayed");
			if(convenientTimeMM.isEnabled())
			{
				System.out.println("Drop down list for Time(MM) is enabled");
				if(convenientTimeMM.isSelected())
				{
					System.out.println("Drop down list for Time(MM) is selected");	
				}
				else
				{
					Select minute=new Select(convenientTimeMM);
					//Selecting time in minutes using select() method.
					minute.selectByValue(timeMM);
					System.out.println("Time selected in minutes is "+timeMM);
					System.out.println("-------------------------------------------------------------------------------------");

				}	
			}
			else
			{
				System.out.println("Drop down list for Time(MM) is disabled");	
			}

		}
		else 
		{
			System.out.println("Drop down list for Time(MM) is not displayed");	
		}

		/* Text box validation and input for Date
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Mobile Number
		//Object declaration for web element-Mobile Number
		WebElement contactNumber= driver.findElement(By.id("vfb-19"));

		if(contactNumber.isDisplayed()) 
		{
			System.out.println("Text box for Contact number is displayed");
			if(contactNumber.isEnabled())
			{
				System.out.println("Text box for Contact number is enabled");
				//Entering mobile number  using sendKeys() method.
				contactNumber.sendKeys(mobNumber);
				System.out.println("Mobile number is: "+mobNumber);
				System.out.println("-------------------------------------------------------------------------------------");
			}
			else
			{
				System.out.println("Text box for Contact number is disabled");

			}
		}
		else 
		{
			System.out.println("Text box for Contact number is not displayed");

		}

		/* Check box validation and input for Course
		 * Displayed-true/false
		 * Enabled-true/false
		 * Selected-true/false 
		 */

		//Java check box
		//Object declaration for web element-Java check box	
		WebElement courseJava=driver.findElement(By.id("vfb-20-3"));
		if(courseJava.isDisplayed())
		{
			System.out.println("Checkbox for Java course is displayed");
			if(courseJava.isEnabled())
			{
				System.out.println("Checkbox for Java course is enabled");
				if(courseJava.isSelected()) 
				{
					System.out.println("Checkbox for Java course is selected");
				}
				else 
				{
					//Selecting checkbox using click() method  
					courseJava.click();
					WebElement selectCourse=driver.findElement(By.xpath("//*[@id=\"item-vfb-20\"]/div/span[4]/label"));
					String courseInput=selectCourse.getText();
					System.out.println("Checkbox selected: "+courseInput);
					System.out.println("-------------------------------------------------------------------------------------");
				}
			}
			else
			{
				System.out.println("Checkbox for Java course is disabled");	
			}

		}
		else
		{
			System.out.println("Checkbox for Java course is not displayed");
		}

		/* Check box validation and input for Course
		 * Displayed-true/false
		 * Enabled-true/false
		 * Selected-true/false 
		 */

		//Others check box
		//Object declaration for web element-Others check box
		WebElement courseOthers=driver.findElement(By.id("vfb-20-5"));
		if(courseOthers.isDisplayed())
		{
			System.out.println("Checkbox for other course is displayed");	
			if(courseOthers.isEnabled())
			{
				System.out.println("Checkbox for other course is enabled");
				if(courseOthers.isSelected()) 
				{
					System.out.println("Checkbox for other course is selected");
				}
				else 
				{
					//Selecting checkbox using click() method
					courseOthers.click();
					WebElement selectCourseNext=driver.findElement(By.xpath("//*[@id=\"item-vfb-20\"]/div/span[6]/label"));
					String courseInputNext=selectCourseNext.getText();
					System.out.println("Checkbox selected: "+courseInputNext);
					System.out.println("-------------------------------------------------------------------------------------");
				}
			}
			else
			{
				System.out.println("Checkbox for other course is disabled");
			}

		}
		else
		{
			System.out.println("Checkbox for other course is not displayed");
		}


		//Query
		//Object declaration for web element-Query
		WebElement queryElement=driver.findElement(By.id("vfb-23"));

		if(queryElement.isDisplayed()) {
			System.out.println("Query textbox is displayed");
			//Entering query using sendKeys() method
			queryElement.sendKeys(query);
			System.out.println("Entered query is: "+query);
			System.out.println("-------------------------------------------------------------------------------------");

		}
		else
		{
			System.out.println("Query textbox is not displayed");
		}

		/* Example code and Example code text box validation
		 * Displayed-true/false
		 * Enabled-true/false 
		 */

		//Example code 
		//Object declaration for web element-Example code
		WebElement varificationCodeExample=driver.findElement(By.xpath("//*[@id=\"item-vfb-2\"]/ul/li[1]/span/label"));

		if(varificationCodeExample.isDisplayed()) 
		{
			System.out.println("Verification code is displayed");
			//Using getText method() to retrieve text of example code.
			String verificationCode= varificationCodeExample.getText();
			String exampleCode[]=verificationCode.split(":");
			String finalCode=exampleCode[1].trim();

			//Example code text box
			//Object declaration for web element-Example code text box
			WebElement verificationCodeTextBox=driver.findElement(By.id("vfb-3"));

			if(verificationCodeTextBox.isDisplayed()) {
				System.out.println("Verification code text box is displayed");
				verificationCodeTextBox.sendKeys(finalCode);
				System.out.println("Verification Code is: "+finalCode);
				System.out.println("-------------------------------------------------------------------------------------");
			}
			else
			{
				System.out.println("Verification code text box is not displayed");	
			}
		}
		else
		{
			System.out.println("Verification code is not displayed");
		}

		/*Submit button validation
		 * Displayed-true/false
		 * Enabled-true/false
		 */

		//Object declaration for web element-Submit Button
		WebElement submitButton=driver.findElement(By.id("vfb-4"));
		if(submitButton.isDisplayed())
		{
			System.out.println("Submit button is displayed");
			if(submitButton.isEnabled()) 
			{
				System.out.println("Submit button is enabled");
				submitButton.click();
				System.out.println("Submit button is clicked");
				System.out.println("-------------------------------------------------------------------------------------");
			}
			else
			{
				System.out.println("Submit button is disabled");	
			}
		}
		else
		{
			System.out.println("Submit button is not displayed");
		}
	}


	@Test(priority=4)
	public void validateSuccessfullMsg() {
		//Confirmation message validation
		//Object declaration for web element-Confirmation message
		WebElement outputMessage=driver.findElement(By.xpath("//*[@id=\"content\"]/article/div/div/div/div/section[1]/div/div/div[1]/div/div/div/div/div"));
		String message=outputMessage.getText();
		String displayMessage[]=message.split(" The");
		String transID[]=message.split(":");
		String displayedTransID=transID[1].trim();


		if(message.contains(confirmationMsg)){
			System.out.println("Registration form submitted successfully");
			System.out.println("Confirmation message displayed successfully.");
			System.out.println("The expected message is: "+""+confirmationMsg);
			System.out.println("The received message is: "+displayMessage[0]);
			System.out.println("The transaction ID is: "+displayedTransID);
			System.out.println("-------------------------------------------------------------------------------------");
		}
		else 
		{
			System.out.println("Confirmation message is not received successfully.");	
		}
	}

	@Test(priority=5)
	public void closeApplication() {
		//Closing application
		driver.close();
		System.out.println("Application closed successfully.");
		System.out.println("-------------------------------------------------------------------------------------");
	}

}
