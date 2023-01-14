# cadonix.test



# How to run through command line

mvn test -D"cucumber.filter.tags=@TerminalComponentDB" -DcomponentDB=quickstart -DuserName=username -Dpassword=password -DtestInstance=instancename -DprofileName=profilename -DprojectName=projectname


@TerminalComponentDB is an example tag from feature file located in "src/test/resources/features"