//USEUNIT MT_CheckRegions

function navigationNextLevel()
{
//create region of the nextLevelButton
//Regions.nextLevel.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);
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
Region_AnimationCar();
aqUtils.Delay(5000);
//Regions.CarStreetActive.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);
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

function navigationGameMenu()
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

function restart()
{
//create region of the nextThemeButton
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
//create region of the nextThemeButton
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
