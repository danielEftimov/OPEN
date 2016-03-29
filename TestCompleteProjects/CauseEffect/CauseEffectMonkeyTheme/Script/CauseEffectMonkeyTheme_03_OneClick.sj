//USEUNIT CauseEffectMonkeyTheme_01_ContinuosMovement
//USEUNIT CauseEffectMonkeyTheme_15_GameMenu
//USEUNIT MT_CheckRegions
function causeEffect_OneClick()
{


try{

  aqUtils.Delay(1000);
  //Launch the tested application.
  launchApp();
  
  
  //Removing bananas from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();
    
  //Navigate to the next level
  navigationNextLevel();
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
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

function oneClickCar()
{  
  //Check if the proper layer is getting displayed
  Region_AnimationMonkey()
  
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 450;
  var coorY = 500;
 
  
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
  aqUtils.Delay(4000);
  
  //Check if the happy animations has been shown properly 
  Region_HappyAnimation();   
}