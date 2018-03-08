package com.gtlk.entity;
import java.util.ArrayList;
public class make_RF {	
	public  int [][] Ftrain_patterns;
	public  int [][] Ftest_patterns;
	public  int [][] Ftest_targets;//一行为一棵树的结果
	public  int [] correct_Ftest_targets;//正确的测试集的结果
	public  int  Ftrain_sample;
	public  int Ftest_sample;
	public  int num_of_feature=27;
	public  int NTree;
	public  int[] final_result;  //运行结果
	public  String rules="";
	public static ArrayList<myRule> rule=new ArrayList<myRule>();
	public int level=0;	
	public make_RF(int [][] t){
		 int[][]temp=new int[t[0].length][t.length];
		 for(int i=0;i<t.length;i++)
				for(int j=0;j<t[i].length;j++){
					temp[j][i]=t[i][j];
		 System.out.print(temp[j][i]+" ");}
			num_of_feature=27;
			Ftrain_sample=177;
			Ftest_sample=13;
			NTree=10;
			Tree tree=new Tree(num_of_feature);
			 Ftrain_patterns=new int[num_of_feature+1][Ftrain_sample];
			 Ftest_patterns=new int[num_of_feature+1][Ftest_sample];
	         Ftest_targets=new int [NTree][Ftest_sample];
		     correct_Ftest_targets=new int [Ftest_sample];
		int [][] train_patterns=new int[num_of_feature+1][Ftrain_sample];
		for(int i=0;i<temp.length;i++)
			for(int j=0;j<t[i].length;j++)
				{Ftrain_patterns[i][j]=temp[i][j];
				System.out.print(Ftrain_patterns[i][j]+" ");
				}
		int i,j,k,random;
		for(i=0;i<NTree;i++){//构建一个决策树，并得出结果
			for(k=0;k<Ftrain_sample;k++){//随机抽取样本
				random=(int)(Math.random()*(Ftrain_sample-1));
				for(j=0;j<(num_of_feature+1);j++){
					train_patterns[j][k]=Ftrain_patterns[j][random];
				}
			}
			tree=make_tree(train_patterns, tree.new_select_sample);//与参考不同
			rule(tree);
			rules+=".";
		}
		
	}
 public  Tree make_tree(int [][] train_patterns,ArrayList<Integer> new_select_sample ){
	 C45 c4_5=new C45(train_patterns);
	 Tree tree=new Tree(num_of_feature);
		int num_of_feature=train_patterns.length-1;
		int new_num_of_feature=new_select_sample.size();	//去掉已经选取的特征后，特征属性的个数
	    int num_of_sample=train_patterns[0].length;
	    int num_of_targets;
	    int i,j,k,t,p,q,m;
	    int c_max;
	    ArrayList<num_of_targets> al=new ArrayList<num_of_targets>();//al为train_targets的决策类别值
	    //对特征属性进行随机抽样
	    int Pi=(int)(Math.log10(new_select_sample.size())/Math.log10(2)+1);//每个结点应抽取的特征个数
	    int[] select_sample=new int[new_select_sample.size()];	//随机选取的特征的个数
	 if(new_select_sample.size()<Pi){
		 for(i=0;i<new_select_sample.size();i++)
		 select_sample[i]=(int)new_select_sample.get(i);
		 }
	 else
		 select_sample = randomCommon(0,new_select_sample.size(),Pi);
	    int [] train_targets=new int[num_of_sample];
	    for(i=0;i<num_of_sample;i++){
	    	train_targets[i]=train_patterns[num_of_feature][i];
	    }//构造train_target
	    al=statics(train_targets);	
	    int t_class=-1;
	   
		if((num_of_sample==1)||al.size()==1){
			//找最大的
			tree.Nf=null;
			int max=((num_of_targets)al.get(0)).num;
			t_class=((num_of_targets)al.get(0)).targets;
			for(i=0;i<al.size();i++){
				if(((num_of_targets)al.get(i)).num>max){
					max=((num_of_targets)al.get(i)).num;
					t_class=((num_of_targets)al.get(i)).targets;
				}
			}
			tree.dim=-1;
			tree.t_class=t_class; 
			tree.child=null;
			return tree;
			}
		if(new_select_sample.size()==1){//只剩下一个属性
			//找最大的
			tree.Nf=null;	
			int max=((num_of_targets)al.get(0)).num;
			t_class=((num_of_targets)al.get(0)).targets;
			for(i=0;i<al.size();i++){
				if(((num_of_targets)al.get(i)).num>max){
					max=((num_of_targets)al.get(i)).num;
					t_class=((num_of_targets)al.get(i)).targets;
				}
			}
			tree.dim=-1;
			tree.t_class=t_class; 
			tree.child=null;
			return tree;
		}
		//计算每个结点的期望
		double sum_I=0;
		double Pnode=0;
		double I=0;
	double E=0;
	double gain=0;
	double splitinfor=0;
	double splitinfor_ratio=0;
	double[] gainratio=new double [Pi];
	int selected_feature;
		for(j=0;j<al.size();j++){
			Pnode=((num_of_targets)al.get(j)).num/(float)(num_of_sample+Math.exp(0));
			sum_I=sum_I-Pnode*(Math.log(Pnode)/Math.log(2));
		}
		//计算信息增益率
		for(i=0;i<Pi;i++){//找信息增益率最大的特征
			selected_feature=(int)new_select_sample.get(select_sample[i]);
			 ArrayList<Integer> sij=new ArrayList<Integer>();
			 E=0;
			for(j=0;j<c4_5.unique_feature[selected_feature].length;j++){//找特征i的属性值为j的样本
				sij.clear();
				for(k=0;k<num_of_sample;k++){
					if(train_patterns[selected_feature][k]==c4_5.unique_feature[selected_feature][j].targets)
						sij.add(k);//特征值为j的样本序号
				}
				I=0;
				for(t=0;t<al.size();t++){
					int num=0;
					double I_radio=0;
					for(p=0;p<sij.size();p++){
						if(((num_of_targets)al.get(t)).targets==train_targets[(int)sij.get(p)]){
							num++;
						}//特征属性i的值为j的样本，属于类t
					}
					I_radio=(double)num/((c4_5.unique_feature[selected_feature][j].num));
					if(I_radio==0)
						I=I-I_radio;
					else
						I=I-I_radio*(Math.log10(I_radio)/Math.log10(2));	
				}
			E=E+(double)c4_5.unique_feature[selected_feature][j].num/num_of_sample*I;
			}
			gain=sum_I-E;
			splitinfor=0;
			for(m=0;m<c4_5.unique_feature[selected_feature].length;m++){
				splitinfor_ratio=(double)c4_5.unique_feature[selected_feature][m].num/num_of_sample;
				if(splitinfor_ratio==0)
					splitinfor=splitinfor;
				else
					splitinfor=splitinfor-(splitinfor_ratio*(Math.log(splitinfor_ratio)/Math.log(2)));
			}
			gainratio[i]=gain/(splitinfor+Math.exp(0));	
	}
		System.out.println();
		System.out.println("信息增益率为：");
		for(i=0;i<gainratio.length;i++){
			System.out.print(gainratio[i]+" ");
		}
		int removed_index=select_sample[0];
		tree.dim=(int)new_select_sample.get(select_sample[0]);
		tree.t_class=-1;
		double max=gainratio[0];
		for(i=0;i<gainratio.length;i++){
			if(gainratio[i]>max){
				max=gainratio[i];
				tree.dim=(int)new_select_sample.get(select_sample[i]);//找到信息增益率最大的特征
				removed_index=select_sample[i];//被移除的特征属性
				}
			}
		tree.set_tree_child(c4_5.unique_feature[tree.dim].length);
		tree.set_tree_NF(c4_5.unique_feature[tree.dim].length);
		for(j=0;j<c4_5.unique_feature[tree.dim].length;j++){
			tree.Nf[j]=c4_5.unique_feature[tree.dim][j].targets;
		}//结点分支的值
		tree.new_select_sample.clear();
		for(i=0;i<new_select_sample.size();i++){
			
			tree.new_select_sample.add((int)new_select_sample.get(i));
		}
		tree.new_select_sample.remove(removed_index);
		
		int [][] patterns;
		int num_of_patterns=0;
			for(i=0;i<c4_5.unique_feature[tree.dim].length;i++){
				t=0;
				for(j=0;j<num_of_sample;j++){
					if(train_patterns[tree.dim][j]==c4_5.unique_feature[tree.dim][i].targets){
						num_of_patterns++;
					}//统计个数
				}
				 patterns=new int[num_of_feature+1][num_of_patterns];
				for(j=0;j<num_of_sample;j++){
					if(train_patterns[tree.dim][j]==c4_5.unique_feature[tree.dim][i].targets){
						for(k=0;k<=num_of_feature;k++){
							patterns[k][t]=train_patterns[k][j];
						
					}
					t++;
					}
				}//抽取满足下一个结点要求的样本
				 tree.child[i]=make_tree(patterns,tree.new_select_sample);
				 tree.new_select_sample.clear();
					for(j=0;j<new_select_sample.size();j++){
						
						tree.new_select_sample.add((int)new_select_sample.get(j));
					}
			}
			return tree;
		
}
	public void  rule(Tree tree){
		int  dim=tree.dim;
		int i,j,t;
		if(tree.dim==-1){
			for(i=0;i<rule.size();i++){
				rules+=(char)((((myRule)rule.get(i)).feature)+65)+"="+((myRule)rule.get(i)).value+",";
				}
			rules+=tree.t_class+";";
			if(rule.size()>0){
				rule.remove(rule.size()-1);
				level--;
			}
			return ;
		}
		else
		{
			for(i=0;i<tree.Nf.length;i++){
				rule.add(new myRule(tree.dim,tree.Nf[i]));
				level++;
				rule(tree.child[i]);
			}
			level--;
			if(rule.size()>0){
				rule.remove(rule.size()-1);
				level--;
			}
		}
		return;
	}
	public ArrayList<num_of_targets> statics(int[] a){
		int i,j;
		ArrayList<num_of_targets> al=new ArrayList<num_of_targets>();
		 al.add(new num_of_targets(1,a[0]));
		    for(i=1;i<a.length;i++){
		    	for(j=0;j<al.size();j++){
		    		if(a[i]==((num_of_targets)al.get(j)).targets){
		    			((num_of_targets)al.get(j)).num++;
		    			break;
		    			}
		    	}
		    	if(j==al.size())
		    		al.add(new num_of_targets(1,a[i]));
		    }
		return al;
	}
	public float result(int [][]test_pattern,int []targets){
		float correct=0;
		int num=test_pattern.length-1;
		int correct_num=0;
		int i;
		for(i=0;i<test_pattern[num].length;i++){
			if(test_pattern[num][i]==targets[i])
				correct_num++;
		}
		correct=(float)correct_num/test_pattern[num].length;
		return correct;
	}
	/** 
	2. * 随机指定范围内N个不重复的数 
	3. * 最简单最基本的方法 
	4. * @param min 指定范围最小值 
	5. * @param max 指定范围最大值 
	6. * @param n 随机数个数 
	7. */  
	public  int[] randomCommon(int min, int max, int n){  
	    if (n >= (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n]; 
	    for(int i=0;i<n;i++)
	    	result[i]=-1;
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[count] = num;  
	            count++;  
	        }  
	    }  
	    return result;  
	}  
}