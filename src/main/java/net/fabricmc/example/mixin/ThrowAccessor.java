//package net.fabricmc.example.mixin;
//
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.gen.Accessor;
//
//import net.minecraft.client.network.ClientPlayerEntity;
//import net.minecraft.client.network.ClientPlayNetworkHandler;
//import net.minecraft.util.Hand;
//
//@Mixin(ClientPlayerEntity.class)
//public interface ThrowAccessor {
//	@Accessor("networkHandler")
//	public ClientPlayNetworkHandler accessHandler();
//	
//	@Accessor("hand")
//	public Hand getHand();
//}
