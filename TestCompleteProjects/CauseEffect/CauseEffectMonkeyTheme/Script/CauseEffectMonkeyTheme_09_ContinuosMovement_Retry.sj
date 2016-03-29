//USEUNIT CauseEffectMonkeyTheme_15_GameMenu
//USEUNIT MT_CheckRegions
//USEUNIT CauseEffectMonkeyTheme_01_ContinuosMovement

function causeEffect()
{
try{

  aqUtils.Delay(1000);
  //Launch the tested application.
  launchApp();
  
  
  //Removing bananas from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();    
  
 restart_passed();
 Log.AppendFolder("This test is for Retry  of eraser level");  
  Region_Bananas();      
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



function closeApp()
{
 //Closes the game window.
  causeEffectObject.Close();
  Log.Message("The 'Cause and Effect' game finshed")
}


