/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package penggajian;

/**
 *
 * @author dr. Yoe
 */
public class gaji {
    
    String golongan,statusNikah;
    int jumAnak,masaKerja,tunjGolongan,tunjStatus,tunjAnak,tunjKerja;
    
 
    public gaji(){} //constructor 1
    
    public gaji(String gol){
        this.golongan = gol;
    }//constructor 2
    
    public gaji(String gol, String status){
        this.golongan = gol;
        this.statusNikah = status;
    }//constructor 3
    
    public gaji(String gol, String status, int jumlah){
        this.golongan = gol;
        this.statusNikah = status;
        this.jumAnak = jumlah;
    }//constructor 4
    
    public gaji(String gol, String status, int jumlah, int masa){
        this.golongan = gol;
        this.statusNikah = status;
        this.jumAnak = jumlah;
        this.masaKerja = masa;
    }//constructor 5
    
    
    
    public void inputGolongan(String golongan){
        this.golongan = golongan;
    }
    
    public int ambilTunjGolongan(){
        this.tunjGolongan = 0;
        if (this.golongan.equals("I")){
            this.tunjGolongan = 300000;
        }else if (this.golongan.equals("II")){
            this.tunjGolongan = 350000;
        }else if (this.golongan.equals("III")){
            this.tunjGolongan = 400000;
        }   else {this.tunjGolongan = 4500000;}
        
        return this.tunjGolongan;
    }
    
    public void inputStatusNikah(String status){
        this.statusNikah = status;
    }
    
    public String getStatus(){
        return this.statusNikah;
    }
    
    public int ambilTunjStatus(){
        this.tunjStatus = 0;
        if (this.statusNikah.equals("Menikah")){
            this.tunjStatus = 1500000;
        }else {this.tunjStatus = 5000000;}
        
        return this.tunjStatus;
    }
    
    public void inputJumlahAnak(int jumlah){
        this.jumAnak = jumlah;
    }
    
    public int ambilTunjAnak(){
        this.tunjAnak = 0;
        
        if (this.jumAnak==0){
            this.tunjAnak = 0;
        }else if (this.jumAnak>=1 && this.jumAnak<=2){
            this.tunjAnak = 200000;
        }else if (this.jumAnak>=3 && this.jumAnak<=4){
            this.tunjAnak = 400000;
        }else{
            this.tunjAnak = 550000;
        }
        return this.tunjAnak;
    }
    
    public void inputMasaKerja(int jumTahun){
        this.masaKerja = jumTahun;
    }
    
    public int ambilTunjMasaKerja(){
        this.tunjKerja = 0;
        if (this.masaKerja>=0 && this.masaKerja<=2){
            this.tunjKerja = 350000;
        }else if (this.masaKerja>=3 && this.masaKerja<=4){
            this.tunjKerja = 550000;
        }else{
            this.tunjKerja = 750000;
        }
        
        return this.tunjKerja;
    }
    
    public int gajiTotal(){
        return ambilTunjGolongan()+ambilTunjStatus()+
                ambilTunjMasaKerja()+ambilTunjAnak();
    }
    
}
