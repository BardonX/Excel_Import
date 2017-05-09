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
 * @Description: Excel ���������빤����
 * @author: Bardon
 * @date: 2017��5��3�� ����12:28:08
 * @version1.0
 */
public class ImportsUtil {
	/**
	 * ����Excel������
	 * @Title: readExcel
	 * @Author: Bardon
	 * @Time: 2017��5��3�� ����3:51:43
	 * @params: @param execlUrl �ļ�������·��
	 * @params: @return
	 * @return: List<HashMap<String,String>>
	 * @throws
	 */
	public static List<HashMap<String, String>> readExcel(String execlUrl){
		//��main�����в��ԣ�����ȡ������
		//1������Excel�ļ�·��
		
		//String execlUrl="D:\\�ٶ���\\��������������\\datawps.xls";
		List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
		
		try{
			//ֻ��ʶ��excel 2003   xls�ļ�
		    //ͨ�����ļ���ȡExcel�ļ�
			InputStream is=new FileInputStream(execlUrl);
			//��ȡExcel�ļ�����
			Workbook workbook=Workbook.getWorkbook(is);
			// ��ȡExcel �ļ� sheet��Ĭ�ϵ�һ����
			Sheet sheet=workbook.getSheet(0);
			//��ȡ��
			int rows=sheet.getRows();
			//��
			int cols=sheet.getColumns();
		    System.out.println(rows+"  "+cols);
		    //ѭ����������
		    for(int i=0;i<rows-1;i++){
		    	HashMap<String, String> map=new HashMap<String, String>();
		    	//�ڶ��п�ʼ
		    	Cell[] cells=sheet.getRow(i+1);
		    	//�γ̱���
		    	if(!(cells[0].getContents()==null||cells[0].getContents().equals(""))){
		    		String title=cells[0].getContents();
			    	String desc=cells[1].getContents();
			    	//System.out.println(title+" "+desc);
			    	//���title��һ���ģ��Ǿ���GG��
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
		//3������Excel�ļ�
		
		//4����������������ݴ洢��map�����з��͵�ҳ�����չʾ
		
		//5��ͬ�������ݿ�
		return list;
	}
	

	public static void main(String[] args) {
		System.out.println(readExcel("D:\\�ٶ���\\��������������\\datawps.xls"));
	}
	
	
	
}
