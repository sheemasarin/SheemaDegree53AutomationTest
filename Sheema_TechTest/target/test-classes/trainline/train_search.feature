@train
Feature:Trainline home page search

  Scenario Outline: Verify different passenger search combinations - happy path

    Given passenger is in home page
    When he selects the origin <From> and destination as <To>
    And he selects to return on the travel
    And he selects OUT date as "<OutDate>" and time as "<OutHour>" and "<OutTime>"
    And he selects RETURN date as "<ReturnDate>" and time as "<ReturnHour>" and "<ReturnTime>"
    And he selects rail card as "<RailCard>"
    And search for trains
    Then he should see "<From>"
    Then he should see "<To>"
    Then he should see "<RailCard>"

    Examples:
      | From               | To            | OutDate | OutHour | OutTime | ReturnDate | ReturnHour | ReturnTime | RailCard         |
      | Manchester Airport | London Bridge | Today   | 23      | 45      | 3          | 23         | 45         | Annual Gold Card |


  Scenario Outline: Verify different passenger search combinations - other combinations

    Given passenger is in home page
    When he selects the origin <From> and destination as <To>
    And he selects to return on the travel
    And he selects OUT date as "<OutDate>" and time as "<OutHour>" and "<OutTime>"
    And he selects RETURN date as "<ReturnDate>" and time as "<ReturnHour>" and "<ReturnTime>"
    And he selects rail card as "<RailCard>"
    And search for trains
    Then he should see "<From>"
    Then he should see "<To>"
    Then he should see "<RailCard>"

    Examples:
      | From               | To            | OutDate | OutHour | OutTime | ReturnDate | ReturnHour | ReturnTime | RailCard         |
      | Leeds | Manchester Airport | Today   | 23      | 45      | 3          | 23         | 45         | Annual Gold Card |
      | Manchester Airport | Barking | Today   | 23      | 45      | 5          | 23         | 45         | Annual Gold Card |