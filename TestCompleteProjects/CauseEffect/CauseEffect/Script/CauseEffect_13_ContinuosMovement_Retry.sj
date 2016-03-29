//USEUNIT CauseEffect_19_GameMenu
//USEUNIT CheckRegions
//USEUNIT CauseEffect_01_ContinuosMovement

function causeEffect()
{
try{

  aqUtils.Delay(1000);
  //Launch the tested application.
  launchApp();
  
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();    
  
  restart_passed();
  Log.AppendFolder("This test is for Retry  of eraser level");  
  
  Region_Leaves();      
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



