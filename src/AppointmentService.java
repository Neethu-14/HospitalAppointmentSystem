import java.sql.Date;
import java.sql.Time;

public class AppointmentService {
    AppointmentDAO dao = new AppointmentDAOImpl();

    // existing method
    public void book(AppointmentDTO appointment) {
        dao.addAppointment(appointment);
    }

    // overloaded method for convenience (used in HospitalMain)
    public void book(String patientName, String doctorName, String department, Date date, Time time) {
        AppointmentDTO appointment = new AppointmentDTO(patientName, doctorName, department, date, time);
        dao.addAppointment(appointment);
    }

    public void view() {
        dao.viewAppointments();
    }

    public void searchDoctor(String doctorName) {
        dao.searchByDoctor(doctorName);
    }

    public void cancel(int id) {
        dao.cancelAppointment(id);
    }
}
