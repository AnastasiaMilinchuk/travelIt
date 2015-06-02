package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.algorithms.prefer.AlgoContext;
import com.travelit.secure.algorithms.prefer.LinearConvolution;
import com.travelit.secure.algorithms.prefer.Population;
import com.travelit.secure.entity.Place;
import com.travelit.secure.service.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Configuration
public class OptimizeImport{

    public List<Place> getSequence(List<Place> pls) {
	// write your code here1
        Place[] places = new Place[pls.size()];
        for(int i = 0; i < pls.size(); i++){
            places[i] = pls.get(i);
        }

        Population pop = new Population(places);
        AlgoContext ac = new AlgoContext();
        ac.setAlgoStrategy(new LinearConvolution(0.2,0.2,0.2,0.2,0.2)); // внутри либо MinimizationGeneralCriterial(1,1,1,1,1) or MinMaxGeneralCriteria(1,1,1,1,1)
        places = ac.mcoAlgo(pop);
        //pop.setPlaces(lc.mcoAlgo(pop));
        for(int i =0; i< pls.size(); i++){
            System.out.println(pop.getPlaces()[i].getFitnessIndividual());
        }

        return toList(pop.getPlaces());
    }

    private List<Place> toList(Place[] places){
        List<Place> pls = new ArrayList<>();
        for(int i = 0; i < places.length; i++){
            pls.add(places[i]);
        }

        return pls;
    }
}
