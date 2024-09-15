package com.systex.model;

import java.util.Comparator;

public class MyDate implements Comparable<MyDate> {

	private int Day;
	private int Month;
	private int Year;	
	
    public static final Comparator<MyDate> YEAR_MONTH_DAY_COMP = new Comparator<MyDate>() {
        @Override
        public int compare(MyDate o1, MyDate o2) {
            if (o1.getYear() != o2.getYear()) {
                return Integer.compare(o1.getYear(), o2.getYear());
            }
            if (o1.getMonth() != o2.getMonth()) {
                return Integer.compare(o1.getMonth(), o2.getMonth());
            }
            return Integer.compare(o1.getDay(), o2.getDay());
        }
    };
    
    public static final Comparator<MyDate> DAY_MONTH_YEAR_COMP = new Comparator<MyDate>() {
        @Override
        public int compare(MyDate o1, MyDate o2) {
            if (o1.getDay() != o2.getDay()) {
                return Integer.compare(o1.getDay(), o2.getDay());
            }
            if (o1.getMonth() != o2.getMonth()) {
                return Integer.compare(o1.getMonth(), o2.getMonth());
            }
            return Integer.compare(o1.getYear(), o2.getYear());
        }
    };
    
    public static final Comparator<MyDate> MONTH_DAY_YEAR_COMP = new Comparator<MyDate>() {
        @Override
        public int compare(MyDate o1, MyDate o2) {
            if (o1.getMonth() != o2.getMonth()) {
                return Integer.compare(o1.getMonth(), o2.getMonth());
            }
            if (o1.getDay() != o2.getDay()) {
                return Integer.compare(o1.getDay(), o2.getDay());
            }
            return Integer.compare(o1.getYear(), o2.getYear());
        }
    };

	public static final Comparator<MyDate> DAY_COMP = new Comparator<MyDate>() {
		
		@Override
		public int compare(MyDate o1 , MyDate o2) {
			// TODO Auto-generated method stub
			if (o1.getDay() > o2.getDay()) {
				return 1;
			} else if (o1.getDay() < o2.getDay()) {
				return -1;
			} else {
				return 0;
			}
		}
	}; 
	
	public static final Comparator<MyDate> MONTH_COMP = new Comparator<MyDate>() {
		
		@Override
		public int compare(MyDate o1 , MyDate o2) {
			// TODO Auto-generated method stub
			if (o1.getMonth() > o2.getMonth()) {
				return 1;
			} else if (o1.getMonth() < o2.getMonth()) {
				return -1;
			} else {
				return 0;
			}
		}
	}; 
	
	public static final Comparator<MyDate> YEAR_COMP = new Comparator<MyDate>() {
		
		@Override
		public int compare(MyDate o1 , MyDate o2) {
			// TODO Auto-generated method stub
			if (o1.getYear() > o2.getYear()) {
				return 1;
			} else if (o1.getYear() < o2.getYear()) {
				return -1;
			} else {
				return 0;
			}
		}
	}; 
	
    @Override
    public int compareTo(MyDate other) {
        if (this.Year != other.Year) {
            return Integer.compare(this.Year, other.Year);
        }
        if (this.Month != other.Month) {
            return Integer.compare(this.Month, other.Month);
        }
        return Integer.compare(this.Day, other.Day);
    }
	
	public MyDate(int day, int month, int year) {
		//super();
		Day = day;
		Month = month;
		Year = year;
	}
		
	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	@Override
	public String toString() {
		return "MyDate [Day=" + Day + ", Month=" + Month + ", Year=" + Year + "]";
	}
}
