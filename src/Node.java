public class Node {
    public Node cocuklar;
    public Node kardes;
    public Node ebeveyn;
    public boolean kelime;
    public int sayi;
    public char harf;

    public Node() {
    }

    public Node(Node ebeveyn, char harf) {
        this.ebeveyn = ebeveyn;
        this.harf = harf;
    }

    public void cocukEKle(char harf){
        Node temp = new Node(this,harf);
        if(cocuklar == null){
            cocuklar = temp;
        }
        else{
            Node gezici = cocuklar;
            while (gezici.kardes != null){
                gezici = gezici.kardes;
            }
            gezici.kardes = temp;
        }
    }



    public void cocukSil(Node cocuk){
        if(cocuk == this.cocuklar){
            cocuklar=cocuk.kardes;
            return;
        }
        Node gezici = cocuklar;
        while(true){
            if(gezici.kardes == cocuk){
                gezici.kardes = gezici.kardes.kardes;
                return;
            }
            gezici = gezici.kardes;
        }
    }

    public Node cocukGetir(char harf){
        Node gezici = cocuklar;
        while (gezici != null){
            if(gezici.harf == harf){
                return gezici;
            }
            gezici = gezici.kardes;
        }
        return null;
    }
}
