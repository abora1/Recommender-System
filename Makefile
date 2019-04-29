all:compile

compile: 
	javac -cp ".:junrar-0.8.jar:commons-lang3-3.4.jar:opencsv-4.1.jar" dm_project.java

run:
	java -cp ".:junrar-0.8.jar:commons-lang3-3.4.jar:opencsv-4.1.jar" dm_project 

clean:
	rm *.class

	
	








