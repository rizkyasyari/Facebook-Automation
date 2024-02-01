#Author: Muhammad Rizky Asyari
@LoginPositive
Feature: Login Positive Case
  User Successfully Login to Facebook

  @LoginFacebook
  Scenario: User berhasil Login ke Akun Facebook
    Given User Menuju Url Facebook
    When User Mengisi Email dan Password
    Then User Berhasil Login ke Facebook