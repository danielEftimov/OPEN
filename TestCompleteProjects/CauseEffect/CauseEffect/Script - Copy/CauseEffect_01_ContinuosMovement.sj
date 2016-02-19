function causeEffect()
{
try{
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
  TestedApps.desktop.Run();
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
  //Check if the first layer (top layer - leaves) is getting displayed
  Regions.RegionLeaves.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 1, 29, 1445, 906, false));
  var eraser_audioDelay=3000;
  aqUtils.Delay(eraser_audioDelay);

  //perform the erase action (continuos movement of the mouse over the scene) 
  LLCollection.ContinuousMovement.Execute();
  
  //Check if the second layer (bottom layer - car/street) has been shown properly
  Regions.HappyAnimation.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 571, 320, 338, 105, false),false,false,46024);
  
}