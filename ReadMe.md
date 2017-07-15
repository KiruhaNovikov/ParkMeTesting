## Hi!
### Here is a test project for learning test automation basics

#### How to make a pull request:
- Pull all the changes from remote branch by using _git pull_
- Create new brunch, where you will add all your changes by executing command: **git checkout -b <branchname>** OR
by creating new branch in your IDE
- Make all the code changes you wanted
- When you think you are done, make commit by **git commit** (be aware about adding new files, if you did that, you
need to execute **git add <filename>** command OR add the file using IDE UI)
- Then you should push your changes by **git push -u origin <branch-name>** OR using your IDE
- Go to GitHub website, **projectHome -> pull request -> create new**
- Find your newly created branch and create pull request on it.
- Wait untill someone accepted your PR. If there is one or more comments, make appropriate changes in your IDE, make
**git commit** and **git push** commands again (if your head is still on this brunch, you don't need to specify
its name)
- Wait untill your new changes approved
- When it's done, you should merge your changes by git commands:
```
   git checkout master
   git merge --no-ff <brunchName>
   git push origin master
```
OR
Clicking on that button on GitHub:
![button image](https://image.prntscr.com/image/K3fHeSe1TLqaD6J-nxfGeg.png)