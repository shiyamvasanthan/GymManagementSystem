import java.sql.*;

public class Main {
    String url = "jdbc:postgresql://localhost:5432/Assignment3Question1";
    String user = "postgres";
    String password = "shiyam";

    //Display the records from students table
    public void getAllStudents()
    {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeQuery("SELECT * FROM students");
                ResultSet resultSet = statement.getResultSet();

                while(resultSet.next())
                {
                    String student_id = resultSet.getString("student_id");
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String enrollment_date = resultSet.getString("enrollment_date");

                    System.out.println(student_id + " " + first_name + " " + last_name + " " + email + " " + enrollment_date);
                }

                resultSet.close();
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Add a new student into the students table
    public void addStudent(String first_name, String last_name, String email,
                           String enrollment_date)
    {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES ('" + first_name + "','" + last_name + "','" + email + "','" + enrollment_date + "')");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Update the student email given the student id
    public void updateStudentEmail(int student_id, String new_email){
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE students SET email=" + "'" + new_email + "'" + " WHERE student_id=" + student_id + "");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Delete the student with the given student_id
    public void deleteStudent(int student_id)
    {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM students WHERE student_id=" + student_id + "");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        //Call application functions here
        //For example main.GetAllStudents()
    }
}
