//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package vehicle;

public class ElectricTrucks extends Vehicles
{
	private String plateNumber = "ET";
	private int nbOfElectricTrucks = 0;
	
	private int maximumCapacity;	//Truck
	private int autonomyRange;	//Electric
	
	
	public ElectricTrucks(String make, String model, int yearOfProduction, int maximumCapacity, int autonomyRange)
	{
		super(make, model, yearOfProduction);
		nbOfElectricTrucks++;
		this.plateNumber = plateNumber + (nbOfElectricTrucks + 1000);
		this.maximumCapacity = maximumCapacity;
		this.autonomyRange = autonomyRange;
	}
	public ElectricTrucks(ElectricTrucks t)
	{
		super(t);
		nbOfElectricTrucks++;
		this.plateNumber = plateNumber + (nbOfElectricTrucks + 1000);
		this.maximumCapacity = t.maximumCapacity;
		this.autonomyRange = t.autonomyRange;
	}
	//Constructors are done
	
	//All the Getters
	public String getPlateNumber()
	{
		return this.plateNumber;
	}
	public int getNbOfElectricTrucks()
	{
		return (this.nbOfElectricTrucks);
	}
	public int getMaximumCapacity()
	{
		return this.maximumCapacity;
	}
	public int getAutonomyRange()
	{
		return this.autonomyRange;
	}
	//All the Setters
	public void setMaximumCapacity(int maximumCapacity)
	{
		this.maximumCapacity = maximumCapacity;
	}
	public void setAutonomyRange(int autonomyRange)
	{
		this.autonomyRange = autonomyRange;
	}
	//toString() override
	public String toString()
	{
		String line = super.toString();
		line = line +  "\nElectric Truck\nPlate number: " + plateNumber + " || Maximum capacity: " + maximumCapacity + " || Autonomy range: " + autonomyRange;
		return line + "\n*************************************************************************";
	}
	//equals()
	public boolean equals(Object q)
	{
		if(!super.equals(q) && q.getClass()!=getClass()) return false;
			
		ElectricTrucks electricTrucks = (ElectricTrucks) q;
		return (this.maximumCapacity == electricTrucks.maximumCapacity && this.autonomyRange == electricTrucks.autonomyRange);
	}
	//Deep copy
	public ElectricTrucks clone()
	{
		return new ElectricTrucks (this.make, this.model, this.yearOfProduction, this.maximumCapacity, this.autonomyRange);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
