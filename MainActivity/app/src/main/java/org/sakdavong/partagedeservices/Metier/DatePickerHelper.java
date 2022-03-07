package org.sakdavong.partagedeservices.Metier;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.util.Calendar;

// Source: https://stackoverflow.com/questions/53095146/how-to-popup-datepicker-when-click-on-edittext-in-fragment
public class DatePickerHelper {

    /********************************************DatePickerRelatedWork*****************************/
    public static void showDatePicker(Activity activity, OnDateSelectedListener listener, boolean shouldUsePreviousDate) {
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH);
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(activity, new MyDateSetListener(listener), currentYear, currentMonth, currentDay);
        datePicker.setTitle("Choisir date");
        if (shouldUsePreviousDate){
            datePicker.getDatePicker().setMinDate(-1893475799000L);
        }else {
            datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        }
        datePicker.show();
    }

    public static class MyDateSetListener implements DatePickerDialog.OnDateSetListener {

        private OnDateSelectedListener listener;

        public MyDateSetListener(OnDateSelectedListener listener) {

            this.listener = listener;
        }

        @Override
        public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
            String selectedDateString = null;
            selectedMonth = selectedMonth + 1;
            if (selectedDay >= 0 && selectedDay < 10 && selectedMonth >= 0 && selectedMonth < 10) {
                selectedDateString = "0" + selectedDay + "-" + "0" + selectedMonth + "-" + selectedYear;
            } else if (selectedDay >= 0 && selectedDay < 10) {
                selectedDateString = "0" + selectedDay + "-" + selectedMonth + "-" + selectedYear;
            } else if (selectedMonth >= 0 && selectedMonth < 10) {
                selectedDateString = selectedDay + "-" + "0" + selectedMonth + "-" + selectedYear;
            } else {
                selectedDateString = selectedDay + "-" + selectedMonth + "-" + selectedYear;
            }
            listener.onDateSelected(selectedDateString);
        }
    }

    public interface OnDateSelectedListener {
        void onDateSelected(String selectedDateString);
    }
}
