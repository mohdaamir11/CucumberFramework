Feature: Form filling
@regression
Scenario:
   Given User Launch chrome Browser
When user opens URL "https://practice-automation.com/form-fields/"
And  user enters name "abc" and password "def" and message "this is message"
And  user clicks submit button
Then  alert message contains "Message received!"
Then  use clicks on alert ok
  And  close browser