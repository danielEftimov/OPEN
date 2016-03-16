//USEUNIT CauseEffect_01_ContinuosMovement
//USEUNIT CauseEffectNoDelay_02_Navigation_NextLevel
//USEUNIT CheckRegions


function ClicksOntheCarBeforeAudioIsFinished()
{  
  
  
  //Specifies the coordinates of the first click (it depends on the screen resolution)
  var coorX = 450;
  var coorY = 500;
 
  
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
 CheckRegions.Region_AnimationCar();
     

}