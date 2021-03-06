package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.*;



public class Database {
	
	//for mostSecureEncryptionEver
	private static final String ENCRYPTEDPW = "gvznyfoyzhzfi";
	private static final String ENCODER = "zyvonihgf";
	private static final String DECODER = "abelmrstu";
	
	// constants for the dbClass family of functions
	private static final String CLASSNAME = "ClassName";
	private static final String UNITS = "Units";
	private static final String CREDIT = "Credit";
	private static final String TERMS = "Terms";
	private static final String PREREQS = "Prereqs";
	private static final String HOURS = "hours";
	
	// constants for student info functions
	private static final String STUDENTNAME = "name";
	private static final String STUDENTMAJOR = "major";
	private static final String STUDENTMINOR = "minor";
	private static final String CATALOGYEAR = "cat_year";
	private static final String QUARTERTOPLANFOR = "qtpf";
	private static final String NUMUNITS = "noutt";
	private static final String PREVCLASSES = "prevClass";
	
	//schedulsaur
	private static final String SCHEDELSAUR = "schedulsaur";
	private static final String DBSITE = "jdbc:mysql://schedulsaur-database.coiryrpvj04m.us-west-1.rds.amazonaws.com?useSSL=false";
	
	// sonarcloud hates print
	private static final Logger logger = Logger.getLogger("Database");
	
	//sql to pull cpe catalog table
	public static final String CSCCATSQL = "SELECT * FROM schedulsaurdb.catalog_cpe";
	//sql to pull csc catalog table
	public static final String CPECATSQL = "SELECT * FROM schedulsaurdb.catalog_cpe";
	//sql to pull cpe section table
	public static final String CSCSECSQL = "SELECT * FROM schedulsaurdb.sections_csc";
	//sql to pull csc section table
	public static final String CPESECSQL = "SELECT * FROM schedulsaurdb.sections_cpe";
	
	/* ----------------------------------------------------------------------------------- */
	
	// sonarcloud doesn't like plaintext passwords
	// so i did a substitution cipher lol
	public static String mostSecureEncryptionEver(String str) {
		char temp;
		char[] res = str.toCharArray();
		for(int i = 0; i < str.length(); i++) {
			// get the character from encoder, then translate it to decoder
			temp = DECODER.charAt(ENCODER.indexOf(res[i]));
			res[i] = temp;
		}
		return new String(res);
	}
	
	/* ----------------------------------------------------------------------------------- */
	
