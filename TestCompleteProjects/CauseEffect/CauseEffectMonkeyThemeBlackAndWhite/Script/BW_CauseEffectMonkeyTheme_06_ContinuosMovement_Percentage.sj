//USEUNIT BW_CauseEffectMonkeyTheme_01_ContinuosMovement

function causeEffect()
{
try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
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

function eraser ()
{
  //Check if the first layer (top layer - leaves) is getting displayed
  Region_Leaves();
  
  //perform the erase action (continuos movement of the mouse over the scene) 
  MT_BW_LLCollection.MT_BW_ContinuousMovement.Execute();
  
  //Check if the happy animation is properly showed 
  Region_HappyAnimation();
}
