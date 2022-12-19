import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JFrame frame;
    JButton viewDoctors;
    JButton viewBookings;
    JButton addPatient;
    JButton sortDoctors;
    JLabel mainheading;
    JButton addconsultation;

    JPanel panelmain;
    JPanel panelTop;

    public GUI() {

        new JFrame();

        JPanel panelleft = new JPanel();
        panelleft.setPreferredSize(new Dimension(200, 300));
        panelleft.setBackground(Color.LIGHT_GRAY);

        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1720, 300));
        panelTop.setBackground(Color.WHITE);

        panelmain = new JPanel();
        panelmain.setPreferredSize(new Dimension(800, 100));
        panelmain.setBackground(Color.green);

        JLabel mainheading = new JLabel("Westminster Skin Consultation Manager");
        mainheading.setBounds(55, 25, 220, 50);
        mainheading.setFont(new Font("Verdana", Font.PLAIN, 26));

        viewDoctors = new JButton("View Doctors");
        viewDoctors.setSize(200, 100);

        viewBookings = new JButton("View Bookings");
        viewBookings.setSize(200, 100);
        // viewBookings.addActionListener(this);

        addPatient = new JButton("Add Patient");
        addPatient.setSize(200, 100);

        addconsultation = new JButton("Add consultation");
        addconsultation.setSize(200, 100);

        addPatient.addActionListener(e -> {
            addPatientWindow(getName(), getTitle(), getWarningString(), getName());
        });

        addconsultation.addActionListener(e -> {
            addConsultationWindow();
        });

        panelmain.add(mainheading);
        panelleft.add(viewDoctors);
        panelleft.add(viewBookings);
        panelleft.add(addPatient);
        panelleft.add(addconsultation);

        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelleft, BorderLayout.WEST);
        this.add(panelmain, BorderLayout.NORTH);
        this.add(panelTop, BorderLayout.EAST);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

        SwingTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewBookings) {
            SwingTest();
        }

    }

    void SwingTest() {

        WestminsterSkinConsultationManager wm = new WestminsterSkinConsultationManager();

        JTable table = new JTable();
        table.setBounds(700, 10, 700, 700);
        JScrollPane scroll = new JScrollPane();
        DefaultTableModel model = new DefaultTableModel();

        String headers[] = { "Name", "DOB", "Mobile", "Medical Lic No", "Specialization" };

        model.setColumnIdentifiers(headers);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);

        scroll = new JScrollPane(table);

        Object rowData[] = new Object[5];

        for (int i = 0; i < wm.doctors.size(); i++) {
            rowData[0] = wm.doctors.get(i).getName() + " " + wm.doctors.get(i).getSurname();
            rowData[1] = wm.doctors.get(i).getDOB();
            rowData[2] = wm.doctors.get(i).getMobile();
            rowData[3] = wm.doctors.get(i).getMedicalLicenceNumber();
            rowData[4] = wm.doctors.get(i).getspecialization();

            model.addRow(rowData);

        }

        panelTop.add(scroll);
        this.setVisible(true);

        // sortDoctors = new JButton("Sort Doctors");
        // sortDoctors.setSize(200, 50);
        // // sortDoctors.setBounds(100, 800, 100, 30);
        // panelTop.add(sortDoctors);

    }
    // #######################################################################################################

    public static void addPatientWindow(String name, String initauthor, String initprice, String bId) {
        JFrame addPatientFrame = new JFrame();
        addPatientFrame.setSize(1920, 1080);
        addPatientFrame.setLayout(null);
        addPatientFrame.setVisible(true);

        JLabel main_heading = new JLabel("Add Patient");
        main_heading.setBounds(55, 25, 100, 30);
        addPatientFrame.add(main_heading);

        JPanel panel = new JPanel();
        panel.setBounds(40, 80, 600, 200);
        panel.setBackground(Color.white);

        JLabel id_label = new JLabel("(ON Click Id)");
        id_label.setBounds(700, 750, 100, 30);
        addPatientFrame.add(id_label);
        JTextField bookid = new JTextField("");
        bookid.setBounds(800, 750, 200, 30);
        bookid.setEditable(false);
        bookid.setText(bId);
        addPatientFrame.add(bookid);

        JLabel l_fname = new JLabel("First Name");
        l_fname.setBounds(50, 100, 100, 30);
        addPatientFrame.add(l_fname);
        JTextField t_fname = new JTextField("");
        t_fname.setBounds(250, 100, 200, 30);
        t_fname.setText(name);
        addPatientFrame.add(t_fname);

        JLabel l_suraname = new JLabel("Surname");
        l_suraname.setBounds(50, 150, 100, 30);
        addPatientFrame.add(l_suraname);
        JTextField t_suraname = new JTextField("");
        t_suraname.setBounds(250, 150, 200, 30);
        t_suraname.setText(name);
        addPatientFrame.add(t_suraname);

        addPatientFrame.add(panel);

        JButton save_btn = new JButton("Save");
        save_btn.setBounds(50, 350, 100, 30);
        addPatientFrame.add(save_btn);

    }

    // ############################################################################################
    public void addConsultationWindow() {
        JFrame addConsultationFrame = new JFrame();

        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(1720, 300));
        panelTop.setBackground(Color.WHITE);

        panelmain = new JPanel();
        panelmain.setPreferredSize(new Dimension(800, 100));
        panelmain.setBackground(Color.green);
        panelmain.setVisible(true);

        addConsultationFrame.add(panelmain, BorderLayout.NORTH);
        addConsultationFrame.add(panelTop, BorderLayout.EAST);

        addConsultationFrame.setSize(1920, 1080);
        addConsultationFrame.setLayout(null);
        addConsultationFrame.setVisible(true);

        JTable available_table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        String headers[] = { "id", "lic_no", "date", "start time", "end time" };
        model.setColumnIdentifiers(headers);
        available_table.setModel(model);
        available_table.setBounds(100, 200, 700, 700);
        available_table.setVisible(true);
        // JScrollPane scroll = new JScrollPane();
        // scroll = new JScrollPane(available_table);

        addConsultationFrame.add(available_table);
        this.setVisible(true);

        WestminsterSkinConsultationManager wm = new WestminsterSkinConsultationManager();
        String[] doctors = new String[20];

        for (int i = 0; i < wm.doctors.size(); i++) {
            String name = wm.doctors.get(i).getName() + " " + wm.doctors.get(i).getSurname();
            doctors[i] = name;

        }

        final JComboBox<String> cb = new JComboBox<String>(doctors);

        cb.setVisible(true);
        cb.setBounds(100, 50, 200, 50);
        addConsultationFrame.add(cb);
        cb.addActionListener(e -> {
            String doc_name = cb.getSelectedItem().toString();
            String selected_doc = "";
            model.setRowCount(0);

            for (int i = 0; i < wm.doctors.size(); i++) {

                if (doc_name.equals(wm.doctors.get(i).getName() + " " + wm.doctors.get(i).getSurname())) {
                    selected_doc = wm.doctors.get(i).getMedicalLicenceNumber();
                    System.out.println(selected_doc);
                    ResultSet rows = getAvailableData(selected_doc);

                    Object rowData[] = new Object[4];
                    try {
                        while (rows.next() == true) {
                            rowData[0] = rows.getString(2);
                            rowData[1] = rows.getString(3);
                            rowData[2] = rows.getString(4);
                            rowData[3] = rows.getString(5);

                            model.addRow(rowData);

                        }
                    } catch (Exception e_) {
                        // TODO: handle exception
                        System.out.println(e_);
                    }

                }

            }

        });

        String[] patients = new String[20];
        ResultSet p_rows = getPatientData();

        try {
            int i = 0;
            while (p_rows.next() == true) {
                patients[i] = p_rows.getString(5) + " - " + p_rows.getString(1);

                i++;
            }
        } catch (Exception e_) {
            // TODO: handle exception
            System.out.println(e_);
        }

        String[] get_doctor_id = new String[20];

        for (int i = 0; i < wm.doctors.size(); i++) {
            String name = wm.doctors.get(i).getMedicalLicenceNumber();
            get_doctor_id[i] = name;

        }
        // -----------------------------------------------------------------------------------------------------------

        JLabel f_name = new JLabel("Patient Id/Name");
        f_name.setBounds(1200, 50, 100, 30);
        addConsultationFrame.add(f_name);

        JComboBox<String> patinet_name_cb = new JComboBox<String>(patients);
        patinet_name_cb.setSelectedIndex(-1);
        patinet_name_cb.setVisible(true);
        patinet_name_cb.setBounds(1500, 50, 200, 50);
        addConsultationFrame.add(patinet_name_cb);

        JLabel doc_id = new JLabel("Doctor Id");
        doc_id.setBounds(1200, 150, 100, 30);
        addConsultationFrame.add(doc_id);

        JComboBox<String> doctor_is_cb = new JComboBox<String>(get_doctor_id);
        doctor_is_cb.setSelectedIndex(-1);
        doctor_is_cb.setVisible(true);
        doctor_is_cb.setBounds(1500, 150, 200, 50);
        addConsultationFrame.add(doctor_is_cb);
        doctor_is_cb.addActionListener(e -> {

            String doctor_id = doctor_is_cb.getSelectedItem().toString();
            String selected_doc = "";

            String[] datetime = new String[20];
            ResultSet dt_rows = getAvailableData(selected_doc);

            for (int i = 0; i < wm.doctors.size(); i++) {

                if (doctor_id.equals(wm.doctors.get(i).getMedicalLicenceNumber())) {
                    selected_doc = wm.doctors.get(i).getName();
                    System.out.println(selected_doc);
                    ResultSet rows = getAvailableData(selected_doc);

                    try {
                        int x = 0;
                        while (dt_rows.next() == true) {
                            datetime[x] = dt_rows.getString(5) + " - " + dt_rows.getString(1);

                            x++;
                        }
                    } catch (Exception e_) {
                        // TODO: handle exception
                        System.out.println(e_);
                    }

                }

            }

            JComboBox<String> date_time_cb = new JComboBox<String>(datetime);
            date_time_cb.setSelectedIndex(-1);
            date_time_cb.setVisible(true);
            date_time_cb.setBounds(1500, 250, 200, 50);
            addConsultationFrame.add(date_time_cb);
        });

        JLabel date_time = new JLabel("Date/Time");
        date_time.setBounds(1200, 250, 100, 30);
        addConsultationFrame.add(date_time);

        // ------------------------------------------------------------------------------------

    }

    public static ResultSet getAvailableData(String lic) {
        String sql = "";
        sql = "SELECT * FROM `availability` WHERE lic_no='" + lic + "';";
        // System.out.println(sql);
        SQLCon sc = new SQLCon();
        ResultSet rs = sc.GetData(sql);
        return rs;
        // ------------------------------------------------------------------------------------
    }

    public static ResultSet getPatientData() {
        String sql = "";
        sql = "SELECT * FROM patients;";
        SQLCon sc = new SQLCon();
        ResultSet rs = sc.GetData(sql);
        return rs;
    }

}
