public class Ataque {
    int id;
    String tipo;
    int dano;

    public Ataque(){
        System.out.println("Ataque criado!");
    }
    public Ataque(int id, String tipo, int dano){
        this.id = id;
        this.tipo = tipo;
        this.dano = dano;
    }

    public int calcularDanoPersonagem(Personagem personagem) {
        if(tipo.equals("fisico")) {
            int danoFinal = dano * personagem.getForca();
            System.out.println("Dano causado ao personagem: " + danoFinal);
            return danoFinal;
        }
        else if(tipo.equals("magico")) {
            int danoFinal = dano * personagem.getInteligencia();
            System.out.println("Dano causado ao personagem: " + danoFinal);
            return  danoFinal;
        }
            return 0;
    }

    public int calcularDanoInimigo(Inimigo inimigo) {
        int danoInimigoFinal = (int) (inimigo.getDano() + dano);
        System.out.println("Dano causado ao inimigo: " + danoInimigoFinal);
        return danoInimigoFinal;
    }
}
