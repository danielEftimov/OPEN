//USEUNIT CauseEffect_01_ContinuosMovement
//USEUNIT CauseEffect_03_OneClick
//USEUNIT CauseEffect_19_GameMenu
//USEUNIT CheckRegions
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
  navigationNextLevel();
  Log.PopLogFolder();  
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
  oneClickCar();  
  aqUtils.Delay(1500);  
  
  //Navigation towards next level 
  navigationNextLevel();
  Log.PopLogFolder(); 
  
  //Click the object on the screen so that it moves forward 1/3 towards the target and reach the target in 3 steps
  Log.AppendFolder("This test is for Reaching the goal with multiple clicks");  
  multipleClicks();  
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
  
  sDelay = 1000;
  // Simulates the secound click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+300, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
  
  sDelay = 1000;
  // Simulates the 3rd click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+600, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+600, coorY, sDelay);
 
  aqUtils.Delay(4000);  
  
  //Check if the happy animations has been shown properly
  CheckRegions.Region_HappyAnimation(); 
  
}