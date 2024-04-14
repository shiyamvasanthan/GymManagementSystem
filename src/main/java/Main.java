import java.sql.*;
import java.util.Scanner;

public class Main {
    static String url = "jdbc:postgresql://localhost:5432/FinalProject";
    static String user = "postgres";
    static String password = "shiyam";

    //Function that handles user registration
    public static void userRegistration(Scanner scanner) {
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();

        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your weight goal (in lbs):");
        int weightGoal = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your time goal (YYYY-MM-DD):");
        String timeGoal = scanner.nextLine();

        System.out.println("Please enter your resting heart rate (beats per minute):");
        int heartRate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your BMI:");
        int bmi = scanner.nextInt();
        scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO Members (email_id, member_name, weight_goal, time_goal, heart_rate, bmi) VALUES ('" + email + "','" + name + "'," + weightGoal + ",'" + timeGoal + "', " + heartRate + ", " + bmi + ")");
                statement.executeUpdate("INSERT INTO Dashboard (email_id, exercise_routines, achievements, stats) VALUES ('" + email + "', NULL, NULL, NULL)");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles profile management
    public static void profileManagement(Scanner scanner) {
        System.out.println("Please enter the email so we can update the info:");
        String email = scanner.nextLine();

        System.out.println("Please enter your new name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your new weight goal (in lbs):");
        int weightGoal = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your new time goal (YYYY-MM-DD):");
        String timeGoal = scanner.nextLine();

        System.out.println("Please enter your new resting heart rate (beats per minute):");
        int heartRate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your new BMI:");
        int bmi = scanner.nextInt();
        scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE Members SET member_name = '" + name + "', weight_goal = " + weightGoal + ", time_goal = '" + timeGoal + "', heart_rate = " + heartRate + ", bmi = " + bmi + " WHERE email_id = '" + email + "'");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles dashboard display
    public static void dashboardDisplay() {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeQuery("SELECT * FROM dashboard");
                ResultSet resultSet = statement.getResultSet();

                while(resultSet.next())
                {
                    String email_id = resultSet.getString("email_id");
                    String exercise_routines = resultSet.getString("exercise_routines");
                    String achievements = resultSet.getString("achievements");
                    String stats = resultSet.getString("stats");

                    System.out.println("Email: " + email_id + " Exercise routine: " + exercise_routines + " Achievements: " + achievements + " Stats: " + stats);
                }

                resultSet.close();
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles trainer schedule managment
    public static void trainerScheduleManagement(Scanner scanner)
    {
        System.out.println("Please enter the trainer id:");
        int trainerId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the time you are available for:");
        String availableTime = scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE Trainer SET available_time = '" + availableTime +  "' WHERE trainer_id = " + trainerId + "");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles member profile viewing
    public static void memberProfileViewing(Scanner scanner)
    {
        System.out.println("Please enter the member name:");
        String memberName = scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeQuery("SELECT * FROM Members WHERE member_name = '" + memberName + "'");
                ResultSet resultSet = statement.getResultSet();

                while(resultSet.next())
                {
                    String email_id = resultSet.getString("email_id");
                    String member_name = resultSet.getString("member_name");
                    int weight_goal = resultSet.getInt("weight_goal");
                    String time_goal = resultSet.getString("time_goal");
                    int heart_rate = resultSet.getInt("heart_rate");
                    int bmi = resultSet.getInt("bmi");

                    System.out.println("Email: " + email_id + " Member Name: " + member_name + " Weight goal: " + weight_goal + " Time goal: " + time_goal + " Heart rate: " + heart_rate + " BMI: " + bmi);
                }

                resultSet.close();
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles admin room booking management
    public static void roomBookingManagement(Scanner scanner)
    {
        System.out.println("Please enter the admin id:");
        int adminId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the id of the room to manage:");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO Booking (admin_id, room_id) VALUES (" + adminId + "," + roomId + ")");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles admin equipment maintenance monitoring
    public static void equipmentMaintenanceMonitoring(Scanner scanner)
    {
        System.out.println("Please enter the admin id:");
        int adminId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the equipment id:");
        int equipmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the current quality of this piece of equipment:");
        String quality = scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE Monitor SET quality = '" + quality +  "' WHERE admin_id = " + adminId + " AND equipment_id = " + equipmentId + "");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    //Function that handles admin class schedule updating
    public static void classScheduleUpdating(Scanner scanner)
    {
        System.out.println("Please enter the admin id:");
        int adminId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the class id:");
        int classId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter the new time for this class:");
        String newTime = scanner.nextLine();

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            if(connection != null)
            {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE Updates SET new_time = '" + newTime +  "' WHERE admin_id = " + adminId + " AND class_id = " + classId + "");
            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String role;

        while (true) {
            System.out.println("Welcome to the Gym Management System!");
            System.out.println("Please select your role:");
            System.out.println("1. Member");
            System.out.println("2. Trainer");
            System.out.println("3. Administrator");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    role = "Member";
                    memberMenu(scanner);
                    break;
                case 2:
                    role = "Trainer";
                    trainerMenu(scanner);
                    break;
                case 3:
                    role = "Administrator";
                    adminMenu(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Gym Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void memberMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMember Menu:");
            System.out.println("1. User Registration");
            System.out.println("2. Profile Management");
            System.out.println("3. Dashboard Display");
            System.out.println("4. Schedule Management");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You selected User Registration.");
                    userRegistration(scanner);
                    break;
                case 2:
                    System.out.println("You selected Profile Management.");
                    profileManagement(scanner);
                    break;
                case 3:
                    System.out.println("You selected Dashboard Display.");
                    dashboardDisplay();
                    break;
                case 4:
                    System.out.println("You selected Schedule Management.");
                    break;
                case 5:
                    System.out.println("Returning to Main Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void trainerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nTrainer Menu:");
            System.out.println("1. Schedule Management");
            System.out.println("2. Member Profile Viewing");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You selected Schedule Management.");
                    trainerScheduleManagement(scanner);
                    break;
                case 2:
                    System.out.println("You selected Member Profile Viewing.");
                    memberProfileViewing(scanner);
                    break;
                case 3:
                    System.out.println("Returning to Main Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Room Booking Management");
            System.out.println("2. Equipment Maintenance Monitoring");
            System.out.println("3. Class Schedule Updating");
            System.out.println("4. Billing and Payment Processing");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You selected Room Booking Management.");
                    roomBookingManagement(scanner);
                    break;
                case 2:
                    System.out.println("You selected Equipment Maintenance Monitoring.");
                    equipmentMaintenanceMonitoring(scanner);
                    break;
                case 3:
                    System.out.println("You selected Class Schedule Updating.");
                    classScheduleUpdating(scanner);
                    break;
                case 4:
                    System.out.println("You selected Billing and Payment Processing.");
                    break;
                case 5:
                    System.out.println("Returning to Main Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
