function Test9()
{
  //Runs the "desktop_1_0" tested application.
  TestedApps.desktop_1_0.Run();
  //Compares the ThemeSelect Stores item with the image of the Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 73, 111, 284, 264, false) object.
  Regions.ThemeSelect.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 73, 111, 284, 264, false));
}