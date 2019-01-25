/** 
 * Copyright (C) 2019, 2019 All Right Reserved, http://www.yullin.com/
 * 
 * SHE Business can not be copied and/or distributed without the express
 * permission of Yullin Technologies
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * 
 */

package com.she.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 엑셀파일 리더
 *
 */
public class ExcelReader
{	
	/**
	 * 엑셀 파일 읽기
	 * @param filePath 파일경로
	 * @return 엑셀파일 시트목록
	 */
	public List<String[][]> read(String filePath)
	{
		List<String[][]> list = new ArrayList<String[][]>();
		
		try
		{
			int startIndex = filePath.lastIndexOf('.');
			String ext = filePath.substring(startIndex+1, filePath.length());
			if(ext.equals("xls"))
			{
				list = this.readOfXls(filePath);
			}
			else if(ext.equals("xlsx"))
			{
				list = this.readOfXlsx(filePath);
			}
		}
		catch(Exception e)
		{
		}
		
		return list;
	}
	
	/**
	 * 엑셀 파일 읽기
	 * @param filePath 파일경로
	 * @return 엑셀파일 시트목록
	 */
	public List<String[][]> read(File file)
	{
		List<String[][]> list = new ArrayList<String[][]>();
		
		try
		{
			int startIndex = file.getPath().lastIndexOf('.');
			String ext = file.getPath().substring(startIndex+1, file.getPath().length());
			if(ext.equals("xls"))
			{
				list = this.readOfXls(file);
			}
			else if(ext.equals("xlsx"))
			{
				list = this.readOfXlsx(file);
			}
		}
		catch(Exception e)
		{
		}
		
		return list;
	}
	
