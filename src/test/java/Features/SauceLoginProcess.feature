@SauceDemo

Feature: Sauce Page Test Cases

  @AllEmpty
  Scenario Outline: Empty UserName and Empty Password
    Given User At Login Page
    When Click Login Button
    Then Check "<error>" Message About UserName
    Examples:
    |error                                  |
    |Epic sadface: Username is required     |

  @EmptyPassword
  Scenario Outline:Empty Password
    Given User At Login Page
    When Write "<UserName>" For UserName Field
    When Click Login Button
    Then Check "<error>" Message Abaout Password
    Examples:
    |UserName     ||error                             |
    |standard_user||Epic sadface: Password is required|

  @EmptyUserName
  Scenario Outline: Empty UserName
    Given User At Login Page
    When Write "<Password>" For Password Field
    When Click Login Button
    Then Check "<error>" Message About UserName
    Examples:
    |Password            ||error                                  |
    |secret_sauce        ||Epic sadface: Username is required     |

  @FalseLoginForPassword
  Scenario Outline: Correct UserName and False Password
    Given User At Login Page
    When Write "<UserName>" For UserName Field
    When Write "<Password>" For Password Field
    When Click Login Button
    Then Check "<error>" Message Abaout Password
    Examples:
    |UserName     ||Password ||error                                                                    |
    |standard_user||123123123||Epic sadface: Username and password do not match any user in this service|

  @FalseLoginForUserName
  Scenario Outline: False UserName and Correct Password
    Given User At Login Page
    When Write "<UserName>" For UserName Field
    When Write "<Password>" For Password Field
    When Click Login Button
    Then Check "<error>" Message About UserName
    Examples:
      |UserName     ||Password    ||error                                                                    |
      |FalseUserName||secret_sauce||Epic sadface: Username and password do not match any user in this service|

  @CorrectLogin
  Scenario Outline: Correct UserName and Correct Password
    Given User At Login Page
    When Write "<UserName>" For UserName Field
    When Write "<Password>" For Password Field
    When Click Login Button
    Then Check Login
    Examples:
    |UserName     ||Password |
    |standard_user||secret_sauce|
