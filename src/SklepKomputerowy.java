import java.time.LocalDate;

    public class SklepKomputerowy {
        private Produkt[] produkty = new Produkt[10];
        private Klient[] klienci = new Klient[10];
        private Zamowienie[] zamowienia = new Zamowienie[10];
        private int liczbaProduktow;
        private int liczbaKlientow;
        private int liczbaZamowien;

        public void dodajProdukt(Produkt produkt1) {
            //TODO
        }

        public void dodajKlienta(Klient klient1) {
            //TODO
        }

        public Zamowienie utworzZamowienie(
                Klient klient1,
                Produkt[] produktyZamowienia1,
                int[] ilosciZamowienia1) {

            Zamowienie zamowienie = new Zamowienie();
            zamowienie.setId(0);
            zamowienie.setKlient(klient1);
            zamowienie.setProdukty(produktyZamowienia1);
            zamowienie.setIlosci(ilosciZamowienia1);
            zamowienie.setDataZamowienia(LocalDate.now().toString());
            zamowienie.setStatus("Nowe");

            return zamowienie;
        }

        public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
            Produkt[] zamProdukty = zamowienie.getProdukty();
            int[] zamIlosci = zamowienie.getIlosci();

            for (int i = 0; i < zamProdukty.length; i++) {
                Produkt p = zamProdukty[i];
                int iloscZamowiona = zamIlosci[i];

                for (int j = 0; j < liczbaProduktow; j++) {
                    if (produkty[j].getId() == p.getId()) {
                        int nowaIlosc = produkty[j].getIloscWMagazynie() - iloscZamowiona;
                        produkty[j].setIloscWMagazynie(nowaIlosc);
                    }
                }
            }
        }

        public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
            for (int i = 0; i < liczbaZamowien; i++) {
                if (zamowienia[i].getId() == idZamowienia) {
                    zamowienia[i].setStatus(nowyStatus);
                    break;
                }
            }
        }

        public void wyswietlProduktyWKategorii(String kategoria) {
            System.out.println("Produkty w kategorii: " + kategoria);
            for (int i = 0; i < liczbaProduktow; i++) {
                if (produkty[i].getKategoria().equalsIgnoreCase(kategoria)) {
                    produkty[i].wyswietlInformacje();
                    System.out.println("-----");
                }
            }
        }

        public void wyswietlZamowieniaKlienta(int idKlienta) {
            for (int i = 0; i < liczbaZamowien; i++) {
                if (zamowienia[i].getKlient().getId() == idKlienta) {
                    zamowienia[i].wyswietlSzczegoly();
                    System.out.println("======================");
                }
            }
        }
    }

