package domain.db;

import java.awt.List;
import java.util.ArrayList;

import domain.model.StudieMoment;

public class StudyTracker {
	
	private static ArrayList<StudieMoment> studie = new ArrayList<>();
	private static StudyTracker tracker = new StudyTracker();
	
	public static ArrayList<StudieMoment> getStudie(){
		return studie;
	}
	

	private StudyTracker(){
		
	}
	public void addStdudyMoment(StudieMoment moment){
		studie.add(moment);
	}
	public static StudyTracker getStudyMoment(){
		return tracker;
	}
	public int getAantalUur() {
		int uur = 0;
		for(StudieMoment s : studie){
			uur += uur + s.getUur();
		}
		return uur;
	}
}
