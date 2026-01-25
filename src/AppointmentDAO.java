public interface AppointmentDAO {
    void addAppointment(AppointmentDTO a);
    void viewAppointments();
    void searchByDoctor(String doctorName);
    void cancelAppointment(int id);
}
