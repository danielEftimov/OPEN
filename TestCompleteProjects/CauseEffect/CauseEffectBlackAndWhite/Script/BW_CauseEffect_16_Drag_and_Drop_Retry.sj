//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CauseEffect_03_OneClick
//USEUNIT BW_CauseEffect_06_Navigation_NextLevel
//USEUNIT BW_CauseEffect_09_Navigation_Restart
//USEUNIT BW_CauseEffect_05_MultipleClicks
//USEUNIT BW_CauseEffect_14_Drag_and_Drop
//USEUNIT BW_CauseEffect_15_DragAndDropFailed
//USEUNIT BW_CheckRegions

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
   
  navigationNextLevel();
  Log.PopLogFolder(); 
  
Log.AppendFolder("This test is for Reaching the goal with multiple clicks");  
  DragAndDropFailed();  
  Log.PopLogFolder();
  
   restart()
 Log.AppendFolder("This test is for Retry  of the multiple clicks level");  
  DragAndDrop();      
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
