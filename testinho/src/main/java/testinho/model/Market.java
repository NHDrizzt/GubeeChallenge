package testinho.model;

public record Market(String name){
	@Override
	public String toString() {
		return name;
	}
}
