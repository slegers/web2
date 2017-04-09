package domain;

public class Counter {
	private String name;
	
	public Counter(String naam){
		this.name = naam;
	}
	
	public int count(String l){
		int numb = 0;
		for(int i = 0; i < name.length();i++){
			if(name.substring(i, i+1).equals(l)){
				numb= numb+1;
			}
		}
		return numb;
	}

}
