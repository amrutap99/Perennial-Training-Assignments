package edu.ritindia.CovidSystem.service;

import edu.ritindia.CovidSystem.model.LocationModel;
import edu.ritindia.CovidSystem.repository.LocationRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


/**
 * This is Service Class
 * This class provides service of fetching data from external API
 */
@Service
public class CovidDataService {

    @Value("${dataURL}")   //this is coming from application.properties file
    public String siteURL;
    public List<LocationModel> allLocationsStatus = new ArrayList<LocationModel>();  //populating "allLocationsStatus" with newLocations
    @Autowired
    LocationRepository repository;


    //Creted getter for -allLocationsStatus

    /**
     * This method returns all locations corona cases and saves data to database
     *
     * @return List of allLocationsStatus
     */
    public List<LocationModel> getAllLocationsStatus() {
        repository.saveAll(allLocationsStatus);  //save to db
        return allLocationsStatus;
    }


    /**
     * This method fetches data from external covid api in the form of string
     * Aim is to get api as soon as application starts,used @PostConstruct
     *
     * @throws IOException
     * @throws InterruptedException
     */
    @PostConstruct      //as soon as class-CovidDataService.java is instantiated,executing this method
    public void getData() throws IOException, InterruptedException {

        List<LocationModel> newLocationStatus = new ArrayList<LocationModel>(); //this new list -because to get latest info each time,previous list get replaced with new list data

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(siteURL, String.class);

        StringReader csvReader = new StringReader(result); //converting String to StringReader,& returns string of .csv,to

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);      //"csvReader" is reader object
        for (CSVRecord record : records) {
            LocationModel locationStatus = new LocationModel();
            locationStatus.setCountry(record.get("Country/Region"));
            locationStatus.setNewTotalCases(Integer.parseInt(record.get(record.size() - 1))); //today's current total cases

            //System.out.println(locationStatus); //this is current status of cases
            int currentDayCases = Integer.parseInt(record.get(record.size() - 1));
            int prevDayCases = Integer.parseInt(record.get(record.size() - 2));

            locationStatus.setDiffFromPrevDay(currentDayCases - prevDayCases);
            newLocationStatus.add(locationStatus);
        }

        this.allLocationsStatus = newLocationStatus; //new status is set to all locations status
    }

}
