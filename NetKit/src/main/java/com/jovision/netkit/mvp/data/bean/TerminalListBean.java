package com.jovision.netkit.mvp.data.bean;

import java.io.Serializable;
import java.util.List;

public class TerminalListBean implements Serializable {


    private List<Terminal> terminals;

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public class Terminal implements Serializable{

        private String terminalID;
        private String terminalName;
        private String lastLoginTime;

        public String getTerminalID() {
            return terminalID;
        }

        public void setTerminalID(String terminalID) {
            this.terminalID = terminalID;
        }

        public String getTerminalName() {
            return terminalName;
        }

        public void setTerminalName(String terminalName) {
            this.terminalName = terminalName;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }
    }

}
