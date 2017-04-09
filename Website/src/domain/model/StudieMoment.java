package domain.model;

public class StudieMoment{

	private int uur;
	private String vak;
	private String dag;

	
	public StudieMoment( int uur,String vak,String dag){
		this.setUur(uur);
		this.setVak(vak);
		this.setDag(dag);
	}
	public int getUur() {
		return uur;
	}
	public void setUur(int uur) {
		this.uur = uur;
	}
	public String getVak() {
		return vak;
	}
	public void setVak(String vak) {
		this.vak = vak;
	}
	public String getDag() {
		return dag;
	}
	public void setDag(String dag) {
		this.dag = dag;
	}
	
}
