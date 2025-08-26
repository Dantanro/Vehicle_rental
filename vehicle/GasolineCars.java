//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package vehicle;

public class GasolineCars extends Vehicles
{
	private String plateNumber = "GC";
	private int nbOfGasolineCars = 0;
	
	private int maximumPassengers;	//Car

	
	public GasolineCars(String make, String model, int yearOfProduction, int maximumPassengers)
	{
		super(make, model, yearOfProduction);
		nbOfGasolineCars++;
		this.plateNumber = plateNumber + (nbOfGasolineCars + 1000);
		
		this.maximumPassengers = maximumPassengers;
	}
	public GasolineCars(GasolineCars t)
	{
		super(t);
		nbOfGasolineCars++;
		this.plateNumber = plateNumber + (nbOfGasolineCars + 1000);
		
		this.maximumPassengers = t.maximumPassengers;
	}
	//Constructors are done
	
	//All the Getters
	public String getPlateNumber()
	{
		return this.plateNumber;
	}
	public int getNbOfGasolineCars()
	{
		return (this.nbOfGasolineCars);
	}
	public int getMaximumPassengers()
	{
		return this.maximumPassengers;
	}
	//All the Setters
	public void setMaximumPassengers(int maximumPassengers)
	{
		this.maximumPassengers = maximumPassengers;
	}
	//toString() override
	public String toString()
	{
		String line = super.toString();
		line = line +  "\nGasoline Car\nPlate number: " + plateNumber + " || Maximum passengers: " + maximumPassengers;
		return line + "\n*************************************************************************";
	}
	//equals()
	public boolean equals(Object q)
	{
		if(!super.equals(q) && q.getClass()!=getClass()) return false;
			
		GasolineCars gasolineCars = (GasolineCars) q;
		return (this.maximumPassengers == gasolineCars.maximumPassengers);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
