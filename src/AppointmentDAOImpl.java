import java.sql.*;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public void addAppointment(AppointmentDTO a) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO appointments(patient_name, doctor_name, department, appointment_date, appointment_time) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getPatientName());
            ps.setString(2, a.getDoctorName());
            ps.setString(3, a.getDepartment());
            ps.setDate(4, a.getAppointmentDate());
            ps.setTime(5, a.getAppointmentTime());
            ps.executeUpdate();
            System.out.println("Appointment booked successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewAppointments() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM appointments");

            System.out.println("ID | Patient | Doctor | Dept | Date | Time");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("appointment_id") + " | " +
                    rs.getString("patient_name") + " | " +
                    rs.getString("doctor_name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDate("appointment_date") + " | " +
                    rs.getTime("appointment_time")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchByDoctor(String doctorName) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM appointments WHERE doctor_name=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, doctorName);
            ResultSet rs = ps.executeQuery();

            System.out.println("ID | Patient | Date | Time");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("appointment_id") + " | " +
                    rs.getString("patient_name") + " | " +
                    rs.getDate("appointment_date") + " | " +
                    rs.getTime("appointment_time")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelAppointment(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM appointments WHERE appointment_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0)
                System.out.println("Appointment cancelled");
            else
                System.out.println("Appointment not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
