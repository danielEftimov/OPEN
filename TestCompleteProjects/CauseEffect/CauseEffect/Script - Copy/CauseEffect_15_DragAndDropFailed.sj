﻿//USEUNIT CauseEffect_01_ContinuosMovement
//USEUNIT CauseEffect_03_OneClick
//USEUNIT CauseEffect_06_Navigation_NextLevel
//USEUNIT CauseEffect_05_MultipleClicks
function causeEffect_OneClick()
{
try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
 //Navigation towards next level 
  navigationNextLevel();
  Log.PopLogFolder();  
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
  oneClickCar();  
  aqUtils.Delay(1500);  
  
  //Navigation towards next level 
  navigationNextLevel();
  Log.PopLogFolder(); 
  
  //Click the object on the screen so that it moves forward 1/3 towards the target and reach the target in 3 steps
  Log.AppendFolder("This test is for Reaching the goal with multiple clicks");  
  multipleClicks();
  aqUtils.Delay(1500);
    
  //Navigation towards next level 
  navigationNextLevel();
  Log.PopLogFolder();
 
 Log.AppendFolder("This test is for 3 unsussessful ties for drag and drop");  
  DragAndDropFailed();
  aqUtils.Delay(1500);  
  Log.PopLogFolder();
 }
 catch(e)
  {
    // Posts an exception message to the test log
    Log.Error(e.description);
    // Stops the test execution
    Runner.Stop();
  }
 finally
 {     
   closeApp();
 }
}
function DragAndDropFailed()
{
 
  LLCollection.DragAndDropFailed.Execute();
  aqUtils.Delay(2000); 
  //Check if the unhappy animation has been shown properly
  Regions.SadAnimation.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 593, 505, 279, 97, false), false, false, 1804);
}