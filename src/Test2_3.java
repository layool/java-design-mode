public class Test2_3 {
    public static void main(String[] args) {
        try {
            TestClass testClass = new TestClass();
            testClass.testException();
        } catch (CustomerException e) {
            //e.printStackTrace();
            System.out.println("MsgDes异常对应的返回码\t"+e.getRetCd());
            System.out.println("RetCd异常对应的描述信息\t"+e.getMsgDes());
        }
    }
}
class CustomerException extends RuntimeException {
    private String retCd;//异常对应的返回码
    private String msgDes;//异常对应的描述信息

   /* public CustomerException() {
        super();
    }*/

   /*public CustomerException(String message) {
        super(message);
        msgDes = message;
    }*/

    public CustomerException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public void setRetCd(String retCd) {
        this.retCd = retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }

    public void setMsgDes(String msgDes) {
        this.msgDes = msgDes;
    }
}
class TestClass {
    public void testException() throws CustomerException {
        try {
            int a=1/0;
        } catch (Exception e) {
            throw new CustomerException("10001","除法异常");
        }
    }
}
