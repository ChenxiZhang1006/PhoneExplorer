import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class storeFileIntoDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		DateFormat datefmt = new SimpleDateFormat("_yyyy_MM_dd");
		String suffix = datefmt.format(date);
		
		String varExpTableName = args[0] + suffix;
		String filePath = args[1];
		String fileName = args[2];
		//String varExpTableName = "varDescExpansion" + suffix;
		
		dbConnect dbConn = new dbConnect();
		dbConn.connectDB();
		//create table
		String sql = "CREATE TABLE " + varExpTableName + "( "
				+ "id integer AUTO_INCREMENT NOT NULL PRIMARY KEY, "
				+ "varDescription text, "
				+ "varExpansion text"
				+ ")";
		dbConn.createTable(sql);
		
		//Insert Value
		fileFunc ff = new fileFunc();
		//List<List<String>> lVarDescExpansion = ff.readVarDescFile("dbData", "varDescs_expanded.txt");
		List<List<String>> lVarDescExpansion = ff.readVarDescFile(filePath,fileName);
		int nLen = lVarDescExpansion.size();
		for(int i = 0; i < nLen; i ++){
			List<String> l1Var = lVarDescExpansion.get(i);
			String varDescription = l1Var.get(0);
			String varExpansion = "";
			if(l1Var.size() == 2){
				varExpansion = l1Var.get(1);
			}
			sql = "INSERT INTO " + varExpTableName + "(varDescription, varExpansion) "
					+ "VALUES('" + varDescription + "','" + varExpansion + "')";
			dbConn.insertData(sql);
		}
		
		dbConn.disconnectDB();
		
	}

}
