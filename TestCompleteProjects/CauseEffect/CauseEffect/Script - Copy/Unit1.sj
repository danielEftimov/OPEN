function Test1()
{
  //Runs the "desktop" tested application.
  TestedApps.desktop.Run();
  //Clicks at point (812, 839) of the 'wndLWJGL2' object.
  Aliases.javaw.wndLWJGL2.Click(812, 839);
  //Double-clicks at point (193, 633) of the 'wndLWJGL2' object.
  Aliases.javaw.wndLWJGL2.DblClick(193, 633);
  //Clicks at point (193, 633) of the 'wndLWJGL2' object.
  Aliases.javaw.wndLWJGL2.Click(193, 633);
  //Compares the RestartSad Stores item with the image of the Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 6, 27, 1451, 919, false) object.
  Regions.RestartSad.Check(Regions.CreateRegionInfo(Aliases.javaw.wndLWJGL2, 6, 27, 1451, 919, false));
}