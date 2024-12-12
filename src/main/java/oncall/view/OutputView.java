package oncall.view;

public class OutputView {

    public static void outputCalendar(int month, int finalDay) {

        for(int i = 1; i <= finalDay; i++ ){
            System.out.printf("%d월 %d일\n", month, i);
        }
    }

}
