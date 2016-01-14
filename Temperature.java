@@ -0,0 +1,203 @@

public class Temperature {

	public double temperature;
	public char scale; 

	public Temperature(double temperature, char scale)
	{
		this.temperature=temperature;
		this.scale=scale;
	}

	public Temperature() 
	{
	}

	public Temperature toKelvin()
	{
		double converted_Temp;


		if(scale == 'C')
		{
			converted_Temp=(temperature+273.15);
			Temperature temp = new Temperature(converted_Temp, 'K');
			return temp;
		}

		if(scale == 'F')
		{
			converted_Temp=(double)((temperature-32)*5.0/9.0+273.15);
			Temperature temp = new Temperature(converted_Temp, 'K');
			return temp;
		}
		if(temperature < 0) 
		{ 
			System.out.println("K cannot be < 0"); 
			System.exit(0); 
		} 

		return this;
	}

	public Temperature toCelsius()
	{
		double converted_Temp;

		if(scale == 'K')
		{
			converted_Temp=temperature-273.15;
			Temperature temp = new Temperature(converted_Temp, 'C');
			return temp;
		}

		if(scale == 'F')
		{
			converted_Temp=(double)((temperature-32)*5.0/9.0);
			Temperature temp = new Temperature(converted_Temp, 'C');
			return temp;
		}
		if(temperature < -273.15) 
		{ 
			System.out.println("C cannot be < -273.15"); 
			System.exit(0); 
		} 

		return this;
//		switch (scale )
//		{
//		case 'K':
//			converted_Temp=temperature-273.15;
//			Temperature temp = new Temperature(converted_Temp, 'C');
//			return temp;
//		}


	}


	public Temperature toFahrenheit()
	{
		double converted_Temp;
		
		
		if(this.scale == 'K')
		{
			converted_Temp=(double)(temperature -273.15)*9.0/5.0+32;
			Temperature temp = new Temperature(converted_Temp, 'F');
			return temp;
		}

		if(scale == 'C')
		{
			converted_Temp=(double)(temperature*9.0/5.0 +32);
			Temperature temp = new Temperature(converted_Temp, 'F');
			return temp;
		}
		if(temperature < -459.67) 
		{ 
			System.out.println("F cannot be < -459.67"); 
			System.exit(0); 
		} 
		return this;
	}


	public Temperature add(Temperature n)
	{
		Temperature answer = new Temperature();
		switch (this.scale )
		{
		case 'K':
			answer=n.toKelvin();
			Temperature temp = new Temperature(answer.temperature + this.temperature, 'K');
			return temp;
		case 'F':
			answer=n.toFahrenheit();
			Temperature temp1 = new Temperature(answer.temperature + this.temperature, 'F');
			return temp1;
		case 'C':
			answer=n.toCelsius();
			Temperature temp2 = new Temperature(answer.temperature + this.temperature, 'C');
			return temp2;

		}
		return answer;
	}



	


public Temperature subtract(Temperature n)
{
	Temperature answer = new Temperature();
	switch (this.scale )
	{
	case 'K':
		answer=n.toCelsius();
		Temperature temp = new Temperature(answer.temperature - this.temperature, 'K');
		return temp;
	case 'F':
		answer=n.toCelsius();
		Temperature temp1 = new Temperature(answer.temperature - this.temperature, 'F');
		return temp1;
	case 'C':
		answer=n.toCelsius();
		Temperature temp2 = new Temperature(answer.temperature - this.temperature, 'C');
		return temp2;

	}
	return answer;
}

public Temperature multiply(Temperature n)
{
	Temperature answer = new Temperature();
	switch (this.scale )
	{
	case 'K':
		answer=n.toCelsius();
		Temperature temp = new Temperature(answer.temperature * this.temperature, 'K');
		return temp;
	case 'F':
		answer=n.toCelsius();
		Temperature temp1 = new Temperature(answer.temperature * this.temperature, 'F');
		return temp1;
	case 'C':
		answer=n.toCelsius();
		Temperature temp2 = new Temperature(answer.temperature * this.temperature, 'C');
		return temp2;

	}
	return answer;
}

public Temperature divide(double d)
{
	Temperature temp1 = this.toCelsius();
	double new_temp=(double)(temp1.temperature/d);

	return new Temperature(new_temp, 'C');
}


public boolean equals(Temperature n)
{
	return this.temperature==n.temperature&&this.scale==n.scale;
}

public String toString() 
{
	return temperature + " " + scale;
}


public void read()
{
	System.out.println(this);
}
}
