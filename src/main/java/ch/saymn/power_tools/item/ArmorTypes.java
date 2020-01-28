package ch.saymn.power_tools.item;

public enum ArmorTypes {
//    BONE(ArmorTiers.BONE),
//    COAL(ArmorTiers.COAL),
//    EMERALD(ArmorTiers.EMERALD),
//    GLOWSTONE(ArmorTiers.GLOWSTONE),
//    LAPIS(ArmorTiers.LAPIS),
//    OBSIDIAN(ArmorTiers.OBSIDIAN),
//    PAPER(ArmorTiers.PAPER),
//    QUARTZ(ArmorTiers.QUARTZ),
    BORNITE(ArmorTiers.BORNITE);

    private ArmorTiers type;
    private String name;

    private ArmorTypes(ArmorTiers type) {
        this.type = type;
        this.name = type.getName();
    }

    public String getName() {
        return name;
    }

    public ArmorTiers getType() {
        return type;
    }
}