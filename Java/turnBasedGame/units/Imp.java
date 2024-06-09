package units;

public class Imp extends Unit{
    public Imp(String name, int maxHP, int maxDMG) {
        super(name, maxHP, maxDMG, 0, 0);
    }

    public Imp(String name, int maxHp, int maxDMG, int currentHP){
        super(name, maxHp, maxDMG, currentHP);
    }

    public Imp() {
        super("Imp", 25, 12, 25);
    }
}
