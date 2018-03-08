package com.gtlk.entity;

import java.util.ArrayList;

public class DataProcess {
	private static String []attribute={"��������ʱ��״̬",
			   "��·�Ͽ�ǰ5-10s��PRI�ӿ����κ�����",
			   "�Ƿ���OBU����ӦRBC���͵�Ӧ�ò���Ϣ",
			   "�Ƿ���RBC����ӦOBU���͵�Ӧ�ò���Ϣ",
			   "���ӶϿ�ǰ19-20s���ڣ�RBC�Ƿ������յ�OBU->RBC��AK����������Ӧ��",
			   "���ӶϿ�ǰ19-20s���ڣ��Ƿ���RBC->OBU�����AK",
			   "�Ƿ���ER��������",
			   "���ӶϿ�ǰ��RBC�Ƿ������յ�OBU->RBC�����RRȷ��֡",
			   "���ӶϿ�ǰ���Ƿ���RBC->OBU�����RRȷ��֡",
			   "���HDLC֡�����ش�����",
			   "�Ƿ��г�ʱ�䣨7-20s��OBU->RBC�������Ч���ݣ������0,1���֣�",
			   "����ʼ��SABME��Ϣ���Ƿ��յ�������Ϣ�����б�������",
			   "�Ƿ����յ�FRMR��Ϣ�����У���������",
			   "�ͷ�ԭ��",
			   "��Ϣ����",
			   "ԭ��ֵ",
			   "�����ͷŹؼ���",
			   "�Ƿ���δ��ɵ��л�",
			   "�л��ؼ���",
			   "�Ƿ�T3103��ʱ��MTδִ�У�",
			   "����BTS���쳣��Ϣ��RLT��ʱ��",
			   "�Ƿ�BSC����Ӧ�л�����",
			   "�����ͷ�ǰ����ͨ������",
			   "�����ͷ�ǰ����ͨ������",
			   "�����ͷ�ǰ���е�ƽ",
			   "�����ͷ�ǰ���е�ƽ",
			   "��������",
			   "��������"
	};
	private static String [][]init={{"��ȫ���ӽ���������","��Ȩ��","Ӧ�ò�Ự����������","Ӧ�ò��п����ݽ�����"},
			   {"0","1"},
			   {"NAL","��","��"},
			   {"NAL","��","��"},
			   {"NAL","��","��"},
			   {"NAL","��","��"},
			   {"NAL","��"},
			   {"NAL","��","��"},
			   {"NAL","��","��"},
			   {"NAL","OBU->RBC","RBC->OBU"},
			   {"0","1"},
			   {"NAL","OBU->RBC","RBC->OBU"},
			   {"NAL","OBU->RBC","RBC->OBU"},
			   {"DISCONNECT CAUSE:Cause_Value=16,Cause_Definition=Normal call clearing","DISCONNECT CAUSE:Cause_Value=31,Cause_Definition=Normal,unspecified","DISCONNECT CAUSE:Cause_Value=41,Cause_Definition=Temporary failure"},
			   {"CLEAR COMMAND","CLEAR REQUEST","DISCONNECT","RELEASE"},
			   {"Normal event/Call control","Normal event/Normal (unspecified)","Normal event/Normal call clearing","Normal event/Radio interface message failure","Resources unavialible/Equipment failure","Resource Unavailable/Temporary failure"},
			   {"Abnormal release (unspecified)","local end release","Normal call clearing","Normal event","Normal, unspecified","Temporary failure"},
			   {"��","��"},
			   {"NAL","Normal event/Uplink quality","Normal event/Downlink quality"},
			   {"��","��"},
			   {"Abnormal release (no activity on the radio path)","handover access failure","IMSI DETACH INDICATION","NAL","radio link failure"},
			   {"��","��"},
			   {"0","1"},
			   {"0","1","2"},
			   {"0","1","2","3"},
			   {"0","1","2","3","4"},
			   {"BSC","MSC","RBCorATP�����","RBC��·��","RBC�����","RBCӦ�ò�","����MT","���ذ�ȫ��","������·��"},
			   {"ATP/RBC��������","ATP����","BSC����","MSC�����˷������","RBC����","�������","�������2","�������3","�л����","�����񻯣��п��û��������"}
	           };
	/*����0 1��*/
	public static ArrayList<Integer[]> dataPretreat(ArrayList<TrainMonitorInfo> trainmi){
		ArrayList<Integer[]> trainsample = new ArrayList<Integer[]>();
		System.out.println("ttt"+trainmi.get(130).getPriWithoutData());
		System.out.println(trainmi.get(133).getOid());
		for(int i=0;i<trainmi.size();i++){
			Integer []temp=new Integer[28];
			/*��������ʱ��״̬*/
			if(trainmi.get(i).getSituation().equals(init[0][0])) {
				temp[0]=0;
			}
			else if(trainmi.get(i).getSituation().equals(init[0][1])){
				temp[0]=1;
			}
			else if(trainmi.get(i).getSituation().equals(init[0][2])){
				temp[0]=2;
			}
			else if(trainmi.get(i).getSituation().equals(init[0][3])){
				temp[0]=3;
			}
			//else{temp[0]=4;}
			else break;
			//System.out.print(b);
			/*��·�Ͽ�ǰ5-10s��PRI�ӿ����κ�����*/
			if(trainmi.get(i).getPriWithoutData().equals(init[1][0])) {
				temp[1]=0;
			}
			else if(trainmi.get(i).getPriWithoutData().equals(init[1][1])) {
				temp[1]=1;
			}
			//else{temp[1]=2;}
			else break;
			/*�Ƿ���OBU����ӦRBC���͵�Ӧ�ò���Ϣ*/
			if(trainmi.get(i).getObuUnresponsive().equals(init[2][0])) {
				temp[2]=0;
			}
			else if(trainmi.get(i).getObuUnresponsive().equals(init[2][1])) {
				temp[2]=1;
			}
			else if(trainmi.get(i).getObuUnresponsive().equals(init[2][2])) {
				temp[2]=2;
			}
			//else{temp[2]=3;}
			else break;
			/*�Ƿ���RBC����ӦOBU���͵�Ӧ�ò���Ϣ*/
			if(trainmi.get(i).getRbcUnresponsive().equals(init[3][0])) {
				temp[3]=0;
			}
			else if(trainmi.get(i).getRbcUnresponsive().equals(init[3][1])) {
				temp[3]=1;
			}
			else if(trainmi.get(i).getRbcUnresponsive().equals(init[3][2])) {
				temp[3]=2;
			}
			//else{temp[3]=3;}
			else break;
			/*���ӶϿ�ǰ19-20s���ڣ�RBC�Ƿ������յ�OBU->RBC��AK����������Ӧ��*/
			if(trainmi.get(i).getRbcReceiveAk().equals(init[4][0])) {
				temp[4]=0;
			}
			else if(trainmi.get(i).getRbcReceiveAk().equals(init[4][1])) {
				temp[4]=1;
			}
			else if(trainmi.get(i).getRbcReceiveAk().equals(init[4][2])) {
				temp[4]=2;
			}
			//else{temp[4]=3;}
			else break;
			/*���ӶϿ�ǰ19-20s���ڣ��Ƿ���RBC->OBU�����AK*/
			if(trainmi.get(i).getrToOak().equals(init[5][0])) {
				temp[5]=0;
			}
			else if(trainmi.get(i).getrToOak().equals(init[5][1])) {
				temp[5]=1;
			}
			else if(trainmi.get(i).getrToOak().equals(init[5][2])) {
				temp[5]=2;
			}
			//else{temp[5]=3;}
			else break;
			/*�Ƿ���ER��������*/
			if(trainmi.get(i).getErData().equals(init[6][0])) {
				temp[6]=0;
			}
			else if(trainmi.get(i).getErData().equals(init[6][1])) {
				temp[6]=1;
			}
			//else{temp[6]=2;}
			else break;
			/*���ӶϿ�ǰ��RBC�Ƿ������յ�OBU->RBC�����RRȷ��֡*/
			if(trainmi.get(i).getRbcReceiveRr().equals(init[7][0])) {
				temp[7]=0;
			}
			else if(trainmi.get(i).getRbcReceiveRr().equals(init[7][1])) {
				temp[7]=1;
			}
			else if(trainmi.get(i).getRbcReceiveRr().equals(init[7][2])) {
				temp[7]=2;
			}
			//else{temp[7]=3;}
			else break;
			/*���ӶϿ�ǰ���Ƿ���RBC->OBU�����RRȷ��֡*/
			if(trainmi.get(i).getrToOrr().equals(init[8][0])) {
				temp[8]=0;
			}
			else if(trainmi.get(i).getrToOrr().equals(init[8][1])) {
				temp[8]=1;
			}
			else if(trainmi.get(i).getrToOrr().equals(init[8][2])) {
				temp[8]=2;
			}
			//else{temp[8]=3;}
			else break;
			/*���HDLC֡�����ش�����*/
			if(trainmi.get(i).getRetransmsstionDirection().equals(init[9][0])) {
				temp[9]=0;
			}
			else if(trainmi.get(i).getRetransmsstionDirection().equals(init[9][1])) {
				temp[9]=1;
			}
			else if(trainmi.get(i).getRetransmsstionDirection().equals(init[9][2])) {
				temp[9]=2;
			}
			//else{temp[9]=3;}
			else break;
			/*�Ƿ��г�ʱ�䣨7-20s��OBU->RBC�������Ч���ݣ������0,1���֣�*/
			if(trainmi.get(i).getoToRnosensicalData().equals(init[10][0])) {
				temp[10]=0;
			}
			else if(trainmi.get(i).getoToRnosensicalData().equals(init[10][1])) {
				temp[10]=1;
			}
			//else{temp[10]=2;}
			else break;
			/*����ʼ��SABME��Ϣ���Ƿ��յ�������Ϣ�����б�������*/
			if(trainmi.get(i).getRepeatedSabme().equals(init[11][0])) {
				temp[11]=0;
			}
			else if(trainmi.get(i).getRepeatedSabme().equals(init[11][1])) {
				temp[11]=1;
			}
			else if(trainmi.get(i).getRepeatedSabme().equals(init[11][2])) {
				temp[11]=2;
			}
			//else{temp[11]=3;}
			else break;
			/*�Ƿ����յ�FRMR��Ϣ�����У���������*/
			if(trainmi.get(i).getReceiveFrmr().equals(init[12][0])) {
				temp[12]=0;
			}
			else if(trainmi.get(i).getReceiveFrmr().equals(init[12][1])) {
				temp[12]=1;
			}
			else if(trainmi.get(i).getReceiveFrmr().equals(init[12][2])) {
				temp[12]=2;
			}
			//else{temp[12]=3;}
			else break;
			/*�ͷ�ԭ��*/
			if(trainmi.get(i).getReleaseReason().equals(init[13][0])) {
				temp[13]=0;
			}
			else if(trainmi.get(i).getReleaseReason().equals(init[13][1])) {
				temp[13]=1;
			}
			else if(trainmi.get(i).getReleaseReason().equals(init[13][2])) {
				temp[13]=2;
			}
			//else{temp[13]=3;}
			else break;
			/*��Ϣ����*/
			if(trainmi.get(i).getMessageType().equals(init[14][0])) {
				temp[14]=0;
			}
			else if(trainmi.get(i).getMessageType().equals(init[14][1])) {
				temp[14]=1;
			}
			else if(trainmi.get(i).getMessageType().equals(init[14][2])) {
				temp[14]=2;
			}
			else if(trainmi.get(i).getMessageType().equals(init[14][3])) {
				temp[14]=3;
			}
			//else{temp[14]=4;}
			else break;
			/*ԭ��ֵ          6*/
			if(trainmi.get(i).getReason().equals(init[15][0])) {
				temp[15]=0;
			}
			else if(trainmi.get(i).getReason().equals(init[15][1])) {
				temp[15]=1;
			}
			else if(trainmi.get(i).getReason().equals(init[15][2])) {
				temp[15]=2;
			}
			else if(trainmi.get(i).getReason().equals(init[15][3])) {
				temp[15]=3;
			}
			else if(trainmi.get(i).getReason().equals(init[15][4])) {
				temp[15]=4;
			}
			else if(trainmi.get(i).getReason().equals(init[15][5])) {
				temp[15]=5;
			}
			//else{temp[15]=6;}
			else break;
			/*�����ͷŹؼ���      6*/
			if(trainmi.get(i).getReleaseKey().equals(init[16][0])) {
				temp[16]=0;
			}
			else if(trainmi.get(i).getReleaseKey().equals(init[16][1])) {
				temp[16]=1;
			}
			else if(trainmi.get(i).getReleaseKey().equals(init[16][2])) {
				temp[16]=2;
			}
			else if(trainmi.get(i).getReleaseKey().equals(init[16][3])) {
				temp[16]=3;
			}
			else if(trainmi.get(i).getReleaseKey().equals(init[16][4])) {
				temp[16]=4;
			}
			else if(trainmi.get(i).getReleaseKey().equals(init[16][5])) {
				temp[16]=5;
			}
			//else{temp[16]=6;}
			else break;
			/*�Ƿ���δ��ɵ��л�            2*/
			if(trainmi.get(i).getUnfinishedSwitch().equals(init[17][0])) {
				temp[17]=0;
			}
			else if(trainmi.get(i).getUnfinishedSwitch().equals(init[17][1])) {
				temp[17]=1;
			}
			//else{temp[17]=2;}
			else break;
			/*�л��ؼ���              3*/
			if(trainmi.get(i).getSwitchKey().equals(init[18][0])) {
				temp[18]=0;
			}
			else if(trainmi.get(i).getSwitchKey().equals(init[18][1])) {
				temp[18]=1;
			}
			else if(trainmi.get(i).getSwitchKey().equals(init[18][2])) {
				temp[18]=2;
			}
			else{temp[18]=3;}
			/*�Ƿ�T3103��ʱ��MTδִ�У�       2*/
			if(trainmi.get(i).getT3103Overtime().equals(init[19][0])) {
				temp[19]=0;
			}
			else if(trainmi.get(i).getT3103Overtime().equals(init[19][1])) {
				temp[19]=1;
			}
			//else{temp[19]=2;}
			else break;
			/*����BTS���쳣��Ϣ��RLT��ʱ��     5*/
			if(trainmi.get(i).getBtsAbnormalMesg().equals(init[20][0])) {
				temp[20]=0;
			}
			else if(trainmi.get(i).getBtsAbnormalMesg().equals(init[20][1])) {
				temp[20]=1;
			}
			else if(trainmi.get(i).getBtsAbnormalMesg().equals(init[20][2])) {
				temp[20]=2;
			}
			else if(trainmi.get(i).getBtsAbnormalMesg().equals(init[20][3])) {
				temp[20]=3;
			}
			else if(trainmi.get(i).getBtsAbnormalMesg().equals(init[20][4])) {
				temp[20]=4;
			}
			//else{temp[20]=5;}
			else break;
			/*�Ƿ�BSC����Ӧ�л�����           2*/
			if(trainmi.get(i).getBscUnresponsive().equals(init[21][0])) {
				temp[21]=0;
			}
			else if(trainmi.get(i).getBscUnresponsive().equals(init[21][1])) {
				temp[21]=1;
			}
			//else{temp[21]=2;}
			else break;
			/*�����ͷ�ǰ����ͨ������                 2*/
			if(trainmi.get(i).getUpQuality().equals(init[22][0])) {
				temp[22]=0;
			}
			else if(trainmi.get(i).getUpQuality().equals(init[22][1])) {
				temp[22]=1;
			}
			//else{temp[22]=2;}
			else break;
			/*�����ͷ�ǰ����ͨ������              3*/
			if(trainmi.get(i).getDownQuality().equals(init[23][0])) {
				temp[23]=0;
			}
			else if(trainmi.get(i).getDownQuality().equals(init[23][1])) {
				temp[23]=1;
			}
			else if(trainmi.get(i).getDownQuality().equals(init[23][2])) {
				temp[23]=2;
			}
			//else{temp[23]=3;}
			else break;
			/*�����ͷ�ǰ���е�ƽ                  4*/
			if(trainmi.get(i).getUpElectricity().equals(init[24][0])) {
				temp[24]=0;
			}
			else if(trainmi.get(i).getUpElectricity().equals(init[24][1])) {
				temp[24]=1;
			}
			else if(trainmi.get(i).getUpElectricity().equals(init[24][2])) {
				temp[24]=2;
			}
			else if(trainmi.get(i).getUpElectricity().equals(init[24][3])) {
				temp[24]=3;
			}
			//else{temp[24]=4;}
			else break;
			/*�����ͷ�ǰ���е�ƽ                 5*/
			if(trainmi.get(i).getDownElectricity().equals(init[25][0])) {
				temp[25]=0;
			}
			else if(trainmi.get(i).getDownElectricity().equals(init[25][1])) {
				temp[25]=1;
			}
			else if(trainmi.get(i).getDownElectricity().equals(init[25][2])) {
				temp[25]=2;
			}
			else if(trainmi.get(i).getDownElectricity().equals(init[25][3])) {
				temp[25]=3;
			}
			else if(trainmi.get(i).getDownElectricity().equals(init[25][4])) {
				temp[25]=4;
			}
			//else{temp[25]=5;}
			else break;
			/*��������               9*/
			if(trainmi.get(i).getInitiator().equals(init[26][0])) {
				temp[26]=0;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][1])) {
				temp[26]=1;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][2])) {
				temp[26]=2;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][3])) {
				temp[26]=3;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][4])) {
				temp[26]=4;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][5])) {
				temp[26]=5;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][6])) {
				temp[26]=6;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][7])) {
				temp[26]=7;
			}
			else if(trainmi.get(i).getInitiator().equals(init[26][8])) {
				temp[26]=8;
			}
			//else{temp[26]=9;}
			else break;
			/*��������             10*/
			if(trainmi.get(i).getDegradationType().equals(init[27][0])) {
				temp[27]=0;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][1])) {
				temp[27]=1;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][2])) {
				temp[27]=2;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][3])) {
				temp[27]=3;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][4])) {
				temp[27]=4;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][5])) {
				temp[27]=5;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][6])) {
				temp[27]=6;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][7])) {
				temp[27]=7;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][8])) {
				temp[27]=8;
			}
			else if(trainmi.get(i).getDegradationType().equals(init[27][9])) {
				temp[27]=9;
			}
			//else{temp[27]=10;}
			else break;
			trainsample.add(temp);
			System.out.println("DataProcess "+trainsample.get(i)[0]);
		}
		
		return trainsample;
	}
	/*������ */
	public static String changeABCToChinese(String abc){
		String []a0=abc.split("[.]");	
		String result="";		
		for(int j=0;j<a0.length;j++){
			String []a1=a0[j].split("[;]");
			for(int k=0;k<a1.length;k++){
				System.out.println(k);
				String []a2=a1[k].split("[,]");
				for(int i=0;i<a2.length;i++){
					if(a2[i].length()==3){
						int c=a2[i].charAt(0)-'A';
						int num=a2[i].charAt(2)-'0';
						result=result+attribute[c]+"="+init[c][num]+",";
					}
					else{
						int b=a2[i].charAt(0)-'0';
						result=result+attribute[27]+"="+init[27][b]+";";
					}
				}
			}
			result+=".";
		}
		return result;
	}
	public static String classify(String rules,String[]test){
		int []count=new int[10];
		if(rules!=""){
			String []a0=rules.split("[.]");
			String compare="";
			String label="";
			for(int l=0;l<a0.length;l++){
				System.out.println(a0[l]);
				String []a1=rules.split("[;]");
				for(int i=0;i<a1.length;i++){
					compare="";
					String []a2=a1[i].split("[,]");
					for(int j=0;j<a2.length-1;j++){
						String []a3=a2[j].split("[=]");
						for(int k=0;k<attribute.length;k++){
							if(a3[0].equals(attribute[k])){
								compare=compare+attribute[k]+"="+test[k]+",";
								break;
							}
						}
					}
					String compare2="";
					for(int h=0;h<a2.length-1;h++){
						compare2=compare2+a2[h]+",";
					}
					if(compare2.equals(compare)){
						System.out.println(a2[a2.length-1]+"11111");
						if(a2.length!=1)
						label=""+a2[a2.length-1].split("[=]")[1];
					}
				}
				for(int h=0;h<10;h++){
					if(label.equals(init[27][h]))
						count[h]++;
				}					
			}
			int index=0;
			for(int h=0;h<9;h++){
				if(count[h]<count[h+1])
					index=h+1;
			}				
		return init[27][index];
		}
		else
		return null;
	}
}
	
