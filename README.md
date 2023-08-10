# Calorie Tracker Project

## Introduction

Knowing the amount of calories to consume is essential to help people reach their fitness goals. Recording food intake 
can help people understand and identify their eating habits, reminding people to stay on track. Therefore, to aid people 
keep a good body health/shape, motivate people (including myself) to lose, gain, or maintain weight, and help people 
continue their efforts, I have chosen to build a calorie tracking and counting application. **Potential users** of this 
application include people who want to maintain good physical health, people who are passionate about fitness, and 
people who want to manage weight. 

<u> Some key features of this application including:</u> 

- Searching caloric content of common foods by categories 
- Adding foods to wishlist and save (can also delete wrong ones/clear all)
- A button on wishlist to calculate Daily Total Calories
- Available for users to set their daily calories goal
- displaying *Yayyy! You Made It!* message when the user meets the goal
- displaying the difference between the goal and the actual total when failing to meet the goal



## User Stories

- As a user, I want to be able to add food to the wishlist
- As a user, I want to be able to clear all foods from my wishlist
- As a user, I want to be able to view the list of foods' name I added to the wishlist
- As a user, I want to be able to calculate my Daily Total Calories
- As a user, I want to be able to set my personal calories goal
- As a user, I want to be given the option to save my wishlist to file
- As a user, when I start the application, I want to be given the option to load my wishlist list from file

## Instructions for Grader
- You can generate the first required action related to adding Xs (foods) to a Y (wishlist) by first clicking country button (labelled Korea, China, 
Canada) to get into the foods window. Then browse your willing foods and click the button labelled food's name
and calorie, and click the button labelled "added to the wishlist" to add selected food to wishlist
- You can generate the second required action related to adding Xs to a Y by first clicking "my wishlist" button on 
the main window. Then click the button labelled "remove" and selected the food number you want to delete from the wishlist
- You can locate my visual component by opening the wishlist window by clicking "my wishlist" button on the main window. 
Then click the button labelled "calculate". A picture with total calorie of foods in the wishlist would show on the screen.
There are also images added to the start pop up message dialog, and three country buttons on the main window 
- You can save the state of my application by clicking "File" on the menu bar and clicking "save". If you forget to click save 
before exiting the application, do not worry, there is also a popup message dialog to remind you save before leaving. 
To save the state in this way, you can click "save my wishlist" on the popup window
- You can reload the state of my application by either clicking "load my wishlist" on the start popup message window or 
by clicking "File" on the menu bar and clicking "load"

## Phase 4: Task 2
Wed Aug 09 16:41:25 PDT 2023
Added food to wishlist: tteokbokki


Wed Aug 09 16:41:27 PDT 2023
Added food to wishlist: bibim naengmyeon


Wed Aug 09 16:41:32 PDT 2023
Added food to wishlist: ma po tofu


Wed Aug 09 16:41:35 PDT 2023
Added food to wishlist: kung pao chicken


Wed Aug 09 16:41:40 PDT 2023
Added food to wishlist: poutine


Wed Aug 09 16:41:42 PDT 2023
Added food to wishlist: cheese pizza


Wed Aug 09 16:41:54 PDT 2023
Removed food from wishlist: ma po tofu


Wed Aug 09 16:42:07 PDT 2023
Removed food from wishlist: bibim naengmyeon


Wed Aug 09 16:42:09 PDT 2023
Calculated total daily calorie is: 868

## Phase 4: Task 3
Looking into my FoodsWindow, ChinaWindow, CanadaWindow, and KoreaWindow classes, there are many repetitive tasks 
occurring, that I made separate methods to set up foods button in each window. One possible refactoring could be applied 
to reduce the code redundancy is to put foods in one list instead of having them as independent Food fields. I can first 
generate all buttons, set labels on buttons by foods' names and calories, and their background color and border. Then, 
I would add these buttons to a list and have a checkCountry method in FoodsWindow. I would implement a for each loop in
the method to check which country the current button belongs to, and then call the setLocation method to set the
accurate location for the button in their appropriate window. setLocation would be an abstract method, and be 
implemented (using for loop to update location -- y-axis) in each subclass to generate location for each button. 

Secondly, by looking at my UML diagram, there's a  triangle shape between CalorieApp, MainPanel, and WishlistPanel. It 
implies, there's a redundant association, that mainPanel do not actually need to have a field type Wishlist. One way to 
refactoring this is to delete the field in MainPanel, and add parameter of type Wishlist to the methods in the class, 
where it needs the wishlist.  