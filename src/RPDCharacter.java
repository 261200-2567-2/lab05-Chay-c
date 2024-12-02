interface RPGCharacter {
    String getName();
    String getJob();
    void displayStats();
    void equipAccessory(Accessory accessory);
    void attack(RPGCharacter target);
    void takeDamage(int damage);
}


 class Warrior implements RPGCharacter {
    protected String name;
    protected int hp;
    protected int mana;
    protected int attack;
    protected int defense;

    // Constructor ที่กำหนดค่า default
    public Warrior(String name) {
        this(name, 150, 50, 70, 80);
    }

    // Constructor หลักที่กำหนดค่าพารามิเตอร์เอง
    public Warrior(String name, int hp, int mana, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getJob() {
        return "Warrior";
    }

    @Override
    public void displayStats() {
        System.out.println(name + " (" + getJob() + ") - HP: " + hp + ", Mana: " + mana + ", Attack: " + attack + ", Defense: " + defense);
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        System.out.println(name + " equipped " + accessory.getName());
        attack += accessory.getAttackBoost();
        defense += accessory.getDefenseBoost();
        hp += accessory.getHPBoost();
        mana += accessory.getManaBoost();

        if (accessory instanceof Sword) {
            int swordBonus = 10; // Additional attack bonus for Warrior using Sword
            attack += swordBonus;
            System.out.println(name + " gains an additional " + swordBonus + " attack for equipping a Sword!");
        }
    }

    @Override
    public void attack(RPGCharacter target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        int damage = attack - (target instanceof Warrior ? ((Warrior) target).defense / 2 : 0); // Example damage formula
        target.takeDamage(Math.max(damage, 0)); // Avoid negative damage
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " took " + damage + " damage! HP is now " + hp);
        if (hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }
}

class Elf implements RPGCharacter {
    protected String name;
    protected int hp;
    protected int mana;
    protected int attack;
    protected int defense;

    // Constructor ที่กำหนดค่า default
    public Elf(String name) {
        this(name, 120, 100, 80, 60); // เรียกใช้ constructor หลัก
    }

    // Constructor หลักที่กำหนดค่าพารามิเตอร์เอง
    public Elf(String name, int hp, int mana, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getJob() {
        return "Elf";
    }

    @Override
    public void displayStats() {
        System.out.println(name + " (" + getJob() + ") - HP: " + hp + ", Mana: " + mana + ", Attack: " + attack + ", Defense: " + defense);
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        System.out.println(name + " equipped " + accessory.getName());
        attack += accessory.getAttackBoost();
        defense += accessory.getDefenseBoost();
        hp += accessory.getHPBoost();
        mana += accessory.getManaBoost();

        // Special condition for Bow
        if (accessory instanceof Bow) {
            int bowBonus = 12; // Additional attack bonus for Elf using Bow
            attack += bowBonus;
            System.out.println(name + " gains an additional " + bowBonus + " attack for equipping a Bow!");
        }
    }

    @Override
    public void attack(RPGCharacter target) {
        System.out.println(name + " shoots an arrow at " + target.getName() + "!");
        int damage = attack - (target instanceof Warrior ? ((Warrior) target).defense / 2 : 0); // Example damage formula
        target.takeDamage(Math.max(damage, 0)); // Avoid negative damage
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " took " + damage + " damage! HP is now " + hp);
        if (hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }
}

class Mage implements RPGCharacter {
    protected String name;
    protected int hp;
    protected int mana;
    protected int attack;
    protected int defense;

    // Constructor ที่กำหนดค่า default
    public Mage(String name) {
        this(name, 100, 120, 90, 50); // เรียกใช้ constructor หลัก
    }

    // Constructor หลักที่กำหนดค่าพารามิเตอร์เอง
    public Mage(String name, int hp, int mana, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getJob() {
        return "Mage";
    }

    @Override
    public void displayStats() {
        System.out.println(name + " (" + getJob() + ") - HP: " + hp + ", Mana: " + mana + ", Attack: " + attack + ", Defense: " + defense);
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        System.out.println(name + " equipped " + accessory.getName());
        attack += accessory.getAttackBoost();
        defense += accessory.getDefenseBoost();
        hp += accessory.getHPBoost();
        mana += accessory.getManaBoost();

        if (accessory instanceof Staff) {
            int staffBonus = 15; // Additional mana bonus for Mage using Staff
            mana += staffBonus;
            System.out.println(name + " gains an additional " + staffBonus + " mana for equipping a Staff!");
        }
    }

    @Override
    public void attack(RPGCharacter target) {
        if (mana < 20) {
            System.out.println(name + " doesn't have enough mana to attack!");
            return;
        }
        System.out.println(name + " casts a spell on " + target.getName() + "!");
        int damage = attack - (target instanceof Warrior ? ((Warrior) target).defense / 3 : 0); // Example damage formula
        target.takeDamage(Math.max(damage, 0)); // Avoid negative damage
        mana -= 20;
        System.out.println(name + " used 20 mana. Remaining mana: " + mana);
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " took " + damage + " damage! HP is now " + hp);
        if (hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }
}

// Define the accessory interface
interface Accessory {
    String getName();
    int getAttackBoost();
    int getDefenseBoost();
    int getHPBoost();
    int getManaBoost();
}

// Define specific accessory types
class Ring implements Accessory {
    protected String name;
    protected int attackBoost;
    protected int manaBoost;

    public Ring(String name, int attackBoost, int manaBoost) {
        this.name = name;
        this.attackBoost = attackBoost;
        this.manaBoost = manaBoost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackBoost() {
        return attackBoost;
    }

    @Override
    public int getDefenseBoost() {
        return 0;
    }

    @Override
    public int getHPBoost() {
        return 0;
    }

    @Override
    public int getManaBoost() {
        return manaBoost;
    }
}

class Boots implements Accessory {
    protected String name;
    protected int defenseBoost;
    protected int hpBoost;

    public Boots(String name, int defenseBoost, int hpBoost) {
        this.name = name;
        this.defenseBoost = defenseBoost;
        this.hpBoost = hpBoost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackBoost() {
        return 0;
    }

    @Override
    public int getDefenseBoost() {
        return defenseBoost;
    }

    @Override
    public int getHPBoost() {
        return hpBoost;
    }

    @Override
    public int getManaBoost() {
        return 0;
    }
}

class Sword implements Accessory {
    protected String name;
    protected int attackBoost;
    protected int defenseBoost;

    public Sword(String name, int attackBoost, int defenseBoost) {
        this.name = name;
        this.attackBoost = attackBoost;
        this.defenseBoost = defenseBoost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackBoost() {
        return attackBoost;
    }

    @Override
    public int getDefenseBoost() {
        return defenseBoost;
    }

    @Override
    public int getHPBoost() {
        return 0;
    }

    @Override
    public int getManaBoost() {
        return 0;
    }
}

class Staff implements Accessory {
    protected String name;
    protected int attackBoost;
    protected int manaBoost;

    public Staff(String name, int attackBoost, int manaBoost) {
        this.name = name;
        this.attackBoost = attackBoost;
        this.manaBoost = manaBoost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackBoost() {
        return attackBoost;
    }

    @Override
    public int getDefenseBoost() {
        return 0;
    }

    @Override
    public int getHPBoost() {
        return 0;
    }

    @Override
    public int getManaBoost() {
        return manaBoost;
    }
}

class Bow implements Accessory {
    protected String name;
    protected int attackBoost;
    protected int hpBoost;

    public Bow(String name, int attackBoost, int hpBoost) {
        this.name = name;
        this.attackBoost = attackBoost;
        this.hpBoost = hpBoost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttackBoost() {
        return attackBoost;
    }

    @Override
    public int getDefenseBoost() {
        return 0;
    }

    @Override
    public int getHPBoost() {
        return hpBoost;
    }

    @Override
    public int getManaBoost() {
        return 0;
    }
}
