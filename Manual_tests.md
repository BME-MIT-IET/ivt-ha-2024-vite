# Manual Test Cases

## Test Case 1: Launch and Main Menu Interaction
**Test Case ID**: 1 
**Objective**: Ensure the game launches and displays the main menu.  
**Preconditions**: None  
**Steps**:
1. Execute the game.
2. Observe the initial screen.

**Expected Result**: The main menu is displayed with options such as "Play" and "Exit".

---

## Test Case 2: Start Game
**Test Case ID**: 2 
**Objective**: Verify that clicking 'Play' starts the game.  
**Preconditions**: Main menu is visible  
**Steps**:
1. Click the 'Play' button on the main menu.

**Expected Result**: The game enters the play mode displaying asteroids and the settler.

---

## Test Case 3: Move Settler
**Test Case ID**: 3  
**Objective**: Test settler movement controls.  
**Preconditions**: Game is in play mode  
**Steps**:
1. Use arrow keys to move the settler in the game environment.

**Expected Result**: Settler moves according to the arrow key directions without any lag.

---

## Test Case 4: Attempt to Mine an Undrilled Asteroid
**Test Case ID**: 4 
**Objective**: Verify that mining an undrilled asteroid does not produce resources and the game handles the action correctly.  
**Preconditions**: Game is in 'Game' mode, the settler is positioned on or near an undrilled asteroid.  
**Steps**:
1. Navigate the settler to an asteroid that has not been drilled.
2. Press the 'M' key to attempt mining.
3. Observe the game's response and any messages displayed.

**Expected Result**: 
- The game should not allow mining of the undrilled asteroid.
- An appropriate message should be displayed, e.g., "Asteroid needs to be drilled first."

---

## Test Case 5: Successfully Drill and Mine an Asteroid
**Test Case ID**: 5
**Objective**: Ensure that the settler can successfully drill and then mine an asteroid.  
**Preconditions**: Game is in 'Game' mode, the settler is positioned on or near an asteroid that needs drilling.  
**Steps**:
1. Navigate the settler to an asteroid.
2. Press the 'D' key to drill the asteroid.
3. Once drilling is completed, press the 'M' key to mine the asteroid.
4. Observe the resources added to the inventory and any game messages.

**Expected Result**: 
- The asteroid should be drilled successfully, decreasing its depth.
- After drilling, mining should result in the collection of resources, such as Carbon, Iron, Water Ice, or Uranium, depending on the asteroid's composition.
- The inventory should update with the newly mined resources.

---

## Test Case 6: Inventory Management
**Test Case ID**: 6  
**Objective**: Check the functionality of the inventory system in the spaceship.  
**Preconditions**: Game is in play mode, and the settler has mined multiple asteroids  
**Steps**:
1. Mine multiple asteroids.
2. Access the spaceship inventory.

**Expected Result**: Inventory correctly reflects the collected resources.

---

## Test Case 7: Handling Sun Storms
**Test Case ID**: 7  
**Objective**: Ensure that sun storms affect settlers and robots appropriately.  
**Preconditions**: Game is in play mode  
**Steps**:
1. A sun storm occurs in the game.
2. Observe its effect on settlers and robots in its path.

**Expected Result**: Settlers and robots take damage or die depending on their exposure.

---

## Test Case 8: Resource Filling in Asteroids
**Test Case ID**: 8  
**Objective**: Check the functionality of filling asteroids with resources.  
**Preconditions**: Game is in play mode, and the settler has mined a fully drilled asteroid  
**Steps**:
1. Fully drill an asteroid making it hollow.
2. Fill the asteroid with a resource.

**Expected Result**: The selected resource is deducted from the inventory and the asteroid shows as filled.

---

## Test Case 9: Insufficient Resources for Robot Creation

**Test Case ID**: 9  
**Objective**: Verify that the system prevents robot creation when there are insufficient resources available.  
**Preconditions**: Game is in play mode, and the settler has fewer resources than required for building a robot.  
**Steps**:
1. **Verify Initial Resource Levels**: Check the current levels of iron, carbon, and uranium to ensure they are below the required thresholds for building a robot.
2. **Attempt to Build a Robot**: Press the 'B' key to initiate the robot building process.
3. **Check for Error or Alert**: Observe if the game displays an error message or alert indicating insufficient resources.
4. **Verify No Robot is Created**: Confirm that no new robot object is added to the game state.

**Expected Result**: The game should notify the player of insufficient resources and prevent the creation of a robot. No change in the state of resources or game objects related to robots should be observed.

---

## Test Case 10: Failure to Create Teleportation Gates with No Resources

**Test Case ID**: 10  
**Objective**: Verify that the game system prevents the creation of teleportation gates when no resources are available.  
**Preconditions**: Game is in play mode, and the settler has zero resources required for building teleportation gates.  
**Steps**:
1. **Verify Initial Resource Levels**: Check that the settler has no iron, water ice, and uranium—the resources necessary for building teleportation gates.
2. **Attempt to Create Teleportation Gates**: Press the 'T' key to try to initiate the creation of teleportation gates.
3. **Check for Error or Alert**: Observe if the game displays an error message or alert indicating no resources.
4. **Verify No Gates are Created**: Ensure that no new teleportation gates are added to the game environment.

**Expected Result**: The game should display an error message due to insufficient resources and prevent the creation of any teleportation gates. There should be no alteration in the game state regarding teleportation gates.

---

## Test Case 11: Filling the Asteroid
**Test Case ID**: 13  
**Objective**: Ensure the settler can fill a hollow, fully drilled asteroid with a unit of resource.  
**Preconditions**: Settler is at a hollow, fully drilled asteroid and has resources in inventory.  
**Steps**:
1. Select a resource from the inventory to fill the asteroid.
2. Use the 'F_Key' to fill the asteroid.
3. Confirm the resource is deducted from the inventory and the asteroid is updated as filled.

**Expected Result**:  
- The asteroid should be successfully filled with the selected resource.
- The inventory should update by deducting the used resource.

---

## Test Case 12: Hiding in an Asteroid
**Test Case ID**: 14  
**Objective**: Test the ability of the settler to hide inside a hollow, fully drilled asteroid.  
**Preconditions**: Settler is at a hollow, fully drilled asteroid.  
**Steps**:
1. Verify the asteroid is hollow and fully drilled.
2. Press the 'H_Key' for the settler to hide.
3. Observe if the game indicates that the settler is hidden.

**Expected Result**:  
- The settler successfully hides in the asteroid.
- The game displays a message confirming the settler is hidden, providing safety from external threats.
