/**
 * La classe rappresenta e gestisce dati di tipo temporale
 */
public class Time {
    /**
     *numero di minuti dell'oggetto Time
     */
    protected int minuti;
    /**
     *numero di ore dell'oggetto Time
     */
    protected int ore;
    /**
     *numero di secondi dell'oggetto Time
     */
    protected int secondi;

    /**
     * Costruisce un oggetto Time dato in ingresso il numero di secondi.
<u>Vengono distribuite in automatico i secondi tra le ore, minuti e secondi.</u> Esempio: se in input viene passato 100 allora ora 0, minuti 1 e secondi 40
     * @param secondi secondi da assegnare al nuovo oggetto
     */
    public Time(int secondi) {
        normalizzaTempo(secondi);
    }

    /**
     * Costruisce un oggetto Time dato in ingresso ore, minuti e secondi.
<u>Se i parametri di ingresso non sono validi (es. minuti 78) allora l'oggetto Time verrà  inizializzato con tutti ore, minuti e secondi impostati a 0</u>
     * @param minuti minuti da assegnare al nuovo oggetto
     * @param ore ore da assegnare al nuovo oggetto
     * @param secondi secondi da assegnare al nuovo oggetto
     */
    public Time(int ore, int minuti, int secondi) {
        if(controlInput(ore, minuti, secondi)){
            this.minuti = minuti;
            this.ore = ore;
            this.secondi = secondi;
        }
        else{
            this.minuti = 0;
            this.ore = 0;
            this.secondi = 0;
        }
    }

    /**
     *Restituisce il numero di minuti
     * @return il numero di minuti dell'oggetto Time
     */
    public int getMinuti() {
        return minuti;
    }

    /**
     * @deprecated
     * @param minuti
     */
    public void setMinuti(int minuti) {
    }

    /**
     *Restituisce il numero delle ore
     * @return il numero di ore dell'oggetto Time
     */
    public int getOre() {
        return ore;
    }

    /**
     * @deprecated
     * @param ore
     */
    public void setOre(int ore) {
    }

    /**
     *Restituisce il numero di secondi
     * @return il numero di secondi dell'oggetto Time
     */
    public int getSecondi() {
        return secondi;
    }

    /**
     * @deprecated
     * @param secondi
     */
    public void setSecondi(int secondi) {
    }

    private boolean controlInput(int o, int m, int s){
        if(o > 60 || m > 60 || s > 60 || o < 0 || m < 0 || s < 0){
            return false;
        }
        return true;
    }

    /**
     *
     * @param s
     */
    private void normalizzaTempo(int s){
        if(s >= 60){
            int min = s / 60;
            int sec = s % 60;
            int or = 0;

            if(min >= 60){
                or = min / 60;
                min = min % 60;
            }

            this.minuti = min;
            this.ore = or;
            this.secondi = sec;
        }
        else{
            this.secondi = s;
        }
    }

    /**
     *Vengono addizionati il numero di secondi specificati. Il tempo viene normalizzato in automatico.
     * @param s numero di secondi da aggiungere
     */
    public void addSecondi(int s){
        int sec = convertiSecondi() + s;
        normalizzaTempo(sec);
    }

    /**
     * Esprime le ore, i minuti e i secondi dell'oggetto Time in secondi. Esempio. 1 ora, 20 min, 10 secondi -> 4810s
     * @return il numero totale dei secondi
     */
    public int convertiSecondi(){
        return (ore * 3600) + (minuti * 60) + secondi;
    }

    /**
     *Restituisce una stringa che rappresenta l'oggetto
     @return Rappresentazione testuale dell'oggetto Time {ore:minuti:secondi}
     */
    @Override
    public String toString() {
        return "{" + ore + ":" + minuti + ":" + secondi + "}";
    }
}
