//USEUNIT CauseEffect_01_ContinuosMovement
function causeEffect_Navigation_GameManu()
{
try{
  //Launch the tested application.
  launchApp();
  
  //Removing leaves from the top layer of the scene by continuous movement of the mouse
   eraser ();
 
  //Navigation on the next level
   navigationGameManu();
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

function navigationGameManu()
{
//create region of the GameManu Button
Regions.gameManu.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 650;
var coorY = 840;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 

// validate ig game manu is shown properly

}