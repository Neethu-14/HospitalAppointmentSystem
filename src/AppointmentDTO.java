import java.sql.Date;
import java.sql.Time;

public class AppointmentDTO {
    private String patientName;
    private String doctorName;
    private String department;
    private Date appointmentDate;
    private Time appointmentTime;  // new field

    public AppointmentDTO(String patientName, String doctorName, String department,
                          Date appointmentDate, Time appointmentTime) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.department = department;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    // Getters
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDepartment() { return department; }
    public Date getAppointmentDate() { return appointmentDate; }
    public Time getAppointmentTime() { return appointmentTime; }
}
