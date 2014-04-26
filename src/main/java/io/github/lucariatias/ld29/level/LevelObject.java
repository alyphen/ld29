package io.github.lucariatias.ld29.level;

import java.awt.*;

public abstract class LevelObject {

    private Level level;
    private Location location;
    private Vector direction;

    private boolean solid;

    public abstract void render(Graphics graphics);
    public abstract Rectangle getBounds();

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public void onTick() {
        if (direction != null) {
            if (!isCollision(location)) {
                location = location.getRelative(direction);
            }
        }
    }

    public boolean isCollision(Location location) {
        for (LevelObject object : level.getObjects()) {
            if (!object.isSolid()) continue;
            if (object.getBounds().intersects(getBounds())) return true;
        }
        return false;
    }

}
