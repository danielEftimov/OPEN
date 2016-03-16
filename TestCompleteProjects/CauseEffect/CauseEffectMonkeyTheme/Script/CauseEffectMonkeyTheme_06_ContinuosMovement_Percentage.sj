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
  //Check if the region theme select is displayed
  Region_ThemeSelect();
    
  var coorX = 680;
  var coorY = 260;
   
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
  aqUtils.Delay(2000);
  
  //Check if the first layer (top layer - bananas) is getting displayed
  Region_Bananas();
  
  //perform the erase action (continuos movement of the mouse over the scene) 
  MT_LLCollection.MT_ContinuousMovement.Execute();
  
  //Check if the happy animation is properly showed 
  Region_HappyAnimation();
}
