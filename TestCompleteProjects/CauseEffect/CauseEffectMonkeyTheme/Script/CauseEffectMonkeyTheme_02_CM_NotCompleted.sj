//USEUNIT CauseEffectMonkeyTheme_01_ContinuosMovement
//USEUNIT MT_CheckRegions
function CauseEffect_NotCompleted ()
{
 try{
    
  aqUtils.Delay(1000);
  //Launch the tested application.
  launchApp();
  
  //User does not remove all bananas from the screen  
  Log.AppendFolder("This is negative scenario for ContinuousMovement of the mouse 'User does not remove all leaves from the screen'")
  
  //Check if the first layer (top layer - bananas) is getting displayed
  
  
  Eraser_N();
  
  //Check if the second layer (bottom layer - car/street) has been shown properly
  if(!Regions.Compare(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL, 571, 320, 305, 143, false),"RegionBananas",lmNone))
  Log.Message("Bananas are not removed properly");
  
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
function Eraser_N()
{
  // Check if the theme select region is displayed
  Region_ThemeSelect();
  
  
  var coorX = 680;
  var coorY = 260;
 
  
  // Specifies a delay in milliseconds
  sDelay = 1000 ;
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
  aqUtils.Delay(2000);
  //Check if the first layer (top layer - leaves) is getting displayed
  Region_Bananas();
  
  aqUtils.Delay(3000);
  //Specifies the coordinates of the first click
  var destX = 171;
  var destY = 215;
 
  // Simulates continuous movement of the mouse
  LLPlayer.MouseMove(305, 215, 0);
  LLPlayer.MouseMove(285, 164, 0);
  LLPlayer.MouseMove(362, 172, 0);
  LLPlayer.MouseMove(400, 173, 16);
  LLPlayer.MouseMove(411, 174, 16);
  LLPlayer.MouseMove(900, 400, 0);
  LLPlayer.MouseMove(1200, 154, 0);
  LLPlayer.MouseMove(1665, 238, 0);
}