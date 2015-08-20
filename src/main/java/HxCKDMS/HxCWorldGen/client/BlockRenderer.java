package HxCKDMS.HxCWorldGen.client;

import HxCKDMS.HxCWorldGen.libs.Colours;
import HxCKDMS.HxCWorldGen.libs.Reference;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class BlockRenderer implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        IIcon icon = Blocks.iron_block.getIcon(0, 0);

        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setColorOpaque(Colours.resourceColour(metadata)[0], Colours.resourceColour(metadata)[1], Colours.resourceColour(metadata)[2]);
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, icon);
        tessellator.draw();

        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        render(block, x, y, z, world.getBlockMetadata(x, y, z), renderer);
        return true;
    }

    public static void render(Block block, int x, int y, int z, int meta, RenderBlocks renderer){
        IIcon icon = block.getIcon(0, 0);
        renderer.renderStandardBlock(Blocks.iron_block, x, y, z);
        renderer.setOverrideBlockTexture(icon);
        renderer.renderStandardBlockWithColorMultiplier(Blocks.iron_block, x, y, z, Colours.resourceColour(meta)[0] / 255F, Colours.resourceColour(meta)[1] / 255F, Colours.resourceColour(meta)[2] / 255F);
        renderer.clearOverrideBlockTexture();
}

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return Reference.BLOCK_RENDER_ID;
    }
}