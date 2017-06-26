# run junit tests
javac -cp .:../junit/junit-4.12.jar  SolutionTest.java
java -cp .:../junit/junit-4.12.jar:../junit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore SolutionTest
