package ch.saymn.power_tools;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import ch.saymn.power_tools.config.config;
import ch.saymn.power_tools.container.ChestContainerType;
import ch.saymn.power_tools.network.PacketHandler;
import ch.saymn.power_tools.proxy.ClientProxy;
import ch.saymn.power_tools.proxy.ServerProxy;
import ch.saymn.power_tools.world.gen.ore_generation;

@Mod(value = power_tools.MODID)
public class power_tools {
	
	public static power_tools instance;

	public static final String MODID = "power_tools";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);


	public static ResourceLocation getId(String path) {
        return new ResourceLocation(MODID, path);
	}
	
	public power_tools() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, config.SERVER, "power_tools-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, config.CLIENT, "power_tools-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		
		config.loadConfig(config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("power_tools-client.toml").toString());
		config.loadConfig(config.SERVER, FMLPaths.CONFIGDIR.get().resolve("power_tools-server.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		ore_generation.setupOreGeneration();
		LOGGER.info("Setup method registered.");
		proxy.preInit();

        DistExecutor.runWhenOn(Dist.CLIENT, () -> ChestContainerType::registerScreenFactories);

        PacketHandler.register();
	}
	
}
