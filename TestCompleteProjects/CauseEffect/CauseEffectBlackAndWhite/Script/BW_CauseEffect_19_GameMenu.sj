//USEUNIT BW_CheckRegions

function navigationNextLevel()
{
//create region of the nextLevelButton
BW_CheckRegions.Region_NextLevel();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 1010;
var coorY = 900;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
aqUtils.Delay(50);
LLPlayer.MouseDown(MK_LBUTTON, coorX+10, coorY+10, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX+10, coorY+10, sDelay);


//validate if same theme is displayed (means you are still on the same theme but different level)
BW_CheckRegions.Region_AnimationCar();
aqUtils.Delay(5000);
//Regions.CarStreetActive.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);
}



function navigationNextTheme()
{
//create region of the nextThemeButton
Regions.BW_nextTheme.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 1250;
var coorY = 840;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 

}


function navigationGameManu()
{
//create region of the GameManu Button
Regions.BW_GameMenu.Check(Aliases.javaw.wndLWJGL2, false, false, 46024);

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
BW_CheckRegions.Region_RestartSad();

//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 850;
var coorY = 858;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
aqUtils.Delay(50);
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
aqUtils.Delay(6000);

}

function restart_passed()
{
//create region of the nextThemeButton
BW_CheckRegions.Region_HappyAnimation();


//Specifies the coordinates of the first click (it depends on the screen resolution)
var coorX = 850;
var coorY = 828;
sDelay = 1000 ;
 
// Simulates pressing and releasing the left mouse button
LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay);
aqUtils.Delay(50);
LLPlayer.MouseDown(MK_LBUTTON, coorX+10, coorY+10, sDelay);
LLPlayer.MouseUp(MK_LBUTTON, coorX+10, coorY+10, sDelay);
aqUtils.Delay(5000); 


}