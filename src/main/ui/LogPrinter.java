package ui;

import model.EventLog;

// Defines behaviours that event log printers must support.
public interface LogPrinter {

     // EFFECTS: Prints the log and throws exception when printing fails for any reason
    void printLog(EventLog el);
}
