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
		
		
		
		//第一步：设置输出的文件路径        
		//如果该目录下不存在该文件，则文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖。        
		File writeFile = new File("write.csv");         
		try{
			//第二步：通过BufferedReader类创建一个使用默认大小输出缓冲区的缓冲字符输出流           
			BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));             
			//第三步：将文档的下一行数据赋值给lineData，并判断是否为空，若不为空则输出            
			for(int i=0;i<nodenum;i++){                
				           
				//调用write的方法将字符串写到流中                
				writeText.write(i+","+node[i]); 
				writeText.newLine();    
				//换行     
				}             
			//使用缓冲区的刷新方法将数据刷到目的地中           
			writeText.flush();            
			//关闭缓冲区，缓冲区没有调用系统底层资源，真正调用底层资源的是FileWriter对象，缓冲区仅仅是一个提高效率的作用           
			//因此，此处的close()方法关闭的是被缓存的流对象            
			writeText.close();        
			}catch (FileNotFoundException e){            
				System.out.println("没有找到指定文件");        
			}catch (IOException e){            
				System.out.println("文件读写出错");        
					}    
		}
	}