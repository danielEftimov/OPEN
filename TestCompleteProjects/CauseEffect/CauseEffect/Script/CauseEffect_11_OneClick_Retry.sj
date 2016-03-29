//USEUNIT CauseEffect_01_ContinuosMovement
//USEUNIT CauseEffect_19_GameMenu
//USEUNIT CauseEffect_04_ClicksOutofBounds
//USEUNIT CauseEffect_03_OneClick
function causeEffect_OneClick()
{
try{

  aqUtils.Delay(1000);
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();
    
  //Navigate to the next level
  navigationNextLevel();
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
  multipleClicksOutOfBounds();   
  Log.PopLogFolder(); 
  
  restart()
  Log.AppendFolder("This test is for Retry  one click");  
  
  oneClickCar();     
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
