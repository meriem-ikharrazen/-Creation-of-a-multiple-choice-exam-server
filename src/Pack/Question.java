package Pack;

import java.util.Arrays;


public class Question 
{
	 public int id;
	 public String question,rep;
	 public String choix1,choix2,choix3,choix4;
	
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	

	public Question(int id,String question, String rep,String choix1,String choix2,String choix3,String choix4) {
		super();
		this.id = id;
		this.question = question;
		this.rep = rep;
		this.choix1=choix1;
		this.choix2=choix2;
		this.choix3=choix3;
		this.choix4=choix4;
	}

	@Override
	public String toString() {
		return "Question [id= "+id+ "question=" + question + ", rep=" + rep + ", choix1=" + choix1 + "choix2"+choix2+"choix3"+choix3+"choix4"+choix4+"]";
	}
	
	

}
