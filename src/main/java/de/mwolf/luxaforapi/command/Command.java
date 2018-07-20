package de.mwolf.luxaforapi.command;

public abstract class Command {

    abstract byte mode();

    abstract byte code();

    abstract byte byte2();

    abstract byte byte3();

    abstract byte byte4();

    abstract byte byte5();

    abstract byte byte6();

    abstract byte byte7();

    public byte[] getCommandMessage() {
        return new byte[]{
                mode(),
                code(),
                byte2(),
                byte3(),
                byte4(),
                byte5(),
                byte6(),
                byte7()
        };
    }

}
