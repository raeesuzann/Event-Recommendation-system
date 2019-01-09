package com.event.model;

public class SlopeOneRecommender {

	boolean isWeighted ;
	DataSource dataSRC ;
	SlopeOneMatrix soMatrix ;
	public SlopeOneRecommender (DataSource dataSRC, boolean isWeighted, SlopeOneMatrix soMatrix) {
		this.isWeighted = isWeighted ;
		this.dataSRC=dataSRC ;
		this.soMatrix=soMatrix ;

	}
	public double recommendOne(int u,int i){
		double difference=0.0,userRatingSum =0.0,prediction=0.0;
		int weight = 0,weightSum=0,numRatings=0;
		for ( int j = 1;j<=5;j++){
			if(dataSRC.getRating().get(j).get(u)!=null && i != j ){

				if(isWeighted) {		
					weight=soMatrix.getWeight(i,j);	
					System.out.println("weight"+weight);
					difference += soMatrix.getItemPairAverageDiff(j,i)* weight ;

					userRatingSum += dataSRC.getRating().get(j).get(u)* weight ;
					weightSum += weight ;
				} else{
					difference += soMatrix.getItemPairAverageDiff(j,i);
					userRatingSum += dataSRC.getRating().get(j).get(u);
					numRatings++;
				}
				System.out.println("diff"+difference);
			}

		}
		if(isWeighted){
			prediction=(double)((userRatingSum+ difference)/weightSum) ;
		}else{
			prediction=(double)((userRatingSum + difference)/numRatings ) ;
		}

		return prediction;
	}
}
