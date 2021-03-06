package HxCKDMS.HxCWorldGen.libs;

public class TextureHandler {
    public static String mod = Reference.RESOURCE_LOCATION;
    public static String a = "16";
    public static String c = "64";
    public static String size = "";
    private static boolean doSpecial = Configurations.tryToBlendIn;

    public static void preInit() {
        switch (Configurations.ResourceSize) {
            case 16 : size = a; break;
            case 64 : size = c; break;
        }
    }

    public static String getTexturePath(String resource) {
        switch (resource) {
            case ("ore") : return mod + Configurations.oreResource + size;
            case ("ingot") : return doSpecial ? "minecraft:iron_ingot" : mod + resource + size;
            case ("gem") : return doSpecial ? "minecraft:diamond" : mod + resource + size;
            case ("metalBlock") : return doSpecial ? "minecraft:iron_block" : mod + resource + size;
            case ("gemBlock") : return doSpecial ? "minecraft:diamond_block" : mod + resource + size;
            default : return mod + resource + size;
        }
    }
}