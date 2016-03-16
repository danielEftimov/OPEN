//USEUNIT CheckRegions
function causeEffect()
{
try{

  aqUtils.Delay(1000);
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
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

function launchApp()
{
  //TestedApps.desktop.Params.SimpleParams.FilePath="\\mkskfs01\Projects\OpenTheWindows\game for testing";
  //TestedApps.desktop.Params.SimpleParams.FileName="desktop.exe"
  //TestedApps.desktop.Params.SimpleParams.Activate();
  TestedApps.desktop_1_0.Run();
  causeEffectObject = Aliases.javaw.wndLWJGL2;
}

function closeApp()
{
 //Closes the game window.
  causeEffectObject.Close();
  Log.Message("The 'Cause and Effect' game finshed")
}


function eraser ()
{

  Log.AppendFolder("This test is for Select theme");
  Region_ThemeSelect()
  Log.PopLogFolder();
  
  //Specifies the coordinates of the click (it depends on the screen resolution)
  var coorX = 400;
  var coorY = 231;
 
  
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
  aqUtils.Delay(2000);
  //Check if the first layer (top layer - leaves) is getting displayed
  CheckRegions.Region_Leaves();
  
  aqUtils.Delay(3000);

  //perform the erase action (continuos movement of the mouse over the scene) 
  LLCollection.ContinuousMovement.Execute();
  
  //Check if the second layer (bottom layer - car/street) has been shown properly
  Region_HappyAnimation();
  
}