Feature: Purchase Smartphone

Scenario: Successful purchase of a smartphone
  Given the user is logged in
  When the user selects a smartphone to purchase
  And the user adds the smartphone to the cart
  And the user completes the checkout process
  Then the user should see a confirmation message