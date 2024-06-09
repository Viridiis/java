package units;

public class Devil extends Unit{
    public Devil(String name, int maxHP, int maxDMG) {
        super(name, maxHP, maxDMG, 0, 0);
    }

    public Devil(String name, int maxHp, int maxDMG, int currentHP){
        super(name, maxHp, maxDMG, currentHP);
    }

    public Devil() {
        super("Devil", 55, 20, 55);
    }
}
