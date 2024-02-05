Feature: Login to LEMS

Scenario: Successful login with valid credentials 
Given User launches the browser
When User opens the URL "https://lems.cfapps.eu10-004.hana.ondemand.com/login"
And User enters the email as "ict@crm.com" and password as "admin123"
And Click on the login

