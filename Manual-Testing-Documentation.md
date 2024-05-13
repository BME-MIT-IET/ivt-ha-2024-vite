# Manual Test Cases Documentation

Manual testing involves direct user interaction with the system to ensure that the application behaves as expected under different scenarios. This documentation outlines various test cases designed to manually validate the functionalities of the application. Each test is structured to provide clear steps and expected results to guide testers through the process.

## Table of Contents

1. Launch and Main Menu Interaction
2. Start Game
3. Move Settler
4. Attempt to Mine an Undrilled Asteroid
5. Successfully Drill and Mine an Asteroid
6. Inventory Management
7. Handling Sun Storms
8. Resource Filling in Asteroids
9. Insufficient Resources for Robot Creation
10. Failure to Create Teleportation Gates with No Resources
11. Filling the Asteroid
12. Hiding in an Asteroid

## Importance of Manual Testing

Manual testing is vital for several reasons:

1. **Detailed Inspection**: Unlike automated tests, manual testing allows for a nuanced examination of the user interface and user experience, capturing the look and feel of the application as perceived by human users.

2. **Flexibility**: Testers can perform exploratory testing by deviating from predefined test scripts to uncover unexpected issues. 

3. **Contextual Understanding**: Manual testers apply their understanding of the business context and user needs, which can lead to a more thorough evaluation of the application’s functionality in real-world scenarios.

4. **Cost-Effective**: For small projects or projects at an early stage of development, manual testing can be more cost-effective than setting up automated tests.

## Creating Manual Test Cases

To create effective manual test cases, follow these steps:

1. **Understand Requirements**: Clearly understand the application’s requirements and objectives. Knowing what the application is supposed to do is the first step in crafting effective test cases.

2. **Define Test Cases**: Write down each test case, describing what needs to be tested and why. This includes the goal of the test, the steps to execute it, any prerequisites, and the expected results.

3. **Organize Test Cases**: Group test cases in a logical order, such as by application module or user journey. This organization helps in executing tests systematically.

4. **Write Clear Steps**: Each step in the test case should be clear and concise, providing exact instructions on what to do. Include details about where to click, what to input, and how to set up the test environment if needed.

5. **Determine Expected Results**: For each test case, clearly define the expected outcome. This could be what the screen should display, how the application should respond to an input, or any changes in the system state.

6. **Review and Revise**: Regularly review and update the test cases to ensure they remain relevant as the application evolves. This includes modifying tests when new features are added or existing features are changed.

7. **Document Results**: After executing each test case, document the results. This documentation should include whether the test passed or failed and any discrepancies from the expected results.

# Failed Tests

## Test Case : Robot Creation and Deployment
**Objective**: Test the ability to build and deploy robots.  
**Preconditions**: Game is in play mode, and the settler has gathered sufficient resources  
**Steps**:
1. Gather sufficient resources.
2. Build a robot using the 'B' key.
3. Deploy the robot.

**Expected Result**: Robot is created and functions autonomously as expected.

---

## Test Case : Teleportation Gates
**Objective**: Test the creation and deployment of teleportation gates.  
**Preconditions**: Game is in play mode, and the settler has gathered necessary resources  
**Steps**:
1. Accumulate necessary resources.
2. Create teleportation gates.
3. Deploy gates on asteroids.

**Expected Result**: Teleportation gates are created and functional, allowing instant travel between linked

---

## Test Case : Building a Space Station 
**Objective**: Test the ability of the settler to build a space station when sufficient resources are available.  
**Preconditions**: Settler has collected all necessary resources for building a space station.  
**Steps**:
1. Verify that the settler has the required resources (Iron, Carbon, Uranium, and Water Ice) in the inventory.
2. Press the 'S_Key' to initiate building the space station.
3. Observe the building process and any on-screen messages or animations.

**Expected Result**:  
- The space station should be built successfully.
- The game should update the state to reflect the settler has won the game.
