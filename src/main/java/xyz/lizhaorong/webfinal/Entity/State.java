package xyz.lizhaorong.webfinal.Entity;

/**
 * 判题状态
 */
public enum State {

    /**
     * 编译错误
     */
    COMPILE_WRONG{
        @Override
        public byte toByteCode() {
            return 1;
        }

    },
    /**
     * 答案错误
     */
    WRONG_ANSWER{
        @Override
        public byte toByteCode() {
            return 2;
        }
    },
    /**
     * 运行时错误
     */
    RUNTIME_ERROR{
        @Override
        public byte toByteCode() {
            return 3;
        }

    },
    /**
     * 正确答案
     */
    ACCEPT{
        @Override
        public byte toByteCode() {
            return 0;
        }
    };

    /**
     * 返回byte code
     * @return byte
     */
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
