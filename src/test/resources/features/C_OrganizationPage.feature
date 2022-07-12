@OrganizationPage
Feature: Organization Page Test
  In order to test functionality of Organization page
  We will test create and edit organization

Background: Launch the URL do the necessary initializations
Given Launch the URL do the necessary initializations

@OrganizationPage_CreateStandardDealershipOrganization
Scenario: Scenario_01 Create standard dealership organization
  Given Verify User is on login page
  Then User attempt to login
  Then User is navigating to the root page
  Then Select the card named "Organization" then verify the page is loaded with name "Organization"
  When Create organization button is clicked
  Then Select the "Standard Dealership" organization template
  Then Click next
  Then Select the following products
  |  Payment Assurance                |
  |  Power Sports                     |
  |  Motorcycle                       |
  |  Inventory Management Services    |
  Then Click next
  Then Enter description
  |  Customer Name      |  Description           |  Time Zone  |
  |  Demo Std Customer  |  Demo std Description  |  Chicago    |
  Then Click next
  Then Check on add administrator checkbox
  Then Enter first name "First Name"
  Then Enter last name "Last Name"
  Then Enter unique email
  Then Enter phone number "1234567890"
  Then Click next
  Then Verify preview
  Then Click complete
  Then Verify popup "Organization created Demo Std Customer"

@OrganizationPage_CreateBasicOrganization
Scenario: Scenario_02 Create basic organization
  Given User is organization page
  When Create organization button is clicked
  Then Select the "Basic Organization" organization template
  Then Click next
  Then Enter description
  |  Customer Name        |  Description             |  Time Zone   |  Type      |
  |  Demo Basic Customer  |  Demo Basic Description  |  Knox        |  Inventory |
  Then Click next
  Then Verify preview
  Then Click complete
  Then Verify popup "Organization created Demo Basic Customer"

@OrganizationPage_UpdateOrganization
Scenario: Scenario_03 Update organization
  Given User is organization page
  When First organization is selected
  Then Update name to random name
  Then Click RENAME ORGANIZATION button
  Then Update description to random description
  Then Click "Details" UPDATE button
  Then verify the updated name and description

@OrganizationPage_ThisScenarioWillFail
Scenario: Scenario_04 This scenario should fail
  Given User is organization page
  When Check the visibility of create organization button







