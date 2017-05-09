package com.px.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 
 * @ClassName: ImportsUtil
 * @Description: Excel 的批量导入工具类
 * @author: Bardon
 * @date: 2017年5月3日 下午12:28:08
 * @version1.0
 */
public class ImportsUtil {
	/**
	 * 解析Excel工具类
	 * @Title: readExcel
	 * @Author: Bardon
	 * @Time: 2017年5月3日 下午3:51:43
	 * @params: @param execlUrl 文件服务器路径
	 * @params: @return
	 * @return: List<HashMap<String,String>>
	 * @throws
	 */
	public static List<HashMap<String, String>> readExcel(String execlUrl){
		//在main函数中测试，再提取出方法
		//1、定义Excel文件路径
		
		//String execlUrl="D:\\百度云\\大数据批量导入\\datawps.xls";
		List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		
		try{
			//只能识别excel 2003   xls文件
		    //通过流文件读取Excel文件
			InputStream is=new FileInputStream(execlUrl);
			//获取Excel文件对象
			Workbook workbook=Workbook.getWorkbook(is);
			// 获取Excel 文件 sheet（默认第一个）
			Sheet sheet=workbook.getSheet(0);
			//获取行
			int rows=sheet.getRows();
			//列
			int cols=sheet.getColumns();
		    System.out.println(rows+"  "+cols);
		    //循环迭代内容
		    for(int i=0;i<rows-1;i++){
		    	HashMap<String, String> map=new HashMap<String, String>();
		    	//第二行开始
		    	Cell[] cells=sheet.getRow(i+1);
		    	//课程标题
		    	if(!(cells[0].getContents()==null||cells[0].getContents().equals(""))){
		    		String title=cells[0].getContents();
			    	String desc=cells[1].getContents();
			    	//System.out.println(title+" "+desc);
			    	//如果title是一样的，那就是GG了
			    	map.put("title", title);
			    	map.put("desc", desc);
			    	//map.put(title, desc);
			    	list.add(map);
		    	}
		    	
		    }
		    //System.out.println(list);
		} catch(Exception e){
			e.printStackTrace();
		}
		//3、解析Excel文件
		
		//4、将解析过后的内容存储在map集合中发送到页面进行展示
		
		//5、同步到数据库
		return list;
	}
	

	public static void main(String[] args) {
		System.out.println(readExcel("D:\\百度云\\大数据批量导入\\datawps.xls"));
	}
	
	
	
}
