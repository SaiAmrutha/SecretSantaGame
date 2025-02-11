package com.example.secretsanta.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.example.secretsanta.model.Employee;

public class CSVWriterUtil {
	public static void writeAssigneeToCSV(String filePath, Map<Employee, Employee> assignee) throws IOException{
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.append("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID\n");
			for(Map.Entry<Employee, Employee> entry : assignee.entrySet()) {
				writer.append(entry.getKey().getName()).append(",")
				.append(entry.getKey().getEmail()).append(",")
				.append(entry.getValue().getName()).append(",")
				.append(entry.getValue().getEmail()).append("\n");
			}
		}
	}
}
