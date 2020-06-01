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

public class inputdata {
	
     public static void main(String[] args) {
         StringBuilder sb = new StringBuilder();
         PrintStream printStream = null ;
         int dataNO=3;

         try {
        	 
             BufferedReader linkreader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Eclipse\\workspace\\ceshi\\Tox21\\tox21-features.csv")));//GBK

             String line = null;
             
             int positivemax=0;
             int negativemax=0;
             int name1datanull=0;
               
             while((line=linkreader.readLine())!=null){
                 String item[] = line.split(",");
                 String last = item[item.length-1];
                 
                 //handle data 1
                 try {
                 double temp=Double.valueOf(item[dataNO]);
                 int inttemp=(int)temp;
                 if(inttemp>0&&inttemp>positivemax)
                	 positivemax=inttemp;
                 if(inttemp<0&&inttemp<negativemax)
                	 negativemax=inttemp;
                 }catch (Exception e) {
                	 name1datanull++;
                 }        
             }

             System.out.println(negativemax);
             System.out.println(positivemax);
             negativemax=-negativemax;
             int max=positivemax;
             if(negativemax>positivemax)
            	 max=negativemax;
             try {
            	 
                 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Eclipse\\workspace\\ceshi\\Tox21\\tox21-features.csv")));//GBK
             line=null;
             int positive[]=new int[max];
             int negative[]=new int[max];
             for(int i=0;i<max;i++) {
            	 positive[i]=0;
            	 negative[i]=0;
             }
             
             while((line=reader.readLine())!=null){
                 String item[] = line.split(",");
                 String last = item[item.length-1];
                 //handle data 1
                 try {
                 double temp=Double.valueOf(item[dataNO]);
                 int inttemp=(int)temp;
                 
                 if(inttemp>0)
                	 positive[inttemp-1]++;
                 if(inttemp<0)
                	 negative[-inttemp-1]++;
                 }catch (Exception e) {
                	 
                 }        
             }
             
             System.out.println(negative[5]);
             try {
                 printStream= new PrintStream(new FileOutputStream("input.html"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                sb.append("<html>");
                
                sb.append("<head>\r\n" + 
                		"<meta charset=\"utf-8\">\r\n" + 
                		"<meta http-equiv=\"Access-Control-Allow-Origin\" content=\"*\">\r\n" + 
                		"    <title>ECharts inputdata</title>\r\n" + 
                		"    <script src=\"https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js\"></script>\r\n" + 
                		"    <script src=\"https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js\"></script>\r\n" + 
                		"</head>\r\n" + 
                		"\r\n" + 
                		"<body>\r\n" + 
                		"<div id=\"main\" style=\"width:500px;height:400px\"></div>\r\n" + 
                		"\r\n" + 
                		"<script type=\"text/javascript\">\r\n" + 
                		"       \r\n" + 
                		"$(document).ready(function(){\r\n" + 
                		"\r\n" + 
                		"        //echarts进行初始化\r\n" + 
                		"		var myChart = echarts.init(document.getElementById(\"main\"));\r\n" + 
                		"		myChart.setOption({\r\n" + 
                		"title: {\r\n" + 
                		"                text: 'inputdata'\r\n" + 
                		"            },\r\n" + 
                		"            tooltip: {},\r\n" + 
                		"            legend: {\r\n" + 
                		"                data:['positive','negative']\r\n" + 
                		"            },\r\n" + 
                		"            xAxis: {\r\n"); 
                sb.append("                data: [");
                for(int i=1;i<max+1;i++) {
                	sb.append("\""+i+"\",");
                }
                sb.append("]\r\n" + 
                		"            },\r\n" + 
                		"            yAxis: {},\r\n" + 
                		"            series: [{\r\n" + 
                		"                name: 'positive',\r\n smooth:true,symbolSize:10," + 
                		"                type: 'line',\r\n" + 
                		"                data: [");
                for(int i=0;i<max;i++) {
                	sb.append(positive[i]+",");
                }
                sb.append("]\r\n" + 
                		"            },{name:'negative',smooth:true,type:'line',symbolSize:10,data:[");
                for(int i=0;i<max;i++) {
                	sb.append(negative[i]+",");
                }
                sb.append("]}]\r\n" + 
                		"\r\n" + 
                		"		});\r\n" + 
                		"\r\n" + 
                		"});\r\n" + 
                		"\r\n" + 
                		"\r\n" + 
                		"</script>");

                //end
                sb.append("</body></html>");
               
               printStream.println(sb.toString());
             
         } catch (Exception e) {
             e.printStackTrace();
         }} catch (Exception e) {
             e.printStackTrace();
         }


         
         
    }
}  

