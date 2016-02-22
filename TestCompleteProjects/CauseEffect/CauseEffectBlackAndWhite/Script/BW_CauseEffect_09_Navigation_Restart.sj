//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CheckRegions
function causeEffect_Navigation_Restart()
{
try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
   eraser ();
 
  //Navigation on the next level
  restart();
  
  //validate if the same level is restarted
 
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

function restart()
{
//create region of the nextThemeButton
BW_CheckRegions.Region_RestartSad();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 850;
var coorY = 828;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
aqUtils.Delay(5000);

}