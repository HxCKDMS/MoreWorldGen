package kay.MoreWorldGen.creativeTabs;

import kay.MoreWorldGen.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class MWGcreativeTab {

    public static CreativeTabs moreWorldGenTab = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.iron_ore);
        }
    };

}
