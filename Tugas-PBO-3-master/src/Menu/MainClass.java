package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainClass {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/2210010332"; // URL database Anda
    private static final String DB_USER = "root"; // Username database Anda
    private static final String DB_PASSWORD = ""; // Password database Anda

    public static void main(String[] args) {
        JFrame frame = new JFrame("CRUD Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 1));

        JButton btnTambahGuru = new JButton("Tambah Guru");
        JButton btnTampilkanGuru = new JButton("Tampilkan Semua Guru");
        JButton btnUpdateGuru = new JButton("Update Guru");
        JButton btnHapusGuru = new JButton("Hapus Guru");
        JButton btnKeluar = new JButton("Keluar");

        frame.add(btnTambahGuru);
        frame.add(btnTampilkanGuru);
        frame.add(btnUpdateGuru);
        frame.add(btnHapusGuru);
        frame.add(btnKeluar);

        btnTambahGuru.addActionListener(e -> showTambahGuruForm());
        btnTampilkanGuru.addActionListener(e -> showTampilkanGuruForm());
        btnUpdateGuru.addActionListener(e -> showUpdateGuruForm());
        btnHapusGuru.addActionListener(e -> showHapusGuruForm());
        btnKeluar.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private static void showTambahGuruForm() {
        JFrame formFrame = new JFrame("Tambah Guru");
        formFrame.setSize(300, 200);
        formFrame.setLayout(new GridLayout(3, 2));

        JLabel lblNama = new JLabel("Nama Guru:");
        JTextField txtNama = new JTextField();
        JButton btnSave = new JButton("Simpan");

        formFrame.add(lblNama);
        formFrame.add(txtNama);
        formFrame.add(new JLabel(""));
        formFrame.add(btnSave);

        btnSave.addActionListener(e -> {
            String nama = txtNama.getText();
            try (Connection conn = getConnection()) {
                String sql = "INSERT INTO Guru (nama) VALUES (?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nama);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(formFrame, "Guru berhasil ditambahkan.");
                formFrame.dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(formFrame, "Terjadi kesalahan.");
            }
        });

        formFrame.setVisible(true);
    }

    private static void showTampilkanGuruForm() {
        JFrame formFrame = new JFrame("Daftar Guru");
        formFrame.setSize(400, 300);
        formFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        formFrame.add(scrollPane, BorderLayout.CENTER);

        try (Connection conn = getConnection()) {
            String sql = "SELECT * FROM Guru";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                textArea.append("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("nama") + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(formFrame, "Terjadi kesalahan.");
        }

        formFrame.setVisible(true);
    }

    private static void showUpdateGuruForm() {
        JFrame formFrame = new JFrame("Update Guru");
        formFrame.setSize(300, 200);
        formFrame.setLayout(new GridLayout(4, 2));

        JLabel lblId = new JLabel("ID Guru:");
        JTextField txtId = new JTextField();
        JLabel lblNama = new JLabel("Nama Baru:");
        JTextField txtNama = new JTextField();
        JButton btnUpdate = new JButton("Update");

        formFrame.add(lblId);
        formFrame.add(txtId);
        formFrame.add(lblNama);
        formFrame.add(txtNama);
        formFrame.add(new JLabel(""));
        formFrame.add(btnUpdate);

        btnUpdate.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            String nama = txtNama.getText();
            try (Connection conn = getConnection()) {
                String sql = "UPDATE Guru SET nama = ? WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nama);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(formFrame, "Guru berhasil diupdate.");
                formFrame.dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(formFrame, "Terjadi kesalahan.");
            }
        });

        formFrame.setVisible(true);
    }

    private static void showHapusGuruForm() {
        JFrame formFrame = new JFrame("Hapus Guru");
        formFrame.setSize(300, 200);
        formFrame.setLayout(new GridLayout(3, 2));

        JLabel lblId = new JLabel("ID Guru:");
        JTextField txtId = new JTextField();
        JButton btnHapus = new JButton("Hapus");

        formFrame.add(lblId);
        formFrame.add(txtId);
        formFrame.add(new JLabel(""));
        formFrame.add(btnHapus);

        btnHapus.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText());
            try (Connection conn = getConnection()) {
                String sql = "DELETE FROM Guru WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(formFrame, "Guru berhasil dihapus.");
                formFrame.dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(formFrame, "Terjadi kesalahan.");
            }
        });

        formFrame.setVisible(true);
    }
}
