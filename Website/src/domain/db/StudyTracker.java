package domain.db;

import java.awt.List;
import java.util.ArrayList;

import domain.model.StudieMoment;

public class StudyTracker {
	
	private static ArrayList<StudieMoment> studie = new ArrayList<>();
	private static StudyTracker tracker = new StudyTracker();
	
	public ArrayList<StudieMoment> getStudie(){
		return studie;
	}
	

	private StudyTracker(){
		
	}
	public void addStdudyMoment(StudieMoment moment){
		studie.add(moment);
	}
	public static synchronized StudyTracker getStudyMoment(){
		if(tracker == null){
			tracker = null;
		}
			return tracker;
	}
	public double getAantalUur() {
		double uur = 0;
		for(StudieMoment s : studie){
			uur = uur + s.getUur();
		}
		return uur;
	}
}
