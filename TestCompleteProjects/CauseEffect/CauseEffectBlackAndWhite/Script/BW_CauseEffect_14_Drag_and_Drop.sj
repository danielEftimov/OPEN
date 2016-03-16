//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CauseEffect_03_OneClick
//USEUNIT BW_CauseEffect_19_GameMenu
//USEUNIT BW_CauseEffect_05_MultipleClicks
//USEUNIT BW_CheckRegions

function causeEffect_OneClick()
{
try{

  aqUtils.Delay(1000);
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
 
  Log.AppendFolder("This test is for Reaching the goal with drag and drop");  
  DragAndDrop();  
  Log.PopLogFolder();
 }
 catch(e)
  {
    // Posts an exception message to the test log
    Log.Error(e.description);
    closeApp();
    // Stops the test execution
    Runner.Stop();
    
  }
 finally
 {     
   closeApp();
 }
}

function DragAndDrop()
{
 sDelay = 1000 ;
 
 BW_LLCollection.DragAndDrop.Execute();
 aqUtils.Delay(1500);
 
 //Check if the happy animation is shown properly
 Region_HappyAnimation();
}
