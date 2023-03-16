package com.main;

import java.util.List;
import java.util.Scanner;

import com.daoFactory.StudentDaoFactory;
import com.dto.StudentDTO;
import com.service.IStudentService;
import com.serviceFactory.StudentServiceFactory;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IStudentService service = StudentServiceFactory.getStudentService();
		// System.out.println(service.getAllStudentInfo());

		System.out.println(
				"============================     Welcome TO Student Service Portal     ============================");
		System.out.println();
		System.out.println();
		l1: while (true) {
			System.out.println("--------------------- We Are Providing Total 5 Services ---------------------");
			System.out.println();
			System.out.println(" Press 1 --> Register New Student ");
			System.out.println(" Press 2 --> Get Student Information ");
			System.out.println(" Press 3 --> Update Student Information ");
			System.out.println(" Press 4 --> Delete Student Information ");
			System.out.println(" Press 5 --> Get All Student Information ");
			System.out.println(" Press 6 --> TO shut Down Program ");

			try {
				int id = sc.nextInt();

				switch (id) {
				case 1: {
					StudentDTO dto = new StudentDTO();
					l2: while (true) {
						try {

							System.out.println("Enter  First Name");
							dto.setfName(sc.next());
							System.out.println("Enter  Last Name");
							dto.setlNAme(sc.next());
							System.out.println("Enter  Roll Number");
							dto.setRollNo(Integer.parseInt(sc.next()));

							System.out.println("Enter  First Language");
							dto.setLanguage(sc.next());
							System.out.println("Enter  FrameWork");
							dto.setFrameWork(sc.next());
							String msg = service.addStudent(dto);
							System.out.println(msg);
							break l2;

						} catch (Exception e) {
							System.out.println("Please enter Valid Info");
						}
					}
					break;
				}

				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5: {
			
					List<StudentDTO> list = service.getAllStudentInfo();
					System.out.println("================       Here Are Your All Records          =====================");

					list.forEach(obj -> {
						System.out.print(obj);
						System.out.println();
					});
					break;

				}
				case 6:
					System.out.println("You are Out Of Program For Service You need to Run Again");
					break l1;

				}

			} catch (Exception e) {
				System.out.println("Please Enter Valid Value ");
			}
		}
	}
}
