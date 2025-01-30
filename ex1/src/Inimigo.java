public class Inimigo {
    Inimigo(){
        System.out.println("nasce um novo inimigo");
    }
    float hp;
    float dano;
    String drops;
    String id;

    Inimigo(String id, float hp, float dano, String drops){
        this.dano = dano;
        this.hp = hp;
        this.drops = drops;
        this.id = id;
    }


    public float getHp() {
        return hp;
    }
    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getDano() {
        return dano;
    }
    public void setDano(float dano) {
        this.dano = dano;
    }

}
