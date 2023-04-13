# cadonix.test



# How to run through command line

mvn test -D"cucumber.filter.tags=@TerminalComponentDB" -DcomponentDB=componentdb -DuserName=username -Dpassword=password -DtestInstance=instancename -DprofileName=profilename -DprojectName=projectname -DprojectID=projectID


@TerminalComponentDB is an example tag from feature file located in "src/test/resources/features"


**Project ID** is an id of project can find in project page in Arcadia