package testinho.model;

import java.util.Objects;

public class Produto {
	
	private int id;
	private String name;
	private String description;
	
	public Produto() {
		
	}
	
	public Produto(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 @Override
	    public boolean equals(Object obj) {
	        // TODO Auto-generated method stub
	        if(obj instanceof Produto)
	        {
	        	Produto temp = (Produto) obj;
	            if(this.name.equals(temp.name) && this.description.equals(temp.description))
	                return true;
	        }
	        return false;
	    }

	    @Override
	    public int hashCode() {
	        // TODO Auto-generated method stub
	        
	        return (this.name.hashCode() + this.description.hashCode());        
	    }
	
}

