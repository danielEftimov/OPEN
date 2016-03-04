function Test6()
{
  //Runs the "desktop" tested application.
  TestedApps.desktop.Run();
  //Clicks at point (814, 846) of the 'wndLWJGL2' object.
  Aliases.javaw.wndLWJGL2.Click(814, 846);
  //Compares the wndLWJGL1 Stores item with the image of the Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 6, 34, 1450, 911, false) object.
  Regions.wndLWJGL1.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 6, 34, 1450, 911, false), false, true);
}

function Test10()
{
  //Runs the "desktop" tested application.
  TestedApps.desktop.Run();
  //Compares the wndLWJGL1 Stores item with the image of the Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 336, 748, 839, 188, false) object.
  Regions.wndLWJGL1.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 336, 748, 839, 188, false));
}

function Test11()
{
  //Runs the "desktop" tested application.
  TestedApps.desktop.Run();
  //Compares the NEXTLEVEL Stores item with the image of the Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 736, 767, 174, 130, false) object.
  Regions.NEXTLEVEL.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 736, 767, 174, 130, false));
}

function Test2()
{
  //Runs the "desktop_1_0" tested application.
  TestedApps.desktop_1_0.Run();
  //Compares the ThemeSelect Stores item with the image of the Regions.CreateRegionInfo(Aliases.java.wndLWJGL, 101, 134, 217, 211, false) object.
  Regions.ThemeSelect.Check(Regions.CreateRegionInfo(Aliases.java.wndLWJGL, 101, 134, 217, 211, false));
  //Clicks at point (208, 207) of the 'wndLWJGL' object.
  Aliases.java.wndLWJGL.Click(208, 207);
}

function Test3()
{
  //Runs the "desktop_1_0" tested application.
  TestedApps.desktop_1_0.Run();
  //Compares the SelectCar Stores item with the image of the Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 107, 134, 201, 206, false) object.
  Regions.SelectCar.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 107, 134, 201, 206, false));
  //Clicks at point (201, 212) of the 'wndLWJGL2' object.
  Aliases.javaw.wndLWJGL2.Click(201, 212);
}