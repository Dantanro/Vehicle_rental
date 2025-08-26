//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package client;
import vehicle.*;

public class Client 
{
	private String name;
	private int age;
	private Vehicles[] leasedVehicles;
	
	public Client()
	{
		this.name = "";
		this.age = 0;
		this.leasedVehicles = new Vehicles[0];
	}
	public Client(String name, int age)
	{
		this.name = name;
		this.age = age;
		this.leasedVehicles = new Vehicles[0];
	}
	public Client(Client t)
	{
		this.name = t.name;
		this.age = t.age;
		this.leasedVehicles = t.leasedVehicles;
	}
	//all constroctors
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public Vehicles[] getLeasedVehicle()
	{
		return this.leasedVehicles;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void setLeasedVehicle(Vehicles[] leasedCars)
	{
		this.leasedVehicles = leasedCars;
	}
	
	//toString()
	public String toString()
	{
		String line = "-------------------------------------------------------------------------\nName: " + name + " Age: " + age + "\n";
		if(leasedVehicles.length < 1) return line + "No leased cars\n-------------------------------------------------------------------------";
		else 
		{
			for(int i = 0; i < leasedVehicles.length; i++)
			{
				int carNb = i + 1;
				line = line + "\nVehicle number " + carNb + ":\n" + leasedVehicles[i].toString();
			}
			return line + 
					"\n-------------------------------------------------------------------------";
		}
	}
	//equals()
	public boolean equals(Object q)
	{
		if(super.equals(q)) return true;
		if(q == null || getClass() != q.getClass())
		{
			return false;
		}
		Client client = (Client) q;
		return (this.name == client.name && this.leasedVehicles == client.leasedVehicles);
	}
	
	public void addLeasedCar(Vehicles q)
	{
		Vehicles[] leasedVehiclesClone = new Vehicles[leasedVehicles.length + 1];
		
		for (int i = 0; i < leasedVehicles.length; i++)
		{
			leasedVehiclesClone[i] = leasedVehicles[i];
		}
		leasedVehiclesClone[leasedVehicles.length] = q;
		leasedVehicles = leasedVehiclesClone;
	}
	
	public void removeLeasedVehicle(int carToRemove)
	{
		Vehicles[] leasedVehiclesClone = new Vehicles[leasedVehicles.length - 1];
			
		for (int i = 0, k = 0; i < leasedVehicles.length; i++)
		{
			if (i != carToRemove)
			{
				leasedVehiclesClone[k] = leasedVehicles[i];
				k++;
			}
		}
		leasedVehicles = leasedVehiclesClone;
	}
	
	
	
	
	
}
