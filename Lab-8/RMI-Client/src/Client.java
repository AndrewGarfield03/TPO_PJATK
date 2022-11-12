
import java.math.BigInteger;
import java.rmi.Naming;
import java.util.Scanner;

@SuppressWarnings("deprecation")
public final class Client {
    public static void main(String[] args) {
        try {
            IEcho echoObj = (IEcho) Naming.lookup("echo");
            Scanner sc = new Scanner(System.in);
            System.out.println("----------Echoing messages----------");
            System.out.println("Please enter the message....");
            String str = sc.nextLine();

            Message msg = new Message();
            msg.setValue(str);
            EchoRequest echoRequest = new EchoRequest(msg);
            System.out.println("request: " + echoRequest.message.getValue());
            EchoResponse echoResponse = echoObj.echo(echoRequest);
            System.out.println("response: " + echoResponse.message.getValue());

            IAddition addition = (IAddition) Naming.lookup("addition");

            System.out.println("----------Adding values of two number operands----------");
            System.out.println("Please enter the first parameter....");
            String param1 = sc.nextLine();
            BigInteger parameter1 = new BigInteger(param1);
            System.out.println("Please enter the second parameter....");
            String param2 = sc.nextLine();
            BigInteger parameter2 = new BigInteger(param2);

            Sum sum = new Sum(parameter1, parameter2);
            AddRequest addRequest = new AddRequest(sum);
            AddResponse addResponse = addition.add(addRequest);
            System.out.printf("parameter1: '%d', parameter2: '%d'\nsumValue: '%d'\n", addRequest.sum.getParameter1(), addRequest.sum.getParameter2(), addResponse.sum.getSumValue());

        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
