##Hi!
###Here is a test project for learnin test automation basics

####How to make a pull request:
- Pull all the changes from remote branch by using _git pull_
- Create new brunch, where you will add all your changes by executing command: _git checkout -b <branchname>_ OR
by creating new branch in your IDE
- Make all the code changes you wanted
- When you think you are done, make commit by _git commit_ (be aware about adding new files, if you did that, you
need to execute _git add <filename>_ command OR add the file using IDE UI)
- Then you should push your changes by _git push -u origin <branch-name>_ OR using your IDE
- Go to GitHub website, projectHome -> pull request -> create new
- Find your newly created branch and create pull request on it.
- Wait untill someone accepted your PR. If there is one or more comments, make appropriate changes in your IDE, make
_git commit_ and _git push_ commands again (if your head is still on this brunch, you don't need to specify
its name)
- Wait untill your new changes approved
- When it's done, you should merge your changes by git commands:
'''
   git checkout master
   git merge --no-ff <brunchName>
   git push origin master
'''
OR
Clicking on that button on GitHub:
![button image](http://prntscr.com/fw0dnt)