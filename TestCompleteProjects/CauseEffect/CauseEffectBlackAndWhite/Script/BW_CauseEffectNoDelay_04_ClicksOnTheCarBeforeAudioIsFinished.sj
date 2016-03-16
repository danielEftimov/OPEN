//USEUNIT BW_CauseEffect_01_ContinuosMovement
//USEUNIT BW_CauseEffectNoDelay_02_Navigation_NextLevel
//USEUNIT BW_CheckRegions

function ClicksOntheCarBeforeAudioIsFinished()
{  
  
  
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 300;
  var coorY = 620;
 
  
  // Specifies a delay in milliseconds
  sDelay = 500 ;
  
  
  // Simulates pressing and releasing the left mouse button
  LLPlayer.MouseDown(MK_LBUTTON, coorX+100, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+100, coorY, sDelay);
  LLPlayer.MouseDown(MK_LBUTTON, coorX, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX, coorY, sDelay); 
  LLPlayer.MouseDown(MK_LBUTTON, coorX+100, coorY, sDelay);
  LLPlayer.MouseUp(MK_LBUTTON, coorX+100, coorY, sDelay);

  
  //Check if the car is moved
 Region_AnimationCar();
     

}