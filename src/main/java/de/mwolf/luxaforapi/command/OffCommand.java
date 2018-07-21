package de.mwolf.luxaforapi.command;

/**
 *
 * @author mwolf
 */
public class OffCommand extends Command {

    private final byte SET_OFF = (byte) 0x4F;

    @Override
    byte mode() {
        return 0;
    }

    @Override
    byte code() {
        return SET_OFF;
    }

    @Override
    byte byte2() {
        return 0;
    }

    @Override
    byte byte3() {
        return 0;
    }

    @Override
    byte byte4() {
        return 0;
    }

    @Override
    byte byte5() {
        return 0;
    }

    @Override
    byte byte6() {
        return 0;
    }

    @Override
    byte byte7() {
        return 0;
    }
    
}
