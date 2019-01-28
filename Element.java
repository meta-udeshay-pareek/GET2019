package sparsematrix;

public class Element 
{
	private int rowIndex;
	private int columnIndex;
	private int elementValue;
	
	public void setRowIndex(int rowIndex)
	{
		this.rowIndex = rowIndex;
	}
	
	public void setColumnIndex(int columnIndex)
	{
		this.columnIndex = columnIndex;
	}
	
	public void setElementValue(int elementValue)
	{
		this.elementValue = elementValue;
	}
	
	public int getValue()
	{
		return this.elementValue;
	}
	
	public int getRowIndex()
	{
		return this.rowIndex;
	}
	
	public int getColumnIndex()
	{
		return this.columnIndex;
	}
	
}