/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penggajian;

/**
 *
 * @author dr. Yoe
 */
public class karyawan extends gaji {
    
    String nik,nama,alamat,telp;
    
    public karyawan (){}
    
    public karyawan (String nik, String nama, String telp, String alamat){
        this.nik = nik;
        this.nama = nama;
        this.telp = telp;
        this.alamat = alamat;
    }
    
    public void inputNIK(String nik){
        this.nik = nik;
    }
    
    public String ambilNIK(){
        return this.nik;
    }
    
    public void inputNAMA(String nama){
        this.nama = nama;
    }
    
    public String ambilNAMA(){
        return this.nama;
    }
    
    public void inputTELP(String telp){
        this.telp = telp;
    }
    
    public String ambilTELP(){
        return this.telp;
    }
    
    public void inputALAMAT(String alamat){
        this.alamat = alamat;
    }
    
    public String ambilALAMAT(){
        return this.alamat;
    }
    
}
