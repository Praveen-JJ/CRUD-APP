package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import com.abc.pojo.Student;
import com.abc.utility.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String save(Student student) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtil.getDBConnection();
			if (connection != null) {
				String SQL_INSERT_QUERY = "INSERT INTO STUDENT(SNAME,SAGE,SADDRESS) VALUES (?,?,?)";
				prepareStatement = connection.prepareStatement(SQL_INSERT_QUERY);
			}

			if (prepareStatement != null) {
				prepareStatement.setString(1, student.getSname());
				prepareStatement.setInt(2, student.getSage());
				prepareStatement.setString(3, student.getSaddress());

				int executeUpdate = prepareStatement.executeUpdate();
				if (executeUpdate > 0) {
					return "Row inserted successfully...";
				}

			}

		} catch (SQLException se) {
			// Step4 => Handling the SQLException object if generated
			if (se.getErrorCode() == 1406)
				System.out.println("Data too long for column");
			else if (se.getErrorCode() == 1062)
				System.out.println("Duplicate primary key value");
			else if (se.getErrorCode() == 1136)
				System.out.println("Insufficent values supplied by the user...");
			else if (se.getErrorCode() == 1064)
				System.out.println("Syntax error in SQL");
			else
				se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, prepareStatement, connection);
		}
		return "Insertion failed";
	}

	@Override
	public Student getStudentById(int id) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getDBConnection();
			if (connection != null) {
				String SQL_SELECT_QUERY = "SELECT SNAME,SAGE,SADDRESS FROM STUDENT WHERE SID=?";
				prepareStatement = connection.prepareStatement(SQL_SELECT_QUERY);
			}

			if (prepareStatement != null) {
				prepareStatement.setInt(1, id);

				resultSet = prepareStatement.executeQuery();

				if (resultSet != null) {
					if (resultSet.next()) {
						Student student = new Student();
						student.setSid(id);
						student.setSname(resultSet.getString(1));
						student.setSage(resultSet.getInt(2));
						student.setSaddress(resultSet.getString(3));
						return student;
					}
				}

			}

		} catch (SQLException se) {
			// Step4 => Handling the SQLException object if generated
			if (se.getErrorCode() == 1406)
				System.out.println("Data too long for column");
			else if (se.getErrorCode() == 1062)
				System.out.println("Duplicate primary key value");
			else if (se.getErrorCode() == 1136)
				System.out.println("Insufficent values supplied by the user...");
			else if (se.getErrorCode() == 1064)
				System.out.println("Syntax error in SQL");
			else
				se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(resultSet, prepareStatement, connection);
		}
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = JdbcUtil.getDBConnection();
			if (connection != null) {

				String SQL_UPDATE_QUERY = "UPDATE STUDENT SET SNAME=?,SAGE=?,SADDRESS=? where SID =?";
				prepareStatement = connection.prepareStatement(SQL_UPDATE_QUERY);

			}

			if (prepareStatement != null) {

				// Setting the inputs
				prepareStatement.setString(1, student.getSname());
				prepareStatement.setInt(2, student.getSage());
				prepareStatement.setString(3, student.getSaddress());
				prepareStatement.setInt(4, student.getSid());

				prepareStatement.executeUpdate();
				return "Updated succefully....";
			}

		} catch (SQLException se) {
			// Step4 => Handling the SQLException object if generated
			if (se.getErrorCode() == 1406)
				System.out.println("Data too long for column");
			else if (se.getErrorCode() == 1062)
				System.out.println("Duplicate primary key value");
			else if (se.getErrorCode() == 1136)
				System.out.println("Insufficent values supplied by the user...");
			else if (se.getErrorCode() == 1064)
				System.out.println("Syntax error in SQL");
			else
				se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, prepareStatement, connection);
		}
		return "updation failed";

	}

	@Override
	public String deleteStudentById(int id) {

		Connection connection = null;
		PreparedStatement prepareStatement = null;

		if (getStudentById(id) == null) {
			return "Record not available to perform delete for id: " + id;
		} else {
			try {
				connection = JdbcUtil.getDBConnection();
				if (connection != null) {
					String SQL_DELETE_QUERY = "DELETE FROM STUDENT WHERE SID=?";
					prepareStatement = connection.prepareStatement(SQL_DELETE_QUERY);
				}

				if (prepareStatement != null) {
					prepareStatement.setInt(1, id);

					prepareStatement.executeUpdate();
				}

			} catch (SQLException se) {
				// Step4 => Handling the SQLException object if generated
				if (se.getErrorCode() == 1406)
					System.out.println("Data too long for column");
				else if (se.getErrorCode() == 1062)
					System.out.println("Duplicate primary key value");
				else if (se.getErrorCode() == 1136)
					System.out.println("Insufficent values supplied by the user...");
				else if (se.getErrorCode() == 1064)
					System.out.println("Syntax error in SQL");
				else
					se.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(null, prepareStatement, connection);
			}

		}
		return "Record deleted successfully...";
	}

	@Override
	public Set<Student> displayTable() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Set<Student> tableSet= new LinkedHashSet<Student>();
		try {
			connection = JdbcUtil.getDBConnection();
			if (connection != null) {
				statement = connection.createStatement();
			}

			if (statement != null) {
				String SQL_SELECT_ALL_QUERY = "SELECT SID, SNAME, SAGE, SADDRESS FROM STUDENT";
				resultSet = statement.executeQuery(SQL_SELECT_ALL_QUERY);
			}
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSaddress(resultSet.getString(4));
				tableSet.add(student);
			}
			
			return tableSet;

		} catch (SQLException se) {
			// Step4 => Handling the SQLException object if generated
			if (se.getErrorCode() == 1406)
				System.out.println("Data too long for column");
			else if (se.getErrorCode() == 1062)
				System.out.println("Duplicate primary key value");
			else if (se.getErrorCode() == 1136)
				System.out.println("Insufficent values supplied by the user...");
			else if (se.getErrorCode() == 1064)
				System.out.println("Syntax error in SQL");
			else
				se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(resultSet, statement, connection);
		}
		return null;
	}

}
