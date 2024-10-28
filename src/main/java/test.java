import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
String strarray = "[['Modules', 'Total TC', 'Pass TC','Fail TC'],['Chrome1',1,1,0],['Chrome2',1,1,0]]";
        
        // Remove the outer brackets and split the string into rows
        strarray = strarray.substring(1, strarray.length() - 1);
        String[] rows = strarray.split("\\],\\[");

        // List to hold the parsed data
        List<List<String>> data = new ArrayList<>();

        for (String row : rows) {
            // Remove any remaining brackets and split by comma
            row = row.replace("[", "").replace("]", "").replace("'", "");
            String[] elements = row.split(",");

            // Add the row data to the list
            List<String> rowData = new ArrayList<>();
            for (String element : elements) {
                rowData.add(element.trim());
            }
            data.add(rowData);
        }

        // Process data module-wise
        for (int i = 1; i < data.size(); i++) { // Start from 1 to skip the header
            List<String> moduleData = data.get(i);
            String moduleName = moduleData.get(0);
            int totalTC = Integer.parseInt(moduleData.get(1));
            int passTC = Integer.parseInt(moduleData.get(2));
            int failTC = Integer.parseInt(moduleData.get(3));

            System.out.println("Module: " + moduleName);
            System.out.println("Total TC: " + totalTC);
            System.out.println("Pass TC: " + passTC);
            System.out.println("Fail TC: " + failTC);
            System.out.println();
        }
    
		
	}

}
