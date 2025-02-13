package lk.acpt.demofx;

public class Main {

    public static void main(String[] args) {
//        Vehicle vehicle = new Vehicle("toyota", "corolla",5);

//        System.out.println(vehicle.brand());

        CustomerController customerController = new CustomerController() {
            @Override
            public void play() {
                // before java 7
            }
        };
        customerController.play();


        CustomerController customerController2 = () -> {
            //after java 8, this is lambda expression
        };
        customerController2.play();
    }

}
