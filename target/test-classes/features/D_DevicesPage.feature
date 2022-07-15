@DevicesPage
Feature: Device page Test
  In order to check create and update Device functionality Based upon User and Organization
  We wTC-A06
  ill test different combination of credentials to test the Create and Update Device functionality

Background:User Login and Navigate to Home Page and then Select Device card
  Given Launch the URL do the necessary initializations and login
  When User is navigating to the root page
  Then Verify the below tabs are visible
  | Overview | Payment Assurance | Inventory Management | Sales | Maintenance|
  And Select the card named "Devices" then verify the page is loaded with name "Devices"

@DevicePage_Creating_Device
Scenario:Scenario_01 Verify that the user is able to Create Devices in the factory organization
  Given click on create device
  Then Fill the following fields and click Create Device button
  |  Device Profile | Serial Number   |   DeviceId     |
  | Arrow \| Public | SerialAuto0055  |DeviceIdAuto0055|
  Then Click on Create Button
  Then Verify the new Device is created with DeviceId "DEVICEIDAUTO0055"
  Then Verify the following details on Device tab
    |  Device Profile | Serial Number   |   DeviceId     | Status  |
    |     arrow-tld   | SERIALAUTO0055  |DEVICEIDAUTO0055| created |

@DevicePage_Updating_Device
Scenario:Scenario_02 Verify that the user is able to update a Device
  Given Search for Device with DeviceId "DEVICEIDAUTO0055" in search text box
  Then Open on the Device with DeviceId "DEVICEIDAUTO0055" on search result
  Then Click on edit button
  Then Update the following details
  |    IMEI    |   External Id  |   SIM Id  |Dealer Box Id|
  |IMEIAUTO0055|EXTERNALAUTO0055|SIMAUTO0055|BOXIDAUTO0055|
  Then Click on update button
  Then Verify Device updated pop-up

@DevicePage_Transferring_Device
Scenario:Scenario_03 To verify that the user is able to transfer the device to dealership organization
  Given Search for Device with DeviceId "DEVICEIDAUTO0055" in search text box
  Then Open on the Device with DeviceId "DEVICEIDAUTO0055" on search result
  Then click on View Actions Button
  Then click on Transfer Device Button
  Then Select "Demo23rd June" as Target Organization
  Then Click on Transfer Button and click Yes to confirm
  Then Verify By Device Transfer PopUp