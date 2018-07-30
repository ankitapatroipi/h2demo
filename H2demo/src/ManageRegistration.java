

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	/**
	 * 
	 */

	/**
	 * @author bok0
	 *
	 */
	public class ManageRegistration {
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "org.h2.Driver";
		static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";

		// Database credentials
		static final String USER = "scott";
		static final String PASS = "tiger3";

		public static void select() {
			Connection conn = null;
			Statement stmt = null;
			try {
				  conn  = getConnection();

				// STEP 3: Execute a query
				System.out.println("Connected database successfully...");
				stmt = conn.createStatement();
				String sql = "SELECT id, first, last, age FROM Registration";
				ResultSet rs = stmt.executeQuery(sql);

				// STEP 4: Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("id");
					int age = rs.getInt("age");
					String first = rs.getString("first");
					String last = rs.getString("last");

					// Display values
					System.out.print("ID: " + id);
					System.out.print(", Age: " + age);
					System.out.print(", First: " + first);
					System.out.println(", Last: " + last);
				}
				// STEP 5: Clean-up environment
				rs.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("Goodbye!");
		}
		
		
		 public static void update() { 
		      Connection conn = null; 
		      Statement stmt = null; 
		      try { 
		         // STEP 1: Register JDBC driver 
		    	  conn  = getConnection();  
		         
		         // STEP 3: Execute a query 
		         System.out.println("Connected database successfully..."); 
		         stmt = conn.createStatement(); 
		         String sql = "UPDATE Registration " + "SET age = 30 WHERE id in (100, 101)"; 
		         stmt.executeUpdate(sql);  
		         
		         // Now you can extract all the records 
		         // to see the updated records 
		         sql = "SELECT id, first, last, age FROM Registration"; 
		         ResultSet rs = stmt.executeQuery(sql);  
		         
		         while(rs.next()){ 
		            // Retrieve by column name 
		            int id  = rs.getInt("id"); 
		            int age = rs.getInt("age"); 
		            String first = rs.getString("first"); 
		            String last = rs.getString("last");  
		            
		            // Display values 
		            System.out.print("ID: " + id); 
		            System.out.print(", Age: " + age); 
		            System.out.print(", First: " + first); 
		            System.out.println(", Last: " + last); 
		         } 
		         rs.close();    
		      } catch(SQLException se) { 
		         // Handle errors for JDBC 
		         se.printStackTrace(); 
		      } catch(Exception e) { 
		         // Handle errors for Class.forName 
		         e.printStackTrace(); 
		      } finally { 
		         // finally block used to close resources  
		         try { 
		            if(stmt!=null) stmt.close(); 
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         } // end finally try 
		      } // end try 
		      System.out.println("Goodbye!"); 
		   } 
		 
		 public static void delete() { 
		      Connection conn = null; 
		      Statement stmt = null; 
		      try { 
		         // STEP 1: Register JDBC driver 
		        
		    	  conn  = getConnection();
		         // STEP 3: Execute a query
		         System.out.println("Creating table in given database..."); 
		         stmt = conn.createStatement();  
		         String sql = "DELETE FROM Registration " + "WHERE id = 101"; 
		         stmt.executeUpdate(sql);  
		         
		         // Now you can extract all the records 
		         // to see the remaining records 
		         sql = "SELECT id, first, last, age FROM Registration"; 
		         ResultSet rs = stmt.executeQuery(sql);  
		         
		         while(rs.next()){ 
		            // Retrieve by column name 
		            int id  = rs.getInt("id"); 
		            int age = rs.getInt("age"); 
		            String first = rs.getString("first"); 
		            String last = rs.getString("last");  
		            
		            // Display values 
		            System.out.print("ID: " + id); 
		            System.out.print(", Age: " + age); 
		            System.out.print(", First: " + first); 
		            System.out.println(", Last: " + last); 
		         } 
		         rs.close(); 
		      } catch(SQLException se) { 
		         // Handle errors for JDBC 
		         se.printStackTrace();  
		      } catch(Exception e) { 
		         // Handle errors for Class.forName 
		         e.printStackTrace(); 
		      } finally { 
		         // finally block used to close resources 
		         try { 
		            if(stmt!=null) stmt.close(); 
		         } catch(SQLException se2) { 
		         } // nothing we can do 
		         try { 
		            if(conn!=null) conn.close(); 
		         } catch(SQLException se) { 
		            se.printStackTrace(); 
		         } // end finally try
		      } // end try 
		      System.out.println("Goodbye!"); 
		   } 
		 
		  public static Connection getConnection()
		  {
			  Connection conn = null;
			  try {
				Class.forName(JDBC_DRIVER);
				  // STEP 2: Open a connection 
		         System.out.println("Connecting to database..."); 
		         conn =  DriverManager.getConnection(DB_URL,USER,PASS);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		         return conn;
		       
		  }

	}


