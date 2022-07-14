@HomePage
Feature: Home Page Test
  In order to test functionality of home page
  We will verify different cards on the home page to check home page functionality

Background: Launch the URL do the necessary initializations and login
  Given Launch the URL do the necessary initializations

@HomePage_ModuleCardsLoad
Scenario: Scenario_01 Verify all tabs are visible on the home page
  Given Verify User is on login page
  And User attempt to login
  Then Verify the user is successfully logged in
  When User is navigating to the root page
  Then Verify the below tabs are visible
  |Overview|Payment Assurance|Inventory Management|Sales|Maintenance|
  Then Verify the below tiles are visible
  |Loans|Assets|Media|Recovery Orders|Vehicles|Geofences|Devices|Organizations|Accounts|Dashboards|Reports|Alerts|
  And Click on hamburger button
  Then Verify the hamburger elements visibility
  |Loans|Recovery Orders|Vehicles|Media|Geofences|Reports|Installer Forms|Analytics|Alerts|Datasets|Dashboard|Accounts|Devices|Sims|Organizations|Settings|Batches|Sales Orders|Automations|Brands|Entries|
  Then Logout