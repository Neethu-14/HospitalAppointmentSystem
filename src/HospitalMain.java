import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class HospitalMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentService service = new AppointmentService();
        int choice;

        do {
            System.out.println("\n===== Hospital Appointment System =====");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Search by Doctor");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Patient Name: ");
                    String patient = sc.nextLine();

                    System.out.print("Doctor Name: ");
                    String doctor = sc.nextLine();

                    System.out.print("Department: ");
                    String department = sc.nextLine();

                    System.out.print("Date (yyyy-mm-dd): ");
                    String dateStr = sc.nextLine();
                    Date appointmentDate = Date.valueOf(dateStr);

                    System.out.print("Time (HH:mm, 24-hour format): ");
                    String timeStr = sc.nextLine();
                    Time appointmentTime = Time.valueOf(timeStr + ":00"); // convert to java.sql.Time

                    // Book the appointment using the service
                    service.book(patient, doctor, department, appointmentDate, appointmentTime);
                    break;

                case 2:
                    System.out.println("\nAll Appointments:");
                    service.view();
                    break;

                case 3:
                    System.out.print("Doctor Name to search: ");
                    String docName = sc.nextLine();
                    service.searchDoctor(docName);
                    break;

                case 4:
                    System.out.print("Appointment ID to cancel: ");
                    int id = sc.nextInt();
                    service.cancel(id);
                    sc.nextLine(); // consume newline
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
