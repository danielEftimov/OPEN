//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CauseEffect_06_Navigation_NextLevel
//USEUNIT BW_CheckRegions
//USEUNIT BW_CheckRegions
function CauseEffect_ClicksOutOfBounds()
{
 try{
    
  //Launch the tested application.
  launchApp();
  
  //User 3 times is clicking out of the object bounds.  
  Log.AppendFolder("GIVEN a scene with object WHEN number of retries is equal to 3 THEN unhappy animation is shown AND game ends")
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();
    
  //Navigate to the next level
  navigationNextLevel();
  
  //Click the object on the screen so that it reaches the target in one step
  Log.AppendFolder("This test is for three clicks out of the car object"); 
  multipleClicksOutOfBounds();  
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

function multipleClicksOutOfBounds()
{
  //Check if the proper layer is getting displayed
  BW_CheckRegions.Region_AnimationCar();

  //Specifies the coordinates of the first click
  var coorX = 658;
  var coorY = 658;
 
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
 
  // Simulates the first click
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
  
  // Simulates the 2nd click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+200, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+200, coorY, sDelay);
  
  // Simulates the 3rd click
  LLPlayer.MouseDown(MK_LBUTTON, coorX+400, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+400, coorY, sDelay);
  
  aqUtils.Delay(2000); 
  //Check if the unhappy animation has been shown properly
  BW_CheckRegions.Region_SadAnimation();
}





