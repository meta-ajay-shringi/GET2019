package question3;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is used to read excel file .
 */
public class ExcelRead {

	public static HashMap<String, Integer> programList = new HashMap<>();
	public static Queue<Student> studentList = new LinkedList<>();

	private static final String EXCEL_FILE_LOCATION = "C:\\Users\\Ajay\\Documents\\StudentList.xls";
	private static final String EXCEL_FILE_LOCATION1 = "C:\\Users\\Ajay\\Documents\\ProgramList.xls";

	/**
	 * This method is used to take input from student list excel file.
	 */
	public static void studentExcal() {

		Workbook workbook = null;
		try {

			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
			Sheet sheet = workbook.getSheet(0);

			for (int index1 = 0; index1 < sheet.getRows(); index1++) {

				Cell cell1 = sheet.getCell(0, index1);
				Cell cell2 = sheet.getCell(1, index1);
				Cell cell3 = sheet.getCell(2, index1);
				Cell cell4 = sheet.getCell(3, index1);
				Cell cell5 = sheet.getCell(4, index1);
				Cell cell6 = sheet.getCell(5, index1);
				studentList.add(new Student(cell1.getContents(), cell2.getContents(), cell3.getContents(), cell4.getContents(), cell5.getContents(), cell6.getContents()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} finally {

			if (workbook != null) {
				workbook.close();
			}

		}

	}

	/**
	 * This method is used to get input from program list with capacity. 
	 */
	public static void programExcal() {

		Workbook workbook = null;
		try {

			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION1));

			Sheet sheet = workbook.getSheet(0);

			for (int index1 = 0; index1 < sheet.getRows(); index1++) {

				Cell cell1 = sheet.getCell(0, index1);
				Cell cell2 = sheet.getCell(1, index1);
				programList.put(cell1.getContents(), Integer.parseInt(cell2.getContents()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} finally {

			if (workbook != null) {
				workbook.close();
			}

		}
	}

}