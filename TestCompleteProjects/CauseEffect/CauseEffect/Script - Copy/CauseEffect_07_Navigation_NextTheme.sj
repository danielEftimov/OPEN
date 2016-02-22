//USEUNIT CauseEffect_01_ContinuosMovement
function causeEffect_Navigation_NextTheme()
{
try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
  eraser ();
 
  //Navigation on the next level
  navigationNextTheme();
  
  //validate - compare if the currenttheme is not same as previous one
  Regions.RegionLeaves.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 1, 29, 1445, 906, false));
  
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

function navigationNextTheme()
{
//create region of the nextThemeButton
Regions.nextTheme.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 1250;
var coorY = 840;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 



}