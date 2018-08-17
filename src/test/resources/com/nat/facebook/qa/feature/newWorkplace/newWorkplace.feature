Feature: Workplace form with mandatory and optional fields
  Scenario: Customer can save a <form_type>  form  with mandatory field  filled in and optional fields filled in
    Given I login with with the following values:
      | Username                   | Password |
      | daria.zablodska@gmail.com  | Test1234 |
    And I open the Profile page
    When I click on About menu item
    Then I click on Work and Education section link item
    And I click on Add a workplace button
    And I specify mandatory fields with the following values:
      | Mandatory Field Name    | Mandatory Field Value |
      | employerNamePageElement | Paazl                 |
    And I specify optional fields with the following values:
      | Optional Field Name             | Optional Field Value      |
      | employerPositionTextPageElement | Quality Assurance Engineer|
    And I click on save changes button
    Then I should see the following created New Workplace:
      | Mandatory Field Locator     | Mandatory Field Value | Optional Field Locator              | Optional Field Value       |
      | editEmployerNamePageElement | Paazl                 | editEmployerPositionTextPageElement | Quality Assurance Engineer |