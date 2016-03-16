//USEUNIT BW_CauseEffectMonkeyTheme_01_ContinuosMovement
//USEUNIT MT_BW_CheckRegions


function navigationNextLevel()
{
//create region of the nextLevelButton
Region_NextLevel();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 1030;
var coorY = 920;
sDelay = 10 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
aqUtils.Delay(50);
LLPlayer.MouseDown(MK_LBUTTON, coorX+10, coorY+10, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX+10, coorY+10, sDelay);
  
 
//validate if same theme is displayed (means you are still on the same theme but different level)
Region_AnimationMonkey();
}