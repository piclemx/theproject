package ca.ulaval.glo4002.theproject.domain.terminal;

public interface TerminalRepository {

    Terminal findByIdentifier(String terminalId);

    void persist(Terminal terminal);
}
