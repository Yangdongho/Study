package 컬렉션2;


public class Student {

	String name;
	int totalScore;

	public Student(String name,int totalScore) {
		
		this.name = name;
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", totalScore=" + totalScore + "]";
	}


	

}
