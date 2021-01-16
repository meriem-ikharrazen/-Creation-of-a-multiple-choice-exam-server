# -Creation-of-a-multiple-choice-exam-server


-->Main ideas in that project
The following project is based on the client / server architecture in Java with sockets.

##Student Area 
1 -the server starts listening to the student to connect to take a multiple choice exam. 
2 - the student has 3 exam choices. 
3 - the student sends the name of the chosen exam to the server. 
4 - The server sends the questions from the database to the student based on the name of the chosen exam. 
5 -the student sends the responses to the server, and the server calculates the result and stores it in the database.

##Teacher's area It is a simple interface that makes it easier for us to manage students: 
  -We can see the list of students 
  -Add a new student 
  -See the students' marks for each exam 
We can also add questions to exams already created.

-->Take into consideration: 
1-Libraries used: 
  -rs2xml -mysql
  -connector 
  -miglayout15-swing

2-Exporting the database named qcm.

-->For execution: first run "the Server class" to start the server then "the Main class"
