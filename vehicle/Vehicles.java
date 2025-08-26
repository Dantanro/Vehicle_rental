//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package vehicle;

public abstract class Vehicles
{
	protected String make;
	protected String model;
	protected int yearOfProduction;
	protected int nbOfVehicle = 0;
	protected boolean isLeased = false;

	public Vehicles()
	{
		this.make = "";
		this.model = "";
		this.yearOfProduction = 0;
		nbOfVehicle++;
	}
	public Vehicles(String make, String model, int yearOfProduction)
	{
		this.make = make;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		nbOfVehicle++;
	}
	public Vehicles(Vehicles t)
	{
		this.make = t.make;
		this.model = t.model;
		this.yearOfProduction = t.yearOfProduction;
		nbOfVehicle++;
	}
	
	//All the Getters
	public String getMake()
	{
		return this.make;
	}
	public String getModel()
	{
		return this.model;
	}
	public int getYearOfProduction()
	{
		return this.yearOfProduction;
	}
	public int getNbOfVehicle()
	{
		return this.nbOfVehicle;
	}
	public boolean getIsLeased()
	{
		return this.isLeased;
	}
	//All the Setters
	public void setMake(String make)
	{
		this.make = make;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public void setYearOfProduction(int yearOfProduction)
	{
		this.yearOfProduction = yearOfProduction;
	}
	public void setIsLeased(boolean isLeased)
	{
		this.isLeased = isLeased; 
	}
	//toString()
	public String toString()
	{
		String line = "*************************************************************************\n"
				+ "Make: " + make + " || Model: " + model + " || Year Of Production: " + yearOfProduction
				+ "\nLeased: " + isLeased + "\n";
		return line;
	}
	//equals()
	public boolean equals(Object q)
	{
		if(super.equals(q)) return true;
		if(q == null || getClass() != q.getClass())
		{
			return false;
		}
		Vehicles vehicles = (Vehicles) q;
		return (this.make == vehicles.make && this.model == vehicles.model && this.yearOfProduction == vehicles.yearOfProduction);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}