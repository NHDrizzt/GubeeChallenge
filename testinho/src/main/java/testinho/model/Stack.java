package testinho.model;

public record Stack (String name){
	@Override
	public String toString() {
		return name;
	}
}
