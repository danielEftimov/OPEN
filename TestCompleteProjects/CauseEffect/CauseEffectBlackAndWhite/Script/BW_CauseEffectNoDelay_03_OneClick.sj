//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CauseEffectNoDelay_02_Navigation_NextLevel
//USEUNIT BW_CauseEffectNoDelay_04_ClicksOnTheCarBeforeAudioIsFinished
//USEUNIT BW_CheckRegions


function causeEffect_OneClick()
{


try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  Log.AppendFolder("This test is for ContinuousMovement of the mouse");
  eraser ();
  Log.PopLogFolder();
    
  //Navigate to the next level
  navigationNextLevel();
  
  //Click the object on the screen so that it reaches the target in one step

 
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

function oneClickCar()
{  
  //Check if the proper layer is getting displayed
  
  //Regions.CarStreetActive.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);
  
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 300;
  var coorY = 620;
 
  
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
  
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
  
  BW_CheckRegions.Region_HappyAnimation();   

}