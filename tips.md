
public static void main(String[] args) {

    DateTimeFormatter fromDateFormatter = new DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd['T'HH:mm:ss]")
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
        .toFormatter();

    DateTimeFormatter toDateFormatter = new DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd['T'HH:mm:ss]")
        .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 59)
        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 59)
        .toFormatter();

    LocalDateTime fromDatetime1 = LocalDateTime.parse("2021-11-16", fromDateFormatter);
    LocalDateTime fromDatetime2 = LocalDateTime.parse("2021-11-16T09:50:21", fromDateFormatter);

    System.out.println("fromDatetime1 = " + fromDatetime1);
    System.out.println("fromDatetime2 = " + fromDatetime2);

}
