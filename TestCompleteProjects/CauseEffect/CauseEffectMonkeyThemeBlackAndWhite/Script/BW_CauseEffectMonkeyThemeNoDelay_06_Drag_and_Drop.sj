﻿//USEUNIT BW_CauseEffectMonkeyTheme_01_ContinuosMovement
//USEUNIT BW_CauseEffectMonkeyTheme_03_OneClick
//USEUNIT BW_CauseEffectMonkeyTheme_05_MultipleClicks
//USEUNIT BW_CauseEffectMonkeyTheme_15_GameMenu
//USEUNIT BW_CauseEffectMonkeyThemeNoDelay_02_Navigation_NextLevel
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
   
  
  //Navigation towards next level 
  BW_CauseEffectMonkeyTheme_15_GameMenu.navigationNextLevel();
  Log.PopLogFolder(); 
  
  //Click the object on the screen so that it moves forward 1/3 towards the target and reach the target in 3 steps
  Log.AppendFolder("This test is for Reaching the goal with multiple clicks");  
  multipleClicks();
 
    
  //Navigation towards next level 
  BW_CauseEffectMonkeyThemeNoDelay_02_Navigation_NextLevel.navigationNextLevel();
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
  var coorX = 450;
  var coorY = 500;
 sDelay=10;
 //LLCollection.DragAndDrop.Execute();
 LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
 LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
 LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
 LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
 
 Region_AnimationMonkey();
}
