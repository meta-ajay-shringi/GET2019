package question3;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;

/**
 * This class is used to create excel file of student with their allocated
 * program.
 */
public class ExcelWrite {

	/**
	 * This method is used to put all student data in excel file.
	 */
	public static void writeFile() {
		int index = 0;
		
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("C:\\Users\\Ajay\\Documents\\AllocateStudentList.xls"));
			WritableSheet workbookSheet = workbook.createSheet("sheet1", 0);
			int index1;
			
			for (index1 = 0; index1 < AllocatePrograms.studentProgram.size(); index1++) {

				String name = AllocatePrograms.studentProgram.get(index).name;
				Label nameLabel = new Label(0, index1, name);
				workbookSheet.addCell(nameLabel);
				String program = AllocatePrograms.studentProgram.get(index).program;
				Label programLabel = new Label(1, index1, program);
				index++;
				workbookSheet.addCell(programLabel);

			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}