package com.rainier.strategypattern.promotionscenario;

import java.time.LocalDate;

public class HolidayPromotionFactory {

    public static HolidayPromotion getPromotion(){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        if (month == 10 && day >=1 && day <= 7 ){
            return new NationalDayPromotion();
        }
        else if (month == 2 && day >= 4 && day <= 10){
            return new SpringFestivalPromotion();
        }

        else {
            return new DefaultHolidayPromotion();
        }
    }

}
