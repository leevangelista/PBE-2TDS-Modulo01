public class Ataque {
    String id;
    float tipo;
    float dano;

    public void calcularDanoPersonagem(personagem){
        if(tipo == fisico){
            dano * forca;
        }
        else if(tipo == magico){
            dano * inteligencia;
        }
    }

    public void calcularDanoInimigo(inimigo){
        danoInimigo = danoInimigo + danoAtaque;
    }

}
