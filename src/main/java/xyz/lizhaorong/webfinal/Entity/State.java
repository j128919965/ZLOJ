package xyz.lizhaorong.webfinal.Entity;

public enum State {

    COMPILE_WRONG{
        @Override
        public byte toByteCode() {
            return 1;
        }

    },
    WRONG_ANSWER{
        @Override
        public byte toByteCode() {
            return 2;
        }
    },
    RUNTIME_ERROR{
        @Override
        public byte toByteCode() {
            return 3;
        }

    },
    ACCEPT{
        @Override
        public byte toByteCode() {
            return 0;
        }
    };

    public abstract byte toByteCode();

    public static State getState(byte b){
        switch (b){
            case 0:{
                return ACCEPT;
            }
            case 1:{
                return COMPILE_WRONG;
            }
            case 2:{
                return WRONG_ANSWER;
            }
            default:{
                return RUNTIME_ERROR;
            }
        }
    }



}
