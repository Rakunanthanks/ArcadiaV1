# cadonix.test



# How to run through command line

mvn test -D"cucumber.filter.tags=@TerminalComponentDB" -DcomponentDB=quickstart -DuserName=<username> -Dpassword=<password> -DtestInstance=mercury1_21 -DprofileName=quickstart -DprojectName=quickstart


@TerminalComponentDB is an example tag from feature file located in "src/test/resources/features"