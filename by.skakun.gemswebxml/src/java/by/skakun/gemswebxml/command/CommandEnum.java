package by.skakun.gemswebxml.command;


public enum CommandEnum {
    SAX {
        {
            this.command = new SAXCommand();
        }
    },
    STAX {
        {
            this.command = new STAXCommand();
        }
    },
    DOM {
        {
            this.command = new DOMCommand();
        }
    },
    VAL {
        {
            this.command = new VALCommand();
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return command;
    }
    
}
