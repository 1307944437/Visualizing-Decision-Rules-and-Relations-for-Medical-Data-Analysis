package ceshi;

import java.io.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.csvreader.*;
import com.opencsv.*;

import javax.swing.JOptionPane;
public class csvhandle {
	public static void main(String[] args) throws Exception {  
		
		String node[] = new String[500];
		int nodenum=0;
		int onecheck=0;
		int twocheck=0;
		System.out.println(node[0]);
		BufferedReader linkreader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\YinWang\\Desktop\\HEPARTWO10k-output.csv")));//GBK
		String line = null;
		
		while((line=linkreader.readLine())!=null){
            String item[] = line.split(",");
            String one = item[1];
            String two = item[2];
            for(int i=0;i<nodenum;i++) {
            	if(node[i].equals(one)) {
            		onecheck=1;
            	}
            	if(node[i].equals(two)) {
            		twocheck=1;
            	}
            }
            if(onecheck==0) {
            	node[nodenum]=one;
            	nodenum++;
            }
            if(twocheck==0) {
            	node[nodenum]=two;
            	nodenum++;
            }
            onecheck=0;
            twocheck=0;
        }
		System.out.println(nodenum);
		
		
		
		//��һ��������������ļ�·��        
		//�����Ŀ¼�²����ڸ��ļ������ļ��ᱻ������ָ��Ŀ¼�¡������Ŀ¼��ͬ���ļ�����ô���ļ��������ǡ�        
		File writeFile = new File("write.csv");         
		try{
			//�ڶ�����ͨ��BufferedReader�ഴ��һ��ʹ��Ĭ�ϴ�С����������Ļ����ַ������           
			BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));             
			//�����������ĵ�����һ�����ݸ�ֵ��lineData�����ж��Ƿ�Ϊ�գ�����Ϊ�������            
			for(int i=0;i<nodenum;i++){                
				           
				//����write�ķ������ַ���д������                
				writeText.write(i+","+node[i]); 
				writeText.newLine();    
				//����     
				}             
			//ʹ�û�������ˢ�·���������ˢ��Ŀ�ĵ���           
			writeText.flush();            
			//�رջ�������������û�е���ϵͳ�ײ���Դ���������õײ���Դ����FileWriter���󣬻�����������һ�����Ч�ʵ�����           
			//��ˣ��˴���close()�����رյ��Ǳ������������            
			writeText.close();        
			}catch (FileNotFoundException e){            
				System.out.println("û���ҵ�ָ���ļ�");        
			}catch (IOException e){            
				System.out.println("�ļ���д����");        
					}    
		}
	}