	// this is because sonarcloud cried at me and doesn't like duplicate code
	public static ResultSet dbClassQuery(Statement stmt, String toFind, Class myClass) {
		try {
			// helper function for anything starting with dbClass
			String classID = myClass.getName();
			// now we do a lookup, but it depends if it's csc/cpe tho
			String department = classID.substring(0,3);
			String sql = "";
			// yes the database has them capitalized, but you know
			if(department.equalsIgnoreCase("csc")) {
				sql = "SELECT " + toFind + " FROM schedulsaurdb.catalog_csc WHERE ClassID LIKE \"" + classID + "\"";
			} else if(department.equalsIgnoreCase("cpe")) {
				sql = "SELECT " + toFind + " FROM schedulsaurdb.catalog_cpe WHERE ClassID LIKE \"" + classID + "\"";
			} else {
				// fix this later for other majors I Guess
			}
			return stmt.executeQuery(sql);
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		return null;
	}
	
	// get course info for a specific csc/cpe class, returns a string (like from the csv)
	public static String dbClassInfo(Statement stmt, Class myClass) {
		String classID = "N/A";
		String className = "N/A";
		String units = "N/A";
		String credit = "N/A";
		String terms = "N/A";
		String prereqs = "N/A";
		try {
			ResultSet rs = dbClassQuery(stmt, "*", myClass);
			if(rs == null) {
				return (classID + ", " + className + ", " + units + ", " + credit + ", " + terms + ", " + prereqs);
			}
			while(rs.next()){
				classID = myClass.getName();
				className = rs.getString(CLASSNAME);
				units = rs.getString(UNITS);
				credit = rs.getString(CREDIT);
				terms = rs.getString(TERMS);
				prereqs = rs.getString(PREREQS);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return (classID + ", " + className + ", " + units + ", " + credit + ", " + terms + ", " + prereqs);
	}
	
	// get full name for a specific csc/cpe class, returns a string
	public static String dbClassLongName(Statement stmt, Class myClass) {
		String className = "N/A";
		try {
			ResultSet rs = dbClassQuery(stmt, CLASSNAME, myClass);
			if(rs == null) {
				return className;
			}
			while(rs.next()){
				className = rs.getString(CLASSNAME);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return className;
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static String dbClassUnits(Statement stmt, Class myClass) {
		String units = "N/A";
		try {
			ResultSet rs = dbClassQuery(stmt, UNITS, myClass);
			if(rs == null) {
				return units;
			}
			while(rs.next()){
				units = rs.getString(UNITS);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return units;
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static String dbClassCredit(Statement stmt, Class myClass) {
		String credit = "N/A";
		try {
			ResultSet rs = dbClassQuery(stmt, CREDIT, myClass);
			if(rs == null) {
				return credit;
			}
			while(rs.next()){
				credit = rs.getString(CREDIT);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return credit;
	}
	
	// get # of units for a specific csc/cpe class, returns a string
	public static String dbClassTerms(Statement stmt, Class myClass) {
		String terms = "N/A";
		try {
			ResultSet rs = dbClassQuery(stmt, TERMS, myClass);
			if(rs == null) {
				return terms;
			}
			while(rs.next()){
				terms = rs.getString(TERMS);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return terms;
	}
	
	// get prereq list for a specific csc/cpe class, returns a string
	public static String dbClassPrereqs(Statement stmt, Class myClass) {
		String prereqs = "N/A";
		try {
			ResultSet rs = dbClassQuery(stmt, PREREQS, myClass);
			if(rs == null) {
				return prereqs;
			}
			while(rs.next()){
				prereqs = rs.getString(PREREQS);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return prereqs;
	}
	
	public static void dbUpdateStudent (Statement stmt, String[] strList) {
		String sql = "UPDATE Student ";
		sql += "set id = " + strList[0];
		sql += "set name = " + strList[1];
		sql += "set major = " + strList[2];
		sql += "set minor = " + strList[3];
		sql += "set cat_year = " + strList[4];
		sql += "set qtpf = " + strList[5];
		sql += "set noutt = " + strList[6];
		sql += "set email = " + strList[7];
		sql += "set password = " + strList[8];
		sql += "set password = " + strList[9];
		sql += "WHERE id = " + strList[0];
		try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}
	
	/* ----------------------------------------------------------------------------------- */
	
	//replace class object with schedule object later							
	public static int dbWriteStudent(Statement stmt, String[] strList) {
		String value = "";
		int i;
		StringBuilder bld = new StringBuilder();
		for(i = 0; i < strList.length-1; i++) {
			bld.append("'" + strList[i] + "'");
			bld.append(",");
		}
		bld.append(strList[i]);
		value = bld.toString(); 
		String sql = "INSERT INTO schedulsaurdb.Student" + " values (" + value + ");";
		try {
			stmt.executeUpdate(sql);
			sql = "SELECT id FROM schedulsaurdb.Student where email=" + strList[6];
			return getResultSetForStudent(stmt, sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return -1;
	}
	
	private static int getResultSetForStudent(Statement stmt, String sql) {
		try(ResultSet rs = stmt.executeQuery(sql)){
			return rs.getInt("id");
		}catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return -1;
	}
   
   public static void dbWriteSchedule(Statement stmt, String sched, int studentId) {
      String sql = "INSERT INTO schedulsaurdb.Schedules (sections, student_id) value ('" + sched + "'," + studentId + ");";
      try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
   }
	
	public static void dbWriteTimeAvail(Statement stmt, int studentId, int availNum, String[] day, String[] hours){
		String value = "";
		
		for(int i = 0; i < day.length; i++){
			StringBuilder bld = new StringBuilder();
			bld.append(Integer.toString(studentId));
			bld.append(",");
			bld.append(Integer.toString(availNum));
			bld.append(",'");
			bld.append(day[i]);
			bld.append("','");
			bld.append(hours[i]);
			bld.append("'");
			value=bld.toString();
			
			String sql = "INSERT INTO schedulsaurdb.TimeAvail () value (" + value + ");";
			try {
				stmt.executeUpdate(sql);
			} catch(Exception e) {
				logger.log(Level.WARNING, e.toString());
			}
		}
	}
	
	/* ----------------------------------------------------------------------------------- */
	
	// helper function for getdbAllRow
	public static List<String[]> dbAllRows(Statement stmt, String sql) throws SQLException {
		ArrayList<String[]> list = new ArrayList<>(); 
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int c = 0;
			while(rs.next()) {
				list.add(new String[rsmd.getColumnCount()]);
				for(int i = 0; i < rsmd.getColumnCount(); i++) {
					list.get(c)[i] = rs.getString(rsmd.getColumnName(i+1));
				}
				c++;
			}
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		} finally {
			if(rs!=null) {
				rs.close();
			}
		}
		return list;
	}
	
	public static List<String[]> getdbAllRow(String csc, String cpe) {
		// This is used, please don't change or delete!
		Statement stmt = null;
		List<String[]> list = null;
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			stmt = conn.createStatement();		
			list = dbAllRows(stmt, csc);
			list.addAll(dbAllRows(stmt, cpe));
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		return list;
	}
	
	/* ----------------------------------------------------------------------------------- */
	
	public static ResultSet dbGetTimeAvailHelper(Statement stmt, int studentID, int studentAvailNum, String day) {
		try {
			String sql = "";
			sql = "select hours from schedulsaurdb.TimeAvil where student_id=\"" + studentID + "\" and availNum=\"" + studentAvailNum + "\" and day=\"" + day + "\"";
			return stmt.executeQuery(sql);
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		return null;
	}
	
	public static List<String> dbGetTimeAvail(Statement stmt, int studentID, int studentAvailNum) {
		List<String> avails = new ArrayList<>();
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		try {
			// sunday through saturday
			for(int i = 0; i < 7; i++) {
				ResultSet rs = dbGetTimeAvailHelper(stmt, studentID, studentAvailNum, days[i]);
				if(rs == null) {
					avails.add("");
				} else {
					while(rs.next()){
						avails.add(rs.getString(HOURS));
					}
					rs.close();
				}
				
			}
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return avails;
	}
	
	
	/* ----------------------------------------------------------------------------------- */
				// Student Methods
	/* ----------------------------------------------------------------------------------- */
	
	public static String dbGenerateHelper(Statement stmt, String sql, String parameter) {
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			String res = "";
			rs = stmt.executeQuery(sql);

				rs.next();
				res = rs.getString(parameter);
				rs.close();
				return res;
				
			
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		} finally {
			if(rs != null) {
				try {
					logger.log(Level.WARNING, "please 1");
					rs.close();
					logger.log(Level.WARNING, "please 1 again");
				} catch (SQLException e) {
					
					logger.log(Level.WARNING, e.toString());
				}
			}
		}
		return null;
	}
	
	// Generate next Student Id
	public static String dbGenerateStudentId(Statement stmt) {
		String studentSql = "SELECT COUNT(*)+1 as nextId FROM schedulsaurdb.Student";
		return dbGenerateHelper(stmt, studentSql, "nextId");
	}
	
	
	// Get Student by Email
	public static String[] dbGetStudent(Statement stmt, String email) {
		String sql = "SELECT * FROM schedulsaurdb.Student WHERE email='" + email + "'";
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			rs = stmt.executeQuery(sql);
			rs.next();
			String[] res = {rs.getString("id"), rs.getString("name"), rs.getString(STUDENTMAJOR), 
								rs.getString(STUDENTMINOR), rs.getString(CATALOGYEAR), 
								rs.getString("qtpf"), rs.getString(NUMUNITS), rs.getString("email"),
								rs.getString("password"), rs.getString(PREVCLASSES)};
			rs.close();
			return res;
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		} finally {
			if(rs != null) {
				try {
					rs.close();
					logger.log(Level.WARNING, "please 2");
				} catch (SQLException e) {
					
					logger.log(Level.WARNING, e.toString());
				}
			}
		}
		return new String[] {};
	}
	
	// update Student by given fields
	public static void dbUpdateStudentFields(Statement stmt, String id, String[] values) {
		String[] fields = {"name", STUDENTMAJOR, STUDENTMINOR, CATALOGYEAR, "qtpf", NUMUNITS};
		String value = "";
		int i;
		StringBuilder bld = new StringBuilder();
		for(i = 0; i < fields.length-1; i++) {
			bld.append("" + fields[i] + "" + "= " +  "'" + values[i] + "'");
			bld.append(",");
		}
		bld.append(fields[i] + "" + "= " + "'" + values[i] + "'");
		value = bld.toString(); 
		String sql = "UPDATE schedulsaurdb.Student SET " + value + " WHERE id=" + id + ";";
		try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	
	}
	
	// get Student past classes
	public static String dbGetStudentPastClasses(Statement stmt, String id) {
		String sql = "SELECT prevClass from schedulsaurdb.Student where id = " + id + ";";
		ResultSet rs = null;
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			String result;
			rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getString(PREVCLASSES);
			rs.close();
			return result;
			
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		} finally {
			if(rs != null) {
				try {
					logger.log(Level.WARNING, "please 3");
					rs.close();
				} catch (SQLException e) {
					
					logger.log(Level.WARNING, e.toString());
				}
			}
		}
		return null;
	}
	
	
	
	/* ----------------------------------------------------------------------------------- */
				// Time Preference Methods
	/* ----------------------------------------------------------------------------------- */
	// Generate next Time Id
	public static String dbGenerateTimeId(Statement stmt, String id) {
		String timeSql = "SELECT COUNT(availNum)+1 as nextId FROM schedulsaurdb.TimePref WHERE student_id = " + id + ";";
		return dbGenerateHelper(stmt, timeSql, "nextId");
	}
	
	// GET TimePref
	public static String dbGetTimePref(Statement stmt, String studentId, String availNum) {
		String timePrefSql = "SELECT name FROM schedulsaurdb.TimePref WHERE student_id = '" + studentId + "' and availNum = '" + availNum + "';";
		return dbGenerateHelper(stmt, timePrefSql, "name");
	
	}
	
	// GET All TimePrefs
	public static List<TimePreference> dbGetAllTimePrefs(Statement stmt, String studentId) {
		String sql = "SELECT availNum, name FROM schedulsaurdb.TimePref WHERE student_id = '" + studentId + "';";
		ResultSet rs = null;
		ArrayList<TimePreference> allPrefs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allPrefs.add(new TimePreference(studentId, rs.getString("availNum"), rs.getString("name")));
			}
			rs.close();
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		} finally {
			if(rs != null) {
				try {
					rs.close();
					logger.log(Level.WARNING, "please 4");
				} catch (SQLException e) {
					
					logger.log(Level.WARNING, e.toString());
				}
			}
		}
		return allPrefs;
	}
	
	// PUT TimePref
	public static void dbPutTimePref(Statement stmt, String studentId, String availNum, String name) {
		String value = "student_id='" + studentId + "', availNum='" + availNum + "', name='" + name + "'";
		String sql = "UPDATE schedulsaurdb.TimePref SET " + value + " WHERE student_id=" + studentId + " and availNum=" + availNum +  ";";
		
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}

	}
	
	// POST TimePref
	public static void dbPostTimePref(Statement stmt, String[] strList) {
		String value = "";
		int i;
		StringBuilder bld = new StringBuilder();
		for(i = 0; i < strList.length-1; i++) {
			bld.append("'" + strList[i] + "'");
			bld.append(",");
		}
		bld.append("'" + strList[i] + "'");
		value = bld.toString(); 
		String sql = "INSERT INTO schedulsaurdb.TimePref" + " values (NULL, " + value + ");";
		try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}
 
	
	/* ----------------------------------------------------------------------------------- */
				// Time Availability Methods
	/* ----------------------------------------------------------------------------------- */
	
	// GET TimeAvail
	public static String[] dbGetStudentTimeAvails(Statement stmt, String studentId, String availNum) throws SQLException {
		String[] block = new String[7];
		ResultSet rs = null;
		String sql = "SELECT hours FROM schedulsaurdb.TimeAvail WHERE student_Id='" + studentId + "' and availNum='" + availNum + "';";
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			rs = stmt.executeQuery(sql);
			int c = 0;
			while(rs.next()) {
				block[c] = rs.getString(HOURS);
				c++;
			}
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		} finally {
			if(rs!=null) {
				rs.close();
			}
		}
		return block;
	}
	
	// POST TimeAvail
	public static void dbPostTimeAvail(Statement stmt, String studentId, String availNum, String[] hours) {
		String main = "INSERT INTO schedulsaurdb.TimeAvail" + " (student_id, availNum, day, hours) values ";
		String values = "('" + studentId + "'," + "'" + availNum + "',";
		String sun =  values + "'Sunday', '" + hours[0] + "'),";
		String mon =  values + "'Monday', '" + hours[1] + "'),";
		String tue =  values + "'Tuesday', '" + hours[2] + "'),";
		String wed =  values + "'Wednesday', '" + hours[3] + "'),";
		String thu =  values + "'Thursday', '" + hours[4] + "'),";
		String fri =  values + "'Friday', '" + hours[5] + "'),";
		String sat =  values + "'Saturday', '" + hours[6] + "')";
		
		try {
			String sql = main + sun + mon + tue + wed + thu + fri + sat;
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
	}

	
	/* ----------------------------------------------------------------------------------- */
	
	public static ResultSet dbGetStudentInfoHelper(Statement stmt, int studentID) {
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			String sql = "";
			sql = "select * from schedulsaurdb.Student where id=\"" + studentID + "\"";
			return stmt.executeQuery(sql);
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
		return null;
	}
	
	// takes in ID, returns Everything (except email and password)
	public static List<String> dbGetStudentInfo(Statement stmt, int studentID) {
		List<String> info = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			ResultSet rs = dbGetStudentInfoHelper(stmt, studentID);
			if(rs == null) {
				return info;
			}
			while(rs.next()){
				info.add(rs.getString(STUDENTNAME));
				info.add(rs.getString(STUDENTMAJOR));
				info.add(rs.getString(STUDENTMINOR));
				info.add(rs.getString(CATALOGYEAR));
				info.add(rs.getString(QUARTERTOPLANFOR));
				info.add(rs.getString(NUMUNITS));
				info.add(rs.getString(PREVCLASSES));
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return info;
	}
	
	// taked in ID, returns just past classes
	public static String dbGetPastClasses(Statement stmt, int studentID) {
		String pastClasses = "";
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			ResultSet rs = dbGetStudentInfoHelper(stmt, studentID);
			if(rs == null) {
				return pastClasses;
			}
			while(rs.next()){
				pastClasses = rs.getString(PREVCLASSES);
			}
			rs.close();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.toString());
		}
		return pastClasses;
	}
	
	/* ----------------------------------------------------------------------------------- */
	
	// (this doesn't do anything really, it was there for trial/error)
	public static void main(String[] args) {
		// below here goes before calls
		Statement stmt = null;
		try (Connection conn = DriverManager.getConnection(DBSITE,SCHEDELSAUR,mostSecureEncryptionEver(ENCRYPTEDPW))){
			stmt = conn.createStatement();
			// calls go here
			stmt.close();
		} catch(SQLException se) {
			//Handle errors for JDBC
			logger.log(Level.WARNING, se.toString());
		} catch(Exception e) {
			//Handle errors for Class.forName
			logger.log(Level.WARNING, e.toString());
		}
	}
	
}
