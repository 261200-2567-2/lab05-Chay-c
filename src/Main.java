public class Main {
    public static void main(String[] args) {
        RPGCharacter warrior = new Warrior("Aragorn");
        RPGCharacter mage = new Mage("Gandalf");
        RPGCharacter elf = new Elf("Legolas");

        Accessory sword = new Sword("Excalibur", 20, 10);
        Accessory staff = new Staff("Wizard's Staff", 15, 25);
        Accessory bow = new Bow("Elven Bow", 18, 5);

        warrior.displayStats();
        mage.displayStats();
        elf.displayStats();

        warrior.equipAccessory(sword);
        mage.equipAccessory(staff);
        elf.equipAccessory(bow);

        warrior.displayStats();
        mage.displayStats();
        elf.displayStats();

        warrior.attack(elf);
        mage.attack(warrior);
        elf.attack(mage);
    }
}