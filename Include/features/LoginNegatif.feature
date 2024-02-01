#Author: Muhammad Rizky Asyari
@LoginNegatif
Feature: Login Negatif Case
  User Failed Login to Facebook

  @InvalidEmail
  Scenario: User Gagal Login - Invalid Email
    Given User Menuju Url Facebook
    When User mengisi dengan Email "dadda72@suryapasti" dan password "Awda@200" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook
    
  @NullEmail
 	Scenario: User Gagal Login - Expired Email
    Given User Menuju Url Facebook
    When User mengisi dengan Email "" dan password "Awda@200" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook
    
  @SpecialEmail
  Scenario: User Gagal Login - Special Character Email
    Given User Menuju Url Facebook
    When User mengisi dengan Email "!!!72@suryapasti.com" dan password "Awda@200" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @MinimumEmail
  Scenario: User Gagal Login - Minimum Character Email
    Given User Menuju Url Facebook
    When User mengisi dengan Email "r" dan password "Awda@200" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @AnotherEmail
  Scenario: User Gagal Login - Another Account Email
    Given User Menuju Url Facebook
    When User mengisi dengan Email "RizkyKeren11@suryapasti.com" dan password "Awda@200" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @UsernameEmail
  Scenario: User Gagal Login - Username Email
    Given User Menuju Url Facebook
    When User mengisi dengan Email "dadda72" dan password "Awda@200" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @InvalidPassword
  Scenario: User Gagal Login - Invalid Password
    Given User Menuju Url Facebook
    When User mengisi dengan Email "dadda72@suryapasti.com" dan password "Awda@1500" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @MinimumPassword
  Scenario: User Gagal Login - Minimum Character Password
    Given User Menuju Url Facebook
    When User mengisi dengan Email "dadda72@suryapasti.com" dan password "1" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook
    
  @NullPassword
  Scenario: User Gagal Login - Null Password
    Given User Menuju Url Facebook
    When User mengisi dengan Email "dadda72@suryapasti.com" dan password "" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @AnotherPassword
  Scenario: User Gagal Login - Another Account Password
    Given User Menuju Url Facebook
    When User mengisi dengan Email "dadda72@suryapasti.com" dan password "Rfa@2000000" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook

  @NullEmailPassword
  Scenario: User Gagal Login - Null Email dan Password
    Given User Menuju Url Facebook
    When User mengisi dengan Email "" dan password "" pada halaman Login Facebook
    Then User Gagal Login ke HomePage Facebook
