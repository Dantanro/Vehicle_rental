//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package vehicle;

public class DieselTrucks extends Vehicles 
{
	private String plateNumber = "DT";
	private int nbOfDieselTrucks = 0;
	
	private int maximumCapacity;	//Truck
	private int tankCapacity;		//DieselTrucks
	
	public DieselTrucks(String make, String model, int yearOfProduction, int maximumCapacity, int tankCapacity)
	{
		super(make, model, yearOfProduction);
		nbOfDieselTrucks++;
		this.plateNumber = plateNumber + (nbOfDieselTrucks + 1000);
		
		this.maximumCapacity = maximumCapacity;
		this.tankCapacity = tankCapacity;
	}
	public DieselTrucks(DieselTrucks t)
	{
		super(t);
		nbOfDieselTrucks++;
		this.plateNumber = plateNumber + (nbOfDieselTrucks + 1000);
		
		this.maximumCapacity = t.maximumCapacity;
		this.tankCapacity = t.tankCapacity;
	}
	public DieselTrucks()
	{
		super();
	}
	//Constructors are done
	
	//All the Getters
	public String getPlateNumber()
	{
		return this.plateNumber;
	}
	public int getNbOfDieselTrucks()
	{
		return (this.nbOfDieselTrucks);
	}
	public int getMaximumCapacity()
	{
		return this.maximumCapacity;
	}
	public int getTankCapacity()
	{
		return this.tankCapacity;
	}
	//All the Setters
	public void setMaximumCapacity(int maximumCapacity)
	{
		this.maximumCapacity = maximumCapacity;
	}
	public void setTankCapacity(int tankCapacity)
	{
		this.tankCapacity = tankCapacity;
	}
	//toString() override
	public String toString()
	{
		String line = super.toString();
		line = line +  "\nDiesel Truck\nPlate number: " + plateNumber + " || Maximum capacity: " + maximumCapacity + " || Tank capacity: " + tankCapacity;
		return line + "\n*************************************************************************";
	}
	//equals()
	public boolean equals(Object q)
	{
		if(!super.equals(q) && q.getClass()!=getClass()) return false;
			
		DieselTrucks dieselTrucks = (DieselTrucks) q;
		return (this.maximumCapacity == dieselTrucks.maximumCapacity && this.tankCapacity == dieselTrucks.tankCapacity);
	}
	
	
	
	
	
	
	
	
	
	
	
}
