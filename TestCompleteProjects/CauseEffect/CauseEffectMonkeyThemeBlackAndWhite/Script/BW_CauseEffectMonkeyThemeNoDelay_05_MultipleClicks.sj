//USEUNIT BW_CauseEffectMonkeyTheme_01_ContinuosMovement
//USEUNIT BW_CauseEffectMonkeyTheme_03_OneClick
//USEUNIT BW_CauseEffectMonkeyTheme_15_GameMenu
//USEUNIT BW_CauseEffectMonkeyThemeNoDelay_02_Navigation_NextLevel
//USEUNIT BW_CauseEffectMTNoDelay_04_ClicksCarBeforeAudioIsFinished
//USEUNIT MT_BW_CheckRegions
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
  BW_CauseEffectMonkeyTheme_15_GameMenu.navigationNextLevel();
  Log.PopLogFolder();  
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
  oneClickCar();  
  aqUtils.Delay(1500);  
  
  //Navigation towards next level 
  BW_CauseEffectMonkeyThemeNoDelay_02_Navigation_NextLevel.navigationNextLevel();
  Log.PopLogFolder(); 
  

 
 Log.AppendFolder("This test is for Reaching the goal with 3 click before audio is finished");  
  
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

function multipleClicks()
{  
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 450;
  var coorY = 500;

 
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
 
  // Simulates the first click
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
  
  // Simulates the secound click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+300, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
 
  // Simulates the 3rd click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+600, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+600, coorY, sDelay);
 
 
  aqUtils.Delay(1500);  
  //Check if the happy animations has been shown properly
  Region_HappyAnimation();
  
}