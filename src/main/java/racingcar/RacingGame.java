package racingcar;

public class RacingGame {

    private Car[] cars; // 경주 차량
    private int totalAttempts;
    private int currentAttempts;



    public RacingGame() {
        this.currentAttempts = 0;
    }

    public void inputCars(String carNames){
        String[] carNameArray = carNames.split(",");
        cars = new Car[carNameArray.length];
        for(int i = 0; i < carNameArray.length; i++){
            cars[i] = new Car(carNameArray[i]);
        }
    }

    public void inputAttempts(int totalAttempts){
        this.totalAttempts = totalAttempts;
    }

    public void start(){
        for(int i = 0; i < totalAttempts; i++){
            for(Car car : cars){
                car.move();
            }
            printResult();
        }
    }

    public void printResult(){
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(){
        int maxPosition = 0;
        for(Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        System.out.print("최종 우승자: ");
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                System.out.print(car.getName() + ", ");
            }
        }
    }
}
