//USEUNIT CauseEffectMonkeyTheme_01_ContinuosMovement
//USEUNIT CauseEffectMonkeyThemeNoDelay_02_Navigation_NextLevel
//USEUNIT MT_CheckRegions
function causeEffect_OneClick()
{


try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();
    
  Log.AppendFolder("This test is for reaching  to the next level");
  navigationNextLevel();
  Log.PopLogFolder();
  

  
 Log.AppendFolder("This test is for Reaching the goal with one click before audio is finished");  
  
  ClicksOntheCarBeforeAudioIsFinished();    
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

function ClicksOntheCarBeforeAudioIsFinished()
{  
  //Check if the proper layer is getting displayed
  
  //Regions.CarStreetActive.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);
  
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 450;
  var coorY = 500;
 
  
  // Specifies a delay in milliseconds
  sDelay = 500 ;
  
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX+100, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+100, coorY, sDelay);
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
  LLPlayer.MouseDown(MK_LBUTTON, coorX+100, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+100, coorY, sDelay);

  
  //Check if the car is moved
 Region_AnimationCar();
     

}