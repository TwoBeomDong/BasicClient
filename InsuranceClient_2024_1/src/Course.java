
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	//entity
	protected String courseID;
	protected String professor;
	protected String courseName;
	protected ArrayList<String> afterCompleteCourseList;
	
	public Course(String couInfo) {
		StringTokenizer stringTokenizer = new StringTokenizer(couInfo);
		
		this.courseID = stringTokenizer.nextToken();
		this.professor = stringTokenizer.nextToken();
		this.courseName = stringTokenizer.nextToken();
		
		this.afterCompleteCourseList = new ArrayList<String>();
		while(stringTokenizer.hasMoreTokens()) {
			this.afterCompleteCourseList.add(stringTokenizer.nextToken());
		}
	}
	
	public String toString() {
        String stringReturn = this.courseID + " " + this.professor + " " + this.courseName;
        for (int i = 0; i < this.afterCompleteCourseList.size(); i++) {
            stringReturn = stringReturn + " " + this.afterCompleteCourseList.get(i).toString();
        }
        return stringReturn;
    }
}
