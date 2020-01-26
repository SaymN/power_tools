/*******************************************************************************
 * Copyright (c) 2012 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * <p>
 * Contributors:
 * cpw - initial API and implementation
 ******************************************************************************/
package ch.saymn.power_tools.network;

import ch.saymn.power_tools.power_tools;
import ch.saymn.power_tools.network.packets.PacketTopStackSyncChest;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public final class PacketHandler
{
    private static final String PROTOCOL_VERSION = Integer.toString(1);

    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(power_tools.MODID, "main_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    public static void register()
    {
        int disc = 0;

        HANDLER.registerMessage(disc++, PacketTopStackSyncChest.class, PacketTopStackSyncChest::encode, PacketTopStackSyncChest::decode, PacketTopStackSyncChest.Handler::handle);
    }

    public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message)
    {
        HANDLER.send(target, message);
    }
}
