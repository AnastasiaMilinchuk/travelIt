
package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.entity.Place;

/**
 * Created by Sony on 16.05.2015.
 */
public class AlgoContext {


    public AlgoContext() {
    }

    public void setAlgoStrategy(AlgoStrategy algoStrategy) {
        this.algoStrategy = algoStrategy;
    }

    private AlgoStrategy algoStrategy;
    public Place[] mcoAlgo(Population pop)
    {
        return algoStrategy.mcoAlgo(pop);
    }

}
