package ca.ulaval.glo4002.theproject.domain.terminal;

public class TerminalFactory {

    public Terminal createTerminal(String terminalIdentifier) {
        return new Terminal(terminalIdentifier);
    }
}
