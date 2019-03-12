package counsling;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class StudentCounseling {
	Workbook workbook;
	private final int totalProgram=5;
	static QueueImplementation queue = new QueueImplementation();
	static HashMap<String,Integer> mapOfProgramCapacity = new HashMap<String,Integer>();
	static HashMap<String,String> mapOfStudentPreference = new HashMap<String,String>();
	static HashMap<String,String> mapOfCounsellingResult = new HashMap<String,String>();

	/**
	 * read the total program and the no. of seats in each program from the Excel file.
	 * @param pathOfFile
	 * @throws IOException
	 */
	public void readTotalNoOfSeatInEachProgram(String pathOfFile) throws IOException  {

		try {
			workbook = Workbook.getWorkbook(new File(pathOfFile));
			Sheet sheet = workbook.getSheet(0);

			for (int row = 1; row < sheet.getRows(); row++) {
				Cell cell = sheet.getCell(0, row);
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					String programName=cell.getContents();
					cell = sheet.getCell(1,row);
					int programCapacity=Integer.parseInt(cell.getContents());

					mapOfProgramCapacity.put(programName, programCapacity);
				}
			}
		} catch (BiffException e) {
			throw new AssertionError("Invalid xls Format");
		}
	}
	/**
	 * read students name with their preferences from the Excel file.
	 * @param pathOfFile
	 * @throws IOException
	 */
	public void readPreferenceOfStudent(String pathOfFile) throws IOException  {
		try {
			workbook = Workbook.getWorkbook(new File(pathOfFile));
			Sheet sheet = workbook.getSheet(0);

			for (int row = 1; row < sheet.getRows(); row++) {  
				Cell cell = sheet.getCell(0, row);  
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					String studentName=cell.getContents();
					queue.Enqueue(studentName);
					cell = sheet.getCell(1,row);
					String preference=cell.getContents();
					mapOfStudentPreference.put(studentName, preference);
				}
			}
		}catch (BiffException e) {
			throw new AssertionError("Invalid xls Format");
		}
	}
	/**
	 * calls counseling process
	 * @return mapOfCounsellingResult
	 * @throws IOException
	 */
	public HashMap<String,String> counselingProcess() throws IOException {	
		readTotalNoOfSeatInEachProgram("ProgramsAvailabilty.xls");
		readPreferenceOfStudent("StudentPreference.xls");
		try {
			return allotProgramsToStudent(queue);	
		}
		catch(Exception e) {
			throw new AssertionError("Counselling Falied");
		}
	}

	/**
	 * alots students with program as per their preferences and availabilty
	 * @param queue
	 * @return mapOfCounsellingResult
	 * @throws InterruptedException
	 */
	public  HashMap<String,String> allotProgramsToStudent(QueueImplementation queue) throws InterruptedException {

		while(!queue.isEmpty()) {

			String student=queue.Dequeue();
			String pref = mapOfStudentPreference.get(student);
			String[] preference = new String[totalProgram];
			preference=pref.split(",");
			boolean assign=false;
			for(int program = 0 ;program < totalProgram ; program++) {
				if(assign==true)
					break;
				String subject = preference[program];
				int programSeatAvailable=mapOfProgramCapacity.get(subject);
				if(programSeatAvailable>0) {
					mapOfCounsellingResult.put(student.toUpperCase(),subject.toUpperCase());
					assign=true;
					programSeatAvailable--;
					mapOfProgramCapacity.put(subject,programSeatAvailable);
				}

			}
		}
		return mapOfCounsellingResult;
	}
}