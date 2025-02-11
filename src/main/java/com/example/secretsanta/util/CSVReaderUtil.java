package com.example.secretsanta.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.secretsanta.model.Employee;

public class CSVReaderUtil {
public static List<Employee> readEmployeesFromCSV(String filePath) throws IOException {
	List<Employee> employees = new ArrayList<>();
	try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		String line;
		boolean isFirstLine = true; //skipping the header row
		while((line = br.readLine()) != null) {
			if(isFirstLine) {
				isFirstLine = false;
				continue;
			}
			String[] data = line.split(",");
			if(data.length == 2) {
				employees.add(new Employee(data[0].trim(), data[1].trim()));
			}
		}
		
	}
	return employees;
}
}
