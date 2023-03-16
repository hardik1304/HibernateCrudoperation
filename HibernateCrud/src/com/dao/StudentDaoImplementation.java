package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dto.StudentDTO;
import com.hibernate.util.HibernateConnection;

public class StudentDaoImplementation implements IStudentDao {

	public static Session session = null;
	public static Transaction tr = null;

	@Override
	public String addStudent(StudentDTO student) {
		boolean flag = false;

		HibernateConnection con = new HibernateConnection();
		session = con.getSession();

		try {
			if (session != null) {
				tr = session.beginTransaction();
				if (tr != null) {
					session.save(student);

					tr.commit();
					flag = true;
				}
			}

		} catch (Exception e) {

			System.out.println("Exception occured  " + e.toString());
			e.printStackTrace();
		} finally {
			con.closeConnection(session);
		}

		if (flag) {
			return "Record Insert SucessFull ";
		} else {
			return "Record Insert Failed";
		}
	}

	@Override
	public String deleteStudent(int studentId) {

		StudentDTO dto = null;

		HibernateConnection con = new HibernateConnection();
		session = con.getSession();

		try {
			if (session != null) {
				tr = session.beginTransaction();
				if (tr != null) {
					dto = session.get(StudentDTO.class, studentId);

					if (dto != null) {
						session.delete(dto);
						tr.commit();

					}

				}

			}

		} catch (Exception e) {

			System.out.println("Exception occured  " + e.toString());
			e.printStackTrace();
		} finally {
			con.closeConnection(session);
		}
		if (dto != null) {
			return "Delete Success";
		}
		return "Delete Failed";
	}

	@Override
	public StudentDTO getStudentInfo(int studentId) {
		StudentDTO dto = null;

		HibernateConnection con = new HibernateConnection();
		session = con.getSession();

		try {
			if (session != null) {
				dto = session.get(StudentDTO.class, studentId);
			}

		} catch (Exception e) {
			System.out.println("Exception occured  " + e.toString());
			e.printStackTrace();
		} finally {
			con.closeConnection(session);
		}
		return dto;
	}

	@Override
	public String updateStudentInfo(int studentId) {
		String msg = null;
		StudentDTO dto = null;
		Scanner sc = new Scanner(System.in);
		HibernateConnection con = new HibernateConnection();
		session = con.getSession();

		try {
			if (session != null) {
				tr = session.beginTransaction();
				if (tr != null) {
					dto = session.get(StudentDTO.class, studentId);

					if (dto != null) {

						while (true) {
							try {
								System.out.println("Enter New First Name");
								dto.setfName(sc.next());
								System.out.println("Enter New Last Name");
								dto.setlNAme(sc.next());
								System.out.println("Enter New Roll Number");
								dto.setRollNo(Integer.parseInt(sc.next()));

								System.out.println("Enter New First Language");
								dto.setLanguage(sc.next());
								System.out.println("Enter New FrameWork");
								dto.setFrameWork(sc.next());
								session.update(dto);
								tr.commit();
								msg = "Record Update Sucessfull";
								break;
							} catch (Exception e) {
								System.out.println("Please enter Valid Info");
							}
						}

					}

				}

			}

		} catch (Exception e) {

			System.out.println("Exception occured  " + e.toString());
			e.printStackTrace();
		} finally {
			con.closeConnection(session);
		}
		sc.close();
		return msg;
	}

	@Override
	public List<StudentDTO> getAllStudentInfo() {
		// TODO Auto-generated method stub

		HibernateConnection con = new HibernateConnection();
		session = con.getSession();
		List<StudentDTO> list = null;

		try {
			if (session != null) {
				Query<StudentDTO> q = session.createQuery("From com.dto.StudentDTO");

				list = q.list();

			}
		} catch (Exception e) {
			System.out.println("Errro is " + e.toString());
		} finally {
			con.closeConnection(session);
		}
		return list;

	}

}
