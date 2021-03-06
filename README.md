# -Creation-of-a-multiple-choice-exam-server


**-->Main ideas in that project<br/>**
The following project is based on the client / server architecture in Java with sockets.<br/><br/>

##Student Area <br/>
1 - The server starts listening to the student to connect to take a multiple choice exam. <br/>
2 - The student has 3 exam choices. <br/>
3 - The student sends the name of the chosen exam to the server. <br/>
4 - The server sends the questions from the database to the student based on the name of the chosen exam. <br/>
5 - The student sends the responses to the server, and the server calculates the result and stores it in the database.<br/><br/>

##Teacher's area It is a simple interface that makes it easier for us to manage students: <br/>
  -We can see the list of students <br/>
  -Add a new student <br/>
  -See the students' marks for each exam <br/>
We can also add questions to exams already created.<br/><br/>

**-->Take into consideration:<br/>**
1-Libraries used: <br/>
  -rs2xml -mysql<br/>
  -connector <br/>
  -miglayout15-swing<br/>

2-Exporting the database named qcm.<br/><br/>

**-->For execution: first run "the Server class" to start the server then "the Main class"**<br/><br/>
1-  Server and Main interfaces:<br/>
![](images/Server+Main.png)<br/>
2-  Student area (Sign in):<br/>
![](images/StudentArea.JPG)<br/>
3-  Student Choices:<br/>
![](images/StudentChoices.JPG)<br/>
4-  Multiple Choice Exams:<br/>
![](images/QCM.JPG)<br/>
5-  Exam:<br/>
![](images/exam.JPG)<br/>
6-  Teacher's area (Sign in):<br/>
![](images/Teacher's%20Area.JPG)<br/>
7-  Teacher choices:<br/>
![](images/TeacherChoices.JPG)<br/>
