package us.ajg0702.queue.api.events;

import org.jetbrains.annotations.NotNull;
import us.ajg0702.queue.api.players.AdaptedPlayer;
import us.ajg0702.queue.api.server.AdaptedServer;

/**
 * Called before AjQueue attempts to connect a player to a proxy server (via Bungee or Velocity)
 * You can use setTargetServer to provide a custom AdaptedServer object for the player to connect to.
 * If canceled, the player will not be connected to the target server.
 * If you cancel this event, it is up to you to send a message telling the player why they were not connected.
 */
@SuppressWarnings("unused")
public class PreConnectEvent implements Event, Cancellable {
    private @NotNull AdaptedServer targetServer;
    private final @NotNull AdaptedPlayer adaptedPlayer;

    private boolean cancelled = false;

    public PreConnectEvent(@NotNull AdaptedServer targetServer, @NotNull AdaptedPlayer adaptedPlayer) {
        this.targetServer = targetServer;
        this.adaptedPlayer = adaptedPlayer;
    }

    /**
     * Set the target server to connect the player to. (Override default behavior with a custom server)
     *
     * @param targetServer the target server (AdaptedServer)
     */
    public void setTargetServer(@NotNull AdaptedServer targetServer) {
        this.targetServer = targetServer;
    }

    /**
     * @return The target server that the player is trying to connect to
     */
    public @NotNull AdaptedServer getTargetServer() {
        return targetServer;
    }

    /**
     * @return The player that is being connected to the server
     */
    public @NotNull AdaptedPlayer getPlayer() {
        return adaptedPlayer;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}

