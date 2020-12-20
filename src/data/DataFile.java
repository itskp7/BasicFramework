package data;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("C:\\testing\\NikulTest.xlsx");
	
	//Login page data
	
	public String correctEmail = d.getCellData("Data1", 1, 2);  // made public so that could be used in any package
	public String wrongPassword = d.getCellData("Data1", 2, 2);
	public String wrongEmail = d.getCellData("Data1", 1, 3);
	public String passwordErrMsg = d.getCellData("Data1", 4, 2);
	public String emailErrMsg = d.getCellData("Data1", 3, 2);
	
	// Footer page
	
	// Add to Cart
	
	// CheckOut
	
	// Search

}
