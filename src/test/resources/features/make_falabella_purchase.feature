#Created by DiegoPinzon20 at 06/05/2022
#Author: diegopip62@gmail.com

Feature: Make a purchase at Falabella online
  As a Falabella customer, I need to make a
  purchase through your website.

  Background: Preparation of the test object
    Given Pedro browses the main web page

  @AddProductsToCart @AutomatedTest
  Scenario Outline: Add products to cart
    When performs the search for the product <productName>
    And select the first option and add <expectedQuantity>
    Then the added product should have the following characteristics
      | expectedQuantity   | expectedTitle   |
      | <expectedQuantity> | <expectedTitle> |

    Examples:
      | productName | expectedQuantity | expectedTitle |
      | Bolso mujer | 1                | Bolso         |
      | Perfume     | 3                | Perfume       |


  @AddProductsToCart @CompleteAddressInformation @AutomatedTest
  Scenario Outline: Add products to cart
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
