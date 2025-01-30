package Personagens;
public class Vilao {
    Personagens personagem = new Personagens();

    public Vilao(){ //BobBuilder
    }

    public void setaInformacoes(){
        personagem.setId(1);
        personagem.setNome("Irmão do Arnaldo");
        personagem.setForca(20);
        personagem.setHp(100);
        personagem.setInteligencia(70);
    }
}
