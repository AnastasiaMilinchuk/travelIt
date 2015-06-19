package com.travelit.secure.search;

import com.travelit.secure.algorithms.prefer.OptimizeImport;
import com.travelit.secure.algorithms.travelsalesman.TravelSalesmanProblem;
import com.travelit.secure.entity.Place;
import org.codehaus.plexus.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import sun.net.www.content.text.plain;

import java.util.List;

/**
 * Created by milinchuk on 5/6/15.
 */
@Service
@ComponentScan("com.travelit")
public class UserPrefer {
    @Autowired
    private TravelSalesmanProblem travelSalesmanProblem;

    @Autowired
    private OptimizeImport optimizeImport;

    @Autowired
    private UserPlaces userPlaces;


    public List<Place> getUserPrefers(){
        List<Place> places = userPlaces.getAllPlaces();
        if(places.size() >= 6){
            return optimizeImport.getSequence(userPlaces.getAllPlaces()).subList(0,6);
        }
        else {
            return optimizeImport.getSequence(userPlaces.getAllPlaces());
        }
    }

    public List<Place> getPlacePrefersByLocation(String city){
        List<Place> places = userPlaces.getPlacesByCity(city);
        if(places.size() >= 6){
             places = optimizeImport.getSequence(places).subList(0,6);
        }
        else {
            places = optimizeImport.getSequence(places);
        }

        System.out.println("get prefer places by location " + places.size());
        return travelSalesmanProblem.findPath(places, 45, 0.8, 0.5, 50);
    }
}
