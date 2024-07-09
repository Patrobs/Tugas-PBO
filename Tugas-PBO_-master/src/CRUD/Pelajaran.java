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

public class Pelajaran {
    private int id;
    private final String nama;

    public Pelajaran(String nama) {
        this.nama = nama;
    }

    public void save() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Pelajaran (nama) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, this.nama);
                stmt.executeUpdate();
            }
        }
    }

    public static void getAll() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Pelajaran";
            try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Nama: " + rs.getString("nama"));
                }
            }
        }
    }

    public static void update(int id, String nama) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Pelajaran SET nama = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nama);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            }
        }
    }

    public static void delete(int id) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Pelajaran WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }
    }
}

