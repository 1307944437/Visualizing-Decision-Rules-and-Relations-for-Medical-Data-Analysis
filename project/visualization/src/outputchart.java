package ceshi;

import java.io.*;



import javax.swing.JOptionPane;

public class outputchart {
	
     public static void main(String[] args) {
         StringBuilder sb = new StringBuilder();
         PrintStream printStream = null ;
         
         String nodename[]=new String[100000];
         String category[]=new String[100000];
         String name[]=new String[100000]; 
         String source[]=new String[100000]; 
         String target[]=new String[100000]; 
         int i=0;
         int linksi=0;
         try {
        	 String nodeaddress=JOptionPane.showInputDialog("Please enter the node file address：");
        	 String linksaddress=JOptionPane.showInputDialog("Please enter the link file address：");
             BufferedReader linkreader = new BufferedReader(new InputStreamReader(new FileInputStream(linksaddress)));
             String line = null;
             
             while((line=linkreader.readLine())!=null){
                 String item[] = line.split(",");
                 String last = item[item.length-1];
                 try {
                 name[i]=item[3].substring(0,4);}
                 catch (Exception e) {
                	 name[i]=item[3];
                 }
                 
                 
                 source[i]=item[1];
                 target[i]=item[2];
                 i++;
                 
                 linksi++;
             }
             
             try {
             BufferedReader nodereader = new BufferedReader(new InputStreamReader(new FileInputStream(nodeaddress)));//GBK
             line = null;
             int nodei=0;
             while((line=nodereader.readLine())!=null){
                 String item[] = line.split(",");
                 String last = item[item.length-1];
                 System.out.println(last);
                 nodename[nodei]=item[1];
                 category[nodei]=item[0];
                 nodei++;
             }
             
             try {
                 printStream= new PrintStream(new FileOutputStream("outputchart.html"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                sb.append("<html>");
                //head
                sb.append("<head>");
                sb.append("<meta charset=\"utf-8\">");
                sb.append("<meta http-equiv=\"Access-Control-Allow-Origin\" content=\"*\">");
                sb.append("<title>output chart</title>");
                sb.append("<script src=\"https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js\"></script>");
                sb.append("<script src=\"https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js\"></script>");      
                sb.append("</head>");
                //body
                sb.append("<body><div id=\"main\" style=\"width:1500px;height:1200px\"></div>");
                //script
                sb.append("<script type=\"text/javascript\">\r\n" + 
                		"\r\n" + 
                		"    var myChart = echarts.init(document.getElementById('main'));\r\n" + 
                		"\r\n" + 
                		"    var categories = [];");
                sb.append("    for (var i = 0; i < "+70+"; i++) {\r\n" + 
                		"\r\n" + 
                		"        categories[i] = {\r\n" + 
                		"\r\n" + 
                		"            name: 'category' + i\r\n" + 
                		"\r\n" + 
                		"        };\r\n" + 
                		"\r\n" + 
                		"    }");
                 
                sb.append("    myChart.setOption({\r\n" + 
                		"\r\n" + 
                		"\r\n" + 
                		"        // 图的标题\r\n" + 
                		"\r\n" + 
                		"        title: {\r\n" + 
                		"\r\n" + 
                		"            text: 'output chart'\r\n" + 
                		"\r\n" + 
                		"        },\r\n" + 
                		"\r\n" + 
                		"        // 提示框的配置\r\n" + 
                		"\r\n" + 
                		"        tooltip: {\r\n" + 
                		"\r\n" + 
                		"            formatter: function (x) {\r\n" + 
                		"\r\n" + 
                		"                return x.data.des;\r\n" + 
                		"\r\n" + 
                		"            }\r\n" + 
                		"\r\n" + 
                		"        },\r\n" + 
                		"\r\n" + 
                		"        // 工具箱\r\n" + 
                		"\r\n" + 
                		"        toolbox: {\r\n" + 
                		"\r\n" + 
                		"            // 显示工具箱\r\n" + 
                		"\r\n" + 
                		"            show: true,\r\n" + 
                		"\r\n" + 
                		"            feature: {\r\n" + 
                		"\r\n" + 
                		"                mark: {\r\n" + 
                		"\r\n" + 
                		"                    show: true\r\n" + 
                		"\r\n" + 
                		"                },\r\n" + 
                		"\r\n" + 
                		"                // 还原\r\n" + 
                		"\r\n" + 
                		"                restore: {\r\n" + 
                		"\r\n" + 
                		"                    show: true\r\n" + 
                		"\r\n" + 
                		"                },\r\n" + 
                		"\r\n" + 
                		"                // 保存为图片\r\n" + 
                		"\r\n" + 
                		"                saveAsImage: {\r\n" + 
                		"\r\n" + 
                		"                    show: true\r\n" + 
                		"\r\n" + 
                		"                }\r\n" + 
                		"\r\n" + 
                		"            }\r\n" + 
                		"\r\n" + 
                		"        },\r\n" + 
                		"\r\n" + 
                		"        legend: [{\r\n" + 
                		"\r\n" + 
                		"            // selectedMode: 'single',\r\n" + 
                		"\r\n" + 
                		"            data: categories.map(function (a) {\r\n" + 
                		"\r\n" + 
                		"                return a.name;\r\n" + 
                		"\r\n" + 
                		"            })\r\n" + 
                		"\r\n" + 
                		"        }],\r\n" + 
                		"\r\n" + 
                		"        series: [{\r\n" + 
                		"\r\n" + 
                		"            type: 'graph', // 类型:关系图\r\n" + 
                		"\r\n" + 
                		"            layout: 'force', //图的布局，类型为力导图\r\n" + 
                		"\r\n" + 
                		"            symbolSize: 40, // 调整节点的大小\r\n" + 
                		"\r\n" + 
                		"            roam: true, // 是否开启鼠标缩放和平移漫游。默认不开启。如果只想要开启缩放或者平移,可以设置成 'scale' 或者 'move'。设置成 true 为都开启\r\n" + 
                		"\r\n" + 
                		"            edgeSymbol: ['circle', 'arrow'],\r\n" + 
                		"\r\n" + 
                		"            edgeSymbolSize: [2, 10],\r\n" + 
                		"\r\n" + 
                		"            edgeLabel: {\r\n" + 
                		"\r\n" + 
                		"                normal: {\r\n" + 
                		"\r\n" + 
                		"                    textStyle: {\r\n" + 
                		"\r\n" + 
                		"                        fontSize: 20\r\n" + 
                		"\r\n" + 
                		"                    }\r\n" + 
                		"\r\n" + 
                		"                }\r\n" + 
                		"\r\n" + 
                		"            },\r\n" + 
                		"\r\n" + 
                		"            force: {\r\n" + 
                		"\r\n" + 
                		"                repulsion: 2500,\r\n" + 
                		"\r\n" + 
                		"                edgeLength: [10, 50]\r\n" + 
                		"\r\n" + 
                		"            },\r\n" + 
                		"\r\n" + 
                		"            draggable: true,\r\n" + 
                		"\r\n" + 
                		"            lineStyle: {\r\n" + 
                		"\r\n" + 
                		"                normal: {\r\n" + 
                		"\r\n" + 
                		"                    width: 2,\r\n" + 
                		"\r\n" + 
                		"                    color: '#4b565b',\r\n" + 
                		"\r\n" + 
                		"                }\r\n" + 
                		"\r\n" + 
                		"            },\r\n" + 
                		"\r\n" + 
                		"            edgeLabel: {\r\n" + 
                		"\r\n" + 
                		"                normal: {\r\n" + 
                		"\r\n" + 
                		"                    show: true,\r\n" + 
                		"\r\n" + 
                		"                    formatter: function (x) {\r\n" + 
                		"\r\n" + 
                		"                        return x.data.name;\r\n" + 
                		"\r\n" + 
                		"                    }\r\n" + 
                		"\r\n" + 
                		"                }\r\n" + 
                		"\r\n" + 
                		"            },\r\n" + 
                		"\r\n" + 
                		"            label: {\r\n" + 
                		"\r\n" + 
                		"                normal: {\r\n" + 
                		"\r\n" + 
                		"                    show: true,\r\n" + 
                		"\r\n" + 
                		"                    textStyle: {}\r\n" + 
                		"\r\n" + 
                		"                }\r\n" + 
                		"\r\n" + 
                		"            },\r\n" + 
                		"\r\n" + 
                		" \r\n" + 
                		"\r\n" + 
                		"            // 数据\r\n" + 
                		"\r\n" + 
                		"            data: [");
                //data
                int nodeI=0;
                sb.append("{name: '"+nodename[nodeI]+"',symbolsize: 50,category: "+category[nodeI]+",} ,");
                nodeI++;
                while(nodeI<nodei-1) {
                	sb.append("{name: '"+nodename[nodeI]+"',symbolsize: 50,category: "+category[nodeI]+",} ,");
                	nodeI++;
                }
                sb.append("{name: '"+nodename[nodeI]+"',symbolsize: 50,category: "+category[nodeI]+",} ");
                sb.append("],\r\n" + 
                		"\r\n");
                //links
                sb.append("            links: [");
                
                int I=0;
                while(I<linksi) {
                	sb.append("{source: '"+source[I]+"',target: '"+target[I]+"',name: '"+name[I]+"'} ,");
                	I++;
                }
                sb.append("{source: '"+source[I]+"',target: '"+target[I]+"',name: '"+name[I]+"'} ");
                sb.append("],\r\n" + 
                		"\r\n" + 
                		"            categories: categories,\r\n" + 
                		"\r\n" + 
                		"        }]\r\n" + 
                		"\r\n" + 
                		"    });\r\n" + 
                		"\r\n" + 
                		"</script>");
                 

                //end
                sb.append("</body></html>");
               
               printStream.println(sb.toString());
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         } catch (Exception e) {
             e.printStackTrace();
         }

         System.out.println(name[0]);
         System.out.println(i);
         
         
    }
     }

