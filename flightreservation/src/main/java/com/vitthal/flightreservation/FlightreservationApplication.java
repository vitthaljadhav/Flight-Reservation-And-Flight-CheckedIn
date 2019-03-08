package com.vitthal.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightreservationApplication  {

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

}
 // if we want convert war then we should be write the below code
//and go to pom.xml there  replace jar to war <packaging>war</packaging>

//// SpringBootServletInitializer class used just Convert the war file and in pom <packaging>war</packaging>

/**@SpringBootApplication
 * public class FlightreservationApplication  extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FlightreservationApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}

}
 */
