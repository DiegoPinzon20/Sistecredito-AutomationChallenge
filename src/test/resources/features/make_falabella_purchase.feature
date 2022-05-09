#Created by DiegoPinzon20 at 06/05/2022
#Author: diegopip62@gmail.com

Feature: Make a purchase at Falabella online
  As a Falabella customer, I need to make a
  purchase through your website.

  Background: Preparation of the test object
    Given Pedro browses the main web page

  Rule: The search cannot be empty

    @EmptySearch @IncorrectSearch @AutomatedTest
    Scenario Outline: Empty search, special characters or incorrect
      When performs the search for the product <productName>
      Then should see the search empty message

      Examples:
        | productName |
        | *#$%        |
        |             |
        | 5           |

  Rule: Some searches do not return results

    @ProductNotAvailable @AutomatedTest
    Scenario Outline: Looking for product not available
      When performs the search for the product <productName>
      Then should see the message of products not available

      Examples:
        | productName |
        | master123   |
        | cebollapro  |

  Rule:A user adds zero products, the cart must be empty

    @AddZeroProducts @AutomatedTest
    Scenario Outline: Add zero quantity of products.
      When performs the search for the product <productName>
      And select the first option and add <expectedQuantity>
      Then should see the basket empty
      Examples:
        | productName   | expectedQuantity |
        | Botella termo | 0                |

  Rule: A user can add products to cart

    @AddProductsToCart @AutomatedTest @SuccessfulCases
    Scenario Outline: Add products to cart
      When performs the search for the product <productName>
      And select the first option and add <expectedQuantity>
      Then the added product should have the following characteristics
        | expectedQuantity   | expectedTitle   |
        | <expectedQuantity> | <expectedTitle> |

      Examples:
        | productName | expectedQuantity | expectedTitle |
        | Bolso mujer | 2                | Bolso         |
        | Perfume     | 5                | Perfume       |
        | +/Reloj*    | 1                | reloj         |

  Rule: To finalize the purchase the user must enter the shipping information

    @CompleteAddressInformation @AutomatedTest
    Scenario Outline: Complete shipping information
      When performs the search for the product <productName>
      And select the first option and add <expectedQuantity>
      And add the shipping information of the order
        | emailAddress   | state   | city   | address   | aditionalAddress   |
        | <emailAddress> | <state> | <city> | <address> | <aditionalAddress> |
      Then the purchase summary should contain the following information
        | expectedQuantity   | expectedTitle   |
        | <expectedQuantity> | <expectedTitle> |

      Examples:
        | productName  | expectedQuantity | emailAddress           | state        | city     | address                | aditionalAddress  | expectedTitle |
        | Mouse        | 2                | webtesting@serenity.co | Cundinamarca | Bogota   | 17734 Lebsack Ports    | Av. Eric, Hab. 05 | Mouse         |
        | Gafas de sol | 10               | example@serenity.ru    | Antioquia    | Medellin | Avinguda Juan, 9, 04 C | #122 Hab. 098     | Gafas         |