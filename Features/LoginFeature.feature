Feature: Login 

Scenario:  Successful Login with valid credentials
   Given User Launch chrome Browser
   When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
   And user enters Email as "admin@yourstore.com" and password as "admin"
   And click on Login
   Then page Title should be "Dashboard / nopCommerce administration"
   When User clicks on log out link
   Then page Title should be "Your Store. Login"
   And close browser
   
