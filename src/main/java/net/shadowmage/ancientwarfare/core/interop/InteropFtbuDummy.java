//TODO ftbutils integration
//package net.shadowmage.ancientwarfare.core.interop;
//
//import com.feed_the_beast.ftbl.api.IForgePlayer;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.util.text.TextComponentTranslation;
//import net.minecraft.util.text.TextFormatting;
//import net.minecraft.world.World;
//
//import java.util.List;
//import java.util.UUID;
//
//public class InteropFtbuDummy implements InteropFtbuInterface {
//    @Override
//    public boolean areFriends(String player1, String player2) { return false; }
//
//    @Override
//    public boolean isFriendOfClient(UUID otherPlayer) { return false; }
//
//    @Override
//    public void addClaim(World world, String ownerName, int posX, int posY, int posZ) {}
//
//    @Override
//    public void addClaim(World world, EntityLivingBase placer, int posX, int posY, int posZ) {}
//
//    //@Override
//    //public void unclaimChunks(World world, String ownerName, int posX, int posY, int posZ) {}
//
//    @Override
//    public void notifyPlayer(TextFormatting titleColor, String ownerName, String title, TextComponentTranslation msg, List<TextComponentTranslation> hoverTextLines) {}
//
//    @Override
//    public IForgePlayer getChunkClaimOwner(int dimId, int chunkX, int chunkY) { return null; }
//
//    @Override
//    public void startWorkerThread() {}
//
//    @Override
//    public void stopWorkerThread() {}
//}
