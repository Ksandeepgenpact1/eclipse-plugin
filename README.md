# Eclipse Comment Plugin

This repository contains the experiments with Eclipse Plugins written in Java.
This plugin gives an option of adding a custom comment using an option in the right click popup menu in another instance.

How to run?
  1. Clone the Project into the Eclipse IDE.
  2. Right click on the project in the Package Explorer -> Run As -> Eclipse Application to see the Runtime Instance of the Eclipse Platform, where we create the Test Project.
  3. To check the functionality of the plugin, select a snippet of code of the Test Project and give a right click to see a menu and can see the plugin labeled as "Add a Comment".
  4. On selecting "Add a Comment" from the menu, the functionality of the plugin is activated and a Confirmation dialog box will popup.
  5. On confirming, the highlighted code snippet from the editor will be replaced by the replacementText provided.

How to Package and Deploy the Plugin?
  1. First a feature project for the developed plugin must be created, You create a feature project via File -> New -> Other…​ -> Plug-in Development -> Feature Project.
  2. Name the Feature Project and intialize it with the particular plugin project.
  3. Now Create a category definition, You can create a category definition via File -> New -> Other…​ -> Plug-in development -> Category Definition.
  4. Name the Category Definition and add the above created Feature Project as the Parent Folder.
