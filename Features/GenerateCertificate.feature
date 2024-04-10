Feature: Generate Certificate

@regression 
Scenario: Generate a School Leaving certificate for Sam  
	Given Login to the Application 
	Then Navigate to certificates 
	And Select the certificate type 
	Then Search and select the student 
	And Click on generate 
	Then Update remarks 
	And Generate and download 
