Feature: Test Case 14: Place Order: Register while Checkout

  Scenario: Place Order: Register while Checkout
    Given user launches the browser
    When user navigates to url 'http://automationexercise.com'
    Then user verifies that home page is visible successfully
    And user adds products to cart
    And user clicks 'Cart' button
    Then user verifies that cart page is displayed
    And user clicks Proceed To Checkout
    And user clicks 'Register Login' button
    And user fills all details in Signup and creates account
    Then user verifies ACCOUNT CREATED! and clicks Continue button
    And user verifies 'Logged in as username' at top
    And user clicks 'Cart' button again
    And user clicks 'Proceed To Checkout' button
    And user verifies Address Details and Review Your Order
    And user enters description in comment text area and clicks Place Order
    And user enters payment details: Name on Card, Card Number, CVC, Expiration date
    And user clicks 'Pay and Confirm Order' button
    Then user verifies success message Your order has been placed successfully!
    And user clicks 'Delete Account' button
    Then user verifies 'ACCOUNT DELETED!' and clicks 'Continue' button