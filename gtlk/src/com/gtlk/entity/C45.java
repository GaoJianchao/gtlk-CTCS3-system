package com.gtlk.entity;
import java.util.*;
public class C45 {
	public  num_of_targets [][] unique_feature;//锯齿数组
	ArrayList new_select_sample;
	 C45(int[][]train_patterns){
	   int num_of_feature=train_patterns.length-1;
	    int num_of_sample=train_patterns[0].length;
		int [] test_targets;	
		int i,j,k,t;
		new_select_sample=new ArrayList();
		for(i=0;i<num_of_feature;i++){
			new_select_sample.add(i);
		}
		int[] num_of_train_target;
	    unique_feature=new num_of_targets [num_of_feature][];//unique_feature为由每个特征的特征值的种类构成的锯齿数组
		//构造锯齿数组  
		for(i=0;i<num_of_feature;i++){
			ArrayList al=new ArrayList();
			al.add(new num_of_targets (1,train_patterns[i][0]));
			for(j=1;j<num_of_sample;j++){
				for(k=0;k<al.size();k++){
					if(train_patterns[i][j]==((num_of_targets)al.get(k)).targets){
						((num_of_targets)al.get(k)).num++;
						break;
						
					}
				}
				if(k==al.size())
					
					al.add(new num_of_targets (1,train_patterns[i][j]));
			}
			unique_feature[i]=new num_of_targets [al.size()];
			for(t=0;t<al.size();t++)
				
				unique_feature[i][t]=((num_of_targets)al.get(t));
			al.clear();
		}
	}
}