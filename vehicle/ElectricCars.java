//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package vehicle;

public class ElectricCars extends Vehicles
{
	private String plateNumber = "EC";
	private int nbOfElectricCars = 0;
	
	private int maximumPassengers;	//Car
	private int autonomyRange;		//Electric

	
	public ElectricCars(String make, String model, int yearOfProduction, int maximumPassengers, int autonomyRange)
	{
		super(make, model, yearOfProduction);
		nbOfElectricCars++;
		this.plateNumber = plateNumber + (nbOfElectricCars + 1000);
		
		this.maximumPassengers = maximumPassengers;
		this.autonomyRange = autonomyRange;
	}
	public ElectricCars(ElectricCars t)
	{
		super(t);
		nbOfElectricCars++;
		this.plateNumber = plateNumber + (nbOfElectricCars + 1000);
		
		this.maximumPassengers = t.maximumPassengers;
		this.autonomyRange = t.autonomyRange;
	}
	//Constructors are done
	
	//All the Getters
	public String getPlateNumber()
	{
		return this.plateNumber;
	}
	public int getNbOfElectricCars()
	{
		return (this.nbOfElectricCars);
	}
	public int getMaximumPassengers()
	{
		return this.maximumPassengers;
	}
	public int getAutonomyRange()
	{
		return this.autonomyRange;
	}
	//All the Setters
	public void setMaximumPassengers(int maximumPassengers)
	{
		this.maximumPassengers = maximumPassengers;
	}
	public void setAutonomyRange(int autonomyRange)
	{
		this.autonomyRange = autonomyRange;
	}
	//toString() override
	public String toString()
	{
		String line = super.toString();
		line = line +  "\nElectric Car\nPlate number: " + plateNumber + " || Maximum passengers: " + maximumPassengers + " || Autonomy range: " + autonomyRange;
		return line + "\n*************************************************************************";
	}
	//equals()
	public boolean equals(Object q)
	{
		if(!super.equals(q) && q.getClass()!=getClass()) return false;
			
		ElectricCars electricCars = (ElectricCars) q;
		return (this.maximumPassengers == electricCars.maximumPassengers && this.autonomyRange == electricCars.autonomyRange);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
