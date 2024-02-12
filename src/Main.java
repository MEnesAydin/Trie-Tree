import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SozlukAgaci sozlukAgaci = new SozlukAgaci();
        sozlukAgaci.ekle("Ali");
        sozlukAgaci.ekle("Alican");
        sozlukAgaci.ekle("Alican");
        sozlukAgaci.ekle("Alihan");
        sozlukAgaci.ekle("Ayse");
        sozlukAgaci.ekle("irfan");
        sozlukAgaci.agaciYazdir();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("işlem seçin:\n" +
                    "1- Kelime ekle\n" +
                    "2- Kelime sil\n" +
                    "3- Kelime degistir\n" +
                    "4- Agaci yazdir\n" +
                    "0- Çıkış\n");
            int islem = scanner.nextInt();
            String kelime = "";
            scanner.nextLine();
            switch (islem){
                case 1:
                    System.out.println("Kelime girin: ");
                    kelime = scanner.nextLine();
                    sozlukAgaci.ekle(kelime);
                    break;
                case 2:
                    System.out.println("Kelime girin: ");
                    kelime = scanner.nextLine();
                    sozlukAgaci.sil(kelime);
                    break;
                case 3:
                    System.out.println("Eski kelime: ");
                    kelime = scanner.nextLine();
                    System.out.println("Yeni kelime: ");
                    String ykelime = scanner.nextLine();
                    sozlukAgaci.degistir(kelime,ykelime);
                    break;
                case 4:
                    sozlukAgaci.agaciYazdir();
                    break;



            }
        }



    }
}