/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Siswa {
    private int id;
    private final String nama;
    private final String kelas;

    public Siswa(String nama, String kelas) {
        this.nama = nama;
        this.kelas = kelas;
    }

    public void save() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Siswa (nama, kelas) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, this.nama);
                stmt.setString(2, this.kelas);
                stmt.executeUpdate();
            }
        }
    }

    public static void getAll() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Siswa";
            try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("nama") + ", Kelas: " + rs.getString("kelas"));
                }
            }
        }
    }

    public static void update(int id, String nama, String kelas) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Siswa SET nama = ?, kelas = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nama);
                stmt.setString(2, kelas);
                stmt.setInt(3, id);
                stmt.executeUpdate();
            }
        }
    }

    public static void delete(int id) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Siswa WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }
    }
}


