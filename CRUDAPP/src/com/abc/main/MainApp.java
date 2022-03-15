package com.abc.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.abc.controller.IStudentController;
import com.abc.factory.StudentControllerFactory;
import com.abc.pojo.Student;

public class MainApp {

	public static void main(String[] args) throws IOException {
		Scanner scanner = null;
		int option = 0;
		String name, age, sid, address, status, newName, newAddress, newAge, enter = null;
		newName = newAddress = newAge = null;
		IStudentController studentController = null;
		Student studentRecord = null;
		BufferedReader br = null;

		while (true) {
			System.out.println("WELCOME TO OUR APPLICATION...");
			System.out.println("Please choose one option...");
			System.out.println("1. Create");
			System.out.println("2. Read");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Display Table");
			System.out.println("Please enter your option...");
			scanner = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			option = scanner.nextInt();
			switch (option) {
			case 1:
				// Create
				// Collecting the inputs for create operation
				System.out.print("Enter the name:: ");
				name = scanner.next();
				System.out.print("Enter the age:: ");
				age = scanner.next();
				System.out.print("Enter the address:: ");
				address = scanner.next();

				Student student = new Student();
				student.setSname(name);
				student.setSage(Integer.parseInt(age));
				student.setSaddress(address);

				studentController = StudentControllerFactory.getController();
				status = studentController.save(student);
				System.out.println(status + "\n");

				break;

			case 2:
				// Read
				// Collection input for read operation
				System.out.print("Enter the sid:: ");
				sid = scanner.next();
				studentController = StudentControllerFactory.getController();
				studentRecord = studentController.getStudentById(Integer.parseInt(sid));
				System.out.println(studentRecord + "\n");

				break;

			case 3:
				// Update
				System.out.print("Enter the sid:: ");
				sid = scanner.next();
				studentController = StudentControllerFactory.getController();
				studentRecord = studentController.getStudentById(Integer.parseInt(sid));

				if (studentRecord != null) {

					try {
						System.out.print("CurrentName is :: " + studentRecord.getSname() + ",  Enter the newName : ");
						newName = br.readLine();

						System.out.print("CurrentAge is :: " + studentRecord.getSage() + ",  Enter the newAge : ");
						newAge = br.readLine();

						System.out.print(
								"CurrentAddress is :: " + studentRecord.getSaddress() + ",  Enter the newAddress : ");
						newAddress = br.readLine();

					} catch (IOException e) {
						e.printStackTrace();
					}

					Student newStudent = new Student();

					newStudent.setSid(Integer.parseInt(sid));

					if (newName.equals("") || newName == null) {
						newStudent.setSname(studentRecord.getSname());
					} else {
						newStudent.setSname(newName);
					}

					if (newAge.equals("") || newAge == null) {
						newStudent.setSage(studentRecord.getSage());
					} else {
						newStudent.setSage(Integer.parseInt(newAge));
					}

					if (newAddress.equals("") || newAddress == null) {
						newStudent.setSaddress(studentRecord.getSaddress());
					} else {
						newStudent.setSaddress(newAddress);
					}

					status = studentController.updateStudent(newStudent);
					System.out.println(status);

				} else {
					System.out.println("Record not available for the updation " + sid);
				}

				break;
			case 4:
				// Delete
				System.out.print("Enter the sid:: ");
				sid = scanner.next();
				studentController = StudentControllerFactory.getController();
				status = studentController.deleteStudentById(Integer.parseInt(sid));
				System.out.println(status + "\n");

				break;

			case 5:
				// Display Table
				studentController = StudentControllerFactory.getController();
				Set<Student> table = studentController.displayTable();

				Iterator<Student> iterator = table.iterator();

				if (table != null) {

					System.out.println("SID\tSNAME\t\tSAGE\tADDRESS");
					System.out.println("---------------------------------------");
					while (iterator.hasNext()) {
						Student student2 = (Student) iterator.next();
						System.out.println(student2.getSid() + "\t" + student2.getSname() + "\t\t" + student2.getSage()
								+ "\t" + student2.getSaddress());
					}
					System.out.println();

				}

				break;

			default:
				System.out.println("Invalid option...\nWould you like to enter again?[YES/NO]");
				enter = scanner.next();
				if (enter.equalsIgnoreCase("NO")) {
					System.out.println("Thank you for visiting....");
					scanner.close();
					System.exit(0);
				}
				break;
			}
		}
	}

}
