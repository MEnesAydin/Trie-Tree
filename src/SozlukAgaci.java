import java.util.Date;

public class SozlukAgaci {
    private Node root;

    public SozlukAgaci() {
        root = new Node();
    }



    public void ekle(String kelime){
        Node gezici = root;
        for(char c:kelime.toCharArray()){
            if(gezici.cocukGetir(c)==null){
                gezici.cocukEKle(c);
            }
            gezici = gezici.cocukGetir(c);
            gezici.sayi += 1;
        }
        gezici.kelime = true;
    }



    public void sil(String kelime){
        if(!sorgu(kelime)){
            System.out.println("Kelime mevcut değil");
            return;
        }
        Node gezici = root;
        for(char c:kelime.toCharArray()){
            Node cocuk = gezici.cocukGetir(c);
            if(cocuk.sayi == 1){
                gezici.cocukSil(cocuk);
                return;
            }
            else{
                cocuk.sayi -= 1;
            }
            gezici = cocuk;
        }
        gezici.kelime = false;
    }

    public void degistir(String eski,String yeni){
        if(sorgu(eski)){
            sil(eski);
            ekle(yeni);
        }
        else{
            System.out.println("Kelime bulunamadı");
        }
    }



    public boolean sorgu(String kelime){
        Node gezici = root;
        for(char c:kelime.toCharArray()){
            if(gezici.cocukGetir(c) != null){
                gezici = gezici.cocukGetir(c);
            }
            else{
                return false;
            }
        }
        if(gezici.kelime){
            return true;
        }
        else{
            return false;
        }
    }

    public void agaciYazdir() {
        agaciYazdir(root, 0);
    }

    private void agaciYazdir(Node node, int derinlik) {
        if (node != null) {
            // İlgili düğümü yazdır
            for (int i = 0; i < derinlik; i++) {
                System.out.print("  "); // Derinlik kadar boşluk bırak
            }
            System.out.println(node.harf);

            // Çocukları için tekrar et
            Node cocuk = node.cocuklar;
            while (cocuk != null) {
                agaciYazdir(cocuk, derinlik + 1);
                cocuk = cocuk.kardes;
            }
        }
    }


}
