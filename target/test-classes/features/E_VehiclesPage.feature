@VehiclesPage
Feature: Vehicles Page Test
  In order to test functionality of Vehicles page

  @VehiclesPage_NavigateToVehiclePageFromHomePage
  Scenario: Verify the vehicle page navigation functionality
    Given Launch the URL do the necessary initializations and login
    Given After login user is on vehicles page
    Given User is navigating to the home page
    Then Verify the below cards are visible
    |Loans|Assets|Media|Recovery Orders|Vehicles|Geofences|Devices|Organizations|Accounts|Dashboards|Reports|Alerts|

  @VehiclesPage_ClickOnInstallDeviceOnVehiclePage
  Scenario: Search for the last created new device and click on install the device button on vehicle page
    Given verify User is on selected organization description "Elastic M2M Root" home page
    Then User navigates to selected organization vehicle page
    Then User removes vehicle inventory filter from search text box
    Then Search for Device with DeviceId "DEVICEIDAUTO0055" in search text box
    Then select the searched device from the table and will check whether the device is installed or not
    Then User clicks on the install device icon

  @VehiclesPage_ProvideVINDeviceDetailsOnVehiclePage
  Scenario: Provide VIN and other details to install selected device into a Vehicle
    Given Verify user is on "SETTINGS" page to provide VIN
    Then click on next button and wait till listening got completed
    Then Click on the logout button and close the browser




