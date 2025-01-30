package Personagens;
public class Heroi {
    Personagens personagem = new Personagens();

    public Heroi(){ //Bob the builder
    }

    public void setaInformacoes(){
        personagem.setId(1);
        personagem.setNome("Arnaldo");
        personagem.setForca(20);
        personagem.setHp(100);
        personagem.setInteligencia(70);
    }
}
