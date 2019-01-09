package com.event.model;

import java.util.HashMap;
import java.util.Map.Entry;

public class SlopeOneMatrix {

	private DataSource dataSRC;
	private HashMap<Integer,HashMap<Integer,Double>> itemAVGDiffMatrix;
	private HashMap<Integer,HashMap<Integer,Integer>> itemItemWeightMatrix;
	private boolean isWeighted;
	public SlopeOneMatrix(DataSource dataSRC,boolean isWeighted) {
		this.dataSRC=dataSRC;
		this.isWeighted=isWeighted;
		itemAVGDiffMatrix=new HashMap<Integer,HashMap<Integer,Double>>();
		calcEventPairs();
	}

	private void calcEventPairs() {	
		int weight = 0;
		HashMap<Integer,Integer> innerHashMapWeight = null ;
		HashMap<Integer,Double> innerHashMapAVG = null ;

		if(isWeighted){
			itemItemWeightMatrix = new HashMap<Integer,HashMap<Integer,Integer>>();
		}

		Integer ratingI=-1,ratingJ=-1,userI=-1,userJ=-1;

		int dev =0;
		int sum =0;
		int countSim =0;
		Double average=0.0 ;

		for(int i=1;i<=3;i++){

			for(int j=1;j<=i;j++){
				
				for(Entry<Integer,Integer> entry:(dataSRC.getRating()).get(j).entrySet()){
					userJ = entry.getKey();
					ratingJ = entry.getValue();
					
					if(dataSRC.getRating().get(i).containsKey(userJ)){
						
						if(isWeighted){
							weight++;
						}
						
						if(i!=j){
							userI=userJ;
							System.out.println("USERI"+userI+"USERJ"+userJ);
							System.out.println("EventI"+i+"EventJ"+j);
									
							ratingI=dataSRC.getRating().get(i).get(userI);
					
							dev=ratingJ-ratingI;
							System.out.println("ratingI"+ratingI+"ratingJ"+ratingJ+"difference in rating"+dev);
							sum+=dev ;
							System.out.println("SUM"+sum);
							countSim++;
						}
					}
				}

				if(i!=j){
					average = ((double)sum/(double)countSim);
					innerHashMapAVG = itemAVGDiffMatrix.get(i);
					if(innerHashMapAVG == null){
						innerHashMapAVG = new HashMap<Integer,Double>();
					}
				}				
				if(isWeighted){
					innerHashMapWeight = itemItemWeightMatrix.get(i) ;
					System.out.println("innerHashMapWeight"+innerHashMapWeight);
					if(innerHashMapWeight==null){
						innerHashMapWeight = new HashMap<Integer,Integer>();
						itemItemWeightMatrix.put(i,innerHashMapWeight) ;
						System.out.println("innerHashMapWeight2"+innerHashMapWeight);
					}
					innerHashMapWeight.put(j,weight);
					weight = 0;
				}					
				if(i!=j){
					innerHashMapAVG.put(j,average);	
					System.out.println("eventAverageRatingDifference"+itemAVGDiffMatrix.put(i,innerHashMapAVG));
					itemAVGDiffMatrix.put(i,innerHashMapAVG) ;
					countSim=0;
					
					sum=0;
				}

			}
		}
	}
	public double getItemPairAverageDiff(Integer i,Integer j){
		HashMap<Integer,Double> outerHashMapI = itemAVGDiffMatrix.get(i);
		HashMap<Integer,Double> outerHashMapJ = itemAVGDiffMatrix.get(j);

		double avgDiff=0.0;

		if(outerHashMapI!=null && !outerHashMapI.isEmpty() && outerHashMapI.containsKey(j)){	
			System.out.println("I"+i+"J"+j);
			if(i<j){
				
				avgDiff=-outerHashMapI.get(j);
				
			} else {
				avgDiff = outerHashMapI.get(j);
			}
		} else if(outerHashMapJ != null && !outerHashMapJ.isEmpty() && outerHashMapJ.containsKey(i)){
			if(i<j){
				avgDiff=-outerHashMapJ.get(i) ;
			} else {
				avgDiff = outerHashMapJ.get(i) ;
				
			}
		}		
		System.out.println("avgDiff"+avgDiff);
		return avgDiff;
	}

	public int getWeight(Integer i,Integer j){
		HashMap<Integer,Integer> outerHashMap=itemItemWeightMatrix.get(i);
		int weight=0;
		if(outerHashMap!=null && ! outerHashMap.isEmpty() && outerHashMap.containsKey(j)){
			weight = outerHashMap.get(j);		
		}else{
			outerHashMap= itemItemWeightMatrix.get(j);
			if(outerHashMap !=null && ! outerHashMap.isEmpty() && outerHashMap.containsKey(i)){
				weight=outerHashMap.get(i);
			}
		}
		System.out.println("weight"+weight);
		return weight ;
	}


}






