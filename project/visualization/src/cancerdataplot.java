package ceshi;

import java.io.*;



public class cancerdataplot {
	
     public static void main(String[] args) {
         StringBuilder sb = new StringBuilder();
         PrintStream printStream = null ;
         int dataNO=18*2;
         String title=null;

         try {
             printStream= new PrintStream(new FileOutputStream("cancerdataplot.html"));
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
            		"<div id=\"main1\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main2\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main3\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main4\" style=\"width:500px;height:400px;clear:both;float:left;\"></div>\r\n" + 
            		"<div id=\"main5\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main6\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main7\" style=\"width:500px;height:400px;clear:both;float:left;\"></div>\r\n" + 
            		"<div id=\"main8\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main9\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main10\" style=\"width:500px;height:400px;clear:both;float:left;\"></div>\r\n" + 
            		"<div id=\"main11\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main12\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main13\" style=\"width:500px;height:400px;clear:both;float:left;\"></div>\r\n" + 
            		"<div id=\"main14\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main15\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main16\" style=\"width:500px;height:400px;clear:both;float:left;\"></div>\r\n" + 
            		"<div id=\"main17\" style=\"width:500px;height:400px;float:left;\"></div>\r\n" + 
            		"<div id=\"main18\" style=\"width:500px;height:400px;float:left;\"></div>" + 
            		
            		"\r\n" + 
            		"<script type=\"text/javascript\">\r\n" + 
            		"       \r\n");
            
            
            for(int page=0;page<18;page++) {
            	
            	try {
               	 
                    BufferedReader linkreader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Eclipse\\workspace\\ceshi\\Tox21\\LungCancer_cancerYesNo.csv")));//GBK

                    String line = null;
                    
                    int positivemax=0;
                   
                    
                      
                    while((line=linkreader.readLine())!=null){
                        String item[] = line.split(",");
                        String last = item[item.length-1];
                        
                        //handle data 1
                        try {
                        double temp=Double.valueOf(item[dataNO+page]);
                        int inttemp=(int)temp;
                        if(inttemp>0&&inttemp>positivemax)
                       	 positivemax=inttemp;
                        
                        }catch (Exception e) {
                       	 
                        }        
                    }

                    
                    System.out.println(positivemax);
                    
                    int max=positivemax;
                    if(max>1) {
                   	 try {
                       	 
                            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Eclipse\\workspace\\ceshi\\Tox21\\LungCancer_cancerYesNo.csv")));//GBK
                        line=null;
                        int positive[]=new int[max];
                       
                        for(int i=0;i<max;i++) {
                       	 positive[i]=0;
                       	
                        }
                        
                        while((line=reader.readLine())!=null){
                            String item[] = line.split(",");
                            String last = item[item.length-1];
                            //handle data 1
                            try {
                            double temp=Double.valueOf(item[dataNO+page]);
                            int inttemp=(int)temp;
                            
                            if(inttemp>0)
                           	 positive[inttemp-1]++;
                            
                            }catch (Exception e) {
                           	 title=item[dataNO+page];
                            }        
                        }
                        sb.append("$(document).ready(function(){\r\n" + 
                        		"\r\n" + 
                        		"        //echarts进行初始化\r\n" + 
                        		"		var myChart = echarts.init(document.getElementById(\"main"+(page+1)+"\"));" + 
                        		"		myChart.setOption({\r\n" + 
                        		"title: {\r\n" + 
                        		"                text: '"+title+"'\r\n" + 
                        		"            },\r\n" + 
                        		"            tooltip: {},\r\n" + 
                        		"            legend: {\r\n" + 
                        		"                data:['positive']\r\n" + 
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
                        		"            }");
                        
                        sb.append("]\r\n" + 
                        		"\r\n" + 
                        		"		});\r\n" + 
                        		"\r\n" + 
                        		"});\r\n" + 
                        		"\r\n" + 
                        		"\r\n");
                        
                   	} catch (Exception e) {
                        e.printStackTrace();
                    }
                    }
                    if(max<=1) {
                    	max=10;
                      	 try {
                          	 
                               BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Eclipse\\workspace\\ceshi\\Tox21\\LungCancer_cancerYesNo.csv")));//GBK
                           line=null;
                           int positive[]=new int[max];
                          
                           for(int i=0;i<max;i++) {
                          	 positive[i]=0;
                          	
                           }
                           
                           while((line=reader.readLine())!=null){
                               String item[] = line.split(",");
                               String last = item[item.length-1];
                               //handle data 1
                               try {
                               double temp=Double.valueOf(item[dataNO+page])*10;
                               int inttemp=(int)temp;
                               
                               if(inttemp>0)
                              	 positive[inttemp-1]++;
                               
                               }catch (Exception e) {
                              	 title=item[dataNO+page];
                               }        
                           }
                           sb.append("$(document).ready(function(){\r\n" + 
                           		"\r\n" + 
                           		"        //echarts进行初始化\r\n" + 
                           		"		var myChart = echarts.init(document.getElementById(\"main"+(page+1)+"\"));" + 
                           		"		myChart.setOption({\r\n" + 
                           		"title: {\r\n" + 
                           		"                text: '"+title+"'\r\n" + 
                           		"            },\r\n" + 
                           		"            tooltip: {},\r\n" + 
                           		"            legend: {\r\n" + 
                           		"                data:['positive']\r\n" + 
                           		"            },\r\n" + 
                           		"            xAxis: {\r\n"); 
                           sb.append("                data: [");
                           for(int i=1;i<max+1;i++) {
                           	sb.append("\""+(double)i/10+"\",");
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
                           		"            }");
                           
                           sb.append("]\r\n" + 
                           		"\r\n" + 
                           		"		});\r\n" + 
                           		"\r\n" + 
                           		"});\r\n" + 
                           		"\r\n" + 
                           		"\r\n");
                           
                      	} catch (Exception e) {
                           e.printStackTrace();
                       }
                       }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            	
            }
             
            
            
            
            
            sb.append("</script>");

            //end
            sb.append("</body></html>");
           
           printStream.println(sb.toString());
         

         
         
    }
}  

