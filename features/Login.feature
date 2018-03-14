Feature: Login to http://automationpractice.com 

	In order to Access Application
	As User
	I want to login

  Scenario: Login to Application and place Tshirt order 
	Given I open "url" on "browser"
	When I click on "signIn"
	And I enter "username" as "someone@example.com" 
	And I enter "password" as "Password123"
	And I click on "signInButton"
	Then I should land on "homePage"
	When I click on "TSHIRTDEPT"
	And I click on "Tshirt_img"
	And I update "quantity" as "2"
	And I enter "size" as "S"
	And I select on "color"
	And I click on "Add_To_Cart"
	And I click on "Proceed_To_Checkout"
	Then I should land on "ShoppingCartSummary"
	When I click on "Proceed_To_Checkout_from_Summary"
	And I click on "Proceed_To_Checkout_from_Address"
	And I select on "terms_of_service"
	And I click on "Proceed_To_Checkout_from_Shipping"
	And I click on "Pay_by_bank_wire"
	And I click on "I_confirm_my_order"
	Then I should see orderConfirmation
	And I click on "back_to_orders"
	Then I verify my order history

  Scenario: Login to Application and Update Personal Information (First Name) in My Account 
	Given I open "url" on "browser"
	When I click on "signIn"
	And I enter "username" as "someone@example.com" 
	And I enter "password" as "Password123"
	And I click on "signInButton"
	Then I should land on "homePage"
	When I click on "My_Personal_Information"
	And I update "firstname" as "Testing"
	And I enter "currentPassword" as "Password123"
	And I click on "Save_button"
	Then I confirm my "confirmation_text"
