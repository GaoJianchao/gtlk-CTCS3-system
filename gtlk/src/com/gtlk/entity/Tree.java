package com.gtlk.entity;

import java.util.ArrayList;

import com.gtlk.entity.Tree;

public class Tree{
	public int dim;
	public 	Tree [] child;
	public 	int[] Nf;
	//public 	int split_loc;
	public int t_class;
	public ArrayList<Integer> new_select_sample;
	//public static ArrayList rule=new ArrayList();
	
	void set_tree_child(int num){
		child=new Tree[num];
	}
	
	void set_tree_NF(int num){
		Nf=new int [num];
	}
	/*Tree (int [][]train_patterns, int [][]train_targets,int inc_node,int base){
		dim=0;
		if(train_patterns.length==0)
			
	}*/
	Tree(int num_of_feature){
		new_select_sample=new ArrayList<Integer>();
		for(int i=0;i<num_of_feature;i++){
			new_select_sample.add(i);
		}
	}
}
