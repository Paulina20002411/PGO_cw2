public class Zamowienie {

        private int id;
        private Klient klient;
        private Produkt[] produkty;
        private int[] ilosci;
        private String dataZamowienia;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Klient getKlient() {
            return klient;
        }

        public void setKlient(Klient klient) {
            this.klient = klient;
        }

        public Produkt[] getProdukty() {
            return produkty;
        }

        public void setProdukty(Produkt[] produkty) {
            this.produkty = produkty;
        }

        public int[] getIlosci() {
            return ilosci;
        }

        public void setIlosci(int[] ilosci) {
            this.ilosci = ilosci;
        }

        public String getDataZamowienia() {
            return dataZamowienia;
        }

        public void setDataZamowienia(String dataZamowienia) {
            this.dataZamowienia = dataZamowienia;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        public double obliczWartoscZamowienia(){
            double suma = 0.0;
            for (int i = 0; i < produkty.length; i++) {
                suma += produkty[i].getCena() * ilosci[i];
            }
            return suma;
        }

        public void  zastosujZnizke(){
            if (klient.isCzyStaly()) {
                for (int i = 0; i < produkty.length; i++) {
                    double cenaPoZnizce = produkty[i].getCena() * 0.9; // 10% zniżki
                    produkty[i].setCena(cenaPoZnizce);
                }
            }
        }

        public void wyswietlSzczegoly(){
            System.out.println("Zamówienie ID: " + id);
            System.out.println("Data: " + dataZamowienia);
            System.out.println("Status: " + status);
            System.out.println("Klient: ");
            klient.wyswietlInformacje();
            System.out.println("Produkty:");
            for (int i = 0; i < produkty.length; i++) {
                produkty[i].wyswietlInformacje();
                System.out.println("Ilość: " + ilosci[i]);
                System.out.println("Wartość pozycji: " + (produkty[i].getCena() * ilosci[i]));
                System.out.println("-----");
            }
            System.out.println("Łączna wartość zamówienia: " + obliczWartoscZamowienia());
        }
}


