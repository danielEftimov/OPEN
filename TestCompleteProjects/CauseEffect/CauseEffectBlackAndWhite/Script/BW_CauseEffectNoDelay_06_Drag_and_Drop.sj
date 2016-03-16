//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CauseEffect_03_OneClick
//USEUNIT BW_CauseEffect_05_MultipleClicks
//USEUNIT BW_CheckRegions

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
  BW_CauseEffect_19_GameMenu.navigationNextLevel();
  Log.PopLogFolder();  
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for Reaching the goal with one click");  
  oneClickCar();  
   
  //Navigation towards next level 
  BW_CauseEffect_19_GameMenu.navigationNextLevel();
  Log.PopLogFolder(); 
  
  //Click the object on the screen so that it moves forward 1/3 towards the target and reach the target in 3 steps
  Log.AppendFolder("This test is for Reaching the goal with multiple clicks");  
  multipleClicks();
     
  //Navigation towards next level 
  BW_CauseEffectNoDelay_02_Navigation_NextLevel.navigationNextLevel();
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
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 500;
  var coorY = 600;
 
  sDelay=1500;
 
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+300, coorY, sDelay);
  
  //Checks if the car moved
  BW_CheckRegions.Region_AnimationCar();
}
