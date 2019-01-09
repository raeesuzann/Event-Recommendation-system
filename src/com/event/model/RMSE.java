package com.event.model;

import java.util.ArrayList;

public class RMSE {
	public double evaluate(ArrayList<Double> actualVal, ArrayList <Double> predictedVal ) {
		double rmse = 0.0;
		double diff ;
		for(int i = 0;i<actualVal.size();i++) {
			diff=actualVal.get(i)- predictedVal.get(i);
			rmse += diff*diff ;
		}
		rmse = Math.sqrt(rmse/actualVal.size()) ;
		return rmse ;
	}
}
