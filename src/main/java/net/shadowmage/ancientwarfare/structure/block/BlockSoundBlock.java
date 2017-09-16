package net.shadowmage.ancientwarfare.structure.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.shadowmage.ancientwarfare.core.network.NetworkHandler;
import net.shadowmage.ancientwarfare.structure.AncientWarfareStructures;
import net.shadowmage.ancientwarfare.structure.item.AWStructuresItemLoader;
import net.shadowmage.ancientwarfare.structure.tile.TileSoundBlock;

import javax.annotation.Nonnull;

public class BlockSoundBlock extends Block {

    public BlockSoundBlock() {
        super(Material.ROCK);
        setCreativeTab(AWStructuresItemLoader.structureTab);
        setUnlocalizedName("sound_block");
        setRegistryName(new ResourceLocation(AncientWarfareStructures.modID, "sound_block"));
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int face){
//        TileEntity tileEntity = blockAccess.getTileEntity(x, y, z);
//        if(tileEntity instanceof TileSoundBlock) {
//            Block block = ((TileSoundBlock) tileEntity).getBlockCache();
//            if (block != null) {
//                return block.getIcon(face, 0);
//            }
//        }
//        return getIcon(face, 0);
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public IIcon getIcon(int side, int meta){
//        return Blocks.JUKEBOX.getIcon(side, meta);
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void registerBlockIcons(IIconRegister iconRegister){
//
//    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileSoundBlock();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        @Nonnull ItemStack itemStack = player.getHeldItem(hand);
        if(itemStack!=null && itemStack.getItem() instanceof ItemBlock){
            TileEntity tileEntity = world.getTileEntity(pos);
            if(tileEntity instanceof TileSoundBlock) {
                ((TileSoundBlock)tileEntity).setBlockCache(itemStack);
            }
        }
        if (!world.isRemote) {
            NetworkHandler.INSTANCE.openGui(player, NetworkHandler.GUI_SOUND_BLOCK, pos);
        }
        return true;
    }

}
