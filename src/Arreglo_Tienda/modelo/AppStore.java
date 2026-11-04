package Arreglo_Tienda.modelo;

public class AppStore {
    private static final int Max =4;
    private Juego juegos[];
    private int indice;

    public  AppStore() {
        juegos = new Juego[Max];
        indice = -1;
    }
    public Juego[] getJuegos() {
        return juegos;
    }
    //El set no se utiliza ya que los datos se ingrasn a demandsa sengun se necesite
    public void agregarJuego(Juego j ) {
        if (j != null && indice <=Max) {
            juegos[++indice] = j;
            return;
        }
    }
}
