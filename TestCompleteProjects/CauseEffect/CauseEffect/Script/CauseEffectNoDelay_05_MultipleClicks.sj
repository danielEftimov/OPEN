//USEUNIT CauseEffect_01_ContinuosMovement
//USEUNIT CauseEffect_03_OneClick
//USEUNIT CauseEffectNoDelay_02_Navigation_NextLevel
//USEUNIT CauseEffectNoDelay_04_ClicksOnTheCarBeforeAudioIsFinished
//USEUNIT CauseEffect_06_Navigation_NextLevel
//USEUNIT CheckRegions
function causeEffect_OneClick()
{
try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
 //Navigation towards next level 
  CauseEffect_06_Navigation_NextLevel.navigationNextLevel();
  Log.PopLogFolder();  
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
  oneClickCar();  
  aqUtils.Delay(1500);  
  
  //Navigation towards next level 
  CauseEffectNoDelay_02_Navigation_NextLevel.navigationNextLevel();
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
  //check if car is moved (create Region1)
  
  // Simulates the secound click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+300, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
  //check if car is moved (create Region2)
  
  // Simulates the 3rd click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+600, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+600, coorY, sDelay);
  //check if car is moved (create Region3)
  
 
  aqUtils.Delay(1500);  
  //Check if the happy animations has been shown properly
   CheckRegions.Region_HappyAnimation();
  
}