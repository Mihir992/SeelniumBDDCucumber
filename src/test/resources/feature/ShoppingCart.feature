Feature: Add Products to Shopping Cart
  
  Background: User is logged into the application
	  	Given user on the Login Page
			When user enters username "testadmin" and password "admin"   
			And user clicks on Login button
			Then verify page title "My Account" 
		  	
  Scenario: User is able to add products into shopping cart
  
  Given user clicks on Tshirts
  When user clicks on "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie" product name
  Then Verify the page title "Designer Men Casual Formal Double Cuffs Grandad Band Collar Shirt Elegant Tie" product
  And validate the product name text
  And validate the product price
  And user enters the quantity "2"
  When user click on Add to Cart button
  Then Verify the page title "Shopping Cart"