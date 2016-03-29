//USEUNIT MT_BW_CheckRegions
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
  causeEffectObject = Aliases.javaw.wndLWJGL;
}

function closeApp()
{
 //Closes the game window.
  causeEffectObject.Close();
  Log.Message("The 'Cause and Effect' game finshed")
}


function eraser ()
{
  Region_SelectTheme();
  
  
  var coorX = 680;
  var coorY = 231;
 
  
  // Specifies a delay in milliseconds
  sDelay = 10 ;
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
  //Check if the first layer (top layer - leaves) is getting displayed
  Region_Bananas();
  

  //perform the erase action (continuos movement of the mouse over the scene) 
  MT_BW_LLCollection.MT_BW_NoDelayContinuousMovement.Execute();
  
  //Check if the second layer (bottom layer - car/street) has been shown properly
  Region_Bananas();
  
}