	/**
	 * 엑셀 97-2003 통합 파일 읽기(.xls)
	 * @param filePath 파일경로
	 * @return 엑셀파일 시트목록
	 */
	public List<String[][]> readOfXls(String filePath)
	{
		List<String[][]> list = new ArrayList<String[][]>();
		
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		try
		{
			fis = new FileInputStream(filePath);
			workbook = new HSSFWorkbook(fis);
			
			HSSFSheet curSheet;
			HSSFRow curRow;
			HSSFCell curCell;			
			for(int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++)
			{				
				curSheet = workbook.getSheetAt(sheetIndex);
				
				int maxRow = curSheet.getPhysicalNumberOfRows();
				int maxCell = (maxRow>0)? curSheet.getRow(0).getPhysicalNumberOfCells():0;
				String[][] sheetData = new String[maxRow][maxCell];
				
				for(int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++)
				{
					curRow = curSheet.getRow(rowIndex);
					for(int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++)
					{
						curCell = curRow.getCell(cellIndex);
						String value = "";
						switch(curCell.getCellType())
						{
						case HSSFCell.CELL_TYPE_FORMULA:
							value = curCell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if(DateUtil.isCellDateFormatted(curCell))
							{
								SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
								value = f.format(curCell.getDateCellValue()) + "";
							}
							else
							{
								value = curCell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = curCell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = curCell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = curCell.getErrorCellValue() + "";
							break;
						}
						
						sheetData[rowIndex][cellIndex] = value;
					}
				}
				
				list.add(sheetData);
			}
		}
		catch(FileNotFoundException e)
		{
		}
		catch(IOException e)
		{			
		}
		catch(Exception e)
		{			
		}
		finally 
		{
			try
			{
				if(workbook != null) workbook.close();
				if(fis != null) fis.close();
			}
			catch(Exception e)
			{				
			}
		}
		
		return list;
	}
	
	/**
	 * 엑셀 97-2003 통합 파일 읽기(.xls)
	 * @param filePath 파일경로
	 * @return 엑셀파일 시트목록
	 */
	public List<String[][]> readOfXls(File file)
	{
		List<String[][]> list = new ArrayList<String[][]>();
		
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		try
		{
			fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
			
			HSSFSheet curSheet;
			HSSFRow curRow;
			HSSFCell curCell;			
			for(int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++)
			{				
				curSheet = workbook.getSheetAt(sheetIndex);
				
				int maxRow = curSheet.getPhysicalNumberOfRows();
				int maxCell = (maxRow>0)? curSheet.getRow(0).getPhysicalNumberOfCells():0;
				String[][] sheetData = new String[maxRow][maxCell];
				
				for(int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++)
				{
					curRow = curSheet.getRow(rowIndex);
					for(int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++)
					{
						curCell = curRow.getCell(cellIndex);
						String value = "";
						switch(curCell.getCellType())
						{
						case HSSFCell.CELL_TYPE_FORMULA:
							value = curCell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if(DateUtil.isCellDateFormatted(curCell))
							{
								SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
								value = f.format(curCell.getDateCellValue()) + "";
							}
							else
							{
								value = curCell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = curCell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = curCell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = curCell.getErrorCellValue() + "";
							break;
						}
						
						sheetData[rowIndex][cellIndex] = value;
					}
				}
				
				list.add(sheetData);
			}
		}
		catch(FileNotFoundException e)
		{
		}
		catch(IOException e)
		{			
		}
		catch(Exception e)
		{			
		}
		finally 
		{
			try
			{
				if(workbook != null) workbook.close();
				if(fis != null) fis.close();
			}
			catch(Exception e)
			{				
			}
		}
		
		return list;
	}
	
	/**
	 * 통합 엑셀 파일 읽기(.xlsx)
	 * @param filePath 파일경로
	 * @return 엑셀파일 시트목록
	 */
	public List<String[][]> readOfXlsx(String filePath)
	{
		List<String[][]> list = new ArrayList<String[][]>();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		try
		{
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;			
			for(int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++)
			{				
				curSheet = workbook.getSheetAt(sheetIndex);
				
				int maxRow = curSheet.getPhysicalNumberOfRows();
				int maxCell = (maxRow>0)? curSheet.getRow(0).getPhysicalNumberOfCells():0;
				String[][] sheetData = new String[maxRow][maxCell];
				
				for(int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++)
				{
					curRow = curSheet.getRow(rowIndex);
					for(int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++)
					{
						curCell = curRow.getCell(cellIndex);
						String value = "";
						switch(curCell.getCellType())
						{
						case XSSFCell.CELL_TYPE_FORMULA:
							value = curCell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							if(DateUtil.isCellDateFormatted(curCell))
							{
								SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
								value = f.format(curCell.getDateCellValue()) + "";
							}
							else
							{
								value = curCell.getNumericCellValue() + "";
							}
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = curCell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_BOOLEAN:
							value = curCell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = curCell.getErrorCellValue() + "";
							break;
						}
						
						sheetData[rowIndex][cellIndex] = value;
					}
				}
				
				list.add(sheetData);
			}
		}
		catch(FileNotFoundException e)
		{
		}
		catch(IOException e)
		{			
		}
		catch(Exception e)
		{			
		}
		finally 
		{
			try
			{
				if(workbook != null) workbook.close();
				if(fis != null) fis.close();
			}
			catch(Exception e)
			{				
			}
		}
		
		return list;
	}

	/**
	 * 통합 엑셀 파일 읽기(.xlsx)
	 * @param filePath 파일경로
	 * @return 엑셀파일 시트목록
	 */
	public List<String[][]> readOfXlsx(File file)
	{
		List<String[][]> list = new ArrayList<String[][]>();
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		try
		{
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			
			XSSFSheet curSheet;
			XSSFRow curRow;
			XSSFCell curCell;			
			for(int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++)
			{				
				curSheet = workbook.getSheetAt(sheetIndex);
				
				int maxRow = curSheet.getPhysicalNumberOfRows();
				int maxCell = (maxRow>0)? curSheet.getRow(0).getPhysicalNumberOfCells():0;
				String[][] sheetData = new String[maxRow][maxCell];
				
				for(int rowIndex = 0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++)
				{
					curRow = curSheet.getRow(rowIndex);
					for(int cellIndex = 0; cellIndex < curRow.getPhysicalNumberOfCells(); cellIndex++)
					{
						curCell = curRow.getCell(cellIndex);
						String value = "";
						switch(curCell.getCellType())
						{
						case XSSFCell.CELL_TYPE_FORMULA:
							value = curCell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							if(DateUtil.isCellDateFormatted(curCell))
							{
								SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
								value = f.format(curCell.getDateCellValue()) + "";
							}
							else
							{
								value = curCell.getNumericCellValue() + "";
							}
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = curCell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_BOOLEAN:
							value = curCell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = curCell.getErrorCellValue() + "";
							break;						
						}
						
						sheetData[rowIndex][cellIndex] = value;
					}
				}
				
				list.add(sheetData);
			}
		}
		catch(FileNotFoundException e)
		{
		}
		catch(IOException e)
		{			
		}
		catch(Exception e)
		{			
		}
		finally 
		{
			try
			{
				if(workbook != null) workbook.close();
				if(fis != null) fis.close();
			}
			catch(Exception e)
			{				
			}
		}
		
		return list;
	}
}
