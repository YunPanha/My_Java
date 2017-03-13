package ClassSource;

public class Interview {

	private String question;
	private String answer;
	private String date;
	
	public Interview (String q,String a,String d){
		this.question=q;
		this.answer=a;
		this.date=d;
	}
	public String Question(){
		return question;
	}
	public String Answer(){
		return answer;
	}
	public String Date(){
		return date;
	}
}
