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
        return optimizeImport.getSequence(userPlaces.getAllPlaces()).subList(0,6);
    }

    public List<Place> getPlacePrefersByLocation(String city){
        return travelSalesmanProblem.findPath(optimizeImport.getSequence(userPlaces.getPlacesByCity(city)).subList(0,6));
    }
}
