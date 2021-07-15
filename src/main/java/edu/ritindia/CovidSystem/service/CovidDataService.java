package edu.ritindia.CovidSystem.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.HttpResource;

import edu.ritindia.CovidSystem.model.LocationModel;
import edu.ritindia.CovidSystem.repository.LocationRepository;
import net.bytebuddy.agent.builder.AgentBuilder.LocationStrategy;

//aim is to get api as soon as application starts
@Service
public class CovidDataService {

	@Autowired
	LocationRepository repository;
	
	private static String dataURL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

	
	private List<LocationModel> allLocationsStatus = new ArrayList<LocationModel>();  //populating "allLocationsStatus" with newLocations
	
	
	
	//Creted getter for -allLocationsStatus
	public List<LocationModel> getAllLocationsStatus() {
		repository.saveAll(allLocationsStatus);  //save to db
		return allLocationsStatus;
	}




	@PostConstruct      //as soon as class-CovidDataService.java is instantiated,executing this method
	@Scheduled(cron = "1 * * * * *") //Created Scheduler to run this method for every 1st sec,  Spring created proxy of this method,return type of method should be void
	public void getData() throws IOException, InterruptedException {
		
		List<LocationModel> newLocationStatus = new ArrayList<LocationModel>(); //this new list -because to get latest info each time,previous list get replaced with new list data


		// 1.Created Http client
		HttpClient client = HttpClient.newHttpClient();

		// 2.Created Http request
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(dataURL)).build();

		// 3.Created Http response and send synchronous request

		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		// above 2nd option is body handler

		//System.out.println(httpResponse.body());  //returns string of .csv,to
		
		
		
		StringReader csvReader = new StringReader(httpResponse.body()); //converting String to StringReader
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);      //"in" is reader object
		for (CSVRecord record : records) {
			LocationModel locationStatus = new LocationModel();
			locationStatus.setCountry(record.get("Country/Region"));
			locationStatus.setNewTotalCases(Integer.parseInt( record.get(record.size() - 1))); //today's current total cases

			//System.out.println(locationStatus); //this is current status of cases
			
			
			int currentDayCases = Integer.parseInt( record.get(record.size() - 1));
			int prevDayCases = Integer.parseInt( record.get(record.size() - 2));

			locationStatus.setDiffFromPrevDay(currentDayCases-prevDayCases);
			newLocationStatus.add(locationStatus);
			
			
		    
		}
		
		this.allLocationsStatus = newLocationStatus; //new status is set to all locations status
		        
	}

}
