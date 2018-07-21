package de.mwolf.luxaforapi.command;

import de.mwolf.luxaforapi.type.Pattern;

/**
 *
 * @author mwolf
 */
public class PatternCommand extends Command {
    
    private final Pattern pattern;
    private final Integer repeat;

    public PatternCommand(Pattern pattern, Integer repeat) {
        this.pattern = pattern;
        this.repeat = repeat;
    }

    @Override
    byte mode() {
        return 6;
    }

    @Override
    byte code() {
        return pattern.getCode();
    }

    @Override
    byte byte2() {
        return repeat.byteValue();
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
