//USEUNIT MT_CheckRegions

function navigationNextLevel()
{
//Check if the next level button is displayed
Region_NextLevel();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 1030;
var coorY = 920;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
aqUtils.Delay(1000);
LLPlayer.MouseDown(MK_LBUTTON, coorX+10, coorY+10, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX+10, coorY+10, sDelay);  

  
//validate if same theme is displayed (means you are still on the same theme but different level)
Region_AnimationMonkey();
aqUtils.Delay(5000);

}


function navigationNextTheme()
{
//Check if the next theme button is displayed
Region_NextTheme();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 1250;
var coorY = 840;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
aqUtils.Delay(50);
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
}

function navigationGameMenu()
{
//Check if the game menu button is displayed
Region_gameManu();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 650;
var coorY = 840;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 

}

function restart()
{
//Check if the sad animation is displayed
Region_RestartSad();


//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 850;
var coorY = 828;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
aqUtils.Delay(6000); 


}

function restart_passed()
{
//Check if happy animation is displayed
Region_HappyAnimation();


//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 850;
var coorY = 828;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
aqUtils.Delay(5000); 


}
