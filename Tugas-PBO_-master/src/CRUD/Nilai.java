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

public class Nilai {
    private int id;
    private final int siswaId;
    private final int pelajaranId;
    private final int nilai;

    public Nilai(int siswaId, int pelajaranId, int nilai) {
        this.siswaId = siswaId;
        this.pelajaranId = pelajaranId;
        this.nilai = nilai;
    }

    public void save() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Nilai (siswa_id, pelajaran_id, nilai) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, this.siswaId);
                stmt.setInt(2, this.pelajaranId);
                stmt.setInt(3, this.nilai);
                stmt.executeUpdate();
            }
        }
    }

    public static void getAll() throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Nilai";
            try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Siswa ID: " + rs.getInt("siswa_id") + ", Pelajaran ID: " + rs.getInt("pelajaran_id") + ", Nilai: " + rs.getInt("nilai"));
                }
            }
        }
    }

    public static void update(int id, int siswaId, int pelajaranId, int nilai) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE Nilai SET siswa_id = ?, pelajaran_id = ?, nilai = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, siswaId);
                stmt.setInt(2, pelajaranId);
                stmt.setInt(3, nilai);
                stmt.setInt(4, id);
                stmt.executeUpdate();
            }
        }
    }

    public static void delete(int id) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM Nilai WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }
    }
}


