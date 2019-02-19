Feature: Redirection on mobile
  As a Product Owner
  I want that the web redirects to mobile site with HTTPS protocol on mobile browsers
  So the user experience will be more secure and user-friendly

  Scenario: Redirection on Android
    Given an Android user on Chrome
    When going to http://aningunsitio.blogspot.com
    Then the connection changes to HTTPS
    And the user is directed to mobile site