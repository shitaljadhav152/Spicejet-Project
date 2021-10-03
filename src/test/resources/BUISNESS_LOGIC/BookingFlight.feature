Feature: Booking flight functionality

Background: user successfully book flight
Given User Open "chrome" Browser and exe ""
Given User open url as "https://beta.spicejet.com/"

Scenario: Check book flight functionality
When user click on one way
When user Select "Mumbai" as a From
When user Select "Jaipur" as To
When user click on Departure date
When user click on date
When user click on Return Date
When user clicks on required date
