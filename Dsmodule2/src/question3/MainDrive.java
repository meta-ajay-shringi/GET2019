package question3;

/**
 *  This is main class for perform operations.
 */
public class MainDrive {

	public static void main(String[] args) {
		ExcelRead excelRead = new ExcelRead();
		excelRead.studentExcal();
		excelRead.programExcal();
	
		AllocatePrograms.addPrograms();
	
		for(int i=0;i<AllocatePrograms.studentProgram.size();i++) {
			       System.out.print(AllocatePrograms.studentProgram.get(i).name + "  ");
					System.out.println(AllocatePrograms.studentProgram.get(i).program);
				}

		ExcelWrite.writeFile();
		
	}

}
