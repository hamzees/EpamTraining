package by.skakun.gemswebxml.command;


public enum CommandEnum {
    SAX {
        {
            this.command = new ParseCommand("SAX");
        }
    },
    STAX {
        {
            this.command = new ParseCommand("STAX");
        }
    },
    DOM {
        {
            this.command = new ParseCommand("DOM");
        }
    },
    VAL {
        {
            this.command = new ValidationCommand();
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    
    ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return command;
    }
    
}
