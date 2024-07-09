/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Menu;

/**
 *
 * @author USER
 */
import CRUD.Guru;
import CRUD.Nilai;
import CRUD.Pelajaran;
import CRUD.Siswa;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Guru");
            System.out.println("2. Tampilkan Semua Guru");
            System.out.println("3. Update Guru");
            System.out.println("4. Hapus Guru");
            System.out.println("5. Tambah Pelajaran");
            System.out.println("6. Tampilkan Semua Pelajaran");
            System.out.println("7. Update Pelajaran");
            System.out.println("8. Hapus Pelajaran");
            System.out.println("9. Tambah Siswa");
            System.out.println("10. Tampilkan Semua Siswa");
            System.out.println("11. Update Siswa");
            System.out.println("12. Hapus Siswa");
            System.out.println("13. Tambah Nilai");
            System.out.println("14. Tampilkan Semua Nilai");
            System.out.println("15. Update Nilai");
            System.out.println("16. Hapus Nilai");
            System.out.println("17. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        tambahGuru();
                        break;
                    case 2:
                        tampilkanSemuaGuru();
                        break;
                    case 3:
                        updateGuru();
                        break;
                    case 4:
                        hapusGuru();
                        break;
                    case 5:
                        tambahPelajaran();
                        break;
                    case 6:
                        tampilkanSemuaPelajaran();
                        break;
                    case 7:
                        updatePelajaran();
                        break;
                    case 8:
                        hapusPelajaran();
                        break;
                    case 9:
                        tambahSiswa();
                        break;
                    case 10:
                        tampilkanSemuaSiswa();
                        break;
                    case 11:
                        updateSiswa();
                        break;
                    case 12:
                        hapusSiswa();
                        break;
                    case 13:
                        tambahNilai();
                        break;
                    case 14:
                        tampilkanSemuaNilai();
                        break;
                    case 15:
                        updateNilai();
                        break;
                    case 16:
                        hapusNilai();
                        break;
                    case 17:
                        System.out.println("Keluar dari program.");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (SQLException e) {
            }
        }
    }

    private static void tambahGuru() throws SQLException {
        System.out.print("Masukkan nama guru: ");
        String nama = scanner.nextLine();
        Guru guru = new Guru(nama);
        guru.save();
        System.out.println("Guru berhasil ditambahkan.");
    }

    private static void tampilkanSemuaGuru() throws SQLException {
        System.out.println("Daftar Guru:");
        Guru.getAll();
    }

    private static void updateGuru() throws SQLException {
        System.out.print("Masukkan ID guru yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan nama baru guru: ");
        String nama = scanner.nextLine();
        Guru.update(id, nama);
        System.out.println("Guru berhasil diupdate.");
    }

    private static void hapusGuru() throws SQLException {
        System.out.print("Masukkan ID guru yang akan dihapus: ");
        int id = scanner.nextInt();
        Guru.delete(id);
        System.out.println("Guru berhasil dihapus.");
    }

    private static void tambahPelajaran() throws SQLException {
        System.out.print("Masukkan nama pelajaran: ");
        String nama = scanner.nextLine();
        Pelajaran pelajaran = new Pelajaran(nama);
        pelajaran.save();
        System.out.println("Pelajaran berhasil ditambahkan.");
    }

    private static void tampilkanSemuaPelajaran() throws SQLException {
        System.out.println("Daftar Pelajaran:");
        Pelajaran.getAll();
    }

    private static void updatePelajaran() throws SQLException {
        System.out.print("Masukkan ID pelajaran yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan nama baru pelajaran: ");
        String nama = scanner.nextLine();
        Pelajaran.update(id, nama);
        System.out.println("Pelajaran berhasil diupdate.");
    }

    private static void hapusPelajaran() throws SQLException {
        System.out.print("Masukkan ID pelajaran yang akan dihapus: ");
        int id = scanner.nextInt();
        Pelajaran.delete(id);
        System.out.println("Pelajaran berhasil dihapus.");
    }

    private static void tambahSiswa() throws SQLException {
        System.out.print("Masukkan nama siswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kelas siswa: ");
        String kelas = scanner.nextLine();
        Siswa siswa = new Siswa(nama, kelas);
        siswa.save();
        System.out.println("Siswa berhasil ditambahkan.");
    }

    private static void tampilkanSemuaSiswa() throws SQLException {
        System.out.println("Daftar Siswa:");
        Siswa.getAll();
    }

    private static void updateSiswa() throws SQLException {
        System.out.print("Masukkan ID siswa yang akan diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan nama baru siswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kelas baru siswa: ");
        String kelas = scanner.nextLine();
        Siswa.update(id, nama, kelas);
        System.out.println("Siswa berhasil diupdate.");
    }

    private static void hapusSiswa() throws SQLException {
        System.out.print("Masukkan ID siswa yang akan dihapus: ");
        int id = scanner.nextInt();
        Siswa.delete(id);
        System.out.println("Siswa berhasil dihapus.");
    }

    private static void tambahNilai() throws SQLException {
        System.out.print("Masukkan ID siswa: ");
        int siswaId = scanner.nextInt();
        System.out.print("Masukkan ID pelajaran: ");
        int pelajaranId = scanner.nextInt();
        System.out.print("Masukkan nilai: ");
        int nilai = scanner.nextInt();
        Nilai nilaiObj = new Nilai(siswaId, pelajaranId, nilai);
        nilaiObj.save();
        System.out.println("Nilai berhasil ditambahkan.");
    }

    private static void tampilkanSemuaNilai() throws SQLException {
        System.out.println("Daftar Nilai:");
        Nilai.getAll();
    }

    private static void updateNilai() throws SQLException {
        System.out.print("Masukkan ID nilai yang akan diupdate: ");
        int id = scanner.nextInt();
        System.out.print("Masukkan ID siswa baru: ");
        int siswaId = scanner.nextInt();
        System.out.print("Masukkan ID pelajaran baru: ");
        int pelajaranId = scanner.nextInt();
        System.out.print("Masukkan nilai baru: ");
        int nilai = scanner.nextInt();
        Nilai.update(id, siswaId, pelajaranId, nilai);
        System.out.println("Nilai berhasil diupdate.");
    }

    private static void hapusNilai() throws SQLException {
        System.out.print("Masukkan ID nilai yang akan dihapus: ");
        int id = scanner.nextInt();
        Nilai.delete(id);
        System.out.println("Nilai berhasil dihapus.");
    }
}


