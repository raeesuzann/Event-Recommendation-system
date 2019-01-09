package com.event.model;

import java.util.ArrayList;

public class Recommendation {
	public static void main(String[] args) {
		DataSource dataSRC = new DataSource();
		SlopeOneMatrix avgDiff = new SlopeOneMatrix(dataSRC,true) ;
		SlopeOneRecommender slopeOne = new SlopeOneRecommender(dataSRC,true,avgDiff);
		RMSE rmse = new RMSE() ;
		double prediction=0.0 ;
		double rating=0.0;
		ArrayList<Double> predictions = new ArrayList <Double>() ;
		ArrayList<Double> ratings = new ArrayList <Double>() ;		
		for(int userId:dataSRC.getUser()){		
			for(int i=1;i<=3;i++){		
				prediction=slopeOne.recommendOne(userId,i);		
				rating=dataSRC.getRating(userId,i);	
				System.out.println("userId"+userId);

				if(!Double.isNaN(rating)&&!Double.isNaN(prediction)){
					ratings.add(rating);
					predictions.add(prediction);
					System.out.println("userId2"+userId);
					System.out.println("rating"+ratings);
					System.out.println("predictions"+predictions);
				}
			}
		}

		System.out.println("rating"+ratings);
		System.out.println("predictions"+predictions);
		System.out.println("RMSE: "+rmse.evaluate(ratings,predictions));
	}

}
