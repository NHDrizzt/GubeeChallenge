package testinho.model;

public class Market {
	
	private int id;
	private String name;


	public Market(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Market(String name)
	{
